package com.water.service;

import com.water.entity.Record;
import com.water.entity.Sample;
import com.water.entity.User;

import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
public interface UserService {
    public void Login(User user);

    public void Logout(User user);

    public Sample apply(Sample sample);

    public Sample checkSample();

    public List<Record> checkRecord(User user);

    Long saveUser();//用于测试

    /**
     * 保存用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @param address  地址
     * @return 记录id
     */
    Long saveUser(String username, String password, String address);//用于测试

    /**
     * 根据用户编号查询用户id
     *
     * @param id 用户记录id
     * @return 用户对象，查询不到则返回null
     */
    User getById(long id);
}
