package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.entity.Apply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bxh on 2017/7/18.
 */
@Repository
public class ApplyDaoImpl implements ApplyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Apply load(Long id) {
        return (Apply)getCurrentSession().load(Apply.class,id);
    }

    public Apply get(Long id) {
        return (Apply)getCurrentSession().get(Apply.class,id);
    }

    public List<Apply> findAll() {
        Session session = getCurrentSession();
        String hql = "from Apply";
        Query query = session.createQuery(hql);
        List<Apply> list = query.list();
        return list;
    }

    public void persist(Apply entity) {
        getCurrentSession().persist(entity);
    }

    public void save(Apply entity) {
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
    public void saveOrUpdate(Apply entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        Apply person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();
    }

}
