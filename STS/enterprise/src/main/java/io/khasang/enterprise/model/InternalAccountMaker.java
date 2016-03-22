package io.khasang.enterprise.model;

import io.khasang.enterprise.model.employee.*;

public class InternalAccountMaker extends AccountFactory {

    UserAccount createAccount(String accountType) {
        switch (accountType) {
            case "developer":
                return new Developer();
            case "designer":
                return new Designer();
            case "QA":
                return new QAEngineer();
            case "techlead":
                return new TechLead();
            case "support":
                return new SupportSpecialist();
            default:
                return null;
        }
    }
}
