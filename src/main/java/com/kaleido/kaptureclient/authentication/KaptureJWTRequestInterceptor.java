/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.authentication;

import com.kaleido.kaptureclient.KaptureClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Intercepts calls to the Kapture api (only) and injects an {@code Authorization} header. It will attempt an authentication
 * if the user is not yet authenticated.
 */
public class KaptureJWTRequestInterceptor implements ClientHttpRequestInterceptor {

    private UserCredentials userCredentials;
    private String kaptureBase;

    private Logger log = LoggerFactory.getLogger(KaptureJWTRequestInterceptor.class);

    public KaptureJWTRequestInterceptor(UserCredentials userCredentials, KaptureClientProperties kaptureClientProperties){
        this.userCredentials = userCredentials;
        this.kaptureBase = kaptureClientProperties.getBase();
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        //if the request is to the kapture service we should add the authorization token
        if(httpRequest.getURI().toString().contains(kaptureBase)) {

            log.debug("Intercepting call to {}, setting authorization header", httpRequest.getURI().toString());
            //set the token on the header
            httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + userCredentials.getBearerToken());
        }

        //execute the client request
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
