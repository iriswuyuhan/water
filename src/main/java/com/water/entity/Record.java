package com.water.entity;

import javax.persistence.Column;

/**
 * Created by asus1 on 2017/7/14.
 */
public class Record {

    private Long userID;
    private Long sampleID;
    private int state;

    @Column(name = "userID" )
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Column(name = "sampleID" )
    public Long getSampleID() {
        return sampleID;
    }

    public void setSampleID(Long sampleID) {
        this.sampleID = sampleID;
    }

    @Column(name = "state" )
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
