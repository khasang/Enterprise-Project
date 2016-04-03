package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {
    public List<News> findAllNews() {
        return null;
    }

    public List<News> findLatestNews() {
        return null;
    }

    public void saveNews(News news) {

    }

    public void deleteNewsById(int id) {

    }

    public void deleteAllNews() {

    }
}
