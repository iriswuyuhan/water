package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.model.ApplyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

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

//    public void persist(ApplyEntity applyEntity){
//        getCurrentSession().persist(applyEntity);
//    }
    /**
     *
     * @param applyEntity
     */
    public void sendApplication(ApplyEntity applyEntity){
//        getCurrentSession().sendApplication(applyEntity);
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
    public ArrayList<ApplyEntity> searchApplicationById(long idApply) {

        return null;
    }

    /**
     * 通过状态查询申请
     *
     * @param state
     * @return
     */
    public ArrayList<ApplyEntity> searchApplicationByState(Integer state) {
        return null;
    }

//    public void flush(){
//        getCurrentSession().flush();
//    }

}
