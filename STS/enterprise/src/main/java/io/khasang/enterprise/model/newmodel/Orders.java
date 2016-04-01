package io.khasang.enterprise.model.newmodel;

import io.khasang.enterprise.model.newmodel.enums.Features;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Projects project;

    @Enumerated(EnumType.STRING)
    private Features feature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public Features getFeature() {
        return feature;
    }

    public void setFeature(Features features) {
        this.feature = features;
    }
}
