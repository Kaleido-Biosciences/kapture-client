package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

/**
 * The value of a readout after processing such as normalization by dilution factor. In screen-db was AssayReadout
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    private AssayReadout assayReadout;

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
            "}";
    }
}
