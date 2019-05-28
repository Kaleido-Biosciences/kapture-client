package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Scientists that can be associated with experiments
 * @author Patrick Kyle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scientist implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The first name of the scientist
     */
    private String firstName;

    /**
     * The last name of the scientist
     */
    private String lastName;

    /**
     * The user name of the scientist
     */
    private String userName;
    
    /**
     * Check this box if the scientist is non-Kaleido
     */
    private Boolean isExternal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Scientist firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Scientist lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public Scientist userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean isIsExternal() {
        return isExternal;
    }

    public Scientist isExternal(Boolean isExternal) {
        this.isExternal = isExternal;
        return this;
    }

    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Scientist scientist = (Scientist) o;
        if (scientist.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), scientist.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Scientist{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", isExternal='" + isIsExternal() + "'" +
            "}";
    }
}
