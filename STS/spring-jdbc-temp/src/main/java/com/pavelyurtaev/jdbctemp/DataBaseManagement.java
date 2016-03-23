package com.pavelyurtaev.jdbctemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataBaseManagement {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS projects");
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS projects" +
                    " (id INT NOT NULL PRIMARY KEY," +
                    "orders DATE NOT NULL," +
                    "customer VARCHAR(45) NOT NULL," +
                    "price int NOT NULL)");
            return "Table successfully created";
        } catch (Exception e) {
            return "Too bad. Not today. The problem is:\n" + e;
        }
    }
}
