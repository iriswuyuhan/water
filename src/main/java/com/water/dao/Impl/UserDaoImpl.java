package com.water.dao.Impl;

import com.water.dao.UserDao;
import com.water.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
/**
 * Created by asus1 on 2017/7/19.
 */
@Repository
public class UserDaoImpl implements UserDao{


    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public UserEntity load(Long id) {
        return (UserEntity) getCurrentSession().load(UserEntity.class,id);
    }

    public UserEntity get(Long id) {
        return (UserEntity)getCurrentSession().get(UserEntity.class,id);
    }

    public List<UserEntity> findAll() {
        return null;
    }

    public void persist(UserEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void save(UserEntity entity) {
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
    public void saveOrUpdate(UserEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        UserEntity person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();

    }
}