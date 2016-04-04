package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.UserList;
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
public class UserListTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    UserList userList;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }


    @Before
    public void setupDB() {
        userList.clearTable();
        userList.saveEntity(new Client("client@mail.ru", "login", "password"));
    }

    @Test
    public void testUserList() {
        Assert.assertNotNull(new UserList());
    }

    @Test
    public void testTypeOfResultSet() {
        Object list = userList.findAll();
        Assert.assertTrue(list instanceof List);
    }

    @Test
    public void testInvalidData() {
        List<Client> list = userList.findAll();
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void testCorrectFieldSave() {
        Client client = userList.findByLogin("login");
        Assert.assertEquals("client@mail.ru", client.getEmail());
        Assert.assertEquals("password", client.getPassword());
    }

    @Test
    public void customerNewsTest() throws Exception {
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
        userList.clearTable();
        List<Client> list = userList.findAll();
        Assert.assertTrue(list.isEmpty());
    }
}


