package com.kaleido.kaptureclient.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Categories of Analytes.
 */
public class AnalyteType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public AnalyteType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnalyteType analyteType = (AnalyteType) o;
        if (analyteType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), analyteType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnalyteType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
