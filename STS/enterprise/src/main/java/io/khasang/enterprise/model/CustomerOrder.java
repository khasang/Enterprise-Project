package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.Features;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private Features feature;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Track> tracks = new HashSet<>(0);

    public CustomerOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return getFeature().toString();
    }
}
