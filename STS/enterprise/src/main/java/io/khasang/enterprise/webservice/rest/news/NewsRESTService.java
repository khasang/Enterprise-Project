package io.khasang.enterprise.webservice.rest.news;

import io.khasang.enterprise.model.News;
import io.khasang.enterprise.service.NewsService;
import io.khasang.enterprise.webservice.rest.offers.Region;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Path("/news")
public class NewsRESTService {
    @Autowired
    NewsService newsService;

    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_XML)
    public Region getRegion() throws URISyntaxException {
        Region region = new Region(4, "Kaliningrad", 500000);
        return region;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<News> getAllNews() throws URISyntaxException {
//        List<Region>list = new ArrayList<>();
//        list.add(new Region(5, "Omsk", 10000));
//        list.add(new Region(6, "NY", 1000000));
//        list.add(new Region(7, "Berlin", 5000));
//        return list;
        List<News> news = newsService.getAllNews();
        return news;
    }
}