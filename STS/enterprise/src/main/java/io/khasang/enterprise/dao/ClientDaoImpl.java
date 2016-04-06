package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.model.Client;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("clientDao")
@Transactional
// костыль, чтобы тесты проходили. Как появится сервис, использующий СlientDao - транзакционность выставим в нем.
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {
    public Client findById(int id) {
        return getSession().get(Client.class, id);
    }

    public Client findClientByLoginAndPassword(String login, String password) {
        Query query = getSession().createQuery("FROM Client u WHERE u.login = :login AND u.password = :password");
        query.setString("login", login);
        query.setString("password", password);
        return (Client) query.list().get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAllClients() {
        Criteria criteria = getSession().createCriteria(Client.class);
        return (List<Client>) criteria.list();
    }

    @Override
    public Client findByLogin(String login) {
        Query query = getSession().createQuery("FROM Client u WHERE u.login = :login");
        query.setString("login", login);
        return (Client) query.list().get(0);
    }

    public void saveClient(Client client) {
        persist(client);
    }

    public void deleteClientByLogin(String login) {
        Query query = getSession().createSQLQuery("delete from client where login = :login");
        query.setString("login", login);
        query.executeUpdate();
    }

    public void deleteAllClients() {
        Query query = getSession().createSQLQuery("delete from client");
        query.executeUpdate();
    }

    @Override
    public boolean isLoginExist(String login) {
        Query query = getSession().createQuery("FROM Client u WHERE u.login = :login");
        query.setString("login", login);
        if (query.list().isEmpty()) {
            return false;
        }
        return true;
    }
}
