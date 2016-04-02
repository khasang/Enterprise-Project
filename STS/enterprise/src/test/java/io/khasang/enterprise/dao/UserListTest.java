package io.khasang.enterprise.dao;


import io.khasang.enterprise.config.HibernateConfig;
import io.khasang.enterprise.config.application.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class}).
public class UserListTest {

    @Test
    public void testUserList() {

    }

}
