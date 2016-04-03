package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.enums.ProjectBasis;

import java.math.BigDecimal;
import java.util.List;

public interface ProjectDao {
    Project findById(int id);

    List<Project> findByProjectBasis(ProjectBasis basis);

    List<Project> findByPrice(BigDecimal price);

    List<Project> findUnfinishedProjects();

    List<Project> findFinishedProjects();

    List<Project> findAllProjects();

    void saveProject(Project project);

    void deleteProjectById(int id);

    void deleteAllProjects();
}
