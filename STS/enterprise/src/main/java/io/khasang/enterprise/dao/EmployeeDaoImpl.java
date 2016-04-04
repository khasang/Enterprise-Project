package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {
    public Employee findById(int id) {
        return null;
    }

    public Employee findEmployeeByLoginAndPassword(String login, String password) {
        return null;
    }

    public List<Employee> findAllEmployees() {
        return null;
    }

    public void saveClient(Employee employee) {

    }

    public void deleteEmployeeByLogin(String login) {

    }

    public void deleteAllEmployees() {

    }
}
