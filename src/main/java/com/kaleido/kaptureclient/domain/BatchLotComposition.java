/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * One batch lot composition is associated with one batch lot
 */
public class BatchLotComposition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of a batch lot composition
     */
    @NotNull
    private String name;

    /**
     * A percentage of a batch lot in a composition
     */
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "100")
    private Double percent;

    @NotNull
    @JsonIgnoreProperties("")
    private BatchLot batchLot;

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

    public BatchLotComposition name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercent() {
        return percent;
    }

    public BatchLotComposition percent(Double percent) {
        this.percent = percent;
        return this;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public BatchLot getBatchLot() {
        return batchLot;
    }

    public BatchLotComposition batchLot(BatchLot batchLot) {
        this.batchLot = batchLot;
        return this;
    }

    public void setBatchLot(BatchLot batchLot) {
        this.batchLot = batchLot;
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
        BatchLotComposition batchLotComposition = (BatchLotComposition) o;
        if (batchLotComposition.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batchLotComposition.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BatchLotComposition{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", percent=" + getPercent() +
            "}";
    }
}
