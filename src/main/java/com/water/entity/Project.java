package com.water.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
    private long idProject;       //项目编号 自增
    private String name;          //项目名称
    private String description;      //项目描述
    private Integer state;          //项目状态
    private String report;          //项目报告
    private Date date;          //日期

    @Id
    @GeneratedValue
    @Column(name = "idProject", nullable = false)
    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "report", nullable = true)
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
