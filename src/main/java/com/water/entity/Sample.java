package com.water.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/20.
 */
@Entity
public class Sample {
    private long idSample;
    private Double longitude;
    private Double latitude;
    private Date sampleDate;
    private Double volume;
    private String image;
    private String remark;
    private Apply applyByIdSample;

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

        Sample sample = (Sample) o;

        if (idSample != sample.idSample) return false;
        if (longitude != null ? !longitude.equals(sample.longitude) : sample.longitude != null) return false;
        if (latitude != null ? !latitude.equals(sample.latitude) : sample.latitude != null) return false;
        if (sampleDate != null ? !sampleDate.equals(sample.sampleDate) : sample.sampleDate != null) return false;
        if (volume != null ? !volume.equals(sample.volume) : sample.volume != null) return false;
        if (image != null ? !image.equals(sample.image) : sample.image != null) return false;
        if (remark != null ? !remark.equals(sample.remark) : sample.remark != null) return false;

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
}
