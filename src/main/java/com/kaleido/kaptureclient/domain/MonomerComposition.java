package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Monomer Composition that represents the percent of each Monomer in a Batch
 */
public class MonomerComposition implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The Abbreviation of the monomer composition
     */
    private String abbreviation;

    /**
     * A percent for the selected Monomer
     */
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "100")
    private Double monomerPercent;

    /**
     * The monomers associated with a monomer composition
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Monomer monomer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public MonomerComposition abbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Double getMonomerPercent() {
        return monomerPercent;
    }

    public MonomerComposition monomerPercent(Double monomerPercent) {
        this.monomerPercent = monomerPercent;
        return this;
    }

    public void setMonomerPercent(Double monomerPercent) {
        this.monomerPercent = monomerPercent;
    }

    public Monomer getMonomer() {
        return monomer;
    }

    public MonomerComposition monomer(Monomer monomer) {
        this.monomer = monomer;
        return this;
    }

    public void setMonomer(Monomer monomer) {
        this.monomer = monomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MonomerComposition monomerComposition = (MonomerComposition) o;
        if (monomerComposition.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), monomerComposition.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MonomerComposition{" +
            "id=" + getId() +
            ", abbreviation='" + getAbbreviation() + "'" +
            ", monomerPercent=" + getMonomerPercent() +
            "}";
    }
}
