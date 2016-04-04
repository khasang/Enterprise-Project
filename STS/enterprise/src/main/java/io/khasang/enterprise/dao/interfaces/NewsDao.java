package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.News;

import java.util.List;

public interface NewsDao {

    List<News> findAllNews();

    List<News> findLastNews();

    void saveNews(News news);

    void deleteNewsById(int id);

    void deleteAll();
}
