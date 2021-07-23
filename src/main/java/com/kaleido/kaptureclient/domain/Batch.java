/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain;

import com.kaleido.kaptureclient.domain.enumeration.GeneralQuestion;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A chemically synthesized batch
 */
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The batch registration name
     */
    @NotNull
    private String name;

    /**
     * the source of the batch
     */
    private String source;

    /**
     * status of the batch
     */
    private String status;

    /**
     * Molecular Number
     */
    private Float mn;

    /**
     * The person who registered this batch
     */
    private String createdBy;

    /**
     * NMR status
     */
    private String nMRStatus;

    /**
     * Reference to the notebook entry describing the synthesis
     */
    private String notebook;

    /**
     * Reference to the notebook page
     */

    private String notebookPage;
    /**
     * the Enzyme used in the synthesis
     */
    private String enzyme;

    /**
     * The date the batch was manufactured
     */
    private ZonedDateTime mfgDate;

    /**
     * purity of the synthesis
     */
    private Float purity;

    /**
     * The time the batch was registered
     */
    private ZonedDateTime dateCreated;

    /**
     * The person who manufactured the batch
     */
    private String mfgBy;

    /**
     * Molecular weight in Daltons
     */
    private String mw;

    /**
     * Method used to determine purity
     */
    private String purityType;

    /**
     * The total synthetic reaction volume
     */
    private Float scale;

    /**
     * The percent of monomers, eg. Ara50Glu50
     */
    private String glycanComposition;

    /**
     * The name of any precursor
     */
    private String precursor;

    /**
     * Method used in synthesis
     */
    private String syntheticMethod;

    /**
     * LIMS registration record
     */
    private String dataRecordName;

    private Double pdi;

    /**
     * Average degree of polymerization
     */
    private Double aveDP;

    /**
     * additional notes
     */
    private String notes;

    private GeneralQuestion isVitaminOrPolyphenol;

    private GeneralQuestion isFoodGrade;

    private GeneralQuestion isNMer;

    private GeneralQuestion isSoluble;

    /**
     * 3rd Party unique identifier (e.g. lot number)
     */
    private String sourceIdentifier;

    /**
     * the volume of available solids when making a new batch
     */
    private Double availableSolid;

    /**
     * the volume unit of available solids when making a new batch
     */
    private String availableSolidUnits;

    private Set<BatchAlias> aliases = new HashSet<>();

    private Set<ChemicalConcept> concepts = new HashSet<>();

    /**
     * The batch associated with a monomer composition
     */
    private Set<MonomerComposition> monomerCompositions = new HashSet<>();

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

    public Batch name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public Batch source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public Batch status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getMn() {
        return mn;
    }

    public Batch mn(Float mn) {
        this.mn = mn;
        return this;
    }

    public void setMn(Float mn) {
        this.mn = mn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Batch createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getnMRStatus() {
        return nMRStatus;
    }

    public Batch nMRStatus(String nMRStatus) {
        this.nMRStatus = nMRStatus;
        return this;
    }

    public void setnMRStatus(String nMRStatus) {
        this.nMRStatus = nMRStatus;
    }

    public String getNotebook() {
        return notebook;
    }

    public Batch notebook(String notebook) {
        this.notebook = notebook;
        return this;
    }

    public void setNotebook(String notebook) {
        this.notebook = notebook;
    }


    public String getNotebookPage() {
        return notebookPage;
    }

    public Batch notebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
        return this;
    }

    public void setNotebookPage(String notebookPage) {
        this.notebookPage = notebookPage;
    }

    public String getEnzyme() {
        return enzyme;
    }

    public Batch enzyme(String enzyme) {
        this.enzyme = enzyme;
        return this;
    }

    public void setEnzyme(String enzyme) {
        this.enzyme = enzyme;
    }

    public ZonedDateTime getMfgDate() {
        return mfgDate;
    }

    public Batch mfgDate(ZonedDateTime mfgDate) {
        this.mfgDate = mfgDate;
        return this;
    }

    public void setMfgDate(ZonedDateTime mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Float getPurity() {
        return purity;
    }

    public Batch purity(Float purity) {
        this.purity = purity;
        return this;
    }

    public void setPurity(Float purity) {
        this.purity = purity;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public Batch dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getMfgBy() {
        return mfgBy;
    }

    public Batch mfgBy(String mfgBy) {
        this.mfgBy = mfgBy;
        return this;
    }

    public void setMfgBy(String mfgBy) {
        this.mfgBy = mfgBy;
    }

    public String getMw() {
        return mw;
    }

    public Batch mw(String mw) {
        this.mw = mw;
        return this;
    }

    public void setMw(String mw) {
        this.mw = mw;
    }

    public String getPurityType() {
        return purityType;
    }

    public Batch purityType(String purityType) {
        this.purityType = purityType;
        return this;
    }

    public void setPurityType(String purityType) {
        this.purityType = purityType;
    }

    public Float getScale() {
        return scale;
    }

    public Batch scale(Float scale) {
        this.scale = scale;
        return this;
    }

    public void setScale(Float scale) {
        this.scale = scale;
    }

    public String getGlycanComposition() {
        return glycanComposition;
    }

    public Batch glycanComposition(String glycanComposition) {
        this.glycanComposition = glycanComposition;
        return this;
    }

    public void setGlycanComposition(String glycanComposition) {
        this.glycanComposition = glycanComposition;
    }

    public String getPrecursor() {
        return precursor;
    }

    public Batch precursor(String precursor) {
        this.precursor = precursor;
        return this;
    }

    public void setPrecursor(String precursor) {
        this.precursor = precursor;
    }

    public String getSyntheticMethod() {
        return syntheticMethod;
    }

    public Batch syntheticMethod(String syntheticMethod) {
        this.syntheticMethod = syntheticMethod;
        return this;
    }

    public void setSyntheticMethod(String syntheticMethod) {
        this.syntheticMethod = syntheticMethod;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public Batch dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public Double getPdi() {
        return pdi;
    }

    public Batch pdi(Double pdi) {
        this.pdi = pdi;
        return this;
    }

    public void setPdi(Double pdi) {
        this.pdi = pdi;
    }

    public Double getAveDP() {
        return aveDP;
    }

    public Batch aveDP(Double aveDP) {
        this.aveDP = aveDP;
        return this;
    }

    public void setAveDP(Double aveDP) {
        this.aveDP = aveDP;
    }

    public String getNotes() {
        return notes;
    }

    public Batch notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public GeneralQuestion getIsVitaminOrPolyphenol() {
        return isVitaminOrPolyphenol;
    }

    public Batch isVitaminOrPolyphenol(GeneralQuestion isVitaminOrPolyphenol) {
        this.isVitaminOrPolyphenol = isVitaminOrPolyphenol;
        return this;
    }

    public void setIsVitaminOrPolyphenol(GeneralQuestion isVitaminOrPolyphenol) {
        this.isVitaminOrPolyphenol = isVitaminOrPolyphenol;
    }

    public GeneralQuestion getIsFoodGrade() {
        return isFoodGrade;
    }

    public Batch isFoodGrade(GeneralQuestion isFoodGrade) {
        this.isFoodGrade = isFoodGrade;
        return this;
    }

    public void setIsFoodGrade(GeneralQuestion isFoodGrade) {
        this.isFoodGrade = isFoodGrade;
    }

    public GeneralQuestion getIsNMer() {
        return isNMer;
    }

    public Batch isNMer(GeneralQuestion isNMer) {
        this.isNMer = isNMer;
        return this;
    }

    public void setIsNMer(GeneralQuestion isNMer) {
        this.isNMer = isNMer;
    }

    public GeneralQuestion getIsSoluble() {
        return isSoluble;
    }

    public Batch isSoluble(GeneralQuestion isSoluble) {
        this.isSoluble = isSoluble;
        return this;
    }

    public void setIsSoluble(GeneralQuestion isSoluble) {
        this.isSoluble = isSoluble;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public Batch sourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
        return this;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public Double getAvailableSolid() {
        return availableSolid;
    }

    public Batch availableSolid(Double availableSolid) {
        this.availableSolid = availableSolid;
        return this;
    }

    public void setAvailableSolid(Double availableSolid) {
        this.availableSolid = availableSolid;
    }

    public String getAvailableSolidUnits() {
        return availableSolidUnits;
    }

    public Batch availableSolidUnits(String availableSolidUnits) {
        this.availableSolidUnits = availableSolidUnits;
        return this;
    }

    public void setAvailableSolidUnits(String availableSolidUnits) {
        this.availableSolidUnits = availableSolidUnits;
    }

    public Set<BatchAlias> getAliases() {
        return aliases;
    }

    public Batch aliases(Set<BatchAlias> batchAliases) {
        this.aliases = batchAliases;
        return this;
    }

    public Batch addAliases(BatchAlias batchAlias) {
        this.aliases.add(batchAlias);
        batchAlias.getBatches().add(this);
        return this;
    }

    public Batch removeAliases(BatchAlias batchAlias) {
        this.aliases.remove(batchAlias);
        batchAlias.getBatches().remove(this);
        return this;
    }

    public void setAliases(Set<BatchAlias> batchAliases) {
        this.aliases = batchAliases;
    }

    public Set<ChemicalConcept> getConcepts() {
        return concepts;
    }

    public Batch concepts(Set<ChemicalConcept> chemicalConcepts) {
        this.concepts = chemicalConcepts;
        return this;
    }

    public Batch addConcepts(ChemicalConcept chemicalConcept) {
        this.concepts.add(chemicalConcept);
        chemicalConcept.getBatches().add(this);
        return this;
    }

    public Batch removeConcepts(ChemicalConcept chemicalConcept) {
        this.concepts.remove(chemicalConcept);
        chemicalConcept.getBatches().remove(this);
        return this;
    }

    public void setConcepts(Set<ChemicalConcept> chemicalConcepts) {
        this.concepts = chemicalConcepts;
    }

    public Set<MonomerComposition> getMonomerCompositions() {
        return monomerCompositions;
    }

    public Batch monomerCompositions(Set<MonomerComposition> monomerCompositions) {
        this.monomerCompositions = monomerCompositions;
        return this;
    }

    public Batch addMonomerComposition(MonomerComposition monomerComposition) {
        this.monomerCompositions.add(monomerComposition);
        return this;
    }

    public Batch removeMonomerComposition(MonomerComposition monomerComposition) {
        this.monomerCompositions.remove(monomerComposition);
        return this;
    }

    public void setMonomerCompositions(Set<MonomerComposition> monomerCompositions) {
        this.monomerCompositions = monomerCompositions;
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
        Batch batch = (Batch) o;
        if (batch.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batch.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Batch{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", source='" + getSource() + "'" +
            ", status='" + getStatus() + "'" +
            ", mn=" + getMn() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", nMRStatus='" + getnMRStatus() + "'" +
            ", notebook='" + getNotebook() + "'" +
            ", notebookPage='" + getNotebookPage() + "'" +
            ", enzyme='" + getEnzyme() + "'" +
            ", mfgDate='" + getMfgDate() + "'" +
            ", purity=" + getPurity() +
            ", dateCreated='" + getDateCreated() + "'" +
            ", mfgBy='" + getMfgBy() + "'" +
            ", mw='" + getMw() + "'" +
            ", purityType='" + getPurityType() + "'" +
            ", scale=" + getScale() +
            ", glycanComposition='" + getGlycanComposition() + "'" +
            ", precursor='" + getPrecursor() + "'" +
            ", syntheticMethod='" + getSyntheticMethod() + "'" +
            ", dataRecordName='" + getDataRecordName() + "'" +
            ", pdi=" + getPdi() +
            ", aveDP=" + getAveDP() +
            ", notes='" + getNotes() + "'" +
            ", isVitaminOrPolyphenol='" + getIsVitaminOrPolyphenol() + "'" +
            ", isFoodGrade='" + getIsFoodGrade() + "'" +
            ", isNMer='" + getIsNMer() + "'" +
            ", isSoluble='" + getIsSoluble() + "'" +
            ", sourceIdentifier='" + getSourceIdentifier() + "'" +
            ", availableSolid=" + getAvailableSolid() +
            ", availableSolidUnits='" + getAvailableSolidUnits() + "'" +
            "}";
    }
}
