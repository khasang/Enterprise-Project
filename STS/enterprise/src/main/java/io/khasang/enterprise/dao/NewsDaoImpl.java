package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<Integer, News> implements NewsDao {
    @SuppressWarnings("unchecked")
    public List<News> findLastNews() {
        Query query = getSession().createSQLQuery("SELECT * FROM news ORDER BY id DESC LIMIT 3");
        return query.list();
    }

    public News getById(Integer id) {
        Query query = getSession().createQuery("FROM News n WHERE n.id = :id");
        query.setInteger("id", id);
        return (News) query.list().get(0);
    }

    public void deleteNewsById(int id) {
        Query query = getSession().createSQLQuery("DELETE from news where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public void deleteAllNews() {
        Query query = getSession().createSQLQuery("delete from news");
        query.executeUpdate();
    }

    @Override
    public News getByTitle(String title) {
        Query query = getSession().createQuery("FROM News n WHERE n.title = :title");
        query.setString("title", title);
        return (News) query.list().get(0);
    }
}