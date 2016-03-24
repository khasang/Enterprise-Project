package io.khasang.enterprise.service.projectService.orderDecorator;

import io.khasang.enterprise.service.projectService.ProjectInterface;

import java.math.BigDecimal;

public class LiveChat extends OrderDecorator {
    public LiveChat(ProjectInterface project) {
        this.project = project;
        setTitle(" LiveChat");
        setDescription(" Chat in real-time with people who are visiting your chat room.");
        setPrice(new BigDecimal(40));
    }
}
