package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.dao.interfaces.*;
import io.khasang.enterprise.model.*;
import io.khasang.enterprise.model.enums.Features;
import io.khasang.enterprise.model.enums.ProjectBasis;
import io.khasang.enterprise.model.enums.TrackStatus;
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

//@Transactional
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class DataAccessTest {
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private ClientDao clientDao;
//    @Autowired
//    private EmployeeDao employeeDao;
//    @Autowired
//    private NewsDao newsDao;
//    @Autowired
//    private OfferDao offerDao;
//    @Autowired
//    private ProjectDao projectDao;
//    @Autowired
//    private OrderDao orderDao;
//    @Autowired
//    private TrackDao trackDao;
//
//    @Before
//    public void setupMock() {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
//    }
//
//    @Before
//    public void setupDB() {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("/schema.sql"));
//        resourceDatabasePopulator.execute(dataSource);
//    }
//
//    @Test
//    public void notNullTest() throws Exception {
//        Assert.assertNotNull(wac);
//        Assert.assertNotNull(mockMvc);
//        Assert.assertNotNull(dataSource);
//        Assert.assertNotNull(clientDao);
//        Assert.assertNotNull(employeeDao);
//        Assert.assertNotNull(newsDao);
//        Assert.assertNotNull(offerDao);
//        Assert.assertNotNull(projectDao);
//        Assert.assertNotNull(orderDao);
//    }
//
//    @Test
//    public void findEmployeeByIdTest() throws Exception {
//        Employee employee = employeeDao.findById(1);
//        Assert.assertEquals("employeelogin", employee.getLogin());
//    }
//
//    @Test
//    public void findEmployeeByLoginTest() throws Exception {
//        Employee employee = employeeDao.findEmployeeByLogin("employeelogin");
//        Assert.assertEquals("employeelogin", employee.getLogin());
//        Assert.assertEquals("employeepassword", employee.getPassword());
//    }
//
//    @Test
//    public void findAllEmployeesTest() throws Exception {
//        List<Employee> employee = employeeDao.findAll();
//        Assert.assertNotNull(employee);
//        Assert.assertTrue(employee.size() >= 4);
//        Assert.assertEquals("employeepassword", employee.get(0).getPassword());
//        Assert.assertEquals("employeepassword1", employee.get(1).getPassword());
//        Assert.assertEquals("employeepassword2", employee.get(2).getPassword());
//        Assert.assertEquals("employeepassword3", employee.get(3).getPassword());
//    }
//
//    @Test
//    public void saveEmployeeTest() throws Exception {
//        employeeDao.save(new Employee("testLogin", "testPassword"));
//        Employee employee = employeeDao.findByLogin("testLogin");
//        Assert.assertEquals("testPassword", employee.getPassword());
//    }
//
//    @Test
//    public void deleteEmployeeByLoginTest() throws Exception {
//        int employeesAmountBefore = employeeDao.findAll().size();
//        employeeDao.deleteEmployeeByLogin("employeelogin4");
//        Assert.assertEquals(employeesAmountBefore - 1, employeeDao.findAll().size());
//        Assert.assertNotSame("employeepassword3", employeeDao.findByLogin("employeelogin4"));
//    }
//
//    @Test
//    public void deleteClientById() throws Exception {
//        int clientAmountBefore = clientDao.findAll().size();
//        clientDao.deleteClientById(4);
//        Assert.assertEquals(clientAmountBefore - 1, clientDao.findAll().size());
//    }
//
//    @Test
//    public void findOfferByIdTest() throws Exception {
//        Assert.assertEquals("OfferTitle", offerDao.findById(1).getTitle());
//        Assert.assertEquals("OfferTitle1", offerDao.findById(2).getTitle());
//        Assert.assertEquals("OfferTitle2", offerDao.findById(3).getTitle());
//        Assert.assertEquals("OfferTitle3", offerDao.findById(4).getTitle());
//    }
//
//    @Test
//    public void findOfferByPriceTest() throws Exception {
//        Assert.assertEquals("OfferTitle", offerDao.findOfferByPrice(new BigDecimal("555.55")).get(0).getTitle());
//        Assert.assertEquals("OfferTitle1", offerDao.findOfferByPrice(new BigDecimal("111.55")).get(0).getTitle());
//        Assert.assertEquals("OfferTitle2", offerDao.findOfferByPrice(new BigDecimal("222.55")).get(0).getTitle());
//        Assert.assertEquals("OfferTitle3", offerDao.findOfferByPrice(new BigDecimal("333.55")).get(0).getTitle());
//    }
//
//    @Test
//    public void findAllOffersTest() throws Exception {
//        Assert.assertTrue(offerDao.findAll().size() >= 4);
//    }
//
//    @Test
//    public void saveOfferTest() throws Exception {
//        int offersAmountBefore = offerDao.findAll().size();
//        offerDao.save(new Offer());
//        Assert.assertEquals(offersAmountBefore + 1, offerDao.findAll().size());
//    }
//
//    //
//    @Test
//    public void deleteOfferByIdTest() throws Exception {
//        int offersAmountBefore = offerDao.findAll().size();
//        offerDao.deleteOfferById(1);
//        Assert.assertEquals(offersAmountBefore - 1, offerDao.findAll().size());
//    }
//
//    @Test
//    public void deleteAllOffersTest() throws Exception {
//        offerDao.deleteAllOffers();
//        Assert.assertTrue(offerDao.findAll().isEmpty());
//    }
//
//    @Test
//    public void typeOfResultSetTest() throws Exception {
//        List list = clientDao.findAll();
//        Assert.assertTrue(list != null); // todo fix this sh.t
//    }
//
//    @Test
//    public void invalidDataTest() throws Exception {
//        List<Client> list = clientDao.findAll();
//        Assert.assertTrue(list.size() >= 4);
//    }
//
//    @Test
//    public void findClientByLoginTest() throws Exception {
//        Client client = clientDao.findByLogin("ClientLogin");
//        Assert.assertEquals("er@yt.ty", client.getEmail());
//        Assert.assertEquals("clientpassword", client.getPassword());
//    }
//
//    @Test
//    public void attributePropertiesTest() throws Exception {
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/news");
//        ResultActions result = mockMvc.perform(request);
//        result.andExpect(status().isOk())
//                .andExpect(view().name("news"))
//                .andExpect(forwardedUrl("/WEB-INF/views/news.jsp"))
//                .andExpect(model().attribute("news", hasItem(
//                        allOf(
//                                hasProperty("title", is("NewsTitle")),
//                                hasProperty("description", is("NewsDescription"))
//                        )
//                )));
//        Assert.assertEquals("2014-12-12", newsDao.findAll().get(0).getPublishDate().toString());
//    }
//
//    @Test
//    public void findLastNewsTest() throws Exception {
//        List<News> newses = newsDao.findLastNews();
//        Assert.assertTrue(newses.size() == 3);
//    }
//
//    @Test
//    public void deletedNewsTest() throws Exception {
//        newsDao.deleteAllNews();
//        List<News> list = newsDao.findAll();
//        Assert.assertTrue(list.isEmpty());
//    }
//
//    @Test
//    public void findOrderByProjectIdTest() throws Exception {
//        List<CustomerOrder> orders = orderDao.findOrdersByProjectId(3);
//        Assert.assertTrue(orders.size() >= 1);
//        Assert.assertEquals(Features.ONLINEPAYMENTS, orders.get(0).getFeature());
//    }
//
//    @Test
//    public void findOrderByIdTest() throws Exception {
//        CustomerOrder order = orderDao.findById(1);
//        Assert.assertEquals(Features.PHOTOGALLERY, order.getFeature());
//
//    }
//
//    @Test
//    public void findByProjectBasisTest() throws Exception {
//        List<Project> projects = projectDao.findByProjectBasis(ProjectBasis.BLOG);
//        for (Project project : projects) {
//            Assert.assertNotEquals(ProjectBasis.BUSINESS, project.getProjectBasis());
//            Assert.assertNotEquals(ProjectBasis.FORUM, project.getProjectBasis());
//            Assert.assertNotEquals(ProjectBasis.PORTFOLIO, project.getProjectBasis());
//            Assert.assertNotEquals(ProjectBasis.SOCIALNETWORK, project.getProjectBasis());
//        }
//    }
//
//    @Test
//    public void findByPriceTest() throws Exception {
//        List<Project> projects = projectDao.findByPrice(new BigDecimal(2000.00));
//        Assert.assertFalse(projects.isEmpty());
//        Assert.assertEquals("SuperProject1", projects.get(0).getTitle());
//    }
//
//    @Test
//    public void findUnfinishedProjectsTest() throws Exception {
//        List<Project> projects = projectDao.findUnfinishedProjects();
//        Assert.assertFalse(projects.isEmpty());
//        Assert.assertTrue(projects.size() >= 1);
//        Assert.assertEquals("SuperProject4", projects.get(0).getTitle());
//        for (Project project : projects) {
//            Assert.assertTrue(project.getEndDate() == null);
//        }
//    }
//
//    @Test
//    public void findFinishedProjectsTest() throws Exception {
//        List<Project> projects = projectDao.findFinishedProjects();
//        Assert.assertFalse(projects.isEmpty());
//        Assert.assertTrue(projects.size() >= 3);
//        for (Project project : projects) {
//            Assert.assertTrue(project.getEndDate() != null);
//        }
//    }
//
////    @Test
////    public void findAllTracksByEmployeeId() throws Exception {
////        List<T>
////    }
//
//    @Test
//    public void findTrackByOrderIdAndMaxProgressTest() throws Exception {
//        Track lastTrackOfOrder = trackDao.findByOrderIdAndMaxProgress(1); //todo костыль, вместо 1 поставить относительное
//        Assert.assertEquals(100, lastTrackOfOrder.getProgress().longValue());
//        lastTrackOfOrder = trackDao.findByOrderIdAndMaxProgress(2); //todo костыль, вместо 2 поставить относительное
//        Assert.assertEquals(70, lastTrackOfOrder.getProgress().longValue());
//    }
//
//    @Test
//    public void findUnfinishedByEmployeeIdTest() throws Exception {
//        final long finishedPercentageValue = 100;
//        List<Track> tasksOfEmployee = trackDao.findUnfinishedByEmployeeId(1); // todo 1 временно
//        for (Track track : tasksOfEmployee) {
//            Assert.assertEquals(TrackStatus.RUNNING, track.getTrackStatus());
//            Assert.assertNotEquals(finishedPercentageValue, track.getProgress().longValue());
//        }
//    }
}