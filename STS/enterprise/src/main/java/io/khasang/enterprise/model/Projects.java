package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.ProjectBasis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Projects {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "project_basis")
    @Enumerated(EnumType.STRING)
    private ProjectBasis projectBasis;
    
    @ManyToOne
    private Clients customer;

    private String title;

    private String description;

    private BigDecimal price;

    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Column(name = "close_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Projects() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectBasis getProjectBasis() {
        return projectBasis;
    }

    public void setProjectBasis(ProjectBasis projectBasis) {
        this.projectBasis = projectBasis;
    }

    public Clients getCustomer() {
        return customer;
    }

    public void setCustomer(Clients customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
