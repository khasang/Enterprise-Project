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
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ClientDao clientDao;

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
    public void notNullTest() throws Exception {
        Assert.assertNotNull(clientDao);
        Assert.assertNotNull(newsService);
        Assert.assertNotNull(employeeDao);
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void findEmployeeByIdTest() throws Exception {
        Employee employee = employeeDao.findById(1);
        Assert.assertEquals("employeelogin", employee.getLogin());
    }

    @Test
    public void findEmployeeByLoginTest() throws Exception {
        Employee employee = employeeDao.findEmployeeByLogin("employeelogin");
        Assert.assertEquals("employeelogin", employee.getLogin());
        Assert.assertEquals("employeepassword", employee.getPassword());
    }

    @Test
    public void findAllEmployeesTest() throws Exception {
        List<Employee> employee = employeeDao.findAllEmployees();
        Assert.assertNotNull(employee);
        Assert.assertEquals(4, employee.size());
        Assert.assertEquals("employepassword", employee.get(0).getPassword());
        Assert.assertEquals("employepassword1", employee.get(1).getPassword());
        Assert.assertEquals("employepassword2", employee.get(2).getPassword());
        Assert.assertEquals("employepassword3", employee.get(3).getPassword());
    }

    @Test
    public void saveEmployeeTest() throws Exception {
        employeeDao.saveEmployee(new Employee("testLogin", "testPassword"));
        Employee employee = employeeDao.findByLogin("testLogin");
        Assert.assertEquals("testPassword", employee.getPassword());
    }

    @Test
    public void deleteEmployeeByLoginTest() throws Exception {
        int employeesAmountBefore = employeeDao.findAllEmployees().size();
        employeeDao.deleteEmployeeByLogin("employeelogin4");
        Assert.assertEquals(employeesAmountBefore - 1, employeeDao.findAllEmployees().size());
//        Assert.assertNotSame("employeepassword3", employeeDao.findByLogin("employeelogin4"));
    }

    @Test
    public void typeOfResultSetTest() throws Exception {
        Object list = clientDao.findAllClients();
        Assert.assertTrue(list instanceof List); // todo fix this sh.t
    }

    @Test
    public void invalidDataTest() throws Exception {
        List<Client> list = clientDao.findAllClients();
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void findClientByLoginTest() throws Exception {
        Client client = clientDao.findByLogin("ClientLogin");
        Assert.assertEquals("er@yt.ty", client.getEmail());
        Assert.assertEquals("clientpassword", client.getPassword());
    }

    @Test
    public void findByLoginAndPasswordTest() throws Exception {
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
    public void deletedClientTest() throws Exception {
        clientDao.deleteAllClients();
        List<Client> list = clientDao.findAllClients();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void deletedNewsTest() throws Exception {
        newsService.deleteAllNews();
        List<News> list = newsService.getAllNews();
        Assert.assertTrue(list.isEmpty());
    }
}