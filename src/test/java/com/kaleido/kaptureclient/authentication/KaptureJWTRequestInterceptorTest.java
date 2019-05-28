package com.kaleido.kaptureclient.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaleido.kaptureclient.KaptureClientProperties;
import com.kaleido.kaptureclient.client.KaptureClient;
import com.kaleido.kaptureclient.client.KaptureResponseErrorHandler;
import com.kaleido.kaptureclient.domain.Analyte;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"kapture.client.username=admin",
        "kapture.client.password=test",
        "kapture.client.base=http://localhost:8080/api/"})
public class KaptureJWTRequestInterceptorTest {

    @Autowired
    KaptureJWTRequestInterceptor interceptor;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserCredentials userCredentials;

    @Autowired
    AuthClient authClient;

    @Autowired
    KaptureClientProperties kaptureClientProperties;

    @Autowired
    KaptureClient<Analyte> analyteKaptureClient;

    @Autowired
    RetryTemplate retryTemplate;


    private static final Instant FAKE_BEARER_EXPIRED = Instant.now().minus(Duration.ofDays(1L));
    private static final Instant FAKE_BEARER_NOT_EXPIRED = Instant.now().plus(Duration.ofDays(1L));
    private static final Instant FAKE_BEARER_IN_BUFFER = Instant.now().plus(Duration.ofMinutes(UserCredentials.EXPIRATION_BUFFER_MINUTES));

    public static final String FAKE_BEARER_TOKEN = generateFakeBearerToken(FAKE_BEARER_NOT_EXPIRED);

    private MockRestServiceServer mockServer;
    private MockRestServiceServer authServer;
    private ObjectMapper mapper = new ObjectMapper();

    private static String generateFakeBearerToken(Instant instantTime) {
        Long timestamp = instantTime.getEpochSecond();
        String payload = "{\"" + UserCredentials.EXPIRY + "\":" +timestamp.toString() + "}";
        return "fake." + Base64.getEncoder().encodeToString(payload.getBytes()) + ".token";
    }

    @Before
    public void init() {
        userCredentials.setBearerToken(FAKE_BEARER_TOKEN);
        userCredentials.setBearerExpiry(FAKE_BEARER_NOT_EXPIRED);
        mockServer = MockRestServiceServer.createServer(restTemplate);
        authServer = MockRestServiceServer.createServer(authClient.getRestTemplate());
    }

    @After
    public void reset() {
        mockServer.reset();
    }

    @Test
    public void jwtInterceptorShouldBeInRestTemplate() {
        assertTrue(restTemplate.getInterceptors()
                .stream()
                .anyMatch(interceptor -> interceptor.getClass().equals(KaptureJWTRequestInterceptor.class)));
    }

    @Test
    public void jwtTokenAddIfNull() {
        userCredentials.setBearerToken(null);

        authServer.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + "authenticate"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("{\"id_token\": \"" + generateFakeBearerToken(FAKE_BEARER_NOT_EXPIRED) + "\"}", MediaType.APPLICATION_JSON));


        userCredentials.getBearerToken();
        assertNotNull(userCredentials.getBearerToken());
        assertFalse(userCredentials.hasTokenExpired());
        authServer.verify();
    }

    @Test
    public void jwtTokenNotExpired() {
        assertFalse(userCredentials.hasTokenExpired());

        userCredentials.getBearerToken();

        assertEquals(FAKE_BEARER_NOT_EXPIRED, userCredentials.getBearerExpiry());
    }

    @Test
    public void jwtTokenExpired() {
        jwtTokenExpiredGetNewToken(FAKE_BEARER_EXPIRED);
    }

    @Test
    public void jwtTokenLessThanBufferExpired() {
        jwtTokenExpiredGetNewToken(FAKE_BEARER_IN_BUFFER);
    }

    private void jwtTokenExpiredGetNewToken(Instant timestamp) {
        userCredentials.setBearerExpiry(timestamp);
        assertTrue(userCredentials.hasTokenExpired());

        authServer.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + "authenticate"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("{\"id_token\": \"" + generateFakeBearerToken(FAKE_BEARER_NOT_EXPIRED) + "\"}", MediaType.APPLICATION_JSON));


        userCredentials.getBearerToken();

        assertFalse(userCredentials.hasTokenExpired());
        authServer.verify();
    }

    @Test
    public void jwtTokenShouldBeAddedToHeader() throws Exception {
        mockServer.expect(ExpectedCount.once(),
                requestTo(kaptureClientProperties.getBase() + "analytes/1"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        analyteKaptureClient.find(1L);
        mockServer.verify();
    }

    @Test(expected = AssertionError.class)
    public void jwtTokenShouldNotBeAddedForOtherUrls() throws Exception {
        restTemplate.setErrorHandler(new KaptureResponseErrorHandler());
        KaptureClient<Analyte> myClient = new KaptureClient<>("http://someotherdomain.com/api/analytes",
                "http://someotherdomain.com/api/_search/analytes",
                restTemplate, retryTemplate, Analyte.class);
        mockServer.expect(ExpectedCount.once(),
                requestTo("http://someotherdomain.com/api/analytes/1"))
                .andExpect(header("Authorization", "Bearer " + userCredentials.getBearerToken()))
                .andRespond(withStatus(HttpStatus.OK));

        //ideally i'd like to ensure the Authorization header is not present but with the current version that is not
        // possible therefore we assert that an AssetionError is thrown via the annotation above.

        myClient.find(1L);
        mockServer.verify();
    }
}