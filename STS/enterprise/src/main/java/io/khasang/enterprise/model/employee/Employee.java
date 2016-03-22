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

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
