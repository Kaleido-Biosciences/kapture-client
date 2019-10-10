package com.kaleido.kaptureclient.domain.dto;

import java.time.ZonedDateTime;

public class AssayReadoutPropertyDTO {

    /**
     * The id of the assay readout property, null creates a new one
     */
    private Long id;

    /**
     * The key of the property. The use of name spaced keys is encouraged.
     */
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
     * This is the constructor for properties with text value
     * @param id
     * @param name
     * @param textValue
     */
    public AssayReadoutPropertyDTO(Long id,
                                   String name,
                                   String textValue) {
        this.id = id;
        this.name = name;
        this.textValue = textValue;
        this.integerValue = null;
        this.precisionValue = null;
        this.timeValue = null;
    }

    /**
     * Constructor for properties with integer values
     * @param id
     * @param name
     * @param integerValue
     */
    public AssayReadoutPropertyDTO(Long id,
                                   String name,
                                   Integer integerValue) {
        this.id = id;
        this.name = name;
        this.textValue = null;
        this.integerValue = integerValue;
        this.precisionValue = null;
        this.timeValue = null;
    }

    /**
     * Constructor for properties with double values
     * @param id
     * @param name
     * @param precisionValue
     */
    public AssayReadoutPropertyDTO(Long id,
                                   String name,
                                   Double precisionValue) {
        this.id = id;
        this.name = name;
        this.textValue = null;
        this.integerValue = null;
        this.precisionValue = precisionValue;
        this.timeValue = null;
    }

    /**
     * Constructor for Time value
     * @param id
     * @param name
     * @param timeValue
     */
    public AssayReadoutPropertyDTO(Long id,
                                   String name,
                                   ZonedDateTime timeValue) {
        this.id = id;
        this.name = name;
        this.textValue = null;
        this.integerValue = null;
        this.precisionValue = null;
        this.timeValue = timeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getPrecisionValue() {
        return precisionValue;
    }

    public void setPrecisionValue(Double precisionValue) {
        this.precisionValue = precisionValue;
    }

    public ZonedDateTime getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(ZonedDateTime timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public String toString() {
        return "AssayReadoutPropertyDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", textValue='" + textValue + '\'' +
            ", integerValue=" + integerValue +
            ", precisionValue=" + precisionValue +
            ", timeValue=" + timeValue +
            '}';
    }
}
