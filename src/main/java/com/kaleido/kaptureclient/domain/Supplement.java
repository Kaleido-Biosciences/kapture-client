/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Sample may be treated with one or many supplements added with media
 */
public class Supplement implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The concentration of the supplement reagent in millimoles
     */
    private Double concentration;

    /**
     * The time in minutes from 0:00am when supplement is added with media
     */
    private Double treatmentTime;

    /**
     * Properties that describe a Supplement instance
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Concept name;

    @NotNull
    @JsonIgnoreProperties("")
    private Concept concentrationUnit;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getConcentration() {
        return concentration;
    }

    public Supplement concentration(Double concentration) {
        this.concentration = concentration;
        return this;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    public Double getTreatmentTime() {
        return treatmentTime;
    }

    public Supplement treatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
        return this;
    }

    public void setTreatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public Concept getName() {
        return name;
    }

    public Supplement name(Concept concept) {
        this.name = concept;
        return this;
    }

    public void setName(Concept concept) {
        this.name = concept;
    }

    public Concept getConcentrationUnit() {
        return concentrationUnit;
    }

    public Supplement concentrationUnit(Concept concept) {
        this.concentrationUnit = concept;
        return this;
    }

    public void setConcentrationUnit(Concept concept) {
        this.concentrationUnit = concept;
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
        Supplement supplement = (Supplement) o;
        if (supplement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), supplement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Supplement{" +
            "id=" + getId() +
            ", concentration=" + getConcentration() +
            ", treatmentTime=" + getTreatmentTime() +
            "}";
    }
}
