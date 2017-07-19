package com.water.service.Impl;

import com.water.dao.UserDao;
import com.water.model.UserEntity;
import com.water.model.UserEntity;
import com.water.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;


/**
 * Created by asus1 on 2017/7/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void addUser1(){

        UserEntity user = new UserEntity();
        user.setIdUser(Long.valueOf(1111111111));
        user.setName("李四");
        user.setPassword("sdfjafdsafas");
        user.setAddress("NJU");
        user.setIsResearcher(0);
        userDao.save(user);
    }

    public void addUser(Long userId, String username, String password, String address, Integer isResearcher) {
        UserEntity user = new UserEntity();
        user.setIdUser(userId);
        user.setName(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setIsResearcher(isResearcher);
        userDao.save(user);
    }

    public UserEntity getById(Long id) {
        return userDao.get(id);
    }
}
