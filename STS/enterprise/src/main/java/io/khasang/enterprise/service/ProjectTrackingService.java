package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.dao.interfaces.ProjectDao;
import io.khasang.enterprise.dao.interfaces.TrackDao;
import io.khasang.enterprise.model.CustomerOrder;
import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.Track;
import io.khasang.enterprise.model.enums.TrackStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        List<Track> lastTracks = new ArrayList<>();
        for (CustomerOrder order : orders) {
            lastTracks.add(trackDao.findByOrderIdAndMaxProgress(order.getId()));
        }
        return lastTracks;
    }
    
    public List<Track> getTrackingHistoryOfOrder(Integer orderId) {
        return trackDao.findAllByOrderId(orderId);
    }

    public CustomerOrder getOrderById(Integer orderId) {
        return orderDao.findById(orderId);
    }

    public void createNewTrack(Track track, Integer orderId) {
        track.setOrder(orderDao.findById(orderId));
        track.setTrackStatus(TrackStatus.REQUESTED);
//        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        track.setEmployee(employeeDao.findById(6)); // todo убрать заглушку 6. Вместо нее ставить id текущего емплоера в системе
        trackDao.save(track);
    }

    public List<Track> getTasksOfEmployee() {
        return trackDao.findUnfinishedByEmployeeId(6); // todo убрать заглушкку 6
    }
}
