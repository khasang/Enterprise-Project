package io.khasang.enterprise.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Project {
    private static int lastNumber = 0;
    private long id;
    private long date;
    private int number;
    private String description;

    public Project() {
        initProject();
    }

    public Project(String description) {
        initProject();
        this.description = description;
    }

    public static int getLastNumber() {
        return lastNumber;
    }

    public static synchronized void setLastNumber() {
        Project.lastNumber++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void initProject() {
        Random random = new Random();
        this.id = random.nextLong();
        this.date = new Date().getTime();
        Project.setLastNumber();
        this.number = Project.lastNumber;
    }

    @Override
    public String toString() {
        Date date = new Date();
        date.setTime(this.date);
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return "Order №" + this.number + " - " + format1.format(date);
    }
}
