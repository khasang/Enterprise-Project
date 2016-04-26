package io.khasang.enterprise.service.registrationService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private AdminService adminService;

    @Transactional
    public void saveClientToDB(Client client) {
        clientDao.save(client);
        adminService.addClientRole(client.getId());
    }

    @Transactional
    public boolean isLoginExist(String login) {
        return !(clientDao.findByLogin(login) == null && employeeDao.findByLogin(login) == null);
    }

    @Transactional
    public void saveEmployeeinDB(Employee employee) {
        employeeDao.save(employee);
        adminService.addEmployeeRole(employee.getId());
    }

    @Transactional
    public Employee getEmployeeToEdit(Principal principal) {
        return employeeDao.findByLogin(principal.getName()); // todo найти способ, как пихнуть сюдя текущего юзера
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }
}
