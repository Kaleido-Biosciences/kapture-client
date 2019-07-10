/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A synonym
 * @author Mark Schreiber
 */

public class AltLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String label;

    /**
     * The Concept for which this is an alternative label
     */
    private Concept synonymOf;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public AltLabel label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Concept getSynonymOf() {
        return synonymOf;
    }

    public AltLabel synonymOf(Concept concept) {
        this.synonymOf = concept;
        return this;
    }

    public void setSynonymOf(Concept concept) {
        this.synonymOf = concept;
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
        AltLabel altLabel = (AltLabel) o;
        if (altLabel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), altLabel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AltLabel{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            "}";
    }
}
