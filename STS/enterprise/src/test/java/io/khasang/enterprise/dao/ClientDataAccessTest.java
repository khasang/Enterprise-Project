package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.model.News;
import io.khasang.enterprise.service.NewsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
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

import javax.sql.DataSource;
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
    DataSource dataSource;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    ClientDao clientDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    NewsService newsService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();

    }

    @Before
    public void setupDB() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/schema.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

    @Test
    public void notNullTest() {
        Assert.assertNotNull(clientDao);
        Assert.assertNotNull(newsService);
        Assert.assertNotNull(employeeDao);
        Assert.assertNotNull(dataSource);
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
    public void findClientByLoginTest() {
        Client client = clientDao.findByLogin("ClientLogin");
        Assert.assertEquals("er@yt.ty", client.getEmail());
        Assert.assertEquals("clientpassword", client.getPassword());
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
                                hasProperty("title", is("NewsTitle")),
                                hasProperty("description", is("NewsDescription"))
                        )
                )));
        Assert.assertEquals("2014-12-12", newsService.findLatestNews().get(0).getPublishDate().toString());
    }

    @Test
    public void findEmployeeByLoginTest() {
        Employee employee = employeeDao.findEmployeeByLogin("employeelogin");
        Assert.assertEquals("employeelogin", employee.getLogin());
        Assert.assertEquals("employepassword", employee.getPassword());
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