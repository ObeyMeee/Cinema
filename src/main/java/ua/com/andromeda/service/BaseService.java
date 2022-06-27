package ua.com.andromeda.service;

import java.util.List;

public interface BaseService <T> {
    T find(Long id);
    List<T> findAll();
    void saveOrUpdate(T entity);
    void remove(Long id);
}
