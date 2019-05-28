package com.kaleido.kaptureclient.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaleido.kaptureclient.KaptureClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/**
 * Holds the user credentials of the user that will attempt to be authenticated with the kapture service
 */
@Component
public class UserCredentials {
    /**
     * How many minutes to buffer to determine when to get a new token before it actually expires so we don't risk trying to use the token between checking if it's expired and it's expiration
     */
    public static final long EXPIRATION_BUFFER_MINUTES = 10L;
    public static final String EXPIRY = "exp";

    private String username;
    private String password;

    private AuthClient authClient;
    private String bearerToken = null;
    private Instant bearerExpiry = null;

    Logger log = LoggerFactory.getLogger(UserCredentials.class);

    public UserCredentials(AuthClient authClient, KaptureClientProperties kaptureClientProperties) {
        this.authClient = authClient;
        this.username = kaptureClientProperties.getUsername();
        this.password = kaptureClientProperties.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @JsonIgnore
    public String getBearerToken() {
        if (bearerToken == null || hasTokenExpired()) {
            UserToken userToken = authClient.getUserToken(this);
            bearerToken = userToken.getBearer();
            bearerExpiry = getExpiryFromBearer();
        }
        return bearerToken;
    }

    public Instant getBearerExpiry() {
        return bearerExpiry;
    }

    public void setBearerExpiry(Instant bearerExpiry) {
        this.bearerExpiry = bearerExpiry;
    }

    /**
     * Parses a JWT token and returns an expiration date in seconds
     *
     * @return Instant time of token expiration
     * @throws PatternSyntaxException    if the bearer token is malformed
     * @throws IndexOutOfBoundsException if the bearer token somehow doesn't have a second segment
     * @throws IOException               if it cannot parse the decoded String as JSON
     */
    private Instant getExpiryFromBearer() {
        if (!StringUtils.hasText(bearerToken)) {
            log.error("No Bearer Token has been provieded {}", bearerToken);
            return null;
        }

        try {
            String b64Payload = bearerToken.split("\\.")[1];
            Map<String, Object> map = new ObjectMapper().readValue(new String(Base64.getDecoder().decode(b64Payload)), Map.class);

            log.info("Token expires at time: {}", map.get(EXPIRY).toString());
            return Instant.ofEpochSecond(Long.parseLong(map.get(EXPIRY).toString()));
        } catch (PatternSyntaxException | IndexOutOfBoundsException | IOException e) {
            log.error("Bearer Token is invalid {}", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Determines if a token has hit it's (expiration - buffer minutes) by taking the expiration time and
     * subtracting the buffer minutes from it.
     *
     * @return true if the token is expired or within the buffer window of expiration or if bearerExpiry is null
     */
    public boolean hasTokenExpired() {
        if (bearerExpiry == null)  {
            return true;
        }
        Instant bufferedExpiry = bearerExpiry.minus(Duration.ofMinutes(EXPIRATION_BUFFER_MINUTES));
        Instant currentTime = Instant.now();
        return currentTime.isAfter(bufferedExpiry);
    }
}
