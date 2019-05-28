package com.kaleido.kaptureclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Holds properties from externalized configuration such as environment variables or {@code application.properties} files.
 * Any variable begining with {@code kapture.client} or for environment variables {@code KAPTURE_CLIENT} and matching
 * a field of this class will over-ride the default value. For example, {@code kapture.client.password=secret} will set
 * the value of the password used by the client.
 * Default values are set to interact with the {@code dev} profile of Kapture and are suitable for development and testing
 * purposes.
 */
@ConfigurationProperties("kapture.client")
@EnableRetry
public class KaptureClientProperties {

    private String username = "admin";
    private String password = "admin";
    private String base = "http://localhost:8080/api/";

    private String searchPathComponent = "_search";

    private String altLabelEndpoint = "alt-labels";
    private String analyteEndpoint = "analytes";
    private String analyteTypeEndpoint = "analyte-types";
    private String assayReadoutEndpoint = "assay-readouts";
    private String assayReadoutPropertyEndpoint = "assay-readout-properties";
    private String associationEndpoint = "associations";
    private String authorityEndpoint = "authorities";
    private String batchEndpoint = "batches";
    private String batchAliasEndpoint = "batch-aliases";
    private String batchComponentEndpoint = "batch-components";
    private String chemicalConceptEndpoint = "chemical-concepts";
    private String communityEndpoint = "communities";
    private String conceptEndpoint = "concepts";
    private String conceptSchemeEndpoint = "concept-schemes";
    private String experimentEndpoint = "experiments";
    private String failedMessageEndpoint = "failed-messages";
    private String importedFileEndpoint = "imported-files";
    private String mediaEndpoint = "media";
    private String monomerEndpoint = "monomers";
    private String monomerCompositionEndpoint = "monomer-compositions";
    private String nmrAssayEndpoint = "nmr-assays";
    private String nmrPeakEndpoint = "nmr-peaks";
    private String noteEndpoint = "notes";
    private String observedTaxonomicUnitEndpoint = "observed-taxonomic-units";
    private String observedTaxonomicUnitCountEndpoint = "observed-taxonomic-unit-counts";
    private String otuCountPropertyEndpoint = "otu-count-properties";
    private String persistentAuditEventEndpoint = "persistent-audit-events";
    private String platemapEndpoint = "platemaps";
    private String plateTypeEndpoint = "plate-types";
    private String processedReadoutEndpoint = "processed-readouts";
    private String sampleEndpoint = "samples";
    private String sampleTreatmentEndpoint = "sample-treatments";
    private String scientistEndpoint = "scientists";
    private String sequencingRunEndpoint = "sequencing-runs";
    private String userEndpoint = "users";
    private String wellEndpoint = "wells";
    private long retryInterval = 5000L;
    private double retryMultiplier = 2.0D;
    private long maxRetryInterval = 15000L;
    private int maxRequestAttempts = 3;

    public String getAnalyteTypeEndpoint() {
        return analyteTypeEndpoint;
    }

    public void setAnalyteTypeEndpoint(String analyteTypeEndpoint) {
        this.analyteTypeEndpoint = analyteTypeEndpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAnalyteEndpoint() {
        return analyteEndpoint;
    }

    public void setAnalyteEndpoint(String analyteEndpoint) {
        this.analyteEndpoint = analyteEndpoint;
    }

    public String getAltLabelEndpoint() {
        return altLabelEndpoint;
    }

    public void setAltLabelEndpoint(String altLabelEndpoint) {
        this.altLabelEndpoint = altLabelEndpoint;
    }

    public String getAssayReadoutEndpoint() {
        return assayReadoutEndpoint;
    }

    public void setAssayReadoutEndpoint(String assayReadoutEndpoint) {
        this.assayReadoutEndpoint = assayReadoutEndpoint;
    }

    public String getAssayReadoutPropertyEndpoint() {
        return assayReadoutPropertyEndpoint;
    }

    public void setAssayReadoutPropertyEndpoint(String assayReadoutPropertyEndpoint) {
        this.assayReadoutPropertyEndpoint = assayReadoutPropertyEndpoint;
    }

    public String getAssociationEndpoint() {
        return associationEndpoint;
    }

    public void setAssociationEndpoint(String associationEndpoint) {
        this.associationEndpoint = associationEndpoint;
    }

    public String getAuthorityEndpoint() {
        return authorityEndpoint;
    }

    public void setAuthorityEndpoint(String authorityEndpoint) {
        this.authorityEndpoint = authorityEndpoint;
    }

    public String getBatchEndpoint() {
        return batchEndpoint;
    }

    public void setBatchEndpoint(String batchEndpoint) {
        this.batchEndpoint = batchEndpoint;
    }

    public String getBatchAliasEndpoint() {
        return batchAliasEndpoint;
    }

    public void setBatchAliasEndpoint(String batchAliasEndpoint) {
        this.batchAliasEndpoint = batchAliasEndpoint;
    }

    public String getBatchComponentEndpoint() {
        return batchComponentEndpoint;
    }

    public void setBatchComponentEndpoint(String batchComponentEndpoint) {
        this.batchComponentEndpoint = batchComponentEndpoint;
    }

    public String getChemicalConceptEndpoint() {
        return chemicalConceptEndpoint;
    }

    public void setChemicalConceptEndpoint(String chemicalConceptEndpoint) {
        this.chemicalConceptEndpoint = chemicalConceptEndpoint;
    }

    public String getCommunityEndpoint() {
        return communityEndpoint;
    }

    public void setCommunityEndpoint(String communityEndpoint) {
        this.communityEndpoint = communityEndpoint;
    }

    public String getConceptEndpoint() {
        return conceptEndpoint;
    }

    public void setConceptEndpoint(String conceptEndpoint) {
        this.conceptEndpoint = conceptEndpoint;
    }

    public String getConceptSchemeEndpoint() {
        return conceptSchemeEndpoint;
    }

    public void setConceptSchemeEndpoint(String conceptSchemeEndpoint) {
        this.conceptSchemeEndpoint = conceptSchemeEndpoint;
    }

    public String getExperimentEndpoint() {
        return experimentEndpoint;
    }

    public void setExperimentEndpoint(String experimentEndpoint) {
        this.experimentEndpoint = experimentEndpoint;
    }

    public String getFailedMessageEndpoint() {
        return failedMessageEndpoint;
    }

    public void setFailedMessageEndpoint(String failedMessageEndpoint) {
        this.failedMessageEndpoint = failedMessageEndpoint;
    }

    public String getImportedFileEndpoint() {
        return importedFileEndpoint;
    }

    public void setImportedFileEndpoint(String importedFileEndpoint) {
        this.importedFileEndpoint = importedFileEndpoint;
    }

    public String getMediaEndpoint() {
        return mediaEndpoint;
    }

    public void setMediaEndpoint(String mediaEndpoint) {
        this.mediaEndpoint = mediaEndpoint;
    }

    public String getMonomerEndpoint() {
        return monomerEndpoint;
    }

    public void setMonomerEndpoint(String monomerEndpoint) {
        this.monomerEndpoint = monomerEndpoint;
    }

    public String getMonomerCompositionEndpoint() {
        return monomerCompositionEndpoint;
    }

    public void setMonomerCompositionEndpoint(String monomerCompositionEndpoint) {
        this.monomerCompositionEndpoint = monomerCompositionEndpoint;
    }

    public String getNmrAssayEndpoint() {
        return nmrAssayEndpoint;
    }

    public void setNmrAssayEndpoint(String nmrAssayEndpoint) {
        this.nmrAssayEndpoint = nmrAssayEndpoint;
    }

    public String getNmrPeakEndpoint() {
        return nmrPeakEndpoint;
    }

    public void setNmrPeakEndpoint(String nmrPeakEndpoint) {
        this.nmrPeakEndpoint = nmrPeakEndpoint;
    }

    public String getNoteEndpoint() {
        return noteEndpoint;
    }

    public void setNoteEndpoint(String noteEndpoint) {
        this.noteEndpoint = noteEndpoint;
    }

    public String getObservedTaxonomicUnitEndpoint() {
        return observedTaxonomicUnitEndpoint;
    }

    public void setObservedTaxonomicUnitEndpoint(String observedTaxonomicUnitEndpoint) {
        this.observedTaxonomicUnitEndpoint = observedTaxonomicUnitEndpoint;
    }

    public String getObservedTaxonomicUnitCountEndpoint() {
        return observedTaxonomicUnitCountEndpoint;
    }

    public void setObservedTaxonomicUnitCountEndpoint(String observedTaxonomicUnitCountEndpoint) {
        this.observedTaxonomicUnitCountEndpoint = observedTaxonomicUnitCountEndpoint;
    }

    public String getOtuCountPropertyEndpoint() {
        return otuCountPropertyEndpoint;
    }

    public void setOtuCountPropertyEndpoint(String otuCountPropertyEndpoint) {
        this.otuCountPropertyEndpoint = otuCountPropertyEndpoint;
    }

    public String getPersistentAuditEventEndpoint() {
        return persistentAuditEventEndpoint;
    }

    public void setPersistentAuditEventEndpoint(String persistentAuditEventEndpoint) {
        this.persistentAuditEventEndpoint = persistentAuditEventEndpoint;
    }

    public String getPlatemapEndpoint() {
        return platemapEndpoint;
    }

    public void setPlatemapEndpoint(String platemapEndpoint) {
        this.platemapEndpoint = platemapEndpoint;
    }

    public String getPlateTypeEndpoint() {
        return plateTypeEndpoint;
    }

    public void setPlateTypeEndpoint(String plateTypeEndpoint) {
        this.plateTypeEndpoint = plateTypeEndpoint;
    }

    public String getProcessedReadoutEndpoint() {
        return processedReadoutEndpoint;
    }

    public void setProcessedReadoutEndpoint(String processedReadoutEndpoint) {
        this.processedReadoutEndpoint = processedReadoutEndpoint;
    }

    public String getSampleEndpoint() {
        return sampleEndpoint;
    }

    public void setSampleEndpoint(String sampleEndpoint) {
        this.sampleEndpoint = sampleEndpoint;
    }

    public String getScientistEndpoint() {
        return scientistEndpoint;
    }

    public void setScientistEndpoint(String scientistEndpoint) {
        this.scientistEndpoint = scientistEndpoint;
    }

    public String getSequencingRunEndpoint() {
        return sequencingRunEndpoint;
    }

    public void setSequencingRunEndpoint(String sequencingRunEndpoint) {
        this.sequencingRunEndpoint = sequencingRunEndpoint;
    }

    public String getUserEndpoint() {
        return userEndpoint;
    }

    public void setUserEndpoint(String userEndpoint) {
        this.userEndpoint = userEndpoint;
    }

    public String getWellEndpoint() {
        return wellEndpoint;
    }

    public void setWellEndpoint(String wellEndpoint) {
        this.wellEndpoint = wellEndpoint;
    }

    public String getSearchPathComponent() {
        return searchPathComponent;
    }

    public void setSearchPathComponent(String searchPathComponent) {
        this.searchPathComponent = searchPathComponent;
    }

    public String getSampleTreatmentEndpoint() {
        return this.sampleTreatmentEndpoint;
    }

    public void setSampleTreatmentEndpoint(String sampleTreatmentEndpoint) {
        this.sampleTreatmentEndpoint = sampleTreatmentEndpoint;
    }

    public long getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(long retryInterval) {
        this.retryInterval = retryInterval;
    }

    public double getRetryMultiplier() {
        return retryMultiplier;
    }

    public void setRetryMultiplier(double retryMultiplier) {
        this.retryMultiplier = retryMultiplier;
    }

    public long getMaxRetryInterval() {
        return maxRetryInterval;
    }

    public void setMaxRetryInterval(long maxRetryInterval) {
        this.maxRetryInterval = maxRetryInterval;
    }

    public int getMaxRequestAttempts() {
        return maxRequestAttempts;
    }

    public void setMaxRequestAttempts(int maxRequestAttempts) {
        this.maxRequestAttempts = maxRequestAttempts;
    }
}
