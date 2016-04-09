package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Employee;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {

    @Override
    public Employee findById(int id) {
        return getSession().get(Employee.class, id);
    }

    public Employee findEmployeeByLogin(String login) {
        Query query = getSession().createQuery("FROM Employee u WHERE u.login = :login");
        query.setString("login", login);
        return (Employee) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Query query = getSession().createQuery("FROM Employee");
        return query.list(); // write test, for checking work without class cast
    }

    @Override
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public void deleteEmployeeByLogin(String login) {
        Employee employee = findByLogin(login);
        delete(employee);
//        Query query = getSession().createSQLQuery("DELETE from employee where login = :login");
//        query.setString("login", login);
//        query.executeUpdate();
    }

    @Override
    public void deleteAllEmployers() {
        Query query = getSession().createSQLQuery("DELETE FROM employee");
        query.executeUpdate();
    }

    @Override
    public Employee findByLogin(String login) {
        Query query = getSession().createQuery("FROM Employee e WHERE e.login = :login");
        query.setString("login", login);
        if (query.list().isEmpty()) {
            return null;
        } else {
            return (Employee) query.list().get(0);
        }
    }

    @Override
    public void addEmployeeRole(int id) {
        SQLQuery query = getSession().createSQLQuery("INSERT INTO employee_role(role, employee_id) " +
                "VALUES ('ROLE_EMPLOYEE', :employee_id)");
        query.setParameter("employee_id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteEmployeeById(int id) {
        Query query = getSession().createSQLQuery("delete from employee where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteEmployeeRoleById(int id) {
        Query query = getSession().createSQLQuery("delete from employee_role where employee_id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteAllEmployersRoles() {
        Query query = getSession().createSQLQuery("delete FROM employee_role");
        query.executeUpdate();
    }
}
