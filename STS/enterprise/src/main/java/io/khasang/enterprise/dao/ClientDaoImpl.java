package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

    @Override
    public Client findById(int id) {
        return getSession().get(Client.class, id);
    }

    @Override
    public Client findClientByLoginAndPassword(String login, String password) {
        Query query = getSession().createSQLQuery("SELECT * FROM client WHERE login = :login AND password = :password");
        query.setString("login", login);
        query.setString("password", password);
        query.executeUpdate();
        return (Client) query.list(); // todo make it work
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = getSession().createCriteria(Client.class);
        return (List<Client>) criteria.list();
    }

    @Override
    public void saveClient(Client client) {
        persist(client);
    }

    @Override
    public void deleteClientByLogin(String login) {
        Query query = getSession().createSQLQuery("delete from client where login = :login");
        query.setString("login", login);
        query.executeUpdate();
    }

    @Override
    public void deleteAllClients() {
        Query query = getSession().createSQLQuery("delete from client");
        query.executeUpdate();
    }
}
