package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.dao.interfaces.ProjectDao;
import io.khasang.enterprise.dao.interfaces.TrackDao;
import io.khasang.enterprise.model.CustomerOrder;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.Track;
import io.khasang.enterprise.model.enums.TrackStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("projectTrackingService")
@Transactional
public class ProjectTrackingService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TrackDao trackDao;
    @Autowired
    private EmployeeDao employeeDao;

    public Project getProjectById(Integer id) {
        return projectDao.findById(id);
    }

    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    public List<CustomerOrder> getProjectOrders(Integer projectId) {
        return orderDao.findOrdersByProjectId(projectId);
    }

    public List<Project> getUnfinishedProjects() {
        return projectDao.findUnfinishedProjects();
    }

    public List<Track> getLastTrackOfEachOrder(List<CustomerOrder> orders) {
        return orders.stream()
                .map(CustomerOrder::getId)
                .map(trackDao::findByOrderIdAndMaxProgress)
                .filter(track -> track != null).collect(Collectors.toList());
    }

    public Track getLastTrackByOrderId(Integer orderId) {
        return trackDao.findByOrderIdAndMaxProgress(orderId);
    }
    
    public List<Track> getTrackingHistoryOfOrder(Integer orderId) {
        return trackDao.findAllByOrderId(orderId);
    }

    public CustomerOrder getOrderById(Integer orderId) {
        return orderDao.findById(orderId);
    }

    public void createNewTrack(Track track, Integer orderId, Principal principal) {
        String login = principal.getName();
        track.setOrder(orderDao.findById(orderId));
        track.setTrackStatus(TrackStatus.REQUESTED);
        track.setEmployee(employeeDao.findByLogin(login));
        trackDao.save(track);
    }

    public List<Track> getTasksOfEmployee(Principal principal) {
        final Integer maxProgressValue = 100;
        String login = principal.getName();
        Employee employee = employeeDao.findByLogin(login);
        List<Integer> orderIds = trackDao.findAllUniqueOrderIdsByEmployeeId(employee.getId());

        return orderIds.stream()
                .map(trackDao::findByOrderIdAndMaxProgress)
                .filter(track -> track.getProgress() < maxProgressValue).collect(Collectors.toList());
    }

    public Project getProjectByTitle(String title) {
        return projectDao.findProjectsByTitle(title);
    }
}