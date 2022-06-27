package ua.com.andromeda.services;

import java.util.List;

public interface BaseService <T> {
    T find(Long id);
    List<T> findAll();
    void saveOrUpdate(T entity);
    void delete(Long id);
}
