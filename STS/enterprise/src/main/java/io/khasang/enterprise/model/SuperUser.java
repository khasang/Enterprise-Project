package io.khasang.enterprise.model;

import javax.persistence.*;

@MappedSuperclass
public class SuperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;

    public SuperUser() {
    }

    @Column(name = "login", nullable = false)
    protected String login;

    @Column(name = "password", nullable = false)
    protected String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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