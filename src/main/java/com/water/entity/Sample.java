package com.water.entity;

import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by asus1 on 2017/7/14.
 */
public class Sample {

    private Long sampleID;//样本编号
    private String longitude;//经度LNG
    private String latitude;//纬度Lat
    private String address;
    private Date applyDate;
    private String remark;
    private byte[] image;//图片文件

    @Id
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Column(name = "sampleID")
    public Long getSampleID() {
        return sampleID;
    }

    public void setSampleID(Long sampleID) {
        this.sampleID = sampleID;
    }

    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "applyDate")
    @Temporal(value = TemporalType.DATE)
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
