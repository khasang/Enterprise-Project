package io.khasang.enterprise.service.registrationService;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void saveClientToDB(Client client){
        clientDao.saveClient(client);
        addClientRole(client.getId());
    }

    @Transactional
    public boolean isLoginExist(String login) {
       if (clientDao.findByLogin(login) == null) return false;
       else return true;
    }

    @Transactional
    public void addClientRole(int id) {
        clientDao.addClientRole(id);
    }
}
