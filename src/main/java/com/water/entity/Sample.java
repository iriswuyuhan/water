package com.water.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/19.
 */
@Entity
@Table(name = "sample", schema = "water")
public class Sample {
    private long idSample;
    private Double longitude;
    private Double latitude;
    private Date sampleDate;
    private Double volume;
    private String image;
    private String remark;
    private Apply applyByIdSample;
    private User userByIdUserSample;
    private Long idUserSample;

    @Id
    @Column(name = "idSample", nullable = false)
    public Long getIdSample() {
        return idSample;
    }

    public void setIdSample(Long idSample) {
        this.idSample = idSample;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "sampleDate", nullable = true)
    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    @Basic
    @Column(name = "volume", nullable = true, precision = 0)
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 255)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sample that = (Sample) o;

        if (idSample != that.idSample) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (sampleDate != null ? !sampleDate.equals(that.sampleDate) : that.sampleDate != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSample ^ (idSample >>> 32));
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (sampleDate != null ? sampleDate.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "idSample", referencedColumnName = "idApply", nullable = false)
    public Apply getApplyByIdSample() {
        return applyByIdSample;
    }

    public void setApplyByIdSample(Apply applyByIdSample) {
        this.applyByIdSample = applyByIdSample;
    }

    @ManyToOne
    @JoinColumn(name = "idUserSample", referencedColumnName = "idUser")
    public User getUserByIdUserSample() {
        return userByIdUserSample;
    }

    public void setUserByIdUserSample(User userByIdUserSample) {
        this.userByIdUserSample = userByIdUserSample;
    }

    @Basic
    @Column(name = "idUserSample", nullable = true)
    public Long getIdUserSample() {
        return idUserSample;
    }

    public void setIdUserSample(Long idUserSample) {
        this.idUserSample = idUserSample;
    }
}
