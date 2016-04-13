package io.khasang.enterprise.service.registrationService;

import io.khasang.enterprise.dao.ClientDaoImpl;
import io.khasang.enterprise.dao.EmployeeDaoImpl;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    private ClientDaoImpl clientDao;
    @Autowired
    private EmployeeDaoImpl employeeDao;
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
}
