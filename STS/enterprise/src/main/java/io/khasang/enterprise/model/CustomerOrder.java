package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.Features;

import javax.persistence.*;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private Features feature;

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

    public Features getFeature() {
        return feature;
    }

    public void setFeature(Features features) {
        this.feature = features;
    }
}
