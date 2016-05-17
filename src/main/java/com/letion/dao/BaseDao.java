package com.letion.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> loadAll();

    T findById(int id);

    T findByLogin(String login);

    T create(T item);

    T update(T item);

    boolean delete(T item);
}
