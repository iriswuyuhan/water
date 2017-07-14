package com.water.dao.Impl;

import com.water.dao.AdminDao;
import com.water.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Admin load(Long id) {
        return (Admin)getCurrentSession().load(Admin.class,id);
    }

    public Admin get(Long id) {
        return (Admin)getCurrentSession().get(Admin.class,id);
    }

    public List<Admin> findAll() {
        return null;
    }

    public void persist(Admin entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(Admin entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Admin entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        Admin admin = load(id);
        getCurrentSession().delete(admin);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
