package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.CustomerOrder;

public interface OrderDao {

    CustomerOrder findOrderByProjectId(int projectId);

    void deleteAllOrders();
}
