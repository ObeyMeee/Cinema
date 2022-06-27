package ua.com.andromeda.dao;

import java.util.List;

public interface BaseDao<T> {
    T find(Long id);
    List<T> findAll();
    void saveOrUpdate(T entity);
    void remove(Long id);

}
