package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    @Override
    public Client findById(int id) {
        return getSession().get(Client.class, id);
    }

    @Override
    public Client findClientByLoginAndPassword(String login, String password) {
        Query query = getSession().createQuery("FROM Client u WHERE u.login = :login AND u.password = :password");
        query.setString("login", login);
        query.setString("password", password);
        return (Client) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = getSession().createCriteria(Client.class);
        return (List<Client>) criteria.list();
    }

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
    public void saveClient(Client client) {
            persist(client);
    }

    @Override
    public void deleteClientById(int id) {
        Query query = getSession().createSQLQuery("delete from client where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
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
