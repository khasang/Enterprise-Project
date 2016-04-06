package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.News;
import io.khasang.enterprise.service.NewsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class ClientDataAccessTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    NewsService newsService;

    private static final Date DATE = new java.sql.Date(999999*999999L);

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Before
    public void setupDB() {
        clientDao.deleteAllClients();
        newsService.deleteAllNews();
        clientDao.saveClient(new Client("client@mail.ru", "login", "password"));
        newsService.saveNewsToDB(new News("BeautifulTitle", "ShortDescription", DATE));
    }

    @Test
    public void notNullTest() {
        Assert.assertNotNull(clientDao);
        Assert.assertNotNull(newsService);
    }

    @Test
    public void typeOfResultSetTest() {
        Object list = clientDao.findAllClients();
        Assert.assertTrue(list instanceof List); // todo fix this sh.t
    }

    @Test
    public void invalidDataTest() {
        List<Client> list = clientDao.findAllClients();
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void findByLoginTest() {
        Client client = clientDao.findByLogin("login");
        Assert.assertEquals("client@mail.ru", client.getEmail());
        Assert.assertEquals("password", client.getPassword());
    }

    @Test
    public void findByLoginAndPasswordTest() {
        Client client = clientDao.findClientByLoginAndPassword("login", "password");
        Assert.assertEquals("client@mail.ru", client.getEmail());
    }

    @Test
    public void attributePropertiesTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/news");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk())
                .andExpect(view().name("news"))
                .andExpect(forwardedUrl("/WEB-INF/views/news.jsp"))
                .andExpect(model().attribute("news", hasItem(
                        allOf(
                                hasProperty("title", is("BeautifulTitle")),
                                hasProperty("description", is("ShortDescription"))
                        )
                )));
        Assert.assertEquals(DATE.toString(), newsService.findLatestNews().get(0).getPublishDate().toString());
    }

    @Test
    public void deletedClientTest() {
        clientDao.deleteAllClients();
        List<Client> list = clientDao.findAllClients();
        Assert.assertTrue(list.isEmpty());
    }
    @Test
    public void deletedNewsTest() {
        newsService.deleteAllNews();
        List<News> list = newsService.getAllNews();
        Assert.assertTrue(list.isEmpty());
    }
}