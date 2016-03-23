package io.khasang.enterprise.model;

public abstract class AccountFactory implements EntityFactory {
    abstract UserAccount createAccount(String type); //factory method
}
