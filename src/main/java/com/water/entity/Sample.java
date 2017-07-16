package com.water.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/16.
 */
public class Sample {
    private String Id;//样本编号
    private double Longitude;//经度
    private double Latitude;//纬度
    private String Remark;//备注
    private byte[] Image;//图片
    private Date ApplyDate;//申请时间
    private int Volume;//样本体积

    @Id
    @GeneratedValue
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    @Column(name = "Longitude")
    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    @Column(name = "Latitude")
    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    @Column(name = "Remark")
    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    @Column(name = "Image")
    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    @Column(name = "ApplyDate")
    @Temporal(value = TemporalType.DATE)
    public Date getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(Date ApplyDate) {
        this.ApplyDate = ApplyDate;
    }

    @Column(name = "Volume")
    public int getVolume() {
        return Volume;
    }

    public void setVolume(int Volume) {
        this.Volume = Volume;
    }


}
