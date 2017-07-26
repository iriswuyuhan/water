package com.water.dao.Impl;

import com.water.dao.ProjectDao;
import com.water.entity.Project;
import com.water.entity.Sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asus1 on 2017/7/26.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public Project load(Long id) {
        return null;
    }

    public Project get(Long id) {
        return (Project) getCurrentSession().get(Project.class, id);
    }

    public List<Project> findAll() {
        return null;
    }

    public void persist(Project entity) {

    }

    public boolean save(Project entity) {
        return false;
    }

    public boolean saveOrUpdate(Project entity) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
    }

    public void flush() {

    }
}
