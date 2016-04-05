package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.model.CustomerOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<CustomerOrder> implements OrderDao {
    public CustomerOrder findById(int id) {
        return null;
    }

    public CustomerOrder findOrderByProjectId(int projectId) {
        return null;
    }

    public List<CustomerOrder> findAllOrders() {
        return null;
    }

    public void saveOrder(CustomerOrder order) {
    }

    public void deleteAllOrders() {
    }
}
