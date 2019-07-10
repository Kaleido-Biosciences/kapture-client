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
 * A Percent of a MediaLot
 */
public class MediaLotComposition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the media lot composition
     */
    @NotNull
    private String name;

    /**
     * A percent for the selected Community
     */
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "100")
    private Double mediaLotPercent;

    @NotNull
    @JsonIgnoreProperties("")
    private MediaLot mediaLot;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public MediaLotComposition name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMediaLotPercent() {
        return mediaLotPercent;
    }

    public MediaLotComposition mediaLotPercent(Double mediaLotPercent) {
        this.mediaLotPercent = mediaLotPercent;
        return this;
    }

    public void setMediaLotPercent(Double mediaLotPercent) {
        this.mediaLotPercent = mediaLotPercent;
    }

    public MediaLot getMediaLot() {
        return mediaLot;
    }

    public MediaLotComposition mediaLot(MediaLot mediaLot) {
        this.mediaLot = mediaLot;
        return this;
    }

    public void setMediaLot(MediaLot mediaLot) {
        this.mediaLot = mediaLot;
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
        MediaLotComposition mediaLotComposition = (MediaLotComposition) o;
        if (mediaLotComposition.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mediaLotComposition.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MediaLotComposition{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", mediaLotPercent=" + getMediaLotPercent() +
            "}";
    }
}
