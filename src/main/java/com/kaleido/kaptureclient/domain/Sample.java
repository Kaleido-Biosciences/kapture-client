/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

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
    @Deprecated
    private Media media;

    @NotNull
    @JsonIgnoreProperties("")
    @Deprecated
    private Community community;

    @NotNull
    @JsonIgnoreProperties("")
    @Deprecated
    private Batch batch;

    /**
     * The experiment that the sample was prepared for
     */
    @JsonIgnoreProperties("")
    private Experiment experiment;

    /**
     * The Community Composition within a Sample
     */
    private Set<CommunityComposition> communityCompositions = new HashSet<>();

    /**
     * The supplement added to a sample with media
     */
    private Set<SupplementMetadata> supplementsMetadata = new HashSet<>();

    private Set<BatchLotComposition> batchLotCompositions = new HashSet<>();

    private Set<MediaLotComposition> mediaLotCompositions = new HashSet<>();

    private Set<Well> wells = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
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

    public Experiment getExperiment() {
        return experiment;
    }

    public Sample experiment(Experiment experiment) {
        this.experiment = experiment;
        return this;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Set<CommunityComposition> getCommunityCompositions() {
        return communityCompositions;
    }

    public Sample communityCompositions(Set<CommunityComposition> communityCompositions) {
        this.communityCompositions = communityCompositions;
        return this;
    }

    public Sample addCommunityComposition(CommunityComposition communityComposition) {
        this.communityCompositions.add(communityComposition);
        return this;
    }

    public Sample removeCommunityComposition(CommunityComposition communityComposition) {
        this.communityCompositions.remove(communityComposition);
        return this;
    }

    public void setCommunityCompositions(Set<CommunityComposition> communityCompositions) {
        this.communityCompositions = communityCompositions;
    }

    public Set<SupplementMetadata> getSupplementsMetadata() {
        return supplementsMetadata;
    }

    public Sample supplementsMetadata(Set<SupplementMetadata> supplementsMetadata) {
        this.supplementsMetadata = supplementsMetadata;
        return this;
    }

    public Sample addSupplementsMetadata(SupplementMetadata supplementMetadata) {
        this.supplementsMetadata.add(supplementMetadata);
        return this;
    }

    public Sample removeSupplementsMetadata(SupplementMetadata supplementMetadata) {
        this.supplementsMetadata.remove(supplementMetadata);
        return this;
    }

    public void setSupplementsMetadata(Set<SupplementMetadata> supplementsMetadata) {
        this.supplementsMetadata = supplementsMetadata;
    }

    public Set<BatchLotComposition> getBatchLotCompositions() {
        return batchLotCompositions;
    }

    public Sample batchLotCompositions(Set<BatchLotComposition> batchLotCompositions) {
        this.batchLotCompositions = batchLotCompositions;
        return this;
    }

    public Sample addBatchLotCompositions(BatchLotComposition batchLotComposition) {
        this.batchLotCompositions.add(batchLotComposition);
        return this;
    }

    public Sample removeBatchLotCompositions(BatchLotComposition batchLotComposition) {
        this.batchLotCompositions.remove(batchLotComposition);
        return this;
    }

    public void setBatchLotCompositions(Set<BatchLotComposition> batchLotCompositions) {
        this.batchLotCompositions = batchLotCompositions;
    }

    public Set<MediaLotComposition> getMediaLotCompositions() {
        return mediaLotCompositions;
    }

    public Sample mediaLotCompositions(Set<MediaLotComposition> mediaLotCompositions) {
        this.mediaLotCompositions = mediaLotCompositions;
        return this;
    }

    public Sample addMediaLotCompositions(MediaLotComposition mediaLotComposition) {
        this.mediaLotCompositions.add(mediaLotComposition);
        return this;
    }

    public Sample removeMediaLotCompositions(MediaLotComposition mediaLotComposition) {
        this.mediaLotCompositions.remove(mediaLotComposition);
        return this;
    }

    public void setMediaLotCompositions(Set<MediaLotComposition> mediaLotCompositions) {
        this.mediaLotCompositions = mediaLotCompositions;
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
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

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
