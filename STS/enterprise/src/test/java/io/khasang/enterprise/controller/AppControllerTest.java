package io.khasang.enterprise.controller;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class AppControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void homeTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/index");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void structureTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/structure");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void servicesTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/services");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void newsTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/news");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void projectsTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/projects");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void loginTest() throws Exception {
        //// TODO: TEST
    }

    @Test
    public void logoutTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/logout");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    @Test
    public void registrationTest() {
        //// TODO: TEST
    }

    @Test
    public void contactsTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/contacts");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void accessDeniedTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/403");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }
}