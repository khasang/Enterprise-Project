package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.Client;

public interface ClientDao {

    Client findByLogin(String login);

    void deleteClientById(int id);

    void deleteAllClients();

    void addClientRole(int id);

    void deleteClientRoleById(int id);

    void deleteAllClientRoles();
}
