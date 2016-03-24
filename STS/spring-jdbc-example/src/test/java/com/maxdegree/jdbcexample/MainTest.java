package com.maxdegree.jdbcexample;

import org.junit.Test;
import org.junit.Assert;

public class MainTest {
    @Test
    public void createTableUsersTest(){
        JDBCManager manager = new JDBCManager();
        String massage = manager.createTableUsers();
        Assert.assertEquals("table users created", massage);
    }
}