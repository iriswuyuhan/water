package com.water.service.Impl;

import com.water.entity.Record;
import com.water.entity.Sample;
import com.water.service.UserService;
import com.water.entity.User;
import com.water.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bxh on 2017/7/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void Login(User user){}
    public void Logout(User user){}
    public Sample apply (Sample sample){return null;}
    public Sample checkSample(){return null;}
    public List<Record> checkRecord(User user){return null;}

    public Long saveUser() {
        User person = new User();
        person.setUsername("11111111111");
        person.setPassword("123456");
        person.setAddress("NJU");
        return userDao.save(person);
    }
}