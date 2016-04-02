package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.ClientDaoImpl;
import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserList {

    @Autowired
    ClientDaoImpl clientDao;

    public List<Users> findAll() {
        clientDao.findAllClients();
    }
}
