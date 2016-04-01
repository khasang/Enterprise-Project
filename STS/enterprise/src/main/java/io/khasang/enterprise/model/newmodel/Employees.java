package io.khasang.enterprise.model.newmodel;

import io.khasang.enterprise.model.newmodel.enums.Department;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Employees {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "full_name")
    private String fullName;

    private String age;

    private String email;

    private String address;

    private BigDecimal salary;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hiredate;

    @Column(name = "fire_date")
    @Temporal(TemporalType.DATE)
    private Date fireDate;

    @Column(name = "department_id")
    @Enumerated(EnumType.STRING)
    private Department department;

    private BigDecimal tax;

    public Employees() {
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

