package com.water.dao.Impl;

import com.water.dao.UploadDao;
import com.water.entity.Sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Repository
public class UploadDaoImpl implements UploadDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Sample load(Long id) {
        return null;
    }

    public Sample get(Long id) {
        return null;
    }

    public List<Sample> findAll() {
        return null;
    }

    public void persist(Sample entity) {

    }

    public void save(Sample entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(entity);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    public void saveOrUpdate(Sample entity) {

    }

    public void delete(Long id) {

    }

    public void flush() {

    }
}
