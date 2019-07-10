/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaleido.kaptureclient.domain.enumeration.CommunityType;
import com.kaleido.kaptureclient.domain.enumeration.GeneralQuestion;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Communities used in ExVivo experiments
 */
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The name of the community
     */
    @NotNull
    private String name;

    /**
     * The type of the community
     */
    private CommunityType communityType;

    /**
     * The barcode of the community
     */
    private String barcode;

    /**
     * Description of the Strain or Community
     */
    private String description;

    /**
     * Any Alias(es) for the Community
     */
    private String alias;

    /**
     * The Species of the Strain
     */
    private String species;

    /**
     * Additional information about the source of the community
     */
    private String source;

    /**
     * Does this species serve as a typed class?
     */
    private GeneralQuestion typed;

    /**
     * Is this species antibiotic resistant?
     */
    private GeneralQuestion knownAntibioticResistance;

    /**
     * Known antibiotics to which species is resistant
     */
    private String antibioticList;

    /**
     * Strain with plasmid
     */
    private String plasmid;

    /**
     * Are starter stocks made?
     */
    private GeneralQuestion starterStocksMade;

    /**
     * LIMS registration record
     */
    private String dataRecordName;

    /**
     * The sample id in the BSI system
     */
    private String bsiId;

    /**
     * The sample name in the BSI system
     */
    private String bsiName;

    /**
     * Additional notes
     */
    private String notes;

    /**
     * The scientist associated with the community/strain
     */
    @JsonIgnoreProperties("")
    private Scientist scientist;

    /**
     * The Source of the strain/community
     */
    @JsonIgnoreProperties("")
    private Concept sourceType;

    /**
     * The related community of the Strain
     */
    @JsonIgnoreProperties("")
    private Community relatedCommunity;

    /**
     * The status of the strain/community
     */
    @JsonIgnoreProperties("")
    private Concept status;

    /**
     * The growth medium of the strain
     */
    @JsonIgnoreProperties("")
    private Media growthMedium;

    /**
     * The Pathogen of the strain/community
     */
    @JsonIgnoreProperties("")
    private Concept pathogen;

    /**
     * The Gram Stain of the strain/community
     */
    @JsonIgnoreProperties("")
    private Concept gramStain;

    /**
     * The Growth Requirement of the strain/community
     */
    @JsonIgnoreProperties("")
    private Concept growthRequirement;

    /**
     * The Community Composition of a community itself
     */
    private Set<CommunityComposition> communityCompositions = new HashSet<>();

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

    public Community name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommunityType getCommunityType() {
        return communityType;
    }

    public Community communityType(CommunityType communityType) {
        this.communityType = communityType;
        return this;
    }

    public void setCommunityType(CommunityType communityType) {
        this.communityType = communityType;
    }

    public String getBarcode() {
        return barcode;
    }

    public Community barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public Community description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public Community alias(String alias) {
        this.alias = alias;
        return this;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSpecies() {
        return species;
    }

    public Community species(String species) {
        this.species = species;
        return this;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSource() {
        return source;
    }

    public Community source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public GeneralQuestion getTyped() {
        return typed;
    }

    public Community typed(GeneralQuestion typed) {
        this.typed = typed;
        return this;
    }

    public void setTyped(GeneralQuestion typed) {
        this.typed = typed;
    }

    public GeneralQuestion getKnownAntibioticResistance() {
        return knownAntibioticResistance;
    }

    public Community knownAntibioticResistance(GeneralQuestion knownAntibioticResistance) {
        this.knownAntibioticResistance = knownAntibioticResistance;
        return this;
    }

    public void setKnownAntibioticResistance(GeneralQuestion knownAntibioticResistance) {
        this.knownAntibioticResistance = knownAntibioticResistance;
    }

    public String getAntibioticList() {
        return antibioticList;
    }

    public Community antibioticList(String antibioticList) {
        this.antibioticList = antibioticList;
        return this;
    }

    public void setAntibioticList(String antibioticList) {
        this.antibioticList = antibioticList;
    }

    public String getPlasmid() {
        return plasmid;
    }

    public Community plasmid(String plasmid) {
        this.plasmid = plasmid;
        return this;
    }

    public void setPlasmid(String plasmid) {
        this.plasmid = plasmid;
    }

    public GeneralQuestion getStarterStocksMade() {
        return starterStocksMade;
    }

    public Community starterStocksMade(GeneralQuestion starterStocksMade) {
        this.starterStocksMade = starterStocksMade;
        return this;
    }

    public void setStarterStocksMade(GeneralQuestion starterStocksMade) {
        this.starterStocksMade = starterStocksMade;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public Community dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public String getBsiId() {
        return bsiId;
    }

    public Community bsiId(String bsiId) {
        this.bsiId = bsiId;
        return this;
    }

    public void setBsiId(String bsiId) {
        this.bsiId = bsiId;
    }

    public String getBsiName() {
        return bsiName;
    }

    public Community bsiName(String bsiName) {
        this.bsiName = bsiName;
        return this;
    }

    public void setBsiName(String bsiName) {
        this.bsiName = bsiName;
    }

    public String getNotes() {
        return notes;
    }

    public Community notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public Community scientist(Scientist scientist) {
        this.scientist = scientist;
        return this;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public Concept getSourceType() {
        return sourceType;
    }

    public Community sourceType(Concept concept) {
        this.sourceType = concept;
        return this;
    }

    public void setSourceType(Concept concept) {
        this.sourceType = concept;
    }

    public Community getRelatedCommunity() {
        return relatedCommunity;
    }

    public Community relatedCommunity(Community community) {
        this.relatedCommunity = community;
        return this;
    }

    public void setRelatedCommunity(Community community) {
        this.relatedCommunity = community;
    }

    public Concept getStatus() {
        return status;
    }

    public Community status(Concept concept) {
        this.status = concept;
        return this;
    }

    public void setStatus(Concept concept) {
        this.status = concept;
    }

    public Media getGrowthMedium() {
        return growthMedium;
    }

    public Community growthMedium(Media media) {
        this.growthMedium = media;
        return this;
    }

    public void setGrowthMedium(Media media) {
        this.growthMedium = media;
    }

    public Concept getPathogen() {
        return pathogen;
    }

    public Community pathogen(Concept concept) {
        this.pathogen = concept;
        return this;
    }

    public void setPathogen(Concept concept) {
        this.pathogen = concept;
    }

    public Concept getGramStain() {
        return gramStain;
    }

    public Community gramStain(Concept concept) {
        this.gramStain = concept;
        return this;
    }

    public void setGramStain(Concept concept) {
        this.gramStain = concept;
    }

    public Concept getGrowthRequirement() {
        return growthRequirement;
    }

    public Community growthRequirement(Concept concept) {
        this.growthRequirement = concept;
        return this;
    }

    public void setGrowthRequirement(Concept concept) {
        this.growthRequirement = concept;
    }

    public Set<CommunityComposition> getCommunityCompositions() {
        return communityCompositions;
    }

    public Community communityCompositions(Set<CommunityComposition> communityCompositions) {
        this.communityCompositions = communityCompositions;
        return this;
    }

    public Community addCommunityComposition(CommunityComposition communityComposition) {
        this.communityCompositions.add(communityComposition);
        return this;
    }

    public Community removeCommunityComposition(CommunityComposition communityComposition) {
        this.communityCompositions.remove(communityComposition);
        return this;
    }

    public void setCommunityCompositions(Set<CommunityComposition> communityCompositions) {
        this.communityCompositions = communityCompositions;
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
        Community community = (Community) o;
        if (community.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), community.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Community{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", communityType='" + getCommunityType() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", description='" + getDescription() + "'" +
            ", alias='" + getAlias() + "'" +
            ", species='" + getSpecies() + "'" +
            ", source='" + getSource() + "'" +
            ", typed='" + getTyped() + "'" +
            ", knownAntibioticResistance='" + getKnownAntibioticResistance() + "'" +
            ", antibioticList='" + getAntibioticList() + "'" +
            ", plasmid='" + getPlasmid() + "'" +
            ", starterStocksMade='" + getStarterStocksMade() + "'" +
            ", dataRecordName='" + getDataRecordName() + "'" +
            ", bsiId='" + getBsiId() + "'" +
            ", bsiName='" + getBsiName() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
