package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("newsDao")
public class NewsDaoImpl extends AbstractDao<News> implements NewsDao {
    public List<News> findAllNews() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<News> findLastNews() {
        Criteria criteria = getSession().createCriteria(News.class);
        return (List<News>) criteria.list();
    }

    public void saveNews(News news) {

    }

    public void deleteNewsById(int id) {

    }

    public void deleteAllNews() {

    }
}
