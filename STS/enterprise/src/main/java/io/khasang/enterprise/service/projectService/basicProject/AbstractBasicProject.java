package io.khasang.enterprise.service.projectService.basicProject;

import io.khasang.enterprise.service.projectService.Status;

public abstract class AbstractBasicProject {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
