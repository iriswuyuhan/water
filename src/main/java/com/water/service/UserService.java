package com.water.service;

import com.water.entity.Sample;
import com.water.entity.User;
import com.water.entity.Record;
import java.util.List;

/**
 * Created by asus1 on 2017/7/14.
 */
public interface UserService {
    public void Login(User user);
    public void Logout(User user);
    public Sample apply (Sample sample);
    public Sample checkSample();
    public List<Record> checkRecord(User user);
    Long saveUser();//用于测试
}
