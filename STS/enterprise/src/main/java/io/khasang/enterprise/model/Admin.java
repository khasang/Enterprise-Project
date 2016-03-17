package io.khasang.enterprise.model;

import io.khasang.enterprise.service.Order;
import io.khasang.enterprise.service.Project;

public class Admin extends User {
    public User getUser() {
        return null;
    }

    public Project getProject() {
        return null;
    }

    public Order getOrder() {
        return null;
    }

}
