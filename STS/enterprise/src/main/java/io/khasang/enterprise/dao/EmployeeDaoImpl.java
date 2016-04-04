package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Employee;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {
    public Employee findById(int id) {
        return getSession().get(Employee.class, id);
    }

    public Employee findEmployeeByLoginAndPassword(String login, String password) {
        Query query = getSession().createQuery("FROM Employee u WHERE u.login = :login AND u.password = :password");
        query.setString("login", login);
        query.setString("password", password);
        return (Employee) query.list().get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Query query = getSession().createQuery("FROM Employee");
        return query.list(); // write test, for checking work without class cast
    }

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    public void deleteEmployeeByLogin(String login) {
        Query query = getSession().createSQLQuery("DELETE from employee where login = :login");
        query.setString("login", login);
        query.executeUpdate();
    }

    public void deleteAllEmployees() {
        Query query = getSession().createSQLQuery("DELETE FROM employee");
        query.executeUpdate();
    }
}
