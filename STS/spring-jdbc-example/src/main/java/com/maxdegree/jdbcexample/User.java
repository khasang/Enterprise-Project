package com.maxdegree.jdbcexample;

public class User {
    private Integer userId;
    private String userName;
    private String userEmail;

    public User() {}

    public User(Integer userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return userId.toString() + ") " + userName + " mail: " + userEmail + "\n";
    }
}