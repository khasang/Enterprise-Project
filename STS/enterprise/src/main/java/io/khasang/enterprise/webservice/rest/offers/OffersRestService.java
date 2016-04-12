package io.khasang.enterprise.webservice.rest.offers;

import io.khasang.enterprise.model.Region;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/offers")
public class OffersRestService {
    @GET
    @Path("/say")
    public String getMsg() {
        return "Hello World !! - Jersey 2";
    }

    private static Map<String, Region> regions = new HashMap<String, Region>();

    @PostConstruct
    public void init() {
        regions.put("1", new Region(1, "Moscow", 10000000));
        regions.put("2", new Region(2, "SPB", 7000000));
        regions.put("3", new Region(3, "Ekaterinburg", 2000000));
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Region> getAll() throws URISyntaxException {
        return new ArrayList<Region>(regions.values());
    }
}
