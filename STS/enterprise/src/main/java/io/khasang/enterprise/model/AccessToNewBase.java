package io.khasang.enterprise.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccessToNewBase {
    private static String status;

    public String access(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        status = "try to connect...";
        try {
            jdbcTemplate.execute("");
            status = "OK";
        } catch (Exception e){
            status = "Error: " + e;
            e.printStackTrace();
        }
        return status;
    }


}
