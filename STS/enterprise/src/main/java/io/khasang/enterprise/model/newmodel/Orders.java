package io.khasang.enterprise.model.newmodel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    @JoinTable(name="project_orders",
            joinColumns = @JoinColumn(name="orderFeature_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="project_id", referencedColumnName="id"))
    private Set<Projects> project = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Features features;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Projects> getProject() {
        return project;
    }

    public void setProject(Set<Projects> project) {
        this.project = project;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }
}
