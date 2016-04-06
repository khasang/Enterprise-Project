package io.khasang.enterprise.service.registrationService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RegistrationService {

    @Autowired
    private ClientDao clientDao;

    public void saveClientToDB(Client client){
        clientDao.saveClient(client);
    }

    public boolean isLoginExist(String login){
       return clientDao.isLoginExist(login);
    }
}
