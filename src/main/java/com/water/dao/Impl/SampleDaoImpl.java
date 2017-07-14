package com.water.dao.Impl;

import com.water.entity.Sample;
import com.water.dao.SampleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
@Repository
public class SampleDaoImpl implements SampleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Sample load(Long id) {
        return (Sample)getCurrentSession().load(Sample.class,id);
    }

    public Sample get(Long id) {
        return (Sample) getCurrentSession().get(Sample.class,id);
    }

    public List<Sample> findAll() {
        return null;
    }

    public void persist(Sample entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(Sample entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Sample entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        Sample sample = load(id);
        getCurrentSession().delete(sample);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
