package io.khasang.enterprise.webservice.rest.offers;

import io.khasang.enterprise.dao.interfaces.OfferDao;
import io.khasang.enterprise.model.Offer;
import io.khasang.enterprise.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/offers")
public class OffersRestService {

//    @Autowired
//    OfferDao offerDao;
//
//    @GET
//    @Path("/last")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Offer getOffers() {
//        Offer offer = new Offer();
//        offer.setId(5);
//        offer.setDescription("first offer");
//        offer.setPrice(new BigDecimal(1000));
//        offer.setTitle("offer title");
//        return offer;
//    }

    @GET
    @Path("/say")
    public String getMsg() {
        return "Hello World !! - Jersey 2";
    }

    static Map<String, Region> regions = new HashMap<String, Region>();

    @PostConstruct
    public void init() {
        regions.put("1", new Region(1, "Moscow", 10000000));
        regions.put("2", new Region(2, "SPB", 7000000));
        regions.put("3", new Region(3, "Ekaterinburg", 2000000));
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Region> getAll() throws URISyntaxException {
        return new ArrayList<Region>(regions.values());
    }
}
