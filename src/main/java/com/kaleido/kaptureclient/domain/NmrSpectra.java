package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A NmrSpectra.
 */
public class NmrSpectra implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String name;

    private String composition;

    private String identifier;

    private String status;

    private String runMode;

    private Boolean hasRefPeak;

    private Integer numAnnotated;

    private Integer numAssignedPeaks;

    private Integer numPeaks;

    private String phaseBefore;

    private String phaseAfter;

    private Double refPeakIntensity;

    private Double totalIntensity;

    private String outputDir;

    private String urlBefore;

    private String urlAfter;

    private String urlPeaks;

    private NmrAssay nmrAssay;

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

    public NmrSpectra name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public NmrSpectra composition(String composition) {
        this.composition = composition;
        return this;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getIdentifier() {
        return identifier;
    }

    public NmrSpectra identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getStatus() {
        return status;
    }

    public NmrSpectra status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRunMode() {
        return runMode;
    }

    public NmrSpectra runMode(String runMode) {
        this.runMode = runMode;
        return this;
    }

    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }

    public Boolean isHasRefPeak() {
        return hasRefPeak;
    }

    public NmrSpectra hasRefPeak(Boolean hasRefPeak) {
        this.hasRefPeak = hasRefPeak;
        return this;
    }

    public void setHasRefPeak(Boolean hasRefPeak) {
        this.hasRefPeak = hasRefPeak;
    }

    public Integer getNumAnnotated() {
        return numAnnotated;
    }

    public NmrSpectra numAnnotated(Integer numAnnotated) {
        this.numAnnotated = numAnnotated;
        return this;
    }

    public void setNumAnnotated(Integer numAnnotated) {
        this.numAnnotated = numAnnotated;
    }

    public Integer getNumAssignedPeaks() {
        return numAssignedPeaks;
    }

    public NmrSpectra numAssignedPeaks(Integer numAssignedPeaks) {
        this.numAssignedPeaks = numAssignedPeaks;
        return this;
    }

    public void setNumAssignedPeaks(Integer numAssignedPeaks) {
        this.numAssignedPeaks = numAssignedPeaks;
    }

    public Integer getNumPeaks() {
        return numPeaks;
    }

    public NmrSpectra numPeaks(Integer numPeaks) {
        this.numPeaks = numPeaks;
        return this;
    }

    public void setNumPeaks(Integer numPeaks) {
        this.numPeaks = numPeaks;
    }

    public String getPhaseBefore() {
        return phaseBefore;
    }

    public NmrSpectra phaseBefore(String phaseBefore) {
        this.phaseBefore = phaseBefore;
        return this;
    }

    public void setPhaseBefore(String phaseBefore) {
        this.phaseBefore = phaseBefore;
    }

    public String getPhaseAfter() {
        return phaseAfter;
    }

    public NmrSpectra phaseAfter(String phaseAfter) {
        this.phaseAfter = phaseAfter;
        return this;
    }

    public void setPhaseAfter(String phaseAfter) {
        this.phaseAfter = phaseAfter;
    }

    public Double getRefPeakIntensity() {
        return refPeakIntensity;
    }

    public NmrSpectra refPeakIntensity(Double refPeakIntensity) {
        this.refPeakIntensity = refPeakIntensity;
        return this;
    }

    public void setRefPeakIntensity(Double refPeakIntensity) {
        this.refPeakIntensity = refPeakIntensity;
    }

    public Double getTotalIntensity() {
        return totalIntensity;
    }

    public NmrSpectra totalIntensity(Double totalIntensity) {
        this.totalIntensity = totalIntensity;
        return this;
    }

    public void setTotalIntensity(Double totalIntensity) {
        this.totalIntensity = totalIntensity;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public NmrSpectra outputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getUrlBefore() {
        return urlBefore;
    }

    public NmrSpectra urlBefore(String urlBefore) {
        this.urlBefore = urlBefore;
        return this;
    }

    public void setUrlBefore(String urlBefore) {
        this.urlBefore = urlBefore;
    }

    public String getUrlAfter() {
        return urlAfter;
    }

    public NmrSpectra urlAfter(String urlAfter) {
        this.urlAfter = urlAfter;
        return this;
    }

    public void setUrlAfter(String urlAfter) {
        this.urlAfter = urlAfter;
    }

    public String getUrlPeaks() {
        return urlPeaks;
    }

    public NmrSpectra urlPeaks(String urlPeaks) {
        this.urlPeaks = urlPeaks;
        return this;
    }

    public void setUrlPeaks(String urlPeaks) {
        this.urlPeaks = urlPeaks;
    }

    public NmrAssay getNmrAssay() {
        return nmrAssay;
    }

    public NmrSpectra nmrAssay(NmrAssay nmrAssay) {
        this.nmrAssay = nmrAssay;
        return this;
    }

    public void setNmrAssay(NmrAssay nmrAssay) {
        this.nmrAssay = nmrAssay;
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
        NmrSpectra nmrSpectra = (NmrSpectra) o;
        if (nmrSpectra.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nmrSpectra.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NmrSpectra{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", composition='" + getComposition() + "'" +
            ", identifier='" + getIdentifier() + "'" +
            ", status='" + getStatus() + "'" +
            ", runMode='" + getRunMode() + "'" +
            ", hasRefPeak='" + isHasRefPeak() + "'" +
            ", numAnnotated=" + getNumAnnotated() +
            ", numAssignedPeaks=" + getNumAssignedPeaks() +
            ", numPeaks=" + getNumPeaks() +
            ", phaseBefore='" + getPhaseBefore() + "'" +
            ", phaseAfter='" + getPhaseAfter() + "'" +
            ", refPeakIntensity=" + getRefPeakIntensity() +
            ", totalIntensity=" + getTotalIntensity() +
            ", outputDir='" + getOutputDir() + "'" +
            ", urlBefore='" + getUrlBefore() + "'" +
            ", urlAfter='" + getUrlAfter() + "'" +
            ", urlPeaks='" + getUrlPeaks() + "'" +
            "}";
    }
}
