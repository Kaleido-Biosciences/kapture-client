/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.kaleido.kaptureclient.domain.enumeration.FileImportStatus;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A file that has been imported into Kapture
 */
public class ImportedFile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The network location of the file
     */
    @NotNull
    private String url;

    /**
     * the storage system - Egnyte, S3 etc
     */
    @NotNull
    private String system;

    /**
     * used to distinguish any relevant file version
     */
    private Float version;

    /**
     * The type of data in the file, e.g. platemap, OD600
     */
    @NotNull
    private String dataType;

    /**
     * the current status of the file import
     */
    @NotNull
    private FileImportStatus status;

    /**
     * the time of import
     */
    private ZonedDateTime importTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public ImportedFile url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSystem() {
        return system;
    }

    public ImportedFile system(String system) {
        this.system = system;
        return this;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Float getVersion() {
        return version;
    }

    public ImportedFile version(Float version) {
        this.version = version;
        return this;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    public String getDataType() {
        return dataType;
    }

    public ImportedFile dataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public FileImportStatus getStatus() {
        return status;
    }

    public ImportedFile status(FileImportStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(FileImportStatus status) {
        this.status = status;
    }

    public ZonedDateTime getImportTime() {
        return importTime;
    }

    public ImportedFile importTime(ZonedDateTime importTime) {
        this.importTime = importTime;
        return this;
    }

    public void setImportTime(ZonedDateTime importTime) {
        this.importTime = importTime;
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
        ImportedFile importedFile = (ImportedFile) o;
        if (importedFile.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), importedFile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ImportedFile{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", system='" + getSystem() + "'" +
            ", version=" + getVersion() +
            ", dataType='" + getDataType() + "'" +
            ", status='" + getStatus() + "'" +
            ", importTime='" + getImportTime() + "'" +
            "}";
    }
}
