/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaleido.kaptureclient.domain.enumeration.AssociationType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Establishes a relationship between two concepts.
 * The {@code subject} is associated with the {@code object}
 * through a {@code predicate} which establishes the
 * association type.
 * @author Mark Schreiber
 */
public class Association implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The type of association between the {@code subject}
     * and the {@code object}
     * The relationship is directional from subject to object
     */
    @NotNull
    private AssociationType predicate;

    /**
     * Editorial notes associated with this relationship
     */
    @JsonIgnore
    private Set<Note> notes = new HashSet<>();

    /**
     * The Concept that is the subject of the relationship
     */
    @NotNull
    private Concept subject;

    /**
     * The Concept that is the object of the relationship
     */
    @NotNull
    private Concept object;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssociationType getPredicate() {
        return predicate;
    }

    public Association predicate(AssociationType predicate) {
        this.predicate = predicate;
        return this;
    }

    public void setPredicate(AssociationType predicate) {
        this.predicate = predicate;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public Association notes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    public Association addNotes(Note note) {
        this.notes.add(note);
        note.setAnnotatedAssociation(this);
        return this;
    }

    public Association removeNotes(Note note) {
        this.notes.remove(note);
        note.setAnnotatedAssociation(null);
        return this;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Concept getSubject() {
        return subject;
    }

    public Association subject(Concept concept) {
        this.subject = concept;
        return this;
    }

    public void setSubject(Concept concept) {
        this.subject = concept;
    }

    public Concept getObject() {
        return object;
    }

    public Association object(Concept concept) {
        this.object = concept;
        return this;
    }

    public void setObject(Concept concept) {
        this.object = concept;
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
        Association association = (Association) o;
        if (association.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), association.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Association{" +
            "id=" + getId() +
            ", predicate='" + getPredicate() + "'" +
            "}";
    }
}
