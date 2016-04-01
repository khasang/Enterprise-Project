package io.khasang.enterprise.model.client;

import io.khasang.enterprise.model.UserAccount;

public abstract class Client extends UserAccount {
    private String companyName;
    private String compamyType;
    private String authority;



    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCompamyType() {
        return compamyType;
    }

    public void setCompamyType(String compamyType) {
        this.compamyType = compamyType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

