package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Client;

import java.util.List;

public interface ClientDao {

    Client findById(int id);

    Client findClientByLoginAndPassword(String login, String password);

    List<Client> findAllClients();

    void saveClient(Client client);

    void deleteClientByLogin(String login);

    void deleteAllClients();
}
