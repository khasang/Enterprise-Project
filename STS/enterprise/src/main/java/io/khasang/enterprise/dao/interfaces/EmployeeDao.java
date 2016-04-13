package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Employee;

public interface EmployeeDao {

    Employee findEmployeeByLogin(String login);

    void deleteEmployeeByLogin(String login);

    void deleteAllEmployees();

    Employee findByLogin(String login);

    void addEmployeeRole(int id);

    void deleteEmployeeById(int id);

    void deleteEmployeeRoleById(int id);

    void deleteAllEmployersRoles();
}
