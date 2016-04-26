package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.hibernate.Criteria;
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

    public void deleteNewsById(int id) {
        Query query = getSession().createSQLQuery("DELETE from news where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public void deleteAllNews() {
        Query query = getSession().createSQLQuery("delete from news");
        query.executeUpdate();
    }
}