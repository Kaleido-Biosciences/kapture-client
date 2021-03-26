package com.kaleido.kaptureclient.domain.dto;

/**
 * A DTO representing an Assay Readout
 * This is based on a single sample
 */
public class LimsSequencingFileDTO {

    private String s3Location;
    private String bucket;
    private String datatype;

    public LimsSequencingFileDTO() { }

    public LimsSequencingFileDTO(String s3Location, String bucket, String datatype) {
        this.s3Location = s3Location;
        this.bucket = bucket;
        this.datatype = datatype;
    }

    public String getS3Location() {
        return s3Location;
    }

    public void setS3Location(String s3Location) {
        this.s3Location = s3Location;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "LimsSequencingFileDTO{" +
            "s3Location='" + s3Location + '\'' +
            ", datatype='" + datatype + '\'' +
            '}';
    }
}
