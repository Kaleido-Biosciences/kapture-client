/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Observed Taxonomic Unit (OTU)
 */
public class ObservedTaxonomicUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * the OTU name
     */
    @NotNull
    private String name;

    /**
     * the sequence of the OTU
     */
    private String seq;

    /**
     * The phyogenetic kingdom
     */
    private String kingdom;

    /**
     * The phyogenetic phylum
     */
    private String phylum;

    /**
     * The phyogenetic class
     */
    private String classTaxon;

    /**
     * The phyogenetic order
     */
    private String orderTaxon;

    /**
     * The phyogenetic family
     */
    private String family;

    /**
     * The phyogenetic genus
     */
    private String genus;

    /**
     * The phyogenetic species
     */
    private String species;

    /**
     * The phyogenetic strain
     */
    private String strain;

    /**
     * The OTU platform used
     */
    private String platform;

    /**
     * Time otu was created
     */
    private ZonedDateTime timestamp;

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

    public ObservedTaxonomicUnit name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeq() {
        return seq;
    }

    public ObservedTaxonomicUnit seq(String seq) {
        this.seq = seq;
        return this;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getKingdom() {
        return kingdom;
    }

    public ObservedTaxonomicUnit kingdom(String kingdom) {
        this.kingdom = kingdom;
        return this;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public ObservedTaxonomicUnit phylum(String phylum) {
        this.phylum = phylum;
        return this;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getClassTaxon() {
        return classTaxon;
    }

    public ObservedTaxonomicUnit classTaxon(String classTaxon) {
        this.classTaxon = classTaxon;
        return this;
    }

    public void setClassTaxon(String classTaxon) {
        this.classTaxon = classTaxon;
    }

    public String getOrderTaxon() {
        return orderTaxon;
    }

    public ObservedTaxonomicUnit orderTaxon(String orderTaxon) {
        this.orderTaxon = orderTaxon;
        return this;
    }

    public void setOrderTaxon(String orderTaxon) {
        this.orderTaxon = orderTaxon;
    }

    public String getFamily() {
        return family;
    }

    public ObservedTaxonomicUnit family(String family) {
        this.family = family;
        return this;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public ObservedTaxonomicUnit genus(String genus) {
        this.genus = genus;
        return this;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public ObservedTaxonomicUnit species(String species) {
        this.species = species;
        return this;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStrain() {
        return strain;
    }

    public ObservedTaxonomicUnit strain(String strain) {
        this.strain = strain;
        return this;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public String getPlatform() {
        return platform;
    }

    public ObservedTaxonomicUnit platform(String platform) {
        this.platform = platform;
        return this;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public ObservedTaxonomicUnit timestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
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
        ObservedTaxonomicUnit observedTaxonomicUnit = (ObservedTaxonomicUnit) o;
        if (observedTaxonomicUnit.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), observedTaxonomicUnit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ObservedTaxonomicUnit{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", seq='" + getSeq() + "'" +
            ", kingdom='" + getKingdom() + "'" +
            ", phylum='" + getPhylum() + "'" +
            ", classTaxon='" + getClassTaxon() + "'" +
            ", orderTaxon='" + getOrderTaxon() + "'" +
            ", family='" + getFamily() + "'" +
            ", genus='" + getGenus() + "'" +
            ", species='" + getSpecies() + "'" +
            ", strain='" + getStrain() + "'" +
            ", platform='" + getPlatform() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }
}
