package io.khasang.enterprise.service.projectService.basicProject;

import java.math.BigDecimal;

public class Forum extends AbstractBasicProject {
    public Forum() {
        setTitle("Forum ");
        setDescription("Basic Forum website ");
        setPrice(new BigDecimal(70));
    }
}
