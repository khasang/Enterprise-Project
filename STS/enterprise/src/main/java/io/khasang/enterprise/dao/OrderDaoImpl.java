package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.model.CustomerOrder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<CustomerOrder> implements OrderDao {
    public CustomerOrder findById(int id) {
        return getSession().get(CustomerOrder.class, id);
    }

    public CustomerOrder findOrderByProjectId(int projectId) {
        Criteria criteria = getSession().createCriteria(CustomerOrder.class);
        criteria.add(Restrictions.eq("project", projectId));
        return (CustomerOrder) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<CustomerOrder> findAllOrders() {
        Criteria criteria = getSession().createCriteria(CustomerOrder.class);
        return criteria.list();
    }

    public void saveOrder(CustomerOrder order) {
        persist(order);
    }

    public void deleteAllOrders() {
        Query query = getSession().createSQLQuery("delete from customer_order");
        query.executeUpdate();
    }
}
