package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<News> implements NewsDao {

    @SuppressWarnings("unchecked")
    public List<News> findAllNews() {
        Criteria criteria = getSession().createCriteria(News.class);
        return (List<News>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<News> findLastNews() {
        Criteria criteria = getSession().createCriteria(News.class);
        return (List<News>) criteria.list(); //todo create criteria for latest 3 news
    }

    public void saveNews(News news) {
        persist(news);
    }

    public void deleteNewsById(int id) {

    }

    public void deleteAll() {
        Query query = getSession().createSQLQuery("delete from news");
        query.executeUpdate();
    }
}
