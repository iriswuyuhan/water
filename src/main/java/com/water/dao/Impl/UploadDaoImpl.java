package com.water.dao.Impl;

import com.water.dao.UploadDao;
import com.water.entity.Apply;
import com.water.entity.Sample;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
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
        return (Sample) getCurrentSession().load(Sample.class, id);
    }

    public Sample get(Long id) {
        return (Sample) getCurrentSession().get(Sample.class, id);
    }

    public List<Sample> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Sample> list = new LinkedList<Sample>();
        try {
            String hql = "from Sample";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public Sample findSampleById(long applyId) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Sample> sampleList = new LinkedList<Sample>();
        try {
            String hql = "from Sample where applyID =:idApply" + applyId;
            Query query = session.createQuery(hql);
            query.setLong("idApply", applyId);
            sampleList = query.list();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        return sampleList.get(0);
    }

    public void persist(Sample entity) {
        getCurrentSession().persist(entity);
    }

    public boolean save(Sample entity) {
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

    public boolean saveOrUpdate(Sample entity) {
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
        return true;
    }

    public void flush() {

    }
}
