package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.CustomerOrder;

import java.util.List;

public interface OrderDao {

    CustomerOrder findById(int id);

    CustomerOrder findOrderByProjectId(int projectId);

    List<CustomerOrder> findAllOrders();

    void saveOrder(CustomerOrder order);

    void deleteAllOrders();
}
