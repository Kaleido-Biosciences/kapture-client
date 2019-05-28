package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * NMR assay
 */
public class NmrAssay implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * Date of the NMR assay
     */
    @NotNull
    private ZonedDateTime assayDate;

    /**
     * Type of NMR assay, e.g. Compound
     */
    @NotNull
    private String assayType;

    /**
     * Scientist who ordered the NMR
     */
    @NotNull
    private String scientist;

    /**
     * rack number
     */
    @NotNull
    @Min(value = 0)
    private Integer rack;

    /**
     * The batch that was assayed
     */
    @JsonIgnoreProperties("")
    private Batch batch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getAssayDate() {
        return assayDate;
    }

    public NmrAssay assayDate(ZonedDateTime assayDate) {
        this.assayDate = assayDate;
        return this;
    }

    public void setAssayDate(ZonedDateTime assayDate) {
        this.assayDate = assayDate;
    }

    public String getAssayType() {
        return assayType;
    }

    public NmrAssay assayType(String assayType) {
        this.assayType = assayType;
        return this;
    }

    public void setAssayType(String assayType) {
        this.assayType = assayType;
    }

    public String getScientist() {
        return scientist;
    }

    public NmrAssay scientist(String scientist) {
        this.scientist = scientist;
        return this;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    public Integer getRack() {
        return rack;
    }

    public NmrAssay rack(Integer rack) {
        this.rack = rack;
        return this;
    }

    public void setRack(Integer rack) {
        this.rack = rack;
    }

    public Batch getBatch() {
        return batch;
    }

    public NmrAssay batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NmrAssay nmrAssay = (NmrAssay) o;
        if (nmrAssay.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrAssay.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrAssay{" +
            "id=" + getId() +
            ", assayDate='" + getAssayDate() + "'" +
            ", assayType='" + getAssayType() + "'" +
            ", scientist='" + getScientist() + "'" +
            ", rack=" + getRack() +
            "}";
    }
}
