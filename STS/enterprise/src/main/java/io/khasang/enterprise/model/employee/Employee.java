package io.khasang.enterprise.model.employee;

import io.khasang.enterprise.model.UserAccount;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Employee extends UserAccount {
    private BigDecimal salary;
    private Date hireDate;
    private Date fireDate;
    private BigDecimal bonus;
    private BigDecimal tax;
}
