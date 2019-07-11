/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.kaleido.kaptureclient.domain.enumeration.BottomType;
import com.kaleido.kaptureclient.domain.enumeration.Material;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Plate Types that can be associated with experiments
 * @author Patrick Kyle
 */
public class PlateType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the Plate Type
     */
    @NotNull
    private String name;

    /**
     * The Material of the Plate Type
     */
    private Material material;

    /**
     * Volume
     */
    @NotNull
    private Integer volume;

    /**
     * Bottom Type
     */
    @NotNull
    private BottomType bottomType;

    /**
     * The number of wells in the plate
     */
    private Integer numberOfWells;

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

    public PlateType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public PlateType material(Material material) {
        this.material = material;
        return this;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getVolume() {
        return volume;
    }

    public PlateType volume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public BottomType getBottomType() {
        return bottomType;
    }

    public PlateType bottomType(BottomType bottomType) {
        this.bottomType = bottomType;
        return this;
    }

    public void setBottomType(BottomType bottomType) {
        this.bottomType = bottomType;
    }

    public Integer getNumberOfWells() {
        return numberOfWells;
    }

    public PlateType numberOfWells(Integer numberOfWells) {
        this.numberOfWells = numberOfWells;
        return this;
    }

    public void setNumberOfWells(Integer numberOfWells) {
        this.numberOfWells = numberOfWells;
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
        PlateType plateType = (PlateType) o;
        if (plateType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), plateType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlateType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", material='" + getMaterial() + "'" +
            ", volume=" + getVolume() +
            ", bottomType='" + getBottomType() + "'" +
            ", numberOfWells=" + getNumberOfWells() +
            "}";
    }
}
