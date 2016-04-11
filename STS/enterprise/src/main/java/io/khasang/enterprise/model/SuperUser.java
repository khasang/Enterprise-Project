package io.khasang.enterprise.model;

import javax.persistence.*;

@MappedSuperclass
public  class SuperUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected Integer id;

    public SuperUser() {
    }

    public SuperUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Column(name = "login", nullable = false)
    protected String login;

    @Column(name = "password", nullable = false)
    protected String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}