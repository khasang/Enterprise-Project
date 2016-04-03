package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("newsService")
@Transactional
public class NewsService {

    @Autowired
    ClientDao clientDao;

    public List<Client> findAll() {
        return clientDao.findAllClients();
    }
}
