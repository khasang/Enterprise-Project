package com.maxdegree.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCManager {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JDBCManager() {}

    public String createTableUsers() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS users");
            jdbcTemplate.execute("CREATE TABLE users (userId int(11) NOT NULL," +
                    "userName varchar(64) NOT NULL," +
                    "userEmail varchar(64) NOT NULL," +
                    "PRIMARY KEY (userId))");
            jdbcTemplate.execute("INSERT INTO users (userId, userName, userEmail) VALUES" +
                    "(1, 'Max', 'max@gmail.com'), (2, 'Jim', 'jim@gmail.com')");
            return "table users created";
        } catch (Exception e) {
            return "something wrong: " + e;
        }
    }

    public List<User> getAllUsers() {
       List<User> list = jdbcTemplate.query("select userId, userName, userEmail from users", new RowMapper<User>() {
           public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
               User user = new User();
               user.setUserId(resultSet.getInt("userId"));
               user.setUserName(resultSet.getString("userName"));
               user.setUserEmail(resultSet.getString("userEmail"));
               return user;
           }
       });
        return list;
    }

    public String addNewUser(User user) {
        try {
            jdbcTemplate.update("INSERT INTO users (userId, userName, userEmail) VALUES (?,?,?)", new Object[] {
                    user.getUserId(), user.getUserName(), user.getUserEmail()
            });
        } catch (Exception e) {
            return "something wrong with add User: " + e;
        }
        return  "new user created";
    }
}