package com.water.dao.Impl;

import com.water.dao.ResultDao;
import com.water.entity.Project;
import com.water.entity.Result;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus1 on 2017/7/26.
 */
@Repository
public class ResultDaoImpl implements ResultDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Result load(Long id) {
        Session session = getCurrentSession();
        Result result = (Result) session.load(Result.class, id);
        session.close();
        return result;
    }

    public Result get(Long id) {
        Session session = getCurrentSession();
        Result result = (Result) session.get(Result.class, id);
        session.close();
        return result;
    }

    public List<Result> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Result> list = new LinkedList<Result>();
        try {
            String sql = "from Result";
            Query query = session.createQuery(sql);
            list = query.list();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public void persist(Result entity) {
        getCurrentSession().persist(entity);
    }

    public boolean save(Result entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            session.save(entity);
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean saveOrUpdate(Result entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            session.saveOrUpdate(entity);
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean delete(Long id) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            Result result = (Result) session.load(Result.class, id);
            session.delete(result);
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public void flush() {
        Session session = getCurrentSession();
        session.flush();
        session.close();
    }
}
