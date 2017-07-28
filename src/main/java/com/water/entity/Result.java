package com.water.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Result {
    private long idResult;            //
    private List<String> image =new ArrayList<String>(); //实验结果的图片？？？
    private String description;       //对实验结果的描述？？？


    @Id
    @Column(name="idResult", nullable = false)
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

    @ElementCollection(fetch=FetchType.LAZY, //加载策略,延迟加载
            targetClass=String.class) //指定集合中元素的类型
    @CollectionTable(name="Result_img") //指定集合生成的表
    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
