package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.CustomerOrder;

public interface OrderDao {

    CustomerOrder findOrderByProjectId(Integer projectId);

    void deleteAllOrders();
}
