package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.model.*;
import io.khasang.enterprise.model.enums.ProjectBasis;
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
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class DataAccessTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ClientDaoImpl clientDao;
    @Autowired
    private EmployeeDaoImpl employeeDao;
    @Autowired
    private NewsDaoImpl newsDao;
    @Autowired
    private OfferDaoImpl offerDao;
    @Autowired
    private ProjectDaoImpl projectDao;

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
        Assert.assertNotNull(wac);
        Assert.assertNotNull(mockMvc);
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(clientDao);
        Assert.assertNotNull(employeeDao);
        Assert.assertNotNull(newsDao);
        Assert.assertNotNull(offerDao);
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
        List<Employee> employee = employeeDao.findAll();
        Assert.assertNotNull(employee);
        Assert.assertEquals(4, employee.size());
        Assert.assertEquals("employeepassword", employee.get(0).getPassword());
        Assert.assertEquals("employeepassword1", employee.get(1).getPassword());
        Assert.assertEquals("employeepassword2", employee.get(2).getPassword());
        Assert.assertEquals("employeepassword3", employee.get(3).getPassword());
    }

    @Test
    public void saveEmployeeTest() throws Exception {
        employeeDao.save(new Employee("testLogin", "testPassword"));
        Employee employee = employeeDao.findByLogin("testLogin");
        Assert.assertEquals("testPassword", employee.getPassword());
    }

    @Test
    public void deleteEmployeeByLoginTest() throws Exception {
        int employeesAmountBefore = employeeDao.findAll().size();
        employeeDao.deleteEmployeeByLogin("employeelogin4");
        Assert.assertEquals(employeesAmountBefore - 1, employeeDao.findAll().size());
        Assert.assertNotSame("employeepassword3", employeeDao.findByLogin("employeelogin4"));
    }

    @Test
    public void deleteClientById() throws Exception {
        int clientAmountBefore = clientDao.findAll().size();
        clientDao.deleteClientById(4);
        Assert.assertEquals(clientAmountBefore - 1, clientDao.findAll().size());
    }

    @Test
    public void findOfferByIdTest() throws Exception {
        Assert.assertEquals("OfferTitle", offerDao.findById(1).getTitle());
        Assert.assertEquals("OfferTitle1", offerDao.findById(2).getTitle());
        Assert.assertEquals("OfferTitle2", offerDao.findById(3).getTitle());
        Assert.assertEquals("OfferTitle3", offerDao.findById(4).getTitle());
    }

    @Test
    public void findOfferByPriceTest() throws Exception {
        Assert.assertEquals("OfferTitle", offerDao.findOfferByPrice(new BigDecimal("555.55")).get(0).getTitle());
        Assert.assertEquals("OfferTitle1", offerDao.findOfferByPrice(new BigDecimal("111.55")).get(0).getTitle());
        Assert.assertEquals("OfferTitle2", offerDao.findOfferByPrice(new BigDecimal("222.55")).get(0).getTitle());
        Assert.assertEquals("OfferTitle3", offerDao.findOfferByPrice(new BigDecimal("333.55")).get(0).getTitle());
    }

    @Test
    public void findAllOffersTest() throws Exception {
        Assert.assertEquals(4, offerDao.findAll().size());
    }

    @Test
    public void saveOfferTest() throws Exception {
        int offersAmountBefore = offerDao.findAll().size();
        offerDao.save(new Offer());
        Assert.assertEquals(offersAmountBefore + 1, offerDao.findAll().size());
    }

    //
    @Test
    public void deleteOfferByIdTest() throws Exception {
        int offersAmountBefore = offerDao.findAll().size();
        offerDao.deleteOfferById(1);
        Assert.assertEquals(offersAmountBefore - 1, offerDao.findAll().size());
    }

    @Test
    public void deleteAllOffersTest() throws Exception {
        offerDao.deleteAllOffers();
        Assert.assertTrue(offerDao.findAll().isEmpty());
    }

    @Test
    public void typeOfResultSetTest() throws Exception {
        List list = clientDao.findAll();
        Assert.assertTrue(list != null); // todo fix this sh.t
    }

    @Test
    public void invalidDataTest() throws Exception {
        List<Client> list = clientDao.findAll();
        Assert.assertTrue(list.size() >= 4);
    }

    @Test
    public void findClientByLoginTest() throws Exception {
        Client client = clientDao.findByLogin("ClientLogin");
        Assert.assertEquals("er@yt.ty", client.getEmail());
        Assert.assertEquals("clientpassword", client.getPassword());
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
        Assert.assertEquals("2014-12-12", newsDao.findLastNews().get(0).getPublishDate().toString());
    }

    @Test
    public void deletedNewsTest() throws Exception {
        newsDao.deleteAllNews();
        List<News> list = newsDao.findAll();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void findByProjectBasisTest() {
        List<Project> projects = projectDao.findByProjectBasis(ProjectBasis.BLOG);
        for (Project project : projects) {
            Assert.assertNotEquals(ProjectBasis.BUSINESS, project.getProjectBasis());
            Assert.assertNotEquals(ProjectBasis.FORUM, project.getProjectBasis());
            Assert.assertNotEquals(ProjectBasis.PORTFOLIO, project.getProjectBasis());
            Assert.assertNotEquals(ProjectBasis.SOCIALNETWORK, project.getProjectBasis());
        }
    }
}