package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
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
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class ClientDataAccessTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    ClientDao clientDao;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }


    @Before
    public void setupDB() {
        clientDao.deleteAllClients();
        clientDao.saveClient(new Client("client@mail.ru", "login", "password"));
    }

    @Test
    public void notNullTest() {
        Assert.assertNotNull(clientDao);
    }

    @Test
    public void typeOfResultSetTest() {
        Object list = clientDao.findAllClients();
        Assert.assertTrue(list instanceof List);
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
                .andExpect(model().attribute("allnews", hasItem(
                        allOf(
                                hasProperty("email", is("client@mail.ru")),
                                hasProperty("login", is("login")),
                                hasProperty("password", is("password"))
                        )
                )));
    }

    @Test
    public void deleteTest() {
        clientDao.deleteAllClients();
        List<Client> list = clientDao.findAllClients();
        Assert.assertTrue(list.isEmpty());
    }
}


