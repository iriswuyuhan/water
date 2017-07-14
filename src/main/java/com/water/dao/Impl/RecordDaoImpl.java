package com.water.dao.Impl;

import com.water.dao.RecordDao;
import com.water.entity.Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
@Repository
public class RecordDaoImpl implements RecordDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Record load(Long id) {
        return null;
    }

    public Record get(Long id) {
        return null ;
    }

    public List<Record> findAll() {
        return null;
    }

    public void persist(Record entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(Record entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Record entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {

    }

    public void flush() {
        getCurrentSession().flush();
    }
}
