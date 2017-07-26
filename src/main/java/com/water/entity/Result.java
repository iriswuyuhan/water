package com.water.entity;

import javax.persistence.*;

public class Result {
    private Sample sample;
    private String image;
    private String describe;
    @Basic
    @Column(name = "describe", nullable = true)
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Id
    @OneToOne
    @JoinColumn(name = "idSample", nullable = false)
    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }
}
