package io.khasang.enterprise.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public abstract class AbstractDao<PK extends Serializable, T> {
    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    public T findById(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(persistentClass);
        return (List<T>) criteria.list(); // todo make it find first 100 rows, not all.
    }

    public void save(T entity) {
        getSession().persist(entity);
    }

    void delete(T entity) {
        getSession().delete(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void merge(T entity) {
        getSession().merge(entity);
    }
}
