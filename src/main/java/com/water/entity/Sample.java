package com.water.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sample {
    private long idSample;      //样本编号
    private Date sampleDate;    //采样时间
    private Double volume;      //样本体积
    private String remark;      //备注
    private Apply apply;        //申请编号 一对一单向外键
    private Integer state;      //样本状态 包括处理中1 已上传实验结果2 未收取0


    @Id
    @Column(name = "idSample", nullable = false)
    public long getIdSample() {
        return idSample;
    }

    public void setIdSample(long idSample) {
        this.idSample = idSample;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @OneToOne
    @JoinColumn(name = "applyID", nullable = false, unique = true)
    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sample sample = (Sample) o;

        if (idSample != sample.idSample) return false;
        if (sampleDate != null ? !sampleDate.equals(sample.sampleDate) : sample.sampleDate != null) return false;
        if (volume != null ? !volume.equals(sample.volume) : sample.volume != null) return false;
        if (remark != null ? !remark.equals(sample.remark) : sample.remark != null) return false;
        if (state != null ? !state.equals(sample.state) : sample.state != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSample ^ (idSample >>> 32));
        result = 31 * result + (sampleDate != null ? sampleDate.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

}
