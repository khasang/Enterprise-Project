package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OrderDao;
import io.khasang.enterprise.model.CustomerOrder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, CustomerOrder> implements OrderDao {

    public CustomerOrder findOrderByProjectId(int projectId) {
        Criteria criteria = getSession().createCriteria(CustomerOrder.class);
        criteria.add(Restrictions.eq("project", projectId));
        return (CustomerOrder) criteria.uniqueResult();
    }

    public void deleteAllOrders() {
        Query query = getSession().createSQLQuery("delete from customer_order");
        query.executeUpdate();
    }
}
