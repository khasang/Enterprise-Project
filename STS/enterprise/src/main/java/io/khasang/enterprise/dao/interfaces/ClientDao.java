package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ClientDao {

    Client findById(int id);

    Client findClientByLoginAndPassword(String login, String password);

    List<Client> findAllClients();

    Client findByLogin(String login);

    void saveClient(Client client);

    void deleteClientById(int id);

    void deleteAllClients();

    void addClientRole(int id);

    void deleteClientRoleById(int id);

    void deleteAllClientRoles();
}
