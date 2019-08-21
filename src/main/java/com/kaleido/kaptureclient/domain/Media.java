/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Media used in an experiment
 */
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the Media
     */
    @NotNull
    private String name;

    /**
     * The description of the Media
     */
    private String description;

    /**
     * Media ph level
     */
    private Float ph;

    /**
     * When the media was created
     */
    private ZonedDateTime dateCreated;

    /**
     * This is the media that the media recipe is derived from or is based on
     */
    private Media baseMedia;

    /**
     * The scientist associated with the experiment
     */
    private Scientist scientist;

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

    public Media name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Media description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPh() {
        return ph;
    }

    public Media ph(Float ph) {
        this.ph = ph;
        return this;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public Media dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Media getBaseMedia() {
        return baseMedia;
    }

    public Media baseMedia(Media media) {
        this.baseMedia = media;
        return this;
    }

    public void setBaseMedia(Media media) {
        this.baseMedia = media;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public Media scientist(Scientist scientist) {
        this.scientist = scientist;
        return this;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
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
        Media media = (Media) o;
        if (media.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), media.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Media{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", ph=" + getPh() +
            ", dateCreated='" + getDateCreated() + "'" +
            "}";
    }
}
