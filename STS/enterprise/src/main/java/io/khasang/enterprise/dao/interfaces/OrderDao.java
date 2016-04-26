package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.CustomerOrder;

import java.util.List;
import java.util.Set;

public interface OrderDao {
    CustomerOrder findById(Integer id);

    List<CustomerOrder> findAll();

    void save(CustomerOrder customerOrder);

    void update(CustomerOrder order);

    List<CustomerOrder> findOrdersByProjectId(Integer projectId);

    void deleteAllOrders();
}
