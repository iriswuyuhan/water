package com.water.dao;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Flutter on 2017/7/19.
 */
public interface DaoUtil<T,PK extends Serializable>{
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    boolean save(T entity);

    void saveOrUpdate(T entity);

    boolean delete(PK id);

    void flush();
}