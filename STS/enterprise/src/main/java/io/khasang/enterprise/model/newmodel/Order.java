package io.khasang.enterprise.model.newmodel;

import io.khasang.enterprise.model.newmodel.enums.Feature;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private Feature feature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
