package com.kaleido.kaptureclient.domain.dto;

import java.util.List;

/**
 * A DTO representing an Assay Readout
 * This is based on a single sample
 */
public class AssayReadoutDTO {

    /**
     * We can specify the label or the ID, but the default & preferred will be label
     * since it is network intensive to retrieve lots of ids and should be
     * handled as close to the DB as possible
     */
    private Long sampleId;
    private String sampleLabel;

    private List<AssayReadoutPayloadDTO> assayReadouts;

    public AssayReadoutDTO() { }

    public AssayReadoutDTO(Long sampleId, List<AssayReadoutPayloadDTO> assayReadouts) {
        this.sampleId = sampleId;
        this.sampleLabel = null;
        this.assayReadouts = assayReadouts;
    }

    public AssayReadoutDTO(String sampleLabel, List<AssayReadoutPayloadDTO> assayReadouts) {
        this.sampleId = null;
        this.sampleLabel = sampleLabel;
        this.assayReadouts = assayReadouts;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleLabel() {
        return sampleLabel;
    }

    public void setSampleLabel(String sampleLabel) {
        this.sampleLabel = sampleLabel;
    }

    public List<AssayReadoutPayloadDTO> getAssayReadouts() {
        return assayReadouts;
    }

    public void setAssayReadouts(List<AssayReadoutPayloadDTO> assayReadouts) {
        this.assayReadouts = assayReadouts;
    }

    @Override
    public String toString() {
        return "AssayReadoutDTO{" +
            "sampleId=" + sampleId +
            ", sampleLabel='" + sampleLabel + '\'' +
            ", assayReadouts=" + assayReadouts +
            '}';
    }
}
