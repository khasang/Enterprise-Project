package io.khasang.enterprise.dao;

import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.service.UserList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
public class UserListTest {

    @Autowired
    UserList userList;

//    @Before
//    public List<Client> findAllClient() {
//        return userList.findAll();
//    }

    @Before
    public void rollBackDb() {
        userList.clearTable();
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
        userList.saveEntity(new Client());
        List<Client> list = userList.findAll();
        Assert.assertTrue(list.size() == 1);
    }

}
