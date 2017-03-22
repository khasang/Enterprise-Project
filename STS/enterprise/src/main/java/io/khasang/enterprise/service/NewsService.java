package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.NewsDao;
import io.khasang.enterprise.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("newsService")
@Transactional
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public NewsService() {
    }

    @Transactional
    public List<News> findLatestNews() {
        return newsDao.findLastNews();
    }

    @Transactional
    public List<News> findAllNews() {
        return newsDao.findAll();
    }

    @Transactional
    public List<News> getAllNews() {
        return newsDao.findAll();
    }

    @Transactional
    public void deleteAllNews() {
        newsDao.deleteAllNews();
    }

    @Transactional
    public void saveNewsToDB(News news) {
        newsDao.save(news);
    }

    @Transactional
    public News getNewsById(Integer id) {
        return newsDao.getById(id);
    }
}
