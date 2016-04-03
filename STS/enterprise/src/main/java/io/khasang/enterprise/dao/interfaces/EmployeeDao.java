package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findById(int id);

    Employee findEmployeeByLoginAndPassword(String login, String password);

    List<Employee> findAllEmployees();

    void saveClient(Employee employee);

    void deleteEmployeeByLogin(String login);

    void deleteAllEmployees();
}
