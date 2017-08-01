package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.entity.Apply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        Session session = getCurrentSession();
        Apply apply = (Apply) session.load(Apply.class, id);
        session.close();
        return apply;
    }

    public Apply get(Long id) {
        Session session = getCurrentSession();
        Apply apply = (Apply) session.get(Apply.class, id);
        session.close();
        return apply;
    }

    public List<Apply> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Apply> list = new LinkedList<>();
        try {
            String hql = "from Apply";
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Apply> findApplyById(String idUser) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Apply> applyList = new LinkedList<>();
        try {

            String hql = "from Apply where userID =:userid";//使用命名参数，推荐使用，易读。
            Query query = session.createQuery(hql);
            query.setString("userid", idUser);
            applyList = query.list();

        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return applyList;
    }

    public void persist(Apply entity) {
        getCurrentSession().persist(entity);
    }

    public boolean updateState(long id, int state){
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            String hql="update Apply set state=:stateInt where idApply =:applyID";//使用命名参数，推荐使用，易读。
            Query query=session.createQuery(hql);
            query.setInteger("stateInt", state);
            query.setLong("applyID",id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean save(Apply entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            session.save(entity);
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean saveOrUpdate(Apply entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            session.saveOrUpdate(entity);
            session.flush();
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
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
            Apply apply = (Apply) session.load(Apply.class, id);
            session.delete(apply);
            tx.commit();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public Apply getApplyByLocation(double longi,double lati){
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Apply> applyList=new ArrayList<>();
        try {

            String hql = "from Apply where longitude =:longitude and latitude =:latitude";//使用命名参数，推荐使用，易读。
            Query query = session.createQuery(hql);
            query.setDouble("longitude", longi);
            query.setDouble("latitude",lati);
            applyList = query.list();

        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        if(applyList.size()==0){
            return  null;
        }else {
            return applyList.get(0);
        }
    }

}
