package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Offer;

import java.math.BigDecimal;
import java.util.List;

public interface OfferDao {

    Offer findById(int id);

    Offer findOfferByPrice(BigDecimal price);

    List<Offer> findAllOffers();

    void saveOffer(Offer offer);

    void deleteOfferById(int id);

    void deleteAllOffers();
}
