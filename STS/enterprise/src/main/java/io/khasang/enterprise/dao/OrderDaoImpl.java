package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.model.CustomerOrder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, CustomerOrder> implements OrderDao {

    public CustomerOrder findOrderByProjectId(Integer projectId) {
        Query query = getSession().createQuery("FROM CustomerOrder u WHERE u.project = :project");
        query.setInteger("project", projectId);
        return (CustomerOrder) query.list().get(0);
    }

    public void deleteAllOrders() {
        Query query = getSession().createSQLQuery("delete from customer_order");
        query.executeUpdate();
    }
}
