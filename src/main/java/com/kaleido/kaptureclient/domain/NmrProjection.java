package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A projection in an NMR
 */
public class NmrProjection implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String runMode;

    private String region;

    @NotNull
    private Double x;

    @NotNull
    private Double y;

    @NotNull
    private ZonedDateTime importDate;

    private String kidsId;

    /**
     * The assay the projection comes from
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

    public String getRunMode() {
        return runMode;
    }

    public NmrProjection runMode(String runMode) {
        this.runMode = runMode;
        return this;
    }

    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }

    public String getRegion() {
        return region;
    }

    public NmrProjection region(String region) {
        this.region = region;
        return this;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getX() {
        return x;
    }

    public NmrProjection x(Double x) {
        this.x = x;
        return this;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public NmrProjection y(Double y) {
        this.y = y;
        return this;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public ZonedDateTime getImportDate() {
        return importDate;
    }

    public NmrProjection importDate(ZonedDateTime importDate) {
        this.importDate = importDate;
        return this;
    }

    public void setImportDate(ZonedDateTime importDate) {
        this.importDate = importDate;
    }

    public String getKidsId() {
        return kidsId;
    }

    public NmrProjection kidsId(String kidsId) {
        this.kidsId = kidsId;
        return this;
    }

    public void setKidsId(String kidsId) {
        this.kidsId = kidsId;
    }

    public NmrAssay getNmrAssay() {
        return nmrAssay;
    }

    public NmrProjection nmrAssay(NmrAssay nmrAssay) {
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
        NmrProjection nmrProjection = (NmrProjection) o;
        if (nmrProjection.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrProjection.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrProjection{" +
            "id=" + getId() +
            ", runMode='" + getRunMode() + "'" +
            ", region='" + getRegion() + "'" +
            ", x=" + getX() +
            ", y=" + getY() +
            ", importDate='" + getImportDate() + "'" +
            ", kidsId='" + getKidsId() + "'" +
            "}";
    }
}
