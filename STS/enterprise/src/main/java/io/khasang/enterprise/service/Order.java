package io.khasang.enterprise.service;

import io.khasang.enterprise.model.employee.Employee;
import java.util.ArrayList;

public class Order {
    private final Project PROJECT;
    private String title;
    private String description;
    private Status status;
    private ArrayList<Employee> executors;
    //OR
    private Employee executor;

    public Order (Project project, String title) {
        this.PROJECT = project;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setExecutors(ArrayList<Employee> executors) {
        this.executors = executors;
    }

//    public boolean setExecutor(Employee executor) {
//        if (PROJECT.hasEmplyee(executor)) {
//            this.executor = executor;
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public Project getProject() {
//        return project;
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public ArrayList<Employee> getExecutors() {
        return executors;
    }

    public Employee getExecutor() {
        return executor;
    }
}