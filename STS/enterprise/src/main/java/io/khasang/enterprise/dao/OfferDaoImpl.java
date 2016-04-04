package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.dao.interfaces.ProjectDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.enums.ProjectBasis;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class OfferDaoImpl extends AbstractDao<Project> implements ProjectDao {
    public Project findById(int id) {
        return null;
    }

    public List<Project> findByProjectBasis(ProjectBasis basis) {
        return null;
    }

    public List<Project> findByPrice(BigDecimal price) {
        return null;
    }

    public List<Project> findUnfinishedProjects() {
        return null;
    }

    public List<Project> findFinishedProjects() {
        return null;
    }

    public List<Project> findAllProjects() {
        return null;
    }

    public void saveProject(Project project) {

    }

    public void deleteProjectById(int id) {

    }

    public void deleteAllProjects() {

    }
}
