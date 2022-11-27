package com.github.hoshihon.picshare.dao;

public interface BaseDAO<T> {
    void insert(T entity);

    int update(T entity);

    int delete(long id);

    T findById(long id);
}
