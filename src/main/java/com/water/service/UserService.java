package com.water.service;

import com.water.entity.User;

/**
 * Created by asus1 on 2017/7/19.
 */
public interface UserService {
    void addUser1();
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
    public void addUser(Long userId, String username, String password, String address, Integer isResearcher);//用于测试

    /**
     * 根据用户编号查询用户id
     *
     * @param id 用户记录id
     * @return 用户对象，查询不到则返回null
     */
    public User getById(Long id);
}
