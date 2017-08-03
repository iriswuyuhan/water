package com.water.dao.Impl;

import com.water.dao.ProjectDao;
import com.water.entity.Apply;
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
        Session session = getCurrentSession();
        Project project = (Project) session.load(Project.class, id);
        session.close();
        return project;
    }

    public Project get(Long id) {
        Session session = getCurrentSession();
        Project project = (Project) session.get(Project.class, id);
        session.close();
        return project;
    }

    public List<Project> findAll() {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Project> list = new LinkedList<>();
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

    public boolean modifyProject(String projectName, String desc, Long id){
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        boolean flag = false;
        try {
            String hql="update Project set name=:projectname , description=:body where idProject =:projectID";//使用命名参数，推荐使用，易读。
            Query query=session.createQuery(hql);
            query.setString("projectname", projectName);
            query.setString("body", desc);
            query.setLong("projectID",id);
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

    public Project findProjectByName(String projectName){
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Project> applyList = new LinkedList<>();
        try {

            String hql = "from Project where name =:proname";//使用命名参数，推荐使用，易读。
            Query query = session.createQuery(hql);
            query.setString("proname", projectName);
            applyList = query.list();

        } catch (Exception ex) {
            tx.rollback();
        } finally {
            session.close();
        }
        if(applyList.size()==0){
            return  null;
        }
        else {
            return applyList.get(0);
        }


    }

    public void flush() {
        Session session = getCurrentSession();
        session.flush();
        session.close();
    }
}
