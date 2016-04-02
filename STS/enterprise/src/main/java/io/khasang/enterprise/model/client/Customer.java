package io.khasang.enterprise.model.client;

public class Customer extends Client {


    public Customer() {
    }

    public Customer(String fullName, int phone, String email, String address, String companyName, String login, String password, String authority) {
        this.setFullName(fullName);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
        this.setCompanyName(companyName);
        this.setLogin(login);
        this.setPassword(password);
        this.setAuthority(authority);
    }

}
