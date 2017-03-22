package io.khasang.enterprise.webservice.rest.news;

import io.khasang.enterprise.model.News;
import io.khasang.enterprise.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.List;

@Component
@Path("/news_service")
public class NewsRestService extends SpringBeanAutowiringSupport {
    @Autowired
    private NewsService newsService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public News getNewsById(@PathParam("id") Integer id) throws URISyntaxException {
        News news = newsService.getNewsById(id);
        return news;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<News> getAllNews() throws URISyntaxException {
        List<News> news = newsService.findLatestNews();
        return news;
    }
}