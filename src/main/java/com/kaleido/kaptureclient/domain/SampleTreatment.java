package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Sample may be treated with a condition over a period of time before the assay readout is measured
 */

public class SampleTreatment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the treatment. Typically the name of a reagent
     */
    @NotNull
    private String name;

    /**
     * The concentration of the treatment reagent in millimoles
     */
    private Double concentration;

    /**
     * The treatment time in minutes
     */
    private Double treatmentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SampleTreatment name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getConcentration() {
        return concentration;
    }

    public SampleTreatment concentration(Double concentration) {
        this.concentration = concentration;
        return this;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    public Double getTreatmentTime() {
        return treatmentTime;
    }

    public SampleTreatment treatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
        return this;
    }

    public void setTreatmentTime(Double treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SampleTreatment sampleTreatment = (SampleTreatment) o;
        if (sampleTreatment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sampleTreatment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SampleTreatment{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", concentration=" + getConcentration() +
            ", treatmentTime=" + getTreatmentTime() +
            "}";
    }
}
