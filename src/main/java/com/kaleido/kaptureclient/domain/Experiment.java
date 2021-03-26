package com.kaleido.kaptureclient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaleido.kaptureclient.domain.enumeration.StudyEnvironment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * An instance of an activity
 */
public class Experiment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * Holds information on each Activity/Experiment name
     */
    @NotNull
    private String name;

    /**
     * The environment of study
     */
    @NotNull
    private StudyEnvironment studyEnvironment;

    /**
     * The name of the study is the activity name and study environment
     */
    private String studyName;

    /**
     * The start date of the activity
     */
    private LocalDate startDate;

    /**
     * The description of the study
     */
    @Size(max = 1000)
    private String description;

    /**
     * The project the activity is associated with (e.g. TMA, SCFA, etc...)
     */
    private String project;

    /**
     * The goals of the study
     */
    private String goals;

    /**
     * The location of the activity
     */
    @NotNull
    private String location;

    /**
     * Which chamber was used
     */
    private String chamber;

    /**
     * The Status of the activity
     */
    private String status;

    /**
     * The type of activity
     */
    private String activityType;

    /**
     * The number of plates
     */
    @Min(value = 0)
    private Integer numberOfPlates;

    /**
     * The percent of the total sample made up by a fecal slurry
     */
    private Double slurryPercent;

    /**
     * Activity notes
     */
    private String notes;

    /**
     * LIMS registration record
     */
    private String dataRecordName;

    /**
     * The scientist associated with the experiment
     */
    @JsonIgnoreProperties("")
    private Scientist scientist;

    /**
     * The processing method of the experiment
     */
    @JsonIgnoreProperties("")
    private Concept processingMethod;

    /**
     * The plate types associated with the experiment
     * @deprecated plate types should now be associated from their platemap
     */
    @Deprecated
    private Set<PlateType> plateTypes = new HashSet<>();

    /**
     * The Assay types associated with the experiment
     */
    private Set<Concept> assayTypes = new HashSet<>();

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

    public Experiment name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudyEnvironment getStudyEnvironment() {
        return studyEnvironment;
    }

    public Experiment studyEnvironment(StudyEnvironment studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
        return this;
    }

    public void setStudyEnvironment(StudyEnvironment studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }

    public String getStudyName() {
        return studyName;
    }

    public Experiment studyName(String studyName) {
        this.studyName = studyName;
        return this;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Experiment startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public Experiment description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public Experiment project(String project) {
        this.project = project;
        return this;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getGoals() {
        return goals;
    }

    public Experiment goals(String goals) {
        this.goals = goals;
        return this;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getLocation() {
        return location;
    }

    public Experiment location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getChamber() {
        return chamber;
    }

    public Experiment chamber(String chamber) {
        this.chamber = chamber;
        return this;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getStatus() {
        return status;
    }

    public Experiment status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityType() {
        return activityType;
    }

    public Experiment activityType(String activityType) {
        this.activityType = activityType;
        return this;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Integer getNumberOfPlates() {
        return numberOfPlates;
    }

    public Experiment numberOfPlates(Integer numberOfPlates) {
        this.numberOfPlates = numberOfPlates;
        return this;
    }

    public void setNumberOfPlates(Integer numberOfPlates) {
        this.numberOfPlates = numberOfPlates;
    }

    public Double getSlurryPercent() {
        return slurryPercent;
    }

    public Experiment slurryPercent(Double slurryPercent) {
        this.slurryPercent = slurryPercent;
        return this;
    }

    public void setSlurryPercent(Double slurryPercent) {
        this.slurryPercent = slurryPercent;
    }

    public String getNotes() {
        return notes;
    }

    public Experiment notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDataRecordName() {
        return dataRecordName;
    }

    public Experiment dataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
        return this;
    }

    public void setDataRecordName(String dataRecordName) {
        this.dataRecordName = dataRecordName;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public Experiment scientist(Scientist scientist) {
        this.scientist = scientist;
        return this;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public Concept getProcessingMethod() {
        return processingMethod;
    }

    public Experiment processingMethod(Concept concept) {
        this.processingMethod = concept;
        return this;
    }

    public void setProcessingMethod(Concept concept) {
        this.processingMethod = concept;
    }

    @Deprecated
    public Set<PlateType> getPlateTypes() {
        return plateTypes;
    }

    @Deprecated
    public Experiment plateTypes(Set<PlateType> plateTypes) {
        this.plateTypes = plateTypes;
        return this;
    }

    @Deprecated
    public Experiment addPlateTypes(PlateType plateType) {
        this.plateTypes.add(plateType);
        return this;
    }

    @Deprecated
    public Experiment removePlateTypes(PlateType plateType) {
        this.plateTypes.remove(plateType);
        return this;
    }

    @Deprecated
    public void setPlateTypes(Set<PlateType> plateTypes) {
        this.plateTypes = plateTypes;
    }

    public Set<Concept> getAssayTypes() {
        return assayTypes;
    }

    public Experiment assayTypes(Set<Concept> concepts) {
        this.assayTypes = concepts;
        return this;
    }

    public Experiment addAssayTypes(Concept concept) {
        this.assayTypes.add(concept);
        return this;
    }

    public Experiment removeAssayTypes(Concept concept) {
        this.assayTypes.remove(concept);
        return this;
    }

    public void setAssayTypes(Set<Concept> concepts) {
        this.assayTypes = concepts;
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
        Experiment experiment = (Experiment) o;
        if (experiment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), experiment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", studyEnvironment='" + getStudyEnvironment() + "'" +
                ", studyName='" + getStudyName() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", description='" + getDescription() + "'" +
                ", project='" + getProject() + "'" +
                ", goals='" + getGoals() + "'" +
                ", location='" + getLocation() + "'" +
                ", chamber='" + getChamber() + "'" +
                ", status='" + getStatus() + "'" +
                ", activityType='" + getActivityType() + "'" +
                ", numberOfPlates=" + getNumberOfPlates() +
                ", slurryPercent=" + getSlurryPercent() +
                ", notes='" + getNotes() + "'" +
                ", dataRecordName='" + getDataRecordName() + "'" +
                "}";
    }
}
