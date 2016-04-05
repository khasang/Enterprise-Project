package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.OfferDao;
import io.khasang.enterprise.model.Offer;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao<Offer> implements OfferDao {

    public Offer findById(int id) {
        return null;
    }

    public Offer findOfferByPrice(BigDecimal price) {
        return null;
    }

    public List<Offer> findAllOffers() {
        return null;
    }

    public void saveOffer(Offer offer) {

    }

    public void deleteOfferById(int id) {

    }

    public void deleteAllOffers() {

    }
}
