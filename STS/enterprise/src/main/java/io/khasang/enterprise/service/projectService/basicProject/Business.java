package io.khasang.enterprise.service.projectService.basicProject;

import java.math.BigDecimal;

public class Business extends AbstractBasicProject {
    public Business() {
        setTitle("Busines website ");
        setDescription("Basic Business website ");
        setPrice(new BigDecimal(90));
    }
}
