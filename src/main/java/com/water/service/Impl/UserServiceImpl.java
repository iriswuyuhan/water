package com.water.service.Impl;

import com.water.dao.UserDao;
import com.water.entity.User;
import com.water.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by asus1 on 2017/7/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void addUser1(){

        User user = new User();
        user.setIdUser(String.valueOf(1111111111));
        user.setName("李四");
        user.setPassword("sdfjafdsafas");
        user.setAddress("NJU");
        user.setIsResearcher(0);
        userDao.save(user);
    }

    public boolean addUser(String userId, String username, String password, String address, Integer isResearcher) {
        User user = new User();
        user.setIdUser(userId);
        user.setName(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setIsResearcher(isResearcher);
        return userDao.save(user);
    }

    public User getById(String id) {
        return userDao.get(id);
    }

    public boolean updateUser(User user) {

        return userDao.saveOrUpdate(user);

    }

    public boolean addUser(String userId){
        User user = new User();
        user.setIdUser(userId);
        user.setName("");
        user.setPassword("");
        user.setAddress("");
        user.setNumber("");
        user.setIsResearcher(0);
        return userDao.save(user);
    }
}
