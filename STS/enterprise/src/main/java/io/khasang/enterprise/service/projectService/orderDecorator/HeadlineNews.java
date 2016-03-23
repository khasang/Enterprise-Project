package io.khasang.enterprise.service.projectService.orderDecorator;

import io.khasang.enterprise.service.projectService.ProjectInterface;

import java.math.BigDecimal;

public class HeadlineNews extends OrderDecorator{
    public HeadlineNews(ProjectInterface project) {
        this.project = project;
        setTitle(" Headline News");
        setDescription(" Provide up-to-the minute news for your visitors automatically!");
        setPrice(new BigDecimal(10));
    }
}
