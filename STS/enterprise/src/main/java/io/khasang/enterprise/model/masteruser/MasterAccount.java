package io.khasang.enterprise.model.masteruser;

import io.khasang.enterprise.model.Account;

public abstract class MasterAccount implements Account {
    private String masterLogin;
    private String masterPassword;

    public void requestForDeleteAccount() {
    }

    public void requestForUpdateAccount() {
    }

    @Override
    public void setLogin(String login) {
        this.masterLogin = login;
    }

    @Override
    public void setPassword(String password) {
        this.masterPassword = password;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public String getMasterPassword() {
        return masterPassword;
    }
}
