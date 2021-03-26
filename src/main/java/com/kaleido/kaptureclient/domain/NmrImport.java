package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * File reference table for NMR Spectra
 */
public class NmrImport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String notebookPage;

    @NotNull
    private String s3Location;

    @NotNull
    private String fileName;

    /**
     * center of spectrum
     */
    private Double o1p;

    /**
     * spectral window
     */
    private Double sw;

    private String experimentType;
    private String experimentDate;
    private ZonedDateTime importTimestamp;

    /**
     * The batch that's referenced to the NMR Import
     */
    @JsonIgnoreProperties("")
    private Batch batch;

    /**
     * The notebook that's referenced to the NMR Import
     */
    @JsonIgnoreProperties("")
    private Notebook notebook;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotebookPage() {
        return notebookPage;
    }

    public NmrImport notebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
        return this;
    }

    public void setNotebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
    }

    public String gets3Location() {
        return s3Location;
    }

    public NmrImport s3Location(String s3Location) {
        this.s3Location = s3Location;
        return this;
    }

    public void sets3Location(String s3Location) {
        this.s3Location = s3Location;
    }

    public String getFileName() {
        return fileName;
    }

    public NmrImport fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double geto1p() {
        return o1p;
    }

    public NmrImport o1p(Double o1p) {
        this.o1p = o1p;
        return this;
    }

    public void seto1p(Double o1p) {
        this.o1p = o1p;
    }

    public Double getSw() {
        return sw;
    }

    public NmrImport sw(Double sw) {
        this.sw = sw;
        return this;
    }

    public void setSw(Double sw) {
        this.sw = sw;
    }

    public String getExperimentType() {
        return experimentType;
    }

    public NmrImport experimentType(String experimentType) {
        this.experimentType = experimentType;
        return this;
    }

    public void setExperimentType(String experimentType) {
        this.experimentType = experimentType;
    }

    public String getExperimentDate() {
        return experimentDate;
    }

    public NmrImport experimentDate(String experimentDate) {
        this.experimentDate = experimentDate;
        return this;
    }

    public void setExperimentDate(String experimentDate) {
        this.experimentDate = experimentDate;
    }

    public ZonedDateTime getImportTimestamp() {
        return importTimestamp;
    }

    public NmrImport importTimestamp(ZonedDateTime importTimestamp) {
        this.importTimestamp = importTimestamp;
        return this;
    }

    public void setImportTimestamp(ZonedDateTime importTimestamp) {
        this.importTimestamp = importTimestamp;
    }

    public Batch getBatch() {
        return batch;
    }

    public NmrImport batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public NmrImport notebook(Notebook notebook) {
        this.notebook = notebook;
        return this;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
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
        NmrImport nmrImport = (NmrImport) o;
        if (nmrImport.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrImport.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrImport{" +
            "id=" + getId() +
            ", notebookPage='" + getNotebookPage() + "'" +
            ", s3Location='" + gets3Location() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", o1p=" + geto1p() +
            ", sw=" + getSw() +
            ", experimentType='" + getExperimentType() + "'" +
            ", experimentDate='" + getExperimentDate() + "'" +
            ", importTimestamp='" + getImportTimestamp() + "'" +
            "}";
    }
}
