/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Community Composition that represents the percent of each Community in a Sample or another Community
 */
public class CommunityComposition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The Abbreviation of the community composition
     */
    private String label;

    /**
     * A percent for the selected Community
     */
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "100")
    private Double communityPercent;

    /**
     * The communitys associated with a community composition
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Community community;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public CommunityComposition label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getCommunityPercent() {
        return communityPercent;
    }

    public CommunityComposition communityPercent(Double communityPercent) {
        this.communityPercent = communityPercent;
        return this;
    }

    public void setCommunityPercent(Double communityPercent) {
        this.communityPercent = communityPercent;
    }

    public Community getCommunity() {
        return community;
    }

    public CommunityComposition community(Community community) {
        this.community = community;
        return this;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommunityComposition communityComposition = (CommunityComposition) o;
        if (communityComposition.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), communityComposition.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommunityComposition{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            ", communityPercent=" + getCommunityPercent() +
            "}";
    }
}
