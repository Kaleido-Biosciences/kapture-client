/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * The readout of an assay
 */
public class AssayReadout implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * the number of the assay
     */
    @NotNull
    private Integer assayNumber;

    /**
     * the value obtained by the assay
     */
    private Double value;

    /**
     * the unit of the value
     */
    @NotNull
    private String unit;

    /**
     * the assay result is approved for release to others
     */
    @NotNull
    private Boolean isReleased;

    /**
     * the timestamp of the generation of the result
     */
    private ZonedDateTime timestamp;

    /**
     * the temperature at the time of readout
     */
    private Double temperature;

    /**
     * the dilution factor which may need to be applied to normalize the readout value
     */
    private Double dilutionFactor;

    /**
     * the minute that the sample was assayed to produce this readout
     */
    private Float timePoint;

    /**
     * The name of the protocol that was used to produce this assay readout
     */
    private String protocolName;

    @JsonIgnoreProperties("")
    private Sample sample;

    @JsonIgnoreProperties("")
    private Analyte analyte;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAssayNumber() {
        return assayNumber;
    }

    public AssayReadout assayNumber(Integer assayNumber) {
        this.assayNumber = assayNumber;
        return this;
    }

    public void setAssayNumber(Integer assayNumber) {
        this.assayNumber = assayNumber;
    }

    public Double getValue() {
        return value;
    }

    public AssayReadout value(Double value) {
        this.value = value;
        return this;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public AssayReadout unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean isIsReleased() {
        return isReleased;
    }

    public AssayReadout isReleased(Boolean isReleased) {
        this.isReleased = isReleased;
        return this;
    }

    public void setIsReleased(Boolean isReleased) {
        this.isReleased = isReleased;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public AssayReadout timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public AssayReadout temperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getDilutionFactor() {
        return dilutionFactor;
    }

    public AssayReadout dilutionFactor(Double dilutionFactor) {
        this.dilutionFactor = dilutionFactor;
        return this;
    }

    public void setDilutionFactor(Double dilutionFactor) {
        this.dilutionFactor = dilutionFactor;
    }

    public Float getTimePoint() {
        return timePoint;
    }

    public AssayReadout timePoint(Float timePoint) {
        this.timePoint = timePoint;
        return this;
    }

    public void setTimePoint(Float timePoint) {
        this.timePoint = timePoint;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public AssayReadout protocolName(String protocolName) {
        this.protocolName = protocolName;
        return this;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public Sample getSample() {
        return sample;
    }

    public AssayReadout sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Analyte getAnalyte() {
        return analyte;
    }

    public AssayReadout analyte(Analyte analyte) {
        this.analyte = analyte;
        return this;
    }

    public void setAnalyte(Analyte analyte) {
        this.analyte = analyte;
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
        AssayReadout assayReadout = (AssayReadout) o;
        if (assayReadout.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), assayReadout.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AssayReadout{" +
            "id=" + getId() +
            ", assayNumber=" + getAssayNumber() +
            ", value=" + getValue() +
            ", unit='" + getUnit() + "'" +
            ", isReleased='" + isIsReleased() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", temperature=" + getTemperature() +
            ", dilutionFactor=" + getDilutionFactor() +
            ", timePoint=" + getTimePoint() +
            ", protocolName='" + getProtocolName() + "'" +
            "}";
    }
}
