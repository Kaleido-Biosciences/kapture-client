/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * One or more MediaLots are created from a Media recipe
 */
public class MediaLot implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The initial amount in the media lot
     */
    private Double quantityCreated;

    /**
     * Description of the media lot
     */
    private String description;

    /**
     * Manufacturers part number
     */
    private String partNumber;

    /**
     * The time that the lot was created
     */
    private ZonedDateTime dateCreated;

    /**
     * Barcode of the lot. Uniquely identifies the lot of Media
     */
    @NotNull
    private String barcode;

    /**
     * Number of bottles containing the lot
     */
    private Integer numberOfBottlesOfMedia;

    /**
     * The unit of volume or mass of the lot
     */
    private String unitOfQuantityCreated;

    /**
     * The lab lot number
     */
    private Integer lotNumber;

    /**
     * The status of the lot, e.g. Available
     */
    private String status;

    /**
     * The username of the individual who created the lot
     */
    private String createdBy;

    /**
     * Indicates if the lot is expired
     */
    private Boolean expired;

    /**
     * The unit of the remaining amount
     */
    private String unitOfQuantityAvailable;

    /**
     * The name of the media lot
     */
    @NotNull
    private String consumableName;

    /**
     * The amount of media remaining in the lot
     */
    private Double quantityRemaining;

    /**
     * The storage location of the lot
     */
    @NotNull
    private String location;

    /**
     * Many media lots can be made for one Media
     */
    @NotNull
    @JsonIgnoreProperties("")
    private Media media;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantityCreated() {
        return quantityCreated;
    }

    public MediaLot quantityCreated(Double quantityCreated) {
        this.quantityCreated = quantityCreated;
        return this;
    }

    public void setQuantityCreated(Double quantityCreated) {
        this.quantityCreated = quantityCreated;
    }

    public String getDescription() {
        return description;
    }

    public MediaLot description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public MediaLot partNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public MediaLot dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBarcode() {
        return barcode;
    }

    public MediaLot barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getNumberOfBottlesOfMedia() {
        return numberOfBottlesOfMedia;
    }

    public MediaLot numberOfBottlesOfMedia(Integer numberOfBottlesOfMedia) {
        this.numberOfBottlesOfMedia = numberOfBottlesOfMedia;
        return this;
    }

    public void setNumberOfBottlesOfMedia(Integer numberOfBottlesOfMedia) {
        this.numberOfBottlesOfMedia = numberOfBottlesOfMedia;
    }

    public String getUnitOfQuantityCreated() {
        return unitOfQuantityCreated;
    }

    public MediaLot unitOfQuantityCreated(String unitOfQuantityCreated) {
        this.unitOfQuantityCreated = unitOfQuantityCreated;
        return this;
    }

    public void setUnitOfQuantityCreated(String unitOfQuantityCreated) {
        this.unitOfQuantityCreated = unitOfQuantityCreated;
    }

    public Integer getLotNumber() {
        return lotNumber;
    }

    public MediaLot lotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    public void setLotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getStatus() {
        return status;
    }

    public MediaLot status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MediaLot createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean isExpired() {
        return expired;
    }

    public MediaLot expired(Boolean expired) {
        this.expired = expired;
        return this;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getUnitOfQuantityAvailable() {
        return unitOfQuantityAvailable;
    }

    public MediaLot unitOfQuantityAvailable(String unitOfQuantityAvailable) {
        this.unitOfQuantityAvailable = unitOfQuantityAvailable;
        return this;
    }

    public void setUnitOfQuantityAvailable(String unitOfQuantityAvailable) {
        this.unitOfQuantityAvailable = unitOfQuantityAvailable;
    }

    public String getConsumableName() {
        return consumableName;
    }

    public MediaLot consumableName(String consumableName) {
        this.consumableName = consumableName;
        return this;
    }

    public void setConsumableName(String consumableName) {
        this.consumableName = consumableName;
    }

    public Double getQuantityRemaining() {
        return quantityRemaining;
    }

    public MediaLot quantityRemaining(Double quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
        return this;
    }

    public void setQuantityRemaining(Double quantityRemaining) {
        this.quantityRemaining = quantityRemaining;
    }

    public String getLocation() {
        return location;
    }

    public MediaLot location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Media getMedia() {
        return media;
    }

    public MediaLot media(Media media) {
        this.media = media;
        return this;
    }

    public void setMedia(Media media) {
        this.media = media;
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
        MediaLot mediaLot = (MediaLot) o;
        if (mediaLot.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mediaLot.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MediaLot{" +
            "id=" + getId() +
            ", quantityCreated=" + getQuantityCreated() +
            ", description='" + getDescription() + "'" +
            ", partNumber='" + getPartNumber() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", numberOfBottlesOfMedia=" + getNumberOfBottlesOfMedia() +
            ", unitOfQuantityCreated='" + getUnitOfQuantityCreated() + "'" +
            ", lotNumber=" + getLotNumber() +
            ", status='" + getStatus() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", expired='" + isExpired() + "'" +
            ", unitOfQuantityAvailable='" + getUnitOfQuantityAvailable() + "'" +
            ", consumableName='" + getConsumableName() + "'" +
            ", quantityRemaining=" + getQuantityRemaining() +
            ", location='" + getLocation() + "'" +
            "}";
    }
}
