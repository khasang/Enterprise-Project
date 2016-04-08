package io.khasang.enterprise.model;


import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_role", catalog = "enterprise")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            unique = true, nullable = false)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "employee_id") // need for cascade delete

    @ManyToOne
//    @OnDelete(action = org.hibernate.annotations.OnDeleteAction.CASCADE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public EmployeeRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
