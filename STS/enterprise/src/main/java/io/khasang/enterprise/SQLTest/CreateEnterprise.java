package io.khasang.enterprise.SQLTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

public class CreateEnterprise {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CreateEnterprise(){}

    public String creaneEnterpriseDB(){
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS enterprise");
            jdbcTemplate.execute("CREATE TABLE enterprise(userId INT NOT NULL KEY AUTO_INCREMENT," +
                    "userName VARCHAR(30), address VARCHAR (50), dob DATE)");
            return "true";
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }

    public String addData(){
        try {
            jdbcTemplate.execute("INSERT INTO enterprise(userName,address,dob) " +
                    "VALUE ('Kostya', '10004 Stedwick rd', '19880112'");
            return "data was added";
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }
}
