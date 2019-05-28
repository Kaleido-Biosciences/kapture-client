package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * An editorial annotation. May be placed on a ConceptScheme, a Concept or an Annotation
 * @author Mark Schreiber
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The content of the note
     */
    @NotNull
    @Size(min = 3)
    private String content;

    /**
     * This Note annotates this {@link Concept}
     */
    private Concept annotatedConcept;

    /**
     * This Note annotates this {@link ConceptScheme}
     */
    private ConceptScheme annotatedScheme;

    /**
     * This Note annotates this {@link Association}
     */
    private Association annotatedAssociation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public Note content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Concept getAnnotatedConcept() {
        return annotatedConcept;
    }

    public Note annotatedConcept(Concept concept) {
        this.annotatedConcept = concept;
        return this;
    }

    public void setAnnotatedConcept(Concept concept) {
        this.annotatedConcept = concept;
    }

    public ConceptScheme getAnnotatedScheme() {
        return annotatedScheme;
    }

    public Note annotatedScheme(ConceptScheme conceptScheme) {
        this.annotatedScheme = conceptScheme;
        return this;
    }

    public void setAnnotatedScheme(ConceptScheme conceptScheme) {
        this.annotatedScheme = conceptScheme;
    }

    public Association getAnnotatedAssociation() {
        return annotatedAssociation;
    }

    public Note annotatedAssociation(Association association) {
        this.annotatedAssociation = association;
        return this;
    }

    public void setAnnotatedAssociation(Association association) {
        this.annotatedAssociation = association;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Note note = (Note) o;
        if (note.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), note.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", content='" + getContent() + "'" +
            "}";
    }
}
