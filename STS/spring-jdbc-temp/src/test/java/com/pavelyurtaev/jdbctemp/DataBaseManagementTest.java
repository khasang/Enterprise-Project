package com.pavelyurtaev.jdbctemp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:web/WEB-INF/dispatcher-servlet.xml"})
public class DataBaseManagementTest {

    @Resource
    DataBaseManagement manager;

    @Test
    public void notNullTest() {
        Assert.assertNotNull(manager);
    }

    @Test
    public void createTableTest() {
        String massage = manager.createTable();
        Assert.assertEquals("Table successfully created", massage);
    }
}