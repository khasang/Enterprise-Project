package com.maxdegree.jdbcexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        {
                "file:web/WEB-INF/dispatcher-servlet.xml"
        }
)
public class MainTest {
    @Resource
    JDBCManager manager;

    @Test
    @Before
    public void createTableUsersTest(){
        String massage = manager.createTableUsers();
        Assert.assertEquals("table users created", massage);
    }

    @Test
    public void getAllUsersTest() {
        Assert.assertNotNull(manager.getAllUsers());
        int lenExpected = 2;
        int lenActual = manager.getAllUsers().toArray().length;
        Assert.assertEquals(lenExpected, lenActual);
    }

    @Test
    public void addNewUserTest() {
        User userValidate = new User(111, "Jean", "jean@gmail.com");
        User userTest_1 = new User(4, null, "max@gmail.com");
        User userTest_2 = new User(5, "Max", null);
        User userNotUnique = new User(1, "Max", "max@gmail.com");
        Assert.assertNotNull(userValidate);
        Assert.assertEquals("new user created", manager.addNewUser(userValidate));
        Assert.assertNotEquals("new user created", manager.addNewUser(userNotUnique));
        Assert.assertNotEquals("new user created", userTest_1);
        Assert.assertNotEquals("new user created", userTest_2);
    }
}