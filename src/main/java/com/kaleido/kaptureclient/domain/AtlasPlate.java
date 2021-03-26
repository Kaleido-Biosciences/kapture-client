package com.kaleido.kaptureclient.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class AtlasPlate implements Serializable {

    private static final long serialVersionUID = 1L;
    private String experiment;
    private ArrayList<WellWithComponents> wellWithComponents;

    public AtlasPlate() {
    }

    public AtlasPlate(String experiment, ArrayList<WellWithComponents> wellWithComponents) {
        this.experiment = experiment;
        this.wellWithComponents = wellWithComponents;
    }

    public String getExperiment() {
        return experiment;
    }

    public void setExperiment(String experiment) {
        this.experiment = experiment;
    }

    public ArrayList<WellWithComponents> getWellWithComponents() {
        return wellWithComponents;
    }

    public void setWellWithComponents(ArrayList<WellWithComponents> wellWithComponents) {
        this.wellWithComponents = wellWithComponents;
    }

    public AtlasPlate experiment(String experiment) {
        this.experiment = experiment;
        return this;
    }

    public AtlasPlate wellWithComponents(ArrayList<WellWithComponents> wellWithComponents) {
        this.wellWithComponents = wellWithComponents;
        return this;
    }


    // inner class
    static public class WellWithComponents {
        private Well well;
        private ArrayList<WellComponent> wellComponents;
        private ArrayList<WellAttribute> attributes;

        public WellWithComponents() {
        }

        public WellWithComponents(Well well, ArrayList<WellComponent> wellComponents, ArrayList<WellAttribute> attributes) {
            this.well = well;
            this.wellComponents = wellComponents;
            this.attributes = attributes;
        }

        public Well getWell() {
            return well;
        }

        public void setWell(Well well) {
            this.well = well;
        }

        public ArrayList<WellComponent> getWellComponents() {
            return wellComponents;
        }

        public void setWellComponents(ArrayList<WellComponent> wellComponents) {
            this.wellComponents = wellComponents;
        }

        public ArrayList<WellAttribute> getAttributes() {
            return attributes;
        }

        public void setAttributes(ArrayList<WellAttribute> attributes) {
            this.attributes = attributes;
        }

        public WellWithComponents well(Well well) {
            this.well = well;
            return this;
        }

        public WellWithComponents wellComponents(ArrayList<WellComponent> wellComponents) {
            this.wellComponents = wellComponents;
            return this;
        }

        public WellWithComponents attributes(ArrayList<WellAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }
    }

    // inner class
    static public class WellComponent {
        private String type;
        private Long id;
        private ArrayList<WellComponentTimepoint> timepoints;

        public WellComponent() {
        }

        public WellComponent(String type, Long id, ArrayList<WellComponentTimepoint> timepoints) {
            this.type = type;
            this.id = id;
            this.timepoints = timepoints;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public ArrayList<WellComponentTimepoint> getTimepoints() {
            return timepoints;
        }

        public void setTimepoints(ArrayList<WellComponentTimepoint> timepoints) {
            this.timepoints = timepoints;
        }

        public WellComponent type(String type) {
            this.type = type;
            return this;
        }

        public WellComponent type(ArrayList<WellComponentTimepoint> timepoints) {
            this.timepoints = timepoints;
            return this;
        }

    }

    static public class WellComponentTimepoint {

        private Double time;
        private Float concentration;
        private String concentrationUnit;

        public WellComponentTimepoint() {
        }

        public WellComponentTimepoint(Double time, Float concentration, String concentrationUnit) {
            this.time = time;
            this.concentration = concentration;
            this.concentrationUnit = concentrationUnit;
        }

        public Double getTime() {
            return time;
        }

        public void setTime(Double time) {
            this.time = time;
        }

        public Float getConcentration() {
            return concentration;
        }

        public void setConcentration(Float concentration) {
            this.concentration = concentration;
        }

        public String getConcentrationUnit() {
            return concentrationUnit;
        }

        public void setConcentrationUnit(String concentrationUnit) {
            this.concentrationUnit = concentrationUnit;
        }

        public WellComponentTimepoint type(Double time) {
            this.time = time;
            return this;
        }

        public WellComponentTimepoint concentration(Float concentration) {
            this.concentration = concentration;
            return this;
        }

        public WellComponentTimepoint concentrationUnit(String concentrationUnit) {
            this.concentrationUnit = concentrationUnit;
            return this;
        }
    }

    static public class WellAttribute {

        private String key;
        private String value;
        private String value_type;
        private String value_unit;

        public WellAttribute() {

        }

        public WellAttribute(String key, String value, String value_type, String value_unit) {
            this.key = key;
            this.value = value;
            this.value_type = value_type;
            this.value_unit = value_unit;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue_type() {
            return value_type;
        }

        public void setValue_type(String value_type) {
            this.value_type = value_type;
        }

        public String getValue_unit() {
            return value_unit;
        }

        public void setValue_unit(String value_unit) {
            this.value_unit = value_unit;
        }

        public WellAttribute key(String key) {
            this.key = key;
            return this;
        }
        public WellAttribute value(String value) {
            this.value = value;
            return this;
        }
        public WellAttribute value_type(String value_type) {
            this.value_type = value_type;
            return this;
        }
        public WellAttribute value_unit(String value_unit) {
            this.value_unit = value_unit;
            return this;
        }

    }
}
