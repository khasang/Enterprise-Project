package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.News;

import java.util.List;

public interface NewsDao {

    List<News> findLastNews();

    void deleteNewsById(int id);

    void deleteAllNews();
}
