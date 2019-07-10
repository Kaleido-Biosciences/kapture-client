/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Platemaps for experiments
 */
public class Platemap implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The plate number
     */
    @NotNull
    @Min(value = 0)
    private Integer plateNumber;

    /**
     * The experiment for the platemap
     * @deprecated It is now recommended that samples be directly connected to the experiment that created them rather
     * than via a platemap.
     */
    @JsonIgnoreProperties("")
    @Deprecated
    private Experiment experiment;

    @JsonIgnoreProperties("")
    private Concept platePurpose;

    @JsonIgnoreProperties("")
    private PlateType plateType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlateNumber() {
        return plateNumber;
    }

    public Platemap plateNumber(Integer plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public void setPlateNumber(Integer plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public Platemap experiment(Experiment experiment) {
        this.experiment = experiment;
        return this;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Concept getPlatePurpose() {
        return platePurpose;
    }

    public Platemap platePurpose(Concept concept) {
        this.platePurpose = concept;
        return this;
    }

    public void setPlatePurpose(Concept concept) {
        this.platePurpose = concept;
    }

    public PlateType getPlateType() {
        return plateType;
    }

    public Platemap plateType(PlateType plateType) {
        this.plateType = plateType;
        return this;
    }

    public void setPlateType(PlateType plateType) {
        this.plateType = plateType;
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
        Platemap platemap = (Platemap) o;
        if (platemap.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platemap.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Platemap{" +
            "id=" + getId() +
            ", plateNumber=" + getPlateNumber() +
            "}";
    }
}
