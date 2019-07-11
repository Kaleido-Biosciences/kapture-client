/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A concept scheme is a collection of Concepts that
 * fit within a vocabulary domain or ontology.
 * @author Mark Schreiber
 */
public class ConceptScheme implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The official name of the concept
     */
    @NotNull
    private String label;

    /**
     * A description of the type of concepts in the scheme
     */
    private String description;

    /**
     * Set to true when a Concept is retired or replaced.
     */
    private Boolean retired;

    /**
     * Editorial notes associated with this concept scheme
     */
    @JsonIgnore
    private Set<Note> notes = new HashSet<>();

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

    public ConceptScheme label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public ConceptScheme description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRetired() {
        return retired;
    }

    public ConceptScheme retired(Boolean retired) {
        this.retired = retired;
        return this;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public ConceptScheme notes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    public ConceptScheme addNotes(Note note) {
        this.notes.add(note);
        note.setAnnotatedScheme(this);
        return this;
    }

    public ConceptScheme removeNotes(Note note) {
        this.notes.remove(note);
        note.setAnnotatedScheme(null);
        return this;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
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
        ConceptScheme conceptScheme = (ConceptScheme) o;
        if (conceptScheme.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), conceptScheme.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ConceptScheme{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            ", description='" + getDescription() + "'" +
            ", retired='" + isRetired() + "'" +
            "}";
    }
}
