package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A synonym
 * @author Mark Schreiber
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AltLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String label;

    /**
     * The Concept for which this is an alternative label
     */
    private Concept synonymOf;

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
