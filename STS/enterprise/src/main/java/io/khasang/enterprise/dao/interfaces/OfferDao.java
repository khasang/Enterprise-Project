package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferDao {
    Offer findById(Integer id);

    List<Offer> findAll();

    void save(Offer offer);

    void update(Offer offer);

    List<Offer> findOfferByPrice(BigDecimal price);

    void deleteOfferById(int id);

    void deleteAllOffers();
}
