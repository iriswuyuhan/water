package com.water.dao.Impl;

import com.water.dao.ApplyDao;
import com.water.model.ApplyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
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

    private ApplicationContext applicationContext = null;
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;
    public void init(){

    }
    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    /**
     * 上传申请信息到数据库
     *
     * @param idApply
     * @param name
     * @param longitude
     * @param latitude
     * @param number
     * @param address
     * @param postcode
     * @param applyDate
     * @param state
     * @param image
     */
    public void sendApplication(String idApply, String name, Double longitude, Double latitude, String number, String address, Integer postcode, Date applyDate, Integer state, byte[] image) {

    }

    /**
     * 修改申请状态
     *
     * @param idApply
     * @param state
     */
    public void updateState(String idApply, Integer state) {
    }

    /**
     * 通过id查询申请
     *
     * @param idApply
     * @return
     */
    public ArrayList<ApplyEntity> searchApplicationById(String idApply) {
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

}
