/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.authentication;

import com.kaleido.kaptureclient.KaptureClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * Specialized Client for the /authorization endpoint of Kapture. It authenticates the user and obtains a JWT token
 * for subsequent calls.
 */
@Service
@EnableConfigurationProperties({KaptureClientProperties.class})
public class AuthClient {
    private RestTemplate restTemplate;
    private String serviceUri;

    public static final String AUTH_ENDPOINT = "authenticate";

    Logger log = LoggerFactory.getLogger(AuthClient.class);

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public AuthClient(KaptureClientProperties kaptureClientProperties) {
        this.serviceUri = kaptureClientProperties.getBase();

        /*
         * important to declare a new RestTemplate here so that we don't get the one with the JWTInterceptor which will
         * attempt to add a token that we don't have yet
         */
        this.restTemplate = new RestTemplate();
    }

    /**
     * Calls the authentication endpoint of Kapture to obtain a token
     * @param userCredentials a Pojo with the username and password of the user
     * @return an object wrapping the JWT token.
     */
    public UserToken getUserToken(UserCredentials userCredentials){

        log.info("getting user token from {}", serviceUri+AUTH_ENDPOINT);
        UserToken userToken = restTemplate.postForObject(serviceUri + AUTH_ENDPOINT, userCredentials, UserToken.class);

        if( StringUtils.hasText(userToken.getBearer()) ){
            log.info("obtained token");
            log.trace("user token: {}", userToken);
        } else {
            log.warn("User token not obtained");
        }

        return userToken;
    }
}
