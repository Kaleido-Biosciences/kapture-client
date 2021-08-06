/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A peak in an NMR
 */
public class NmrPeak implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private Double f1;

    @NotNull
    private Double f2;

    @NotNull
    private Double intensity;

    @NotNull
    private Double width1;

    @NotNull
    private Double width2;

    @NotNull
    private Double area;

    private Integer peakNumber;

    private Double absoluteIntegral;

    private Double integralPpm1;

    private Double integralPpm2;

    private Double normalizedIntegral;

    private String annotation;

    private String maxMin;

    private Double hz1;

    private Double hz2;

    private String type;

    private String assignment;

    private String assignmentType;

    private String assignment2;

    private Double assignmentDistance;

    /**
     * The assay the peak comes from
     */
    @JsonIgnoreProperties("")
    private NmrAssay nmrAssay;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getf1() {
        return f1;
    }

    public NmrPeak f1(Double f1) {
        this.f1 = f1;
        return this;
    }

    public void setf1(Double f1) {
        this.f1 = f1;
    }

    public Double getf2() {
        return f2;
    }

    public NmrPeak f2(Double f2) {
        this.f2 = f2;
        return this;
    }

    public void setf2(Double f2) {
        this.f2 = f2;
    }

    public Double getIntensity() {
        return intensity;
    }

    public NmrPeak intensity(Double intensity) {
        this.intensity = intensity;
        return this;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public Double getWidth1() {
        return width1;
    }

    public NmrPeak width1(Double width1) {
        this.width1 = width1;
        return this;
    }

    public void setWidth1(Double width1) {
        this.width1 = width1;
    }

    public Double getWidth2() {
        return width2;
    }

    public NmrPeak width2(Double width2) {
        this.width2 = width2;
        return this;
    }

    public void setWidth2(Double width2) {
        this.width2 = width2;
    }

    public Double getArea() {
        return area;
    }

    public NmrPeak area(Double area) {
        this.area = area;
        return this;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getPeakNumber() {
        return peakNumber;
    }

    public NmrPeak peakNumber(Integer peakNumber) {
        this.peakNumber = peakNumber;
        return this;
    }

    public void setPeakNumber(Integer peakNumber) {
        this.peakNumber = peakNumber;
    }

    public Double getAbsoluteIntegral() {
        return absoluteIntegral;
    }

    public NmrPeak absoluteIntegral(Double absoluteIntegral) {
        this.absoluteIntegral = absoluteIntegral;
        return this;
    }

    public void setAbsoluteIntegral(Double absoluteIntegral) {
        this.absoluteIntegral = absoluteIntegral;
    }

    public Double getIntegralPpm1() {
        return integralPpm1;
    }

    public NmrPeak integralPpm1(Double integralPpm1) {
        this.integralPpm1 = integralPpm1;
        return this;
    }

    public void setIntegralPpm1(Double integralPpm1) {
        this.integralPpm1 = integralPpm1;
    }

    public Double getIntegralPpm2() {
        return integralPpm2;
    }

    public NmrPeak integralPpm2(Double integralPpm2) {
        this.integralPpm2 = integralPpm2;
        return this;
    }

    public void setIntegralPpm2(Double integralPpm2) {
        this.integralPpm2 = integralPpm2;
    }

    public Double getNormalizedIntegral() {
        return normalizedIntegral;
    }

    public NmrPeak normalizedIntegral(Double normalizedIntegral) {
        this.normalizedIntegral = normalizedIntegral;
        return this;
    }

    public void setNormalizedIntegral(Double normalizedIntegral) {
        this.normalizedIntegral = normalizedIntegral;
    }

    public String getAnnotation() {
        return annotation;
    }

    public NmrPeak annotation(String annotation) {
        this.annotation = annotation;
        return this;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getMaxMin() {
        return maxMin;
    }

    public NmrPeak maxMin(String maxMin) {
        this.maxMin = maxMin;
        return this;
    }

    public void setMaxMin(String maxMin) {
        this.maxMin = maxMin;
    }

    public Double getHz1() {
        return hz1;
    }

    public NmrPeak hz1(Double hz1) {
        this.hz1 = hz1;
        return this;
    }

    public void setHz1(Double hz1) {
        this.hz1 = hz1;
    }

    public Double getHz2() {
        return hz2;
    }

    public NmrPeak hz2(Double hz2) {
        this.hz2 = hz2;
        return this;
    }

    public void setHz2(Double hz2) {
        this.hz2 = hz2;
    }

    public String getType() {
        return type;
    }

    public NmrPeak type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssignment() {
        return assignment;
    }

    public NmrPeak assignment(String assignment) {
        this.assignment = assignment;
        return this;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public NmrPeak assignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
        return this;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignment2() {
        return assignment2;
    }

    public NmrPeak assignment2(String assignment2) {
        this.assignment2 = assignment2;
        return this;
    }

    public void setAssignment2(String assignment2) {
        this.assignment2 = assignment2;
    }

    public Double getAssignmentDistance() {
        return assignmentDistance;
    }

    public NmrPeak assignmentDistance(Double assignmentDistance) {
        this.assignmentDistance = assignmentDistance;
        return this;
    }

    public void setAssignmentDistance(Double assignmentDistance) {
        this.assignmentDistance = assignmentDistance;
    }

    public NmrAssay getNmrAssay() {
        return nmrAssay;
    }

    public NmrPeak nmrAssay(NmrAssay nmrAssay) {
        this.nmrAssay = nmrAssay;
        return this;
    }

    public void setNmrAssay(NmrAssay nmrAssay) {
        this.nmrAssay = nmrAssay;
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
        NmrPeak nmrPeak = (NmrPeak) o;
        if (nmrPeak.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrPeak.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrPeak{" +
                "id=" + getId() +
                ", f1=" + getf1() +
                ", f2=" + getf2() +
                ", intensity=" + getIntensity() +
                ", width1=" + getWidth1() +
                ", width2=" + getWidth2() +
                ", area=" + getArea() +
                ", peakNumber=" + getPeakNumber() +
                ", absoluteIntegral=" + getAbsoluteIntegral() +
                ", integralPpm1=" + getIntegralPpm1() +
                ", integralPpm2=" + getIntegralPpm2() +
                ", normalizedIntegral=" + getNormalizedIntegral() +
                ", annotation='" + getAnnotation() + "'" +
                ", maxMin='" + getMaxMin() + "'" +
                ", hz1=" + getHz1() +
                ", hz2=" + getHz2() +
                ", type='" + getType() + "'" +
                ", assignment='" + getAssignment() + "'" +
                ", assignmentType='" + getAssignmentType() + "'" +
                ", assignment2='" + getAssignment2() + "'" +
                ", assignmentDistance=" + getAssignmentDistance() +
                "}";
    }
}
