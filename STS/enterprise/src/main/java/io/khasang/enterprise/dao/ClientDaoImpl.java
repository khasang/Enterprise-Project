package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    public Client findByLogin(String login) {
        Query query = getSession().createQuery("FROM Client u WHERE u.login = :login");
        query.setString("login", login);
        if (query.list().isEmpty()) {
            return null;
        } else {
            return (Client) query.list().get(0);
        }
    }

    @Override
    public void deleteClientById(int id) {
        Client client = findById(id);
        delete(client);
    }

    @Override
    public void deleteClientRoleById(int id) {
        Query query = getSession().createSQLQuery("delete from client_role where client_id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteAllClientRoles() {
        Query query = getSession().createSQLQuery("delete FROM client_role");
        query.executeUpdate();
    }

    @Override
    public void deleteAllClients() {
        Query query = getSession().createSQLQuery("delete from client");
        query.executeUpdate();
    }

    //todo move this method to service layer for client(when it will be done)
    @Override
    public void addClientRole(int id) {
        SQLQuery query = getSession().createSQLQuery("INSERT INTO client_role(role, client_id) " +
                "VALUES ('ROLE_CLIENT', :client_id)");
        query.setParameter("client_id", id);
        query.executeUpdate();
    }
}
