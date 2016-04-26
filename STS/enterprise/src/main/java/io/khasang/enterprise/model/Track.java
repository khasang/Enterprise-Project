package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.TrackStatus;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Track {

    private static final Integer INITIAL_PROGRESS = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder order;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "progress", nullable = false, columnDefinition = "INT(11) default 5")
    @Min(value = 0)
    @Max(value = 100)
    private Integer progress = INITIAL_PROGRESS;

    @Column(name = "track_status")
    @Enumerated(EnumType.STRING)
    private TrackStatus trackStatus;

    private String description;

    public Track() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer performingStep) {
        this.progress = performingStep;
    }

    public TrackStatus getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(TrackStatus trackStatus) {
        this.trackStatus = trackStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
