package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * An alternative name for a Batch
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchAlias implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * The person who created the alias
     */
    private String createdBy;

    /**
     * The LIMS record reference
     */
    private String dataRecordName;

    /**
     * The alternative name
     */
    @NotNull
    private String alias;

    /**
     * When the alias was created
     */
    private ZonedDateTime dateCreated;

    /**
     * The source of the alias
     */
    private String source;

    @JsonIgnore
    private Set<Batch> batches = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public BatchAlias createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public BatchAlias dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public String getAlias() {
        return alias;
    }

    public BatchAlias alias(String alias) {
        this.alias = alias;
        return this;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public BatchAlias dateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSource() {
        return source;
    }

    public BatchAlias source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Set<Batch> getBatches() {
        return batches;
    }

    public BatchAlias batches(Set<Batch> batches) {
        this.batches = batches;
        return this;
    }

    public BatchAlias addBatches(Batch batch) {
        this.batches.add(batch);
        batch.getAliases().add(this);
        return this;
    }

    public BatchAlias removeBatches(Batch batch) {
        this.batches.remove(batch);
        batch.getAliases().remove(this);
        return this;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
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
        BatchAlias batchAlias = (BatchAlias) o;
        if (batchAlias.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), batchAlias.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BatchAlias{" +
            "id=" + getId() +
            ", createdBy='" + getCreatedBy() + "'" +
            ", dataRecordName='" + getDataRecordName() + "'" +
            ", alias='" + getAlias() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            ", source='" + getSource() + "'" +
            "}";
    }
}
