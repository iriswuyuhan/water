package com.water.dao.Impl;

import com.water.dao.UploadDao;
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
        Session session = getCurrentSession();
        Sample sample = (Sample) session.load(Sample.class, id);
        session.close();
        return sample;
    }

    public Sample get(Long id) {
        Session session = getCurrentSession();
        Sample sample = (Sample) session.get(Sample.class, id);
        session.close();
        return sample;
    }

    public List<Sample> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Sample> list = new LinkedList<>();
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
        List<Sample> sampleList = new LinkedList<>();
        try {
            String hql = "from Sample where applyID =:idApply";
            Query query = session.createQuery(hql);
            query.setLong("idApply", applyId);
            sampleList = query.list();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        Sample result=new Sample();
        if(sampleList.size()==0){
            result=null;

        }else {
            result=sampleList.get(0);
        }

        return result;
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
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            Sample sample = (Sample) session.load(Sample.class, id);
            session.delete(sample);
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
