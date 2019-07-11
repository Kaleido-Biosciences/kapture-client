/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The value of a readout after processing such as normalization by dilution factor. In screen-db was AssayReadout
 */
public class ProcessedReadout implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The processed value
     */
    private Double value;

    /**
     * The unit of the processed value
     */
    private String unit;

    /**
     * The name of the statistical protocol that was used to process this readout
     */
    private String protocolName;

    private AssayReadout assayReadout;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public ProcessedReadout value(Double value) {
        this.value = value;
        return this;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public ProcessedReadout unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public ProcessedReadout protocolName(String protocolName) {
        this.protocolName = protocolName;
        return this;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public AssayReadout getAssayReadout() {
        return assayReadout;
    }

    public ProcessedReadout assayReadout(AssayReadout assayReadout) {
        this.assayReadout = assayReadout;
        return this;
    }

    public void setAssayReadout(AssayReadout assayReadout) {
        this.assayReadout = assayReadout;
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
        ProcessedReadout processedReadout = (ProcessedReadout) o;
        if (processedReadout.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), processedReadout.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProcessedReadout{" +
            "id=" + getId() +
            ", value=" + getValue() +
            ", unit='" + getUnit() + "'" +
            ", protocolName='" + getProtocolName() + "'" +
            "}";
    }
}
