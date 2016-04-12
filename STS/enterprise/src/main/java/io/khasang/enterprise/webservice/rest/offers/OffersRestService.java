package io.khasang.enterprise.webservice.rest.offers;

import io.khasang.enterprise.dao.interfaces.OfferDao;
import io.khasang.enterprise.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Controller
@Path("/offers")
public class OffersRestService {

    @Autowired
    OfferDao offerDao;

    @GET
    @Produces("application/json")
    @Path("/last")
    public List<Offer> getOffers() {
        return offerDao.findAllOffers();

    }
}
