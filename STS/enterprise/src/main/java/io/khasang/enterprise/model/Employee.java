package io.khasang.enterprise.model;

import io.khasang.enterprise.model.enums.Department;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee", catalog = "enterprise")
public class Employee extends SuperUser {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private String age;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hiredate;

    @Column(name = "fire_date")
    @Temporal(TemporalType.DATE)
    private Date fireDate;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1) default 1")
    private boolean enabled;

//    @OneToMany(mappedBy = "employee") //employee = mother
//    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
//    @OnDelete(action = OnDeleteAction.CASCADE)

    //@Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DELETE, CascadeType.REMOVE})
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", orphanRemoval = true)

//    @OneToMany(mappedBy = "employee")
//    @OnDelete(action=OnDeleteAction.CASCADE)

    @OneToMany(mappedBy = "employee")
    @Cascade (value = {CascadeType.SAVE_UPDATE, CascadeType.DELETE})
//    @JoinColumn(name = "employee_id")
    private Set<EmployeeRole> employeeRoles = new HashSet<>(); //employee_role = child

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