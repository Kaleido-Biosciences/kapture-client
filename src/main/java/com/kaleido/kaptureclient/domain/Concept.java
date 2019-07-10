/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Concept in a concept scheme. In some vocabularies
 * it would be called a Term
 * @author Mark Schreiber
 */
public class Concept implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The official name of the concept
     */
    @NotNull
    private String label;

    /**
     * The common definition of the concept in the context of it's scheme
     */
    @Size(min = 3)
    private String definition;

    /**
     * Set to true when a Concept is retired or replaced.
     * If it is replaced then consider setting one or more
     * follower concepts to indicate the new preferred usage.
     */
    private Boolean retired;

    /**
     * Editorial notes associated with this concept
     */
    @JsonIgnore
    private Set<Note> notes = new HashSet<>();

    /**
     * Synonymous or alternative labels for this concept
     */
    @JsonIgnore
    private Set<AltLabel> synonyms = new HashSet<>();

    /**
     * The scheme to which this concept belongs
     */
    @NotNull
    private ConceptScheme scheme;

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

    public Concept label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDefinition() {
        return definition;
    }

    public Concept definition(String definition) {
        this.definition = definition;
        return this;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Boolean isRetired() {
        return retired;
    }

    public Concept retired(Boolean retired) {
        this.retired = retired;
        return this;
    }

    public void setRetired(Boolean retired) {
        this.retired = retired;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public Concept notes(Set<Note> notes) {
        this.notes = notes;
        return this;
    }

    public Concept addNotes(Note note) {
        this.notes.add(note);
        note.setAnnotatedConcept(this);
        return this;
    }

    public Concept removeNotes(Note note) {
        this.notes.remove(note);
        note.setAnnotatedConcept(null);
        return this;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<AltLabel> getSynonyms() {
        return synonyms;
    }

    public Concept synonyms(Set<AltLabel> altLabels) {
        this.synonyms = altLabels;
        return this;
    }

    public Concept addSynonyms(AltLabel altLabel) {
        this.synonyms.add(altLabel);
        altLabel.setSynonymOf(this);
        return this;
    }

    public Concept removeSynonyms(AltLabel altLabel) {
        this.synonyms.remove(altLabel);
        altLabel.setSynonymOf(null);
        return this;
    }

    public void setSynonyms(Set<AltLabel> altLabels) {
        this.synonyms = altLabels;
    }

    public ConceptScheme getScheme() {
        return scheme;
    }

    public Concept scheme(ConceptScheme conceptScheme) {
        this.scheme = conceptScheme;
        return this;
    }

    public void setScheme(ConceptScheme conceptScheme) {
        this.scheme = conceptScheme;
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
        Concept concept = (Concept) o;
        if (concept.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), concept.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Concept{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            ", definition='" + getDefinition() + "'" +
            ", retired='" + isRetired() + "'" +
            "}";
    }
}
