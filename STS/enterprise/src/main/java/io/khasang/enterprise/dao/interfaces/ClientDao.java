package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Client;

import java.util.List;

public interface ClientDao {

    Client findById(Integer id);

    List<Client> findAll();

    void save(Client client);

    Client findByLogin(String login);

    void deleteClientById(int id);

    void deleteAllClients();

    void addClientRole(int id);

    void deleteClientRoleById(int id);

    void deleteAllClientRoles();
}