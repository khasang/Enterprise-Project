package io.khasang.enterprise.model;

import io.khasang.enterprise.model.client.Buyer;
import io.khasang.enterprise.model.client.Customer;

public class ExternalAccountMaker extends AccountFactory {

    public UserAccount create(String accountType) {
        switch (accountType) {
            case "customer":
                return new Customer();
            case "buyer":
                return new Buyer();
            default:
                return null;
        }
    }
}
