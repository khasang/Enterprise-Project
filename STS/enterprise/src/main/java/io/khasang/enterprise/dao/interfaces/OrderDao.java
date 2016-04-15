package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.CustomerOrder;

import java.util.List;

public interface OrderDao {
    CustomerOrder findById(Integer id);

    List<CustomerOrder> findAll();

    void save(CustomerOrder customerOrder);

    CustomerOrder findOrderByProjectId(Integer projectId);

    void deleteAllOrders();
}
