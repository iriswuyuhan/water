package com.water.entity;

import javax.persistence.*;

/**
 * Created by 朱晨乾 on 2017/7/16.
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
