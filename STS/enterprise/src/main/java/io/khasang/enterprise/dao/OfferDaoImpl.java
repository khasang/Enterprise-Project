package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OfferDao;
import io.khasang.enterprise.model.Offer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao<Integer, Offer> implements OfferDao {

    @SuppressWarnings("unchecked")
    public List<Offer> findOfferByPrice(BigDecimal price) {
        Query query = getSession().createQuery("FROM Offer o WHERE o.price = :price");
        query.setBigDecimal("price", price);
        return query.list();
    }

    public void deleteOfferById(int id) {
        Query query = getSession().createSQLQuery("DELETE from offer where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public void deleteAllOffers() {
        Query query = getSession().createSQLQuery("delete from offer");
        query.executeUpdate();
    }
}