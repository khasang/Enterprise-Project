package io.khasang.enterprise.service.projectService.basicProject;

import io.khasang.enterprise.service.projectService.AbstractProject;
import io.khasang.enterprise.service.projectService.Status;

public abstract class AbstractBasicProject extends AbstractProject {
    private Status status = Status.PENDING;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
