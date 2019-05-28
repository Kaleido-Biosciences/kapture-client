package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Analytes for which there are assays
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Analyte implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String name;

    /**
     * The analyte type for this analyte
     */
    @NotNull
    @JsonIgnoreProperties("")
    private AnalyteType analyteType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Analyte name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnalyteType getAnalyteType() {
        return analyteType;
    }

    public Analyte analyteType(AnalyteType analyteType) {
        this.analyteType = analyteType;
        return this;
    }

    public void setAnalyteType(AnalyteType analyteType) {
        this.analyteType = analyteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Analyte analyte = (Analyte) o;
        if (analyte.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), analyte.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Analyte{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
