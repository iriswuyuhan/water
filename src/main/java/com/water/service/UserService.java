package com.water.service;

import com.water.entity.User;

/**
 * Created by asus1 on 2017/7/19.
 */
public interface UserService {

    /**
     * 保存用户信息
     *
     * @param userId 用户ID
     * @param username 用户名
     * @param password 密码
     * @param address  地址
     * @param isResearcher  是否为管理员
     * @return 记录id
     */
    public boolean addUser(String userId, String username, String password, String address, Integer isResearcher);//用于测试

    /**
     * 根据用户编号查询用户
     *
     * @param id 用户记录id
     * @return 用户对象，查询不到则返回null
     */
    public User getById(String id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 添加微信普通用户
     * @param userId
     * @return
     */
    public boolean addUser(String userId);


    public boolean deleteUser(String userId);


}
