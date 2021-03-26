package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A key value for properties
 */
public class SampleProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The key of the property. The use of name spaced keys is encouraged.
     */
    @NotNull
    private String name;

    /**
     * A text value for the name key
     */
    private String textValue;

    /**
     * An Integer value for the name key
     */
    private Integer integerValue;

    /**
     * A floating point value for the name key
     */
    private Double precisionValue;

    /**
     * A timestamp value for the name key
     */
    private ZonedDateTime timeValue;

    /**
     * A boolean for the name key
     */
    private Boolean booleanValue;

    /**
     * A unit type for any of the above values
     */
    private String valueUnit;

    @NotNull
    @JsonIgnoreProperties("")
    private Sample sample;

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

    public SampleProperty name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextValue() {
        return textValue;
    }

    public SampleProperty textValue(String textValue) {
        this.textValue = textValue;
        return this;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public SampleProperty integerValue(Integer integerValue) {
        this.integerValue = integerValue;
        return this;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getPrecisionValue() {
        return precisionValue;
    }

    public SampleProperty precisionValue(Double precisionValue) {
        this.precisionValue = precisionValue;
        return this;
    }

    public void setPrecisionValue(Double precisionValue) {
        this.precisionValue = precisionValue;
    }

    public ZonedDateTime getTimeValue() {
        return timeValue;
    }

    public SampleProperty timeValue(ZonedDateTime timeValue) {
        this.timeValue = timeValue;
        return this;
    }

    public void setTimeValue(ZonedDateTime timeValue) {
        this.timeValue = timeValue;
    }

    public Boolean isBooleanValue() {
        return booleanValue;
    }

    public SampleProperty booleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
        return this;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public SampleProperty valueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
        return this;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public Sample getSample() {
        return sample;
    }

    public SampleProperty sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
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
        SampleProperty sampleProperty = (SampleProperty) o;
        if (sampleProperty.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sampleProperty.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SampleProperty{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", textValue='" + getTextValue() + "'" +
            ", integerValue=" + getIntegerValue() +
            ", precisionValue=" + getPrecisionValue() +
            ", timeValue='" + getTimeValue() + "'" +
            ", booleanValue='" + isBooleanValue() + "'" +
            ", valueUnit='" + getValueUnit() + "'" +
            "}";
    }
}
