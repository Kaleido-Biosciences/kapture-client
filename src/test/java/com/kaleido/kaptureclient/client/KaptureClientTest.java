/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaleido.kaptureclient.KaptureClientProperties;
import com.kaleido.kaptureclient.authentication.UserCredentials;
import com.kaleido.kaptureclient.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(properties = {
        "kapture.client.retryInterval=50",
        "kapture.client.maxRequestAttempts=3"
})
@RunWith(SpringRunner.class)
public class KaptureClientTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    KaptureClientProperties kaptureClientProperties;

    @Autowired
    KaptureClient<Batch> kaptureClient;

    @Autowired
    KaptureClient<Experiment> experimentKaptureClient;
    @Autowired
    KaptureClient<Concept> conceptKaptureClient;

    @Autowired
    KaptureClient<Sample> sampleKaptureClient;

    @Autowired
    UserCredentials userCredentials;

    @Autowired
    ObjectMapper objectMapper;

    private MockRestServiceServer server;
    private static final String FAKE_BEARER_TOKEN = "fake.bearer.token";
    private static final Instant FAKE_BEARER_NOT_EXPIRED = Instant.now().plus(Duration.ofDays(1L));


    @Before
    public void setUp() {
        userCredentials.setBearerToken(FAKE_BEARER_TOKEN);
        userCredentials.setBearerExpiry(FAKE_BEARER_NOT_EXPIRED);
        server = MockRestServiceServer.createServer(restTemplate);
    }

    @After
    public void tearDown() {
        server.reset();
    }

    @Test
    public void findById() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.find(1L);
        server.verify();
    }

    @Test
    public void findOneByMethod() {
        String methodName = "/label";
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + methodName + "/test"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findOneByMethod("label", "test");
        server.verify();
    }

    @Test(expected = HttpClientErrorException.class)
    public void findOneByMethodNoEndpointShouldThrowNotFound() {
        String methodName = "/label";
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + methodName + "/test"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        kaptureClient.findOneByMethod("label", "test");
        server.verify();
    }

    @Test
    public void search() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.search("foo");
        server.verify();
    }

    @Test
    public void searchWithPageing() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=10&size=30"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.search("foo", 10, 30);
        server.verify();
    }

    @Test
    public void searchRetryOnce() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.search("foo");
        server.verify();
    }

    @Test
    public void searchRetryTwice() {
        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.search("foo");
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void searchShouldNotTryMoreThanThreeTimes() throws KaptureClientHTTPException {
        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.GATEWAY_TIMEOUT));

        kaptureClient.search("foo");
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void searchOtherExceptionShouldNotRetry() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent() + "/"
                        + "batches?query=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        kaptureClient.search("foo");
        server.verify();
    }

    @Test
    public void findByFieldEquals() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldEquals("id", "0");
        server.verify();
    }

    @Test
    public void findByFieldEqualsRetryOnce() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldEquals("id", "0");
        server.verify();
    }

    @Test
    public void findByFieldEqualsRetryTwice() {
        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldEquals("id", "0");
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void findByFieldEqualsShouldNotTryMoreThanThreeTimes() throws KaptureClientHTTPException {
        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        kaptureClient.findByFieldEquals("id", "0");
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void findByFieldEqualsOtherExceptionShouldNotRetry() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        kaptureClient.findByFieldEquals("id", "0");
        server.verify();
    }

    @Test
    public void findByFieldEqualsWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.equals=0&page=3&size=10"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldEquals("id", "0", 3, 10);
        server.verify();
    }

    @Test
    public void findByFieldsEqual() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?name.equals=baa&source.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, String> params = new LinkedHashMap<>(); //insertion ordered map
        params.put("name", "baa");
        params.put("source", "baz");

        kaptureClient.findByFieldsEqual(params);
        server.verify();
    }

    @Test
    public void findByFieldsEqualWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?name.equals=baa&source.equals=baz&page=10&size=50"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, String> params = new LinkedHashMap<>(); //insertion ordered map
        params.put("name", "baa");
        params.put("source", "baz");

        kaptureClient.findByFieldsEqual(params, 10, 50);
        server.verify();
    }

    @Test
    public void findByFieldWithOperator() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldWithOperator("id", "15", "greaterThan");
        server.verify();
    }

    @Test
    public void findByFieldWithOperatorWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&page=3&size=10"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByFieldWithOperator("id", "15", "greaterThan", 3, 10);
        server.verify();
    }

    @Test
    public void findByFieldsWithOperators() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params);
        server.verify();
    }

    @Test
    public void findByFieldsWithOperatorsRetryOnce() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params);
        server.verify();
    }

    @Test
    public void findByFieldsWithOperatorsRetryTwice() {
        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params);
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void findByFieldsWithOperatorsShouldNotTryMoreThanThreeTimes() throws KaptureClientHTTPException {
        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params);
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void findByFieldsWithOperatorsOtherExceptionShouldNotRetry() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params);
        server.verify();
    }

    @Test
    public void findByFieldsWithOperatorsWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?id.greaterThan=15&name.equals=baz&page=10&size=50"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("id", field1);
        params.put("name", field2);

        kaptureClient.findByFieldsWithOperators(params, 10, 50);
        server.verify();
    }

    @Test
    public void findAll() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findAll();
        server.verify();
    }

    @Test
    public void findAllWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=5&size=12"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findAll(5, 12);
        server.verify();
    }

    @Test
    public void findAllRetryOnce() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findAll();
        server.verify();
    }

    @Test
    public void findAllRetryTwice() {
        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findAll();
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void findAllShouldNotTryMoreThanThreeTimes() throws KaptureClientHTTPException {
        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        kaptureClient.findAll();
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void findAllOtherExceptionShouldNotRetry() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() +
                        "?page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        kaptureClient.findAll();
        server.verify();
    }

    @Test
    public void save() throws Exception {
        Batch batch = new Batch().name("CB-123BBB");
        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withSuccess());

        kaptureClient.save(batch);
        server.verify();
    }

    @Test
    public void saveAll() throws Exception {
        List<Batch> batches = new ArrayList();
        batches.add(new Batch().name("CB-123BBB"));
        batches.add(new Batch().name("CB-345CCC"));

        String jsonString = objectMapper.writeValueAsString(batches);
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()
                        + "/save-all"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withSuccess());

        kaptureClient.saveAll(batches);
        server.verify();
    }

    @Test(expected = HttpClientErrorException.class)
    public void saveAllNoEndpointShouldThrowNotFoundError() throws Exception {
        List<Batch> batches = new ArrayList();
        batches.add(new Batch().name("CB-123BBB"));
        batches.add(new Batch().name("CB-345CCC"));

        String jsonString = objectMapper.writeValueAsString(batches);
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()
                        + "/save-all"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        kaptureClient.saveAll(batches);
        server.verify();
    }

    @Test
    public void saveWithSetId() throws Exception {
        Batch batch = new Batch().name("CB-123BBB");
        batch.setId(10L);

        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.PUT))
                .andExpect(content().json(jsonString))
                .andRespond(withSuccess());

        kaptureClient.save(batch);
        server.verify();
    }

    @Test
    public void saveRetryOnce() throws JsonProcessingException {
        Batch batch = new Batch().name("CB-123BBB");
        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.save(batch);
        server.verify();
    }

    @Test
    public void saveRetryTwice() throws JsonProcessingException {
        Batch batch = new Batch().name("CB-123BBB");
        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.save(batch);
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void saveShouldNotTryMoreThanThreeTimes() throws JsonProcessingException, KaptureClientHTTPException {
        Batch batch = new Batch().name("CB-123BBB");
        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        kaptureClient.save(batch);
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void saveOtherExceptionShouldNotRetry() throws JsonProcessingException {
        Batch batch = new Batch().name("CB-123BBB");
        String jsonString = objectMapper.writeValueAsString(batch);

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint()))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(jsonString))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        kaptureClient.save(batch);
        server.verify();
    }


    @Test
    public void delete() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.delete(21L);
        server.verify();
    }

    @Test
    public void deleteRetryOnce() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.delete(21L);
        server.verify();
    }

    @Test
    public void deleteRetryTwice() {
        server.expect(ExpectedCount.twice(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.delete(21L);
        server.verify();
    }

    @Test(expected = KaptureClientHTTPException.class)
    public void deleteShouldNotTryMoreThanThreeTimes() throws KaptureClientHTTPException {
        server.expect(ExpectedCount.times(3),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.BAD_GATEWAY));

        kaptureClient.delete(21L);
        server.verify();
    }

    @Test(expected = HttpServerErrorException.class)
    public void deleteOtherExceptionShouldNotRetry() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "/21"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        kaptureClient.delete(21L);
        server.verify();
    }

    @Test
    public void findByName() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?name.equals=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByName("foo");
        server.verify();
    }

    @Test
    public void findByNameWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?name.equals=foo&page=1&size=10"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findByName("foo", 1, 10);
        server.verify();
    }

    @Test
    public void findFirstByName() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "batches?name.equals=foo&page=0&size=1"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        kaptureClient.findFirstByName("foo");
        server.verify();
    }


    @Test
    public void findByLabel() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "samples?label.equals=foo&page=0&size=" + MAX_VALUE))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        sampleKaptureClient.findByLabel("foo");
        server.verify();
    }


    @Test
    public void findByLabelWithPaging() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "samples?label.equals=foo&page=1&size=10"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        sampleKaptureClient.findByLabel("foo", 1, 10);
        server.verify();
    }

    @Test
    public void findFirstByLabel() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "samples?label.equals=name&page=0&size=1"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        sampleKaptureClient.findFirstByLabel("name");
        server.verify();
    }


    @Test
    public void findByFieldEqualsUri() {
        String uriString = kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "?foo.equals=baa&page=0&size=" + MAX_VALUE;
        URI uri = kaptureClient.findByFieldEqualsUri("foo", "baa");
        assertEquals(uriString, uri.toString());
    }

    @Test
    public void findByFieldsEqualUri() {
        String uriString = kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "?foo.equals=baa&foz.equals=baz%20%2B%20boz&page=0&size=20";
        Map<String, String> params = new LinkedHashMap<>();
        params.put("foo", "baa");
        params.put("foz", "baz + boz");
        URI uri = kaptureClient.findByFieldsEqualUri(params, 0, 20);
        assertEquals(uriString, uri.toString());
    }

    @Test
    public void findByFieldWithOperatorsUri() {
        String uriString = kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "?foo.greaterThan=15&page=0&size=" + MAX_VALUE;
        URI uri = kaptureClient.findByFieldWithOperatorUri("foo", "15", "greaterThan");
        assertEquals(uriString, uri.toString());
    }

    @Test
    public void findByFieldsWithOperatorsUri() {
        String uriString = kaptureClientProperties.getBase() + kaptureClientProperties.getBatchEndpoint() + "?foo.greaterThan=15&bar.equals=baz&page=0&size=20";
        Map<String, Map<String, String>> params = new LinkedHashMap<>();
        Map<String, String> field1 = Stream.of(new String[][]{{"operator", "greaterThan"}, {"value", "15"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Map<String, String> field2 = Stream.of(new String[][]{{"operator", "equals"}, {"value", "baz"},}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        params.put("foo", field1);
        params.put("bar", field2);
        URI uri = kaptureClient.findByFieldsWithOperatorsUri(params, 0, 20);
        assertEquals(uriString, uri.toString());
    }

    @Test
    public void searchUri() {
        String uriString = kaptureClientProperties.getBase() + kaptureClientProperties.getSearchPathComponent()
                + "/" + kaptureClientProperties.getBatchEndpoint() + "?query=foo&page=10&size=15";
        URI uri = kaptureClient.searchUri("foo", 10, 15);

        assertEquals(uriString, uri.toString());
    }

    @Test
    public void getEntityClassName() {
        assertEquals(Batch.class.toString(), kaptureClient.getEntityClassName());
    }

    @Test
    public void getEntityClass() {
        assertSame(Batch.class, kaptureClient.getEntityClass());
    }

    @Test
    public void childEntityIdsAreValidFieldForSample() {
        server.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase()
                        + "samples?wellId.equals=1&communityId.equals=1&batchId.equals=1&mediaId.equals=1&page=10&size=50"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        Map<String, String> params = new LinkedHashMap<>(); //insertion ordered map
        params.put("wellId", "1");
        params.put("communityId", "1");
        params.put("batchId", "1");
        params.put("mediaId", "1");

        sampleKaptureClient.findByFieldsEqual(params, 10, 50);
        server.verify();
    }
}
