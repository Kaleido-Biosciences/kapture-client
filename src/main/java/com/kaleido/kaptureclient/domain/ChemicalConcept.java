/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The specification of a chemical class
 */
public class ChemicalConcept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The chemical concept Id
     */
    @NotNull
    private String conceptId;

    /**
     * The person who registered this concept
     */
    private String createdBy;

    /**
     * The LIMs record reference
     */
    private String dataRecordName;

    /**
     * Is this concept active
     */
    private Boolean isActive;

    /**
     * The date of the concept registration
     */
    private ZonedDateTime dateCreated;

    /**
     * a list of alternative names
     */
    private String aliases;

    /**
     * The specification of the class
     */
    private String qualifiers;

    /**
     * additional notes
     */
    private String notes;

    @JsonIgnore
    private Set<Batch> batches = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConceptId() {
        return conceptId;
    }

    public ChemicalConcept conceptId(String conceptId) {
        this.conceptId = conceptId;
        return this;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ChemicalConcept createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public ChemicalConcept dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public ChemicalConcept isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ChemicalConcept dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAliases() {
        return aliases;
    }

    public ChemicalConcept aliases(String aliases) {
        this.aliases = aliases;
        return this;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getQualifiers() {
        return qualifiers;
    }

    public ChemicalConcept qualifiers(String qualifiers) {
        this.qualifiers = qualifiers;
        return this;
    }

    public void setQualifiers(String qualifiers) {
        this.qualifiers = qualifiers;
    }

    public String getNotes() {
        return notes;
    }

    public ChemicalConcept notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Batch> getBatches() {
        return batches;
    }

    public ChemicalConcept batches(Set<Batch> batches) {
        this.batches = batches;
        return this;
    }

    public ChemicalConcept addBatches(Batch batch) {
        this.batches.add(batch);
        batch.getConcepts().add(this);
        return this;
    }

    public ChemicalConcept removeBatches(Batch batch) {
        this.batches.remove(batch);
        batch.getConcepts().remove(this);
        return this;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
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
        ChemicalConcept chemicalConcept = (ChemicalConcept) o;
        if (chemicalConcept.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), chemicalConcept.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ChemicalConcept{" +
            "id=" + getId() +
            ", conceptId='" + getConceptId() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", dataRecordName='" + getDataRecordName() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", aliases='" + getAliases() + "'" +
            ", qualifiers='" + getQualifiers() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
