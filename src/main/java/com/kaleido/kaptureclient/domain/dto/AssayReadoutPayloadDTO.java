package com.kaleido.kaptureclient.domain.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class AssayReadoutPayloadDTO {

    /**
     * The ID of the assay, if it exists it will overwrite the current assay readout
     * NULL is a valid thing to pass for the ID
     */
    private Long id;

    /**
     * the number of the assay
     */
    private Integer assayNumber;

    /**
     * the value obtained by the assay
     */
    private Double value;

    /**
     * the unit of the value
     */
    private String unit;

    /**
     * the assay result is approved for release to others
     */
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

    /**
     * Name of the analyte that will be linked to
     */
    private String analyteName;

    private List<AssayReadoutPropertyDTO> assayReadoutPropertyList;

    public AssayReadoutPayloadDTO() {
    }

    /**
     * Constructor for when an ID is available.
     * @param id
     * @param assayNumber
     * @param value
     * @param unit
     * @param isReleased
     * @param timestamp
     * @param temperature
     * @param dilutionFactor
     * @param timePoint
     * @param protocolName
     * @param analyteName
     * @param assayReadoutPropertyList
     */
    public AssayReadoutPayloadDTO(Long id,
                                  Integer assayNumber,
                                  Double value,
                                  String unit,
                                  Boolean isReleased,
                                  ZonedDateTime timestamp,
                                  Double temperature,
                                  Double dilutionFactor,
                                  Float timePoint,
                                  String protocolName,
                                  String analyteName,
                                  List<AssayReadoutPropertyDTO> assayReadoutPropertyList) {
        this.id = id;
        this.assayNumber = assayNumber;
        this.value = value;
        this.unit = unit;
        this.isReleased = isReleased;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.dilutionFactor = dilutionFactor;
        this.timePoint = timePoint;
        this.protocolName = protocolName;
        this.analyteName = analyteName;
        this.assayReadoutPropertyList = assayReadoutPropertyList;
    }

    /**
     * Constructor for when there is no ID effectively creating a new record
     * @param assayNumber
     * @param value
     * @param unit
     * @param isReleased
     * @param timestamp
     * @param temperature
     * @param dilutionFactor
     * @param timePoint
     * @param protocolName
     * @param analyteName
     * @param assayReadoutPropertyList
     */
    public AssayReadoutPayloadDTO(Integer assayNumber,
                                  Double value,
                                  String unit,
                                  Boolean isReleased,
                                  ZonedDateTime timestamp,
                                  Double temperature,
                                  Double dilutionFactor,
                                  Float timePoint,
                                  String protocolName,
                                  String analyteName,
                                  List<AssayReadoutPropertyDTO> assayReadoutPropertyList) {
        this.id = null;
        this.assayNumber = assayNumber;
        this.value = value;
        this.unit = unit;
        this.isReleased = isReleased;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.dilutionFactor = dilutionFactor;
        this.timePoint = timePoint;
        this.protocolName = protocolName;
        this.analyteName = analyteName;
        this.assayReadoutPropertyList = assayReadoutPropertyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAssayNumber() {
        return assayNumber;
    }

    public void setAssayNumber(Integer assayNumber) {
        this.assayNumber = assayNumber;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getReleased() {
        return isReleased;
    }

    public void setReleased(Boolean released) {
        isReleased = released;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getDilutionFactor() {
        return dilutionFactor;
    }

    public void setDilutionFactor(Double dilutionFactor) {
        this.dilutionFactor = dilutionFactor;
    }

    public Float getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(Float timePoint) {
        this.timePoint = timePoint;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getAnalyteName() {
        return analyteName;
    }

    public void setAnalyteName(String analyteName) {
        this.analyteName = analyteName;
    }

    public List<AssayReadoutPropertyDTO> getAssayReadoutPropertyList() {
        return assayReadoutPropertyList;
    }

    public void setAssayReadoutPropertyList(List<AssayReadoutPropertyDTO> assayReadoutPropertyList) {
        this.assayReadoutPropertyList = assayReadoutPropertyList;
    }

    @Override
    public String toString() {
        return "AssayReadoutPayloadDTO{" +
            "id=" + id +
            ", assayNumber=" + assayNumber +
            ", value=" + value +
            ", unit='" + unit + '\'' +
            ", isReleased=" + isReleased +
            ", timestamp=" + timestamp +
            ", temperature=" + temperature +
            ", dilutionFactor=" + dilutionFactor +
            ", timePoint=" + timePoint +
            ", protocolName='" + protocolName + '\'' +
            ", analyteName='" + analyteName + '\'' +
            ", assayReadoutPropertyList=" + assayReadoutPropertyList +
            '}';
    }
}
