package com.water.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 朱晨乾 on 2017/7/16.
 */
public class User {
    private String Id;
    private String Password;
    private String Name;//姓名
    private String TelephoneNumber;//电话号码
    private String HomeAddress;//家庭地址
    private String PostCode;//邮编
    private boolean IsResearcher;//是否是研究者

    @Id
    @GeneratedValue
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    @Column(name = "Password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Column(name = "Name")
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Column(name = "TelephoneNumber")
    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }

    @Column(name = "HomeAddress")
    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String HomeAddress) {
        this.HomeAddress = HomeAddress;
    }

    @Column(name = "PostCode")
    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    @Column(name = "IsResearch")
    public boolean getIsResearcher() {
        return IsResearcher;
    }

    public void setIsReSearcher(boolean IsResearcher) {
        this.IsResearcher = IsResearcher;
    }

}
