/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * One or more batch lots are created from a batch
 */
public class BatchLot implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The barcode of a batch lot
     */
    private String barcode;

    /**
     * The concentration of a batch lot (w/v %)
     */
    private Float concentration;

    /**
     * The starting quantity of a batch lot in gram or milliliter
     */
    private Float startingQuantity;

    /**
     * The available quantity of a batch lot in gram or milliliter
     */
    private Float availableQuantity;

    /**
     * The time the batch lot was registered
     */
    private ZonedDateTime dateCreated;

    /**
     * One and more batch lots are created from a batch
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Batch batch;

    /**
     * The unit of the available and starting quantity, it can be gram or milliliter
     */
    @JsonIgnoreProperties("")
    private Concept quantityUnit;

    /**
     * The solvent used in the batch lot
     */
    @JsonIgnoreProperties("")
    private Concept solvent;

    /**
     * The scientist who registered the batch lot
     */
    @JsonIgnoreProperties("")
    private Scientist createdBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public BatchLot barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Float getConcentration() {
        return concentration;
    }

    public BatchLot concentration(Float concentration) {
        this.concentration = concentration;
        return this;
    }

    public void setConcentration(Float concentration) {
        this.concentration = concentration;
    }

    public Float getStartingQuantity() {
        return startingQuantity;
    }

    public BatchLot startingQuantity(Float startingQuantity) {
        this.startingQuantity = startingQuantity;
        return this;
    }

    public void setStartingQuantity(Float startingQuantity) {
        this.startingQuantity = startingQuantity;
    }

    public Float getAvailableQuantity() {
        return availableQuantity;
    }

    public BatchLot availableQuantity(Float availableQuantity) {
        this.availableQuantity = availableQuantity;
        return this;
    }

    public void setAvailableQuantity(Float availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public BatchLot dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Batch getBatch() {
        return batch;
    }

    public BatchLot batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Concept getQuantityUnit() {
        return quantityUnit;
    }

    public BatchLot quantityUnit(Concept concept) {
        this.quantityUnit = concept;
        return this;
    }

    public void setQuantityUnit(Concept concept) {
        this.quantityUnit = concept;
    }

    public Concept getSolvent() {
        return solvent;
    }

    public BatchLot solvent(Concept concept) {
        this.solvent = concept;
        return this;
    }

    public void setSolvent(Concept concept) {
        this.solvent = concept;
    }

    public Scientist getCreatedBy() {
        return createdBy;
    }

    public BatchLot createdBy(Scientist scientist) {
        this.createdBy = scientist;
        return this;
    }

    public void setCreatedBy(Scientist scientist) {
        this.createdBy = scientist;
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
        BatchLot batchLot = (BatchLot) o;
        if (batchLot.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batchLot.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BatchLot{" +
            "id=" + getId() +
            ", barcode='" + getBarcode() + "'" +
            ", concentration=" + getConcentration() +
            ", startingQuantity=" + getStartingQuantity() +
            ", availableQuantity=" + getAvailableQuantity() +
            ", dateCreated='" + getDateCreated() + "'" +
            "}";
    }
}
