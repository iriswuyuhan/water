package com.water.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by asus1 on 2017/7/19.
 */
@Entity
@Table(name = "User")
public class User {
    private Long idUser;              //id用户为手机号 管理员系统设置
    private String password;          //登录密码
    private String name;              //用户姓名
    private String address;           //用户邮寄地址
    private Integer isResearcher;     //是否是管理员 1为管理员 0为用户

    @Id
    @Column(name = "idUser", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }


    @Column(name = "password", length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "isResearcher")
    public Integer getIsResearcher() {
        return isResearcher;
    }

    public void setIsResearcher(Integer isResearcher) {
        this.isResearcher = isResearcher;
    }

}
