package com.water.entity;

import javax.persistence.*;

/**
 * Created by asus1 on 2017/7/14.
 */
@Entity
@Table(name = "Admin")
public class Admin {

    private Long id;
    private String password;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
