package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findById(int id);

    Employee findEmployeeByLogin(String login);

    List<Employee> findAllEmployees();

    void saveEmployee(Employee employee);

    void deleteEmployeeByLogin(String login);

    void deleteAllEmployees();
}
