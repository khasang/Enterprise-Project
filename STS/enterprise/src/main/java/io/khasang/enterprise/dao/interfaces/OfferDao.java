package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferDao {

    List<Offer> findOfferByPrice(BigDecimal price);

    void deleteOfferById(int id);

    void deleteAllOffers();
}
