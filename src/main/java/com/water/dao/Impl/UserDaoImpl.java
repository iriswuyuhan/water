package com.water.dao.Impl;

import com.water.dao.UserDao;
import com.water.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bxh on 2017/7/14.
 */
@Repository
public class UserDaoImpl implements UserDao {

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

    public Long save(User entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        User user = load(id);
        getCurrentSession().delete(user);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}