package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaleido.kaptureclient.domain.enumeration.BottomType;
import com.kaleido.kaptureclient.domain.enumeration.Material;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Plate Types that can be associated with experiments
 * @author Patrick Kyle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
            "}";
    }
}
