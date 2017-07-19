package com.water.dao.Impl;

import com.water.dao.UserDao;
import com.water.entity.User;
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

    public User load(Long id) {
        return (User)getCurrentSession().load(User.class,id);
    }

    public User get(Long id) {
        return (User)getCurrentSession().get(User.class,id);
    }

    public List<User> findAll() {
        return null;
    }

    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    public void save(User entity) {
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
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        User person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();

    }
}