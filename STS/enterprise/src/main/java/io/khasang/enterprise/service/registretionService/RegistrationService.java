package io.khasang.enterprise.service.registretionService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void saveClientToDB(Client client){
        clientDao.saveClient(client);
    }

    @Transactional
    public boolean isLoginExist(String login){
       return clientDao.isLoginExist(login);
    }
}
