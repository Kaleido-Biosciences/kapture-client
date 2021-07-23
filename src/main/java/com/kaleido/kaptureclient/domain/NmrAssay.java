package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * NMR assay
 */
public class NmrAssay implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * Date of the NMR assay
     */
    @NotNull
    private ZonedDateTime assayDate;

    /**
     * Type of NMR assay, e.g. Compound
     */
    @NotNull
    private String assayType;

    /**
     * Scientist who ordered the NMR
     */
    @NotNull
    private String scientist;

    /**
     * rack number
     */
    @Min(value = 0)
    private Integer rack;

    /**
     * rack location
     */
    private String rackLocation;

    /**
     * rack barcode
     */
    private String rackBarcode;

    private Integer numScans;

    private String solvent;

    @Size(max = 4000)
    private String notes;

    private String status;

    private String notebookPage;

    private String experiment;

    /**
     * spectral window
     */
    private Double sw;

    private Double d1;

    private String s3Location;

    private String fileName;

    /**
     * center of spectrum
     */
    private Double o1p;

    private String experimentType;

    private String experimentDate;

    private ZonedDateTime importTimestamp;

    private String limsId;

    private String kidsId;

    /**
     * The notebook that's referenced to the NMR Assay
     */
    @JsonIgnoreProperties("")
    private Notebook notebook;

    /**
     * The batch that was assayed
     */
    @JsonIgnoreProperties("")
    private Batch batch;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getAssayDate() {
        return assayDate;
    }

    public NmrAssay assayDate(ZonedDateTime assayDate) {
        this.assayDate = assayDate;
        return this;
    }

    public void setAssayDate(ZonedDateTime assayDate) {
        this.assayDate = assayDate;
    }

    public String getAssayType() {
        return assayType;
    }

    public NmrAssay assayType(String assayType) {
        this.assayType = assayType;
        return this;
    }

    public void setAssayType(String assayType) {
        this.assayType = assayType;
    }

    public String getScientist() {
        return scientist;
    }

    public NmrAssay scientist(String scientist) {
        this.scientist = scientist;
        return this;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    public Integer getRack() {
        return rack;
    }

    public NmrAssay rack(Integer rack) {
        this.rack = rack;
        return this;
    }

    public void setRack(Integer rack) {
        this.rack = rack;
    }

    public String getRackLocation() {
        return rackLocation;
    }

    public NmrAssay rackLocation(String rackLocation) {
        this.rackLocation = rackLocation;
        return this;
    }

    public void setRackLocation(String rackLocation) {
        this.rackLocation = rackLocation;
    }

    public String getRackBarcode() {
        return rackBarcode;
    }

    public NmrAssay rackBarcode(String rackBarcode) {
        this.rackBarcode = rackBarcode;
        return this;
    }

    public void setRackBarcode(String rackBarcode) {
        this.rackBarcode = rackBarcode;
    }

    public Integer getNumScans() {
        return numScans;
    }

    public NmrAssay numScans(Integer numScans) {
        this.numScans = numScans;
        return this;
    }

    public void setNumScans(Integer numScans) {
        this.numScans = numScans;
    }

    public String getSolvent() {
        return solvent;
    }

    public NmrAssay solvent(String solvent) {
        this.solvent = solvent;
        return this;
    }

    public void setSolvent(String solvent) {
        this.solvent = solvent;
    }

    public String getNotes() {
        return notes;
    }

    public NmrAssay notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public NmrAssay status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotebookPage() {
        return notebookPage;
    }

    public NmrAssay notebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
        return this;
    }

    public void setNotebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
    }

    public String getExperiment() {
        return experiment;
    }

    public NmrAssay experiment(String experiment) {
        this.experiment = experiment;
        return this;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }

    public Double getSw() {
        return sw;
    }

    public NmrAssay sw(Double sw) {
        this.sw = sw;
        return this;
    }

    public void setSw(Double sw) {
        this.sw = sw;
    }

    public Double getd1() {
        return d1;
    }

    public NmrAssay d1(Double d1) {
        this.d1 = d1;
        return this;
    }

    public void setd1(Double d1) {
        this.d1 = d1;
    }

    public String gets3Location() {
        return s3Location;
    }

    public NmrAssay s3Location(String s3Location) {
        this.s3Location = s3Location;
        return this;
    }

    public void sets3Location(String s3Location) {
        this.s3Location = s3Location;
    }

    public String getFileName() {
        return fileName;
    }

    public NmrAssay fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double geto1p() {
        return o1p;
    }

    public NmrAssay o1p(Double o1p) {
        this.o1p = o1p;
        return this;
    }

    public void seto1p(Double o1p) {
        this.o1p = o1p;
    }

    public String getExperimentType() {
        return experimentType;
    }

    public NmrAssay experimentType(String experimentType) {
        this.experimentType = experimentType;
        return this;
    }

    public void setExperimentType(String experimentType) {
        this.experimentType = experimentType;
    }

    public String getExperimentDate() {
        return experimentDate;
    }

    public NmrAssay experimentDate(String experimentDate) {
        this.experimentDate = experimentDate;
        return this;
    }

    public void setExperimentDate(String experimentDate) {
        this.experimentDate = experimentDate;
    }

    public ZonedDateTime getImportTimestamp() {
        return importTimestamp;
    }

    public NmrAssay importTimestamp(ZonedDateTime importTimestamp) {
        this.importTimestamp = importTimestamp;
        return this;
    }

    public void setImportTimestamp(ZonedDateTime importTimestamp) {
        this.importTimestamp = importTimestamp;
    }

    public String getLimsId() {
        return limsId;
    }

    public NmrAssay limsId(String limsId) {
        this.limsId = limsId;
        return this;
    }

    public void setLimsId(String limsId) {
        this.limsId = limsId;
    }

    public String getKidsId() {
        return kidsId;
    }

    public NmrAssay kidsId(String kidsId) {
        this.kidsId = kidsId;
        return this;
    }

    public void setKidsId(String kidsId) {
        this.kidsId = kidsId;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public NmrAssay notebook(Notebook notebook) {
        this.notebook = notebook;
        return this;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Batch getBatch() {
        return batch;
    }

    public NmrAssay batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
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
        NmrAssay nmrAssay = (NmrAssay) o;
        if (nmrAssay.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrAssay.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrAssay{" +
            "id=" + getId() +
            ", assayDate='" + getAssayDate() + "'" +
            ", assayType='" + getAssayType() + "'" +
            ", scientist='" + getScientist() + "'" +
            ", rack=" + getRack() +
            ", rackLocation='" + getRackLocation() + "'" +
            ", rackBarcode='" + getRackBarcode() + "'" +
            ", numScans=" + getNumScans() +
            ", solvent='" + getSolvent() + "'" +
            ", notes='" + getNotes() + "'" +
            ", status='" + getStatus() + "'" +
            ", notebookPage='" + getNotebookPage() + "'" +
            ", experiment='" + getExperiment() + "'" +
            ", sw=" + getSw() +
            ", d1=" + getd1() +
            ", s3Location='" + gets3Location() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", o1p=" + geto1p() +
            ", experimentType='" + getExperimentType() + "'" +
            ", experimentDate='" + getExperimentDate() + "'" +
            ", importTimestamp='" + getImportTimestamp() + "'" +
            ", limsId='" + getLimsId() + "'" +
            ", kidsId='" + getKidsId() + "'" +
            "}";
    }
}
