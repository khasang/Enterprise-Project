package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(Integer id);

    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    Employee findEmployeeByLogin(String login);

    void deleteEmployeeByLogin(String login);

    void deleteAllEmployees();

    Employee findByLogin(String login);

    void addEmployeeRole(int id);

    void deleteEmployeeById(int id);

    void deleteEmployeeRoleById(int id);

    void deleteAllEmployeesRoles();
}
