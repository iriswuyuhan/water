package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.model.ApplyEntity;
import org.hibernate.Query;
import org.hibernate.Query;

//import com.water.entity.Person;
import com.water.model.UserEntity;
import com.water.model.ApplyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Repository
public class ApplyDaoImpl implements ApplyDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public ApplyEntity load(Long id) {
        return (ApplyEntity) getCurrentSession().load(ApplyEntity.class,id);
    }

    public ApplyEntity get(Long id) {
        return (ApplyEntity) getCurrentSession().get(ApplyEntity.class,id);
    }

    public List<ApplyEntity> findAll() {
        Session session = getCurrentSession();
        String hql = "from ApplyEntity";
        Query query = session.createQuery(hql);
        List<ApplyEntity> list = query.list();
        return list;
    }

    /**
     * 修改申请状态
     *
     * @param idApply
     * @param state
     */
    public void updateState(long idApply, Integer state) {

    }

    /**
     * 通过id查询申请
     *
     * @param idApply
     * @return
     */
    public ArrayList<ApplyEntity> searchApplicationById(Long idApply) {

        return null;
    }

    public void persist(ApplyEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void save(ApplyEntity entity) {
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
    public void saveOrUpdate(ApplyEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        ApplyEntity person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}
