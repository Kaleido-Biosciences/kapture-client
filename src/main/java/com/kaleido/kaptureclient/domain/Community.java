package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Communities used in ExVivo experiments
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the community
     */
    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Community name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Community community = (Community) o;
        if (community.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), community.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Community{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
