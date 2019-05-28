package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A sequencing run
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SequencingRun implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * name of the sequencing run
     */
    @NotNull
    private String name;
    
    /**
     * File associated with the sequencing run
     */
    private ImportedFile importedFile;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SequencingRun name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ImportedFile getImportedFile() {
        return importedFile;
    }

    public SequencingRun importedFile(ImportedFile importedFile) {
        this.importedFile = importedFile;
        return this;
    }

    public void setImportedFile(ImportedFile importedFile) {
        this.importedFile = importedFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SequencingRun sequencingRun = (SequencingRun) o;
        if (sequencingRun.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sequencingRun.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SequencingRun{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
