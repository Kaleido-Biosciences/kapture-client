/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a well on a plate
 */
public class Well implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The row coordinate, one or more uppercase characters
     */
    @NotNull
    @Pattern(regexp = "[A-Z]+")
    private String row;

    /**
     * The column coordinate
     */
    @NotNull
    private Integer column;

    @NotNull
    @JsonIgnoreProperties("")
    private Platemap platemap;

    @JsonIgnoreProperties({"wells", "communityCompositions", "supplementsMetadata", "batchLotCompositions", "mediaLotCompositions"})
    private Sample sample;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public Well row(String row) {
        this.row = row;
        return this;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public Well column(Integer column) {
        this.column = column;
        return this;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Platemap getPlatemap() {
        return platemap;
    }

    public Well platemap(Platemap platemap) {
        this.platemap = platemap;
        return this;
    }

    public void setPlatemap(Platemap platemap) {
        this.platemap = platemap;
    }

    public Sample getSample() {
        return sample;
    }

    public Well sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
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
        Well well = (Well) o;
        if (well.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), well.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Well{" +
            "id=" + getId() +
            ", row='" + getRow() + "'" +
            ", column=" + getColumn() +
            "}";
    }
}
