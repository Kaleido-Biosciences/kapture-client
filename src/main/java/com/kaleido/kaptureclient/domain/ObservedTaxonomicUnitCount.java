package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * An Observed Taxonomic Unit Count
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservedTaxonomicUnitCount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * the number of reads matched to an OTU
     */
    private Integer abundance;

    /**
     * Distinguishes multiple measurements done on the same sample
     */
    @NotNull
    private Integer runMeasurement;

    /**
     * the rarefication level, should be either 0 or 5000, 0 is not rarefied, 5000 is rarefied to 5000 reads
     */
    @NotNull
    private Integer sampleDepth;

    /**
     * the software version used to process the data
     */
    @NotNull
    private String softwareVersion;

    @JsonIgnoreProperties("")
    private SequencingRun sequencingRun;

    @JsonIgnoreProperties("")
    private ObservedTaxonomicUnit observedTaxonomicUnit;

    @JsonIgnoreProperties("")
    private Sample sample;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAbundance() {
        return abundance;
    }

    public ObservedTaxonomicUnitCount abundance(Integer abundance) {
        this.abundance = abundance;
        return this;
    }

    public void setAbundance(Integer abundance) {
        this.abundance = abundance;
    }

    public Integer getRunMeasurement() {
        return runMeasurement;
    }

    public ObservedTaxonomicUnitCount runMeasurement(Integer runMeasurement) {
        this.runMeasurement = runMeasurement;
        return this;
    }

    public void setRunMeasurement(Integer runMeasurement) {
        this.runMeasurement = runMeasurement;
    }

    public Integer getSampleDepth() {
        return sampleDepth;
    }

    public ObservedTaxonomicUnitCount sampleDepth(Integer sampleDepth) {
        this.sampleDepth = sampleDepth;
        return this;
    }

    public void setSampleDepth(Integer sampleDepth) {
        this.sampleDepth = sampleDepth;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public ObservedTaxonomicUnitCount softwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
        return this;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public SequencingRun getSequencingRun() {
        return sequencingRun;
    }

    public ObservedTaxonomicUnitCount sequencingRun(SequencingRun sequencingRun) {
        this.sequencingRun = sequencingRun;
        return this;
    }

    public void setSequencingRun(SequencingRun sequencingRun) {
        this.sequencingRun = sequencingRun;
    }

    public ObservedTaxonomicUnit getObservedTaxonomicUnit() {
        return observedTaxonomicUnit;
    }

    public ObservedTaxonomicUnitCount observedTaxonomicUnit(ObservedTaxonomicUnit observedTaxonomicUnit) {
        this.observedTaxonomicUnit = observedTaxonomicUnit;
        return this;
    }

    public void setObservedTaxonomicUnit(ObservedTaxonomicUnit observedTaxonomicUnit) {
        this.observedTaxonomicUnit = observedTaxonomicUnit;
    }

    public Sample getSample() {
        return sample;
    }

    public ObservedTaxonomicUnitCount sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObservedTaxonomicUnitCount observedTaxonomicUnitCount = (ObservedTaxonomicUnitCount) o;
        if (observedTaxonomicUnitCount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), observedTaxonomicUnitCount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ObservedTaxonomicUnitCount{" +
            "id=" + getId() +
            ", abundance=" + getAbundance() +
            ", runMeasurement=" + getRunMeasurement() +
            ", sampleDepth=" + getSampleDepth() +
            ", softwareVersion='" + getSoftwareVersion() + "'" +
            "}";
    }
}
