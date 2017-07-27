package com.water.dao.Impl;

import com.water.dao.ProjectDao;
import com.water.entity.Project;
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
        return (Project) getCurrentSession().load(Project.class, id);
    }

    public Project get(Long id) {
        return (Project) getCurrentSession().get(Project.class, id);
    }

    public List<Project> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Project> list = new LinkedList<Project>();
        try{
            String sql = "from Project";
            Query query = session.createQuery(sql);
            list = query.list();
            tx.commit();
        }catch (Exception ex){
            tx.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public void persist(Project entity) {
        getCurrentSession().persist(entity);
    }

    public boolean save(Project entity) {
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

    public boolean saveOrUpdate(Project entity) {
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
            Project project = (Project) session.load(Project.class, id);
            session.delete(project);
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
        getCurrentSession().flush();
    }
}
