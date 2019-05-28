package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Monomer
 */
public class Monomer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * A text value for the name
     */
    @NotNull
    private String name;

    /**
     * Abbreviation of the monomer
     */
    @NotNull
    private String abbreviation;

    /**
     * A description of the monomer
     */
    private String description;

    /**
     * Molecular weight in Daltons
     */
    private String mw;

    /**
     * Chemical Abstracts Service (CAS) Registry Number
     */
    private String casNumber;

    /**
     * LIMS monomer record
     */
    private String dataRecordName;

    /**
     * The person who created this monomer entry
     */
    private String createdBy;

    /**
     * The time the monomer entry was created
     */
    private ZonedDateTime dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Monomer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Monomer abbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public Monomer description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMw() {
        return mw;
    }

    public Monomer mw(String mw) {
        this.mw = mw;
        return this;
    }

    public void setMw(String mw) {
        this.mw = mw;
    }

    public String getCasNumber() {
        return casNumber;
    }

    public Monomer casNumber(String casNumber) {
        this.casNumber = casNumber;
        return this;
    }

    public void setCasNumber(String casNumber) {
        this.casNumber = casNumber;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public Monomer dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Monomer createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public Monomer dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Monomer monomer = (Monomer) o;
        if (monomer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), monomer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Monomer{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", abbreviation='" + getAbbreviation() + "'" +
            ", description='" + getDescription() + "'" +
            ", mw='" + getMw() + "'" +
            ", casNumber='" + getCasNumber() + "'" +
            ", dataRecordName='" + getDataRecordName() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            "}";
    }
}
