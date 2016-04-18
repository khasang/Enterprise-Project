package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.dao.interfaces.ProjectDao;
import io.khasang.enterprise.model.CustomerOrder;
import io.khasang.enterprise.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectTrackingService")
@Transactional
public class ProjectTrackingService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private OrderDao orderDao;

    public Project getProjectById(Integer id) {
        return projectDao.findById(id);
    }

    public List<Project> getAllProject() {
        return projectDao.findAll();
    }

    public List<CustomerOrder> getProjectOrders(Integer projectId) {
        return orderDao.findOrdersByProjectId(projectId);
    }
}
