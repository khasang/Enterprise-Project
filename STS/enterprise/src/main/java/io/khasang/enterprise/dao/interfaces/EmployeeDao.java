package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findById(int id);

    Employee findEmployeeByLoginAndPassword(String login, String password);

    List<Employee> findAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployeeByLogin(String login);

    void deleteAllEmployers();

    Employee findByLogin(String login);

    void addEmployeeRole(int id);

    void deleteEmployeeById(int id);

    void deleteEmployeeRoleById(int id);

    void deleteAllEmployersRoles();
}
