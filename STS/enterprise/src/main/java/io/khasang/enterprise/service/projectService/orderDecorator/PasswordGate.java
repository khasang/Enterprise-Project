package io.khasang.enterprise.service.projectService.orderDecorator;

import io.khasang.enterprise.service.projectService.ProjectInterface;

import java.math.BigDecimal;

public class PasswordGate extends OrderDecorator {
    public PasswordGate(ProjectInterface project) {
        this.project = project;
        setTitle(" Password Gate");
        setDescription(" Password protect your site to restrict access.");
        setPrice(new BigDecimal(38));
    }
}
