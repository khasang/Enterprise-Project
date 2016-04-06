package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
@Transactional
public class AdminService {
    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void addClientRole(int id) {
        clientDao.addClientRole(id);
    }

    @Transactional
    public void deleteClientById(int id) {
        deleteClientRoleById(id);
        clientDao.deleteClientById(id);
    }

    @Transactional
    public void deleteClientRoleById(int id) {
        clientDao.deleteClientRoleById(id);
    }

    @Transactional
    public void deleteAllClients() {
        deleteAllClientRoles();
        clientDao.deleteAllClients();
    }

    @Transactional
    public void deleteAllClientRoles() {
        clientDao.deleteAllClientRoles();
    }
}
