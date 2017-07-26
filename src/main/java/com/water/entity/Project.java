package com.water.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Project {
    private long idProject;
    private String name;
    private String describe;

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
    @Column(name = "describe", nullable = true)
    public String getDescribe(){return describe;}
    public void setDescribe(String describe){this.describe = describe;}
}
