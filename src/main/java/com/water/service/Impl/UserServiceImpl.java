package com.water.service.Impl;

import com.water.dao.UserDao;
//import com.water.entity.Record;
import com.water.entity.Sample;
import com.water.entity.User;
import com.water.service.UserService;
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

    public void Login(User user) {
    }

    public void Logout(User user) {
    }

    public Sample apply(Sample sample) {
        return null;
    }

    public Sample checkSample() {
        return null;
    }

//    public List<Record> checkRecord(User user) {
//        return null;
//    }

    public Long saveUser() {
        User person = new User();
        person.setId("111111");
        person.setPassword("123456");
        person.setName("11111111111");
        person.setTelephoneNumber("1111111");
        person.setHomeAddress("NJU");
        person.setPostCode("111111");
//        return userDao.save(person);
        return null;
    }

    public Long saveUser(String Id, String Password,String Name,String TelephoneNumber, String HomeAddress,String PostCode) {
        User person = new User();
        person.setId(Id);
        person.setPassword(Password);
        person.setName(Name);
        person.setTelephoneNumber(TelephoneNumber);
        person.setHomeAddress(HomeAddress);
        person.setPostCode(PostCode);
//        return userDao.save(person);
        return null;
    }

    public User getById(long id) {
//        return userDao.get(id);
        return null;
    }
}