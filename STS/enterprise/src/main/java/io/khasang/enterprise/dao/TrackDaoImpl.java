package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.TrackDao;
import io.khasang.enterprise.model.Track;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("trackDao")
public class TrackDaoImpl extends AbstractDao<Integer, Track> implements TrackDao {

    @SuppressWarnings("unchecked")
    public List<Track> findAllByOrderId(Integer orderId) {
        Query query = getSession().createQuery("FROM Track t WHERE t.order = :orderId ORDER BY t.progress ASC");
        query.setInteger("orderId", orderId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Track> findAllByEmployeeId(Integer employeeId) {
        Query query = getSession().createQuery("FROM Track t WHERE t.employee = :employeeId");
        query.setInteger("employeeId", employeeId);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Integer> findAllUniqueOrderIdsByEmployeeId(Integer employeeId) {
        Query query = getSession().createQuery("SELECT DISTINCT t.order.id FROM Track t WHERE t.employee.id = :employeeId");
        query.setInteger("employeeId", employeeId);
        return (List<Integer>) query.list();
    }
    public Track findByOrderIdAndMaxProgress(Integer orderId) {
        Query query = getSession().createQuery("FROM Track t WHERE t.order = :orderId ORDER BY t.progress DESC");
        query.setInteger("orderId", orderId);
        query.getFirstResult();
        if (query.list().size() == 0) {
            return null;
        } else {
            return (Track) query.list().get(0);
        }
    }
}
