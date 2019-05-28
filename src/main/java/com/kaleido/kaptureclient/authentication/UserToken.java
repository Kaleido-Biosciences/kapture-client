package com.kaleido.kaptureclient.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class marshals the user token returned from the Kapture service during authentication
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserToken {


    @JsonProperty("id_token")
    private String idToken;
    private Long expiry;

    /**
     * The JWT token representing the authenticated user
     */
    public String getBearer() {
        return this.idToken;
    }

    public void setBearer(String bearer) {
        this.idToken = bearer;
    }

    /**
     * The expiration time of the JWT token, in seconds
     */
    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "bearer='" + idToken + '\'' +
                "expiry='" + expiry + '\'' +
                '}';
    }
}
