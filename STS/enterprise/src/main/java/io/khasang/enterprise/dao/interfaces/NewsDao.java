package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.News;

import java.util.List;

public interface NewsDao {
    News findById(Integer id);

    List<News> findAll();

    void save(News news);

    void update(News news);

    List<News> findLastNews();

    void deleteNewsById(int id);

    void deleteAllNews();

    News getById(Integer id);
}
