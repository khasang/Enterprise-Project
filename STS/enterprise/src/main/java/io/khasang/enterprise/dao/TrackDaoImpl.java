package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.TrackDao;
import io.khasang.enterprise.model.Track;
import io.khasang.enterprise.model.enums.TrackStatus;
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
    public List<Track> findUnfinishedByEmployeeId(Integer employeeId) {
        Query query = getSession().createQuery("FROM Track t WHERE t.employee = :employeeId AND t.trackStatus = :status AND t.progress != :finishedValue");
        query.setInteger("employeeId", employeeId);
        query.setString("status", "RUNNING");
        query.setInteger("finishedValue", 100);
        return query.list();
    }

    public Track findByOrderIdAndMaxProgress(Integer orderId) {
        Query query = getSession().createQuery("FROM Track t WHERE t.order = :orderId ORDER BY t.progress DESC");
        query.setInteger("orderId", orderId);
        query.getFirstResult();
        return (Track) query.list().get(0);
    }

//    @SuppressWarnings("unchecked")
//    public List<Track> findTemporary(String login) {
//        Query query = getSession().createQuery("FROM Track t WHERE t.employee = :employeeId AND t.trackStatus = :status AND t.progress != :finishedValue");
//        query.setInteger("employeeId", employeeId);
//        query.setString("status", "RUNNING");
//        query.setInteger("finishedValue", 100);
//        return query.list();
//    }
}
