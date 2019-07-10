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
            "}";
    }
}
