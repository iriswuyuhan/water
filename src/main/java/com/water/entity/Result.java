package com.water.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import javax.persistence.*;

@Entity
public class Result {
    private long idResult;         //result的id 实际上与样本共用主键
    private String image;          //实验结果的图片？？？
    private String description;       //对实验结果的描述？？？


    @Id
    @Column(name="idResult")
    public long getIdResult() {
        return idResult;
    }

    public void setIdResult(long idResult) {
        this.idResult = idResult;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
