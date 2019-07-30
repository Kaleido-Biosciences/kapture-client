package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Supplement Metadata represents how much of a supplement is in the sample and at which timepoint as well as any associated media lots
 */
public class SupplementMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * A text value for the name e.g. [MediaLot:]choline 0.5% @ 45h
     */
    private String name;

    /**
     * The concentration of the supplement reagent in millimoles
     */
    private Double concentration;

    /**
     * The time in minutes from start when supplement is added
     */
    private Double treatmentTime;

    @NotNull
    @JsonIgnoreProperties("")
    private Concept concentrationUnit;

    @JsonIgnoreProperties("")
    private Supplement supplement;

    /**
     * If this supplement is part of a MediaLot, select it here
     */
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

    public SupplementMetadata name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getConcentration() {
        return concentration;
    }

    public SupplementMetadata concentration(Double concentration) {
        this.concentration = concentration;
        return this;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    public Double getTreatmentTime() {
        return treatmentTime;
    }

    public SupplementMetadata treatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
        return this;
    }

    public void setTreatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public Concept getConcentrationUnit() {
        return concentrationUnit;
    }

    public SupplementMetadata concentrationUnit(Concept concept) {
        this.concentrationUnit = concept;
        return this;
    }

    public void setConcentrationUnit(Concept concept) {
        this.concentrationUnit = concept;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public SupplementMetadata supplement(Supplement supplement) {
        this.supplement = supplement;
        return this;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }

    public MediaLot getMediaLot() {
        return mediaLot;
    }

    public SupplementMetadata mediaLot(MediaLot mediaLot) {
        this.mediaLot = mediaLot;
        return this;
    }

    public void setMediaLot(MediaLot mediaLot) {
        this.mediaLot = mediaLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupplementMetadata supplementMetadata = (SupplementMetadata) o;
        if (supplementMetadata.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), supplementMetadata.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SupplementMetadata{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", concentration=" + getConcentration() +
            ", treatmentTime=" + getTreatmentTime() +
            "}";
    }
}
