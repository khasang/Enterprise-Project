package io.khasang.enterprise.controller.client;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class ClientControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void customer() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/account");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void customerOrderTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/order");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void customerChatTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/chat");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void customerStructureTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/structure");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void customerNewsTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/news");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }

    @Test
    public void customerContactsTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/client/contacts");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(status().isOk());
    }
}