package com.kaleido.kaptureclient.domain.dto;

/**
 * A DTO representing an Assay Readout
 * This is based on a single sample
 */
public class LimsSequencingFileDTO {

    private String s3Location;
    private String bucket;
    private String datatype;
    private String runInformation;

    public LimsSequencingFileDTO() { }

    public LimsSequencingFileDTO(String s3Location, String bucket, String datatype, String runInformation) {
        this.s3Location = s3Location;
        this.bucket = bucket;
        this.datatype = datatype;
        this.runInformation = runInformation;
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

    public String getRunInformation() {
        return runInformation;
    }

    public void setRunInformation(String runInformation) {
        this.runInformation = runInformation;
    }

    public LimsSequencingFileDTO S3Location(String s3Location) {
        this.s3Location = s3Location;
        return this;
    }

    public LimsSequencingFileDTO Bucket(String bucket) {
        this.bucket = bucket;
        return this;
    }

    public LimsSequencingFileDTO Datatype(String datatype) {
        this.datatype = datatype;
        return this;
    }

    public LimsSequencingFileDTO RunInformation(String runInformation) {
        this.runInformation = runInformation;
        return this;
    }

    @Override
    public String toString() {
        return "LimsSequencingFileDTO{" +
                "s3Location='" + s3Location + '\'' +
                ", bucket='" + bucket + '\'' +
                ", datatype='" + datatype + '\'' +
                ", runInformation='" + runInformation + '\'' +
                '}';
    }
}
