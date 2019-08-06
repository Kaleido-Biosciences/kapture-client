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
 * A Sample may be treated with one or many supplements added with media
 */
public class Supplement implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The Source of the supplement (e.g. vendor, physical source, etc...)
     */
    private String source;

    /**
     * The Description of the supplement
     */
    private String description;

    /**
     * The time that the supplement was registered
     */
    private ZonedDateTime registrationDate;

    /**
     * Properties that describe a Supplement instance
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Concept name;

    @JsonIgnoreProperties("")
    private Concept classification;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public Supplement source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getDescription() {
        return description;
    }

    public Supplement description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Supplement registrationDate(ZonedDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public void setRegistrationDate(ZonedDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Concept getName() {
        return name;
    }

    public Supplement name(Concept concept) {
        this.name = concept;
        return this;
    }

    public void setName(Concept concept) {
        this.name = concept;
    }

    public Concept getClassification() {
        return classification;
    }

    public Supplement classification(Concept concept) {
        this.classification = concept;
        return this;
    }

    public void setClassification(Concept concept) {
        this.classification = concept;
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
        Supplement supplement = (Supplement) o;
        if (supplement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), supplement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Supplement{" +
                "id=" + getId() +
                ", source='" + getSource() + "'" +
                ", description='" + getDescription() + "'" +
                ", registrationDate='" + getRegistrationDate() + "'" +
                "}";
    }
}
