package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.ClientDaoImpl;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserList {

    @Autowired
    ClientDaoImpl clientDao;

    public List<Client> findAll() {
        return clientDao.findAllClients();
    }

    public void saveEntity(Client client) {
        clientDao.saveClient(client);
    }

    public void clearTable() {
        clientDao.deleteAllClients();
    }

    public Client findByLogin(String login) {
        return clientDao.findByLogin(login);
    }
}
