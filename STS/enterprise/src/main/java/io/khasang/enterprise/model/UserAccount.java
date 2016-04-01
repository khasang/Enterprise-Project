package io.khasang.enterprise.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public abstract class UserAccount implements Account {

    @Id
    private int id;
    private String fullName;
    private int phone;

    @Email
    private String email;
    private String address;

    @NotBlank(message = "Username cannot be blank.")
    @Size(min=8, max=15, message = "Username must be between 8 and 15 characters long.")
    @Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers, letters and underscore character.")
    private String login;

    @NotBlank
    @Size(min = 8,max = 15, message = "Password must be between 8 and 15 characters long.")
    @Pattern(regexp = "^\\S+$")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
