package io.khasang.enterprise.service.projectService.orderDecorator;

import io.khasang.enterprise.service.projectService.ProjectInterface;

import java.math.BigDecimal;

public class OnlinePayments extends OrderDecorator {
    public OnlinePayments(ProjectInterface project) {
        this.project = project;
        setTitle(" Online Payments");
        setDescription(" Allow your visitors to buy/sell/trade their products and services.");
        setPrice(new BigDecimal(15));
    }
}
