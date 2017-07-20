package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.entity.Apply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Flutter on 2017/7/19.
 */
@Repository
public class ApplyDaoImpl implements ApplyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Apply load(Long id) {
        return (Apply) getCurrentSession().load(Apply.class,id);
    }

    public Apply get(Long id) {
        return (Apply) getCurrentSession().get(Apply.class,id);
    }

    public List<Apply> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Apply> list = new LinkedList<Apply>();
        try{
            String hql = "from Apply";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
        }catch (Exception ex){
            tx.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void persist(Apply entity) {
        getCurrentSession().persist(entity);
    }

    public boolean save(Apply entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try{
            session.save(entity);
            tx.commit();
            flag = true;
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
        return flag;
    }
    public void saveOrUpdate(Apply entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            session.saveOrUpdate(entity);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
    }

    public boolean delete(Long id) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try{
            Apply apply = (Apply)session.load(Apply.class,id);
            session.delete(apply);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
        }finally{
            session.close();
        }
        return flag;
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
