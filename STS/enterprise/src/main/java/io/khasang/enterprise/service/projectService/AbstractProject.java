package io.khasang.enterprise.service.projectService;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractProject implements ProjectInterface {
    private int id;
    private String title;
    private String description;
    private BigDecimal price;
    private Date date;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
