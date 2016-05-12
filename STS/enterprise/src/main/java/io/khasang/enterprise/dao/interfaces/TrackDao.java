package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Track;

import java.util.List;

public interface TrackDao {
    Track findById(Integer id);

    List<Track> findAll();

    void save(Track project);

    void update(Track project);

    List<Track> findAllByOrderId(Integer orderId);

    List<Track> findAllByEmployeeId(Integer employeeId);

    Track findByOrderIdAndMaxProgress(Integer orderId);

    List<Integer> findAllUniqueOrderIdsByEmployeeId(Integer employeeId);
}
