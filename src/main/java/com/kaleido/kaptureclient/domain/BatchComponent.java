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
 * A batch component is one component that makes up a batch that is a combination (KC). Was compound-combination in expt-db
 */
public class BatchComponent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The proportion of this component in the parent batch
     */
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "1")
    private Float proportion;

    /**
     * The batch this component is a component of
     */
    @JsonIgnoreProperties("")
    private Batch parent;

    /**
     * The batch that has the stated proportion
     */
    @JsonIgnoreProperties("")
    private Batch batch;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getProportion() {
        return proportion;
    }

    public BatchComponent proportion(Float proportion) {
        this.proportion = proportion;
        return this;
    }

    public void setProportion(Float proportion) {
        this.proportion = proportion;
    }

    public Batch getParent() {
        return parent;
    }

    public BatchComponent parent(Batch batch) {
        this.parent = batch;
        return this;
    }

    public void setParent(Batch batch) {
        this.parent = batch;
    }

    public Batch getBatch() {
        return batch;
    }

    public BatchComponent batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
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
        BatchComponent batchComponent = (BatchComponent) o;
        if (batchComponent.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batchComponent.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BatchComponent{" +
            "id=" + getId() +
            ", proportion=" + getProportion() +
            "}";
    }
}
