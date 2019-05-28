package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * The properties of a OTU, called sequencing properties in screen-db
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtuCountProperty implements Serializable {

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

    @JsonIgnoreProperties("")
    private ObservedTaxonomicUnitCount observedTaxonomicUnitCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public OtuCountProperty name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextValue() {
        return textValue;
    }

    public OtuCountProperty textValue(String textValue) {
        this.textValue = textValue;
        return this;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public OtuCountProperty integerValue(Integer integerValue) {
        this.integerValue = integerValue;
        return this;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getPrecisionValue() {
        return precisionValue;
    }

    public OtuCountProperty precisionValue(Double precisionValue) {
        this.precisionValue = precisionValue;
        return this;
    }

    public void setPrecisionValue(Double precisionValue) {
        this.precisionValue = precisionValue;
    }

    public ZonedDateTime getTimeValue() {
        return timeValue;
    }

    public OtuCountProperty timeValue(ZonedDateTime timeValue) {
        this.timeValue = timeValue;
        return this;
    }

    public void setTimeValue(ZonedDateTime timeValue) {
        this.timeValue = timeValue;
    }

    public ObservedTaxonomicUnitCount getObservedTaxonomicUnitCount() {
        return observedTaxonomicUnitCount;
    }

    public OtuCountProperty observedTaxonomicUnitCount(ObservedTaxonomicUnitCount observedTaxonomicUnitCount) {
        this.observedTaxonomicUnitCount = observedTaxonomicUnitCount;
        return this;
    }

    public void setObservedTaxonomicUnitCount(ObservedTaxonomicUnitCount observedTaxonomicUnitCount) {
        this.observedTaxonomicUnitCount = observedTaxonomicUnitCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OtuCountProperty otuCountProperty = (OtuCountProperty) o;
        if (otuCountProperty.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), otuCountProperty.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OtuCountProperty{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", textValue='" + getTextValue() + "'" +
            ", integerValue=" + getIntegerValue() +
            ", precisionValue=" + getPrecisionValue() +
            ", timeValue='" + getTimeValue() + "'" +
            "}";
    }
}
