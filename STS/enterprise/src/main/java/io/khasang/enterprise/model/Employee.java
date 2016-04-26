package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.Department;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends SuperUser {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Digits(integer=6, fraction=2)
    @Column(name = "salary")
    private BigDecimal salary;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hiredate;

    @Column(name = "fire_date")
    @Temporal(TemporalType.DATE)
    private Date fireDate;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Digits(integer=6, fraction=2)
    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1) default 1")
    private boolean enabled;

    @OneToMany(mappedBy = "employee")
    @Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<EmployeeRole> employeeRoles = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @Cascade(value = CascadeType.SAVE_UPDATE)
    private Set<Track> tracks = new HashSet<>(0);

    public Employee() {
    }

    public Employee(String login, String password) {
        super(login, password);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<EmployeeRole> getEmployeeRoles() {
        return employeeRoles;
    }

    public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
        this.employeeRoles = employeeRoles;
    }
}