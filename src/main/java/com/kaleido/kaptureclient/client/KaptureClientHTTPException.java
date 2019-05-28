package com.kaleido.kaptureclient.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class KaptureClientHTTPException extends HttpServerErrorException {

    private Logger log = LoggerFactory.getLogger(KaptureClientHTTPException.class);

    public KaptureClientHTTPException(HttpStatus statusCode) {
        super(statusCode);
    }

    public KaptureClientHTTPException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public static class KaptureClientGatewayTimeoutException extends KaptureClientHTTPException {
        KaptureClientGatewayTimeoutException(HttpStatus statusCode) {
            super(statusCode);
        }

        KaptureClientGatewayTimeoutException(HttpStatus statusCode, String statusText) {
            super(statusCode, statusText);
        }
    }

    public static class KaptureClientBadGatewayException extends KaptureClientHTTPException {
        KaptureClientBadGatewayException(HttpStatus statusCode) {
            super(statusCode);
        }

        KaptureClientBadGatewayException(HttpStatus statusCode, String statusText) {
            super(statusCode, statusText);
        }
    }
}
