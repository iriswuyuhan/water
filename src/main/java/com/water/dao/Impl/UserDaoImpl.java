package com.water.dao.Impl;

import com.water.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 朱晨乾 on 2017/7/18.
 */
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory = null;

    private Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }
    /**
     * 验证身份
     * @param idUser
     * @param password
     */
    public void testIdentify(long idUser, String password) {
//        String sql =
    }
}
