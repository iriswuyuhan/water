package com.water.entity;

import javax.persistence.*;

@Entity
public class Project {
    private long idProject;       //项目编号 自增
    private String name;          //项目名称
    private String description;      //项目描述

    @Id
    @GeneratedValue
    @Column(name = "idProject", nullable = false)
    public long getIdProject(){return idProject;}
    public void setIdProject(long idProject){this.idProject = idProject;}

    @Basic
    @Column(name = "name", nullable = true)
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
}
