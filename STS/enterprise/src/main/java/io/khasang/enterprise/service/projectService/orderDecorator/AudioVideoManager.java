package io.khasang.enterprise.service.projectService.orderDecorator;

import io.khasang.enterprise.service.projectService.ProjectInterface;

import java.math.BigDecimal;

public class AudioVideoManager extends OrderDecorator {
    public AudioVideoManager(ProjectInterface project) {
        this.project = project;
        setTitle(" Audio-Video Manager");
        setDescription(" Manage your audio and video content");
        setPrice(new BigDecimal(30));
    }
}
