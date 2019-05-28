package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Sample in a well from which a readout is derived
 */
public class Sample implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The sample label typically something like G259.p0.D12
     */
    @NotNull
    private String label;

    /**
     * the concentration of the batch
     */
    private Double concentration;

    /**
     * The percent of the total sample made up by a fecal slurry
     */
    private Double slurryPercent;

    /**
     * incubation time in minutes
     */
    private Double timePoint;

    @NotNull
    @JsonIgnoreProperties("")
    private Media media;

    @NotNull
    @JsonIgnoreProperties("")
    private Community community;

    @NotNull
    @JsonIgnoreProperties("")
    private Batch batch;

    private Set<SampleTreatment> treatments = new HashSet<>();

    private Set<Well> wells = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public Sample label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getConcentration() {
        return concentration;
    }

    public Sample concentration(Double concentration) {
        this.concentration = concentration;
        return this;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

    public Double getSlurryPercent() {
        return slurryPercent;
    }

    public Sample slurryPercent(Double slurryPercent) {
        this.slurryPercent = slurryPercent;
        return this;
    }

    public void setSlurryPercent(Double slurryPercent) {
        this.slurryPercent = slurryPercent;
    }

    public Double getTimePoint() {
        return timePoint;
    }

    public Sample timePoint(Double timePoint) {
        this.timePoint = timePoint;
        return this;
    }

    public void setTimePoint(Double timePoint) {
        this.timePoint = timePoint;
    }

    public Media getMedia() {
        return media;
    }

    public Sample media(Media media) {
        this.media = media;
        return this;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Community getCommunity() {
        return community;
    }

    public Sample community(Community community) {
        this.community = community;
        return this;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Batch getBatch() {
        return batch;
    }

    public Sample batch(Batch batch) {
        this.batch = batch;
        return this;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Set<SampleTreatment> getTreatments() {
        return treatments;
    }

    public Sample treatments(Set<SampleTreatment> sampleTreatments) {
        this.treatments = sampleTreatments;
        return this;
    }

    public Sample addTreatments(SampleTreatment sampleTreatment) {
        this.treatments.add(sampleTreatment);
        return this;
    }

    public Sample removeTreatments(SampleTreatment sampleTreatment) {
        this.treatments.remove(sampleTreatment);
        return this;
    }

    public void setTreatments(Set<SampleTreatment> sampleTreatments) {
        this.treatments = sampleTreatments;
    }

    public Set<Well> getWells() {
        return wells;
    }

    public Sample wells(Set<Well> wells) {
        this.wells = wells;
        return this;
    }

    public Sample addWells(Well well) {
        this.wells.add(well);
        well.setSample(this);
        return this;
    }

    public Sample removeWells(Well well) {
        this.wells.remove(well);
        well.setSample(null);
        return this;
    }

    public void setWells(Set<Well> wells) {
        this.wells = wells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sample sample = (Sample) o;
        if (sample.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sample.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Sample{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            ", concentration=" + getConcentration() +
            ", slurryPercent=" + getSlurryPercent() +
            ", timePoint=" + getTimePoint() +
            "}";
    }
}
