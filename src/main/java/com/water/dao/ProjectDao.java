package com.water.dao;

import com.water.entity.Project;

/**
 * Created by asus1 on 2017/7/26.
 */
public interface ProjectDao extends DaoUtil<Project,Long> {
    /**
     * 通过项目名称查找项目
     * @param projectName
     * @return
     */
    public Project findProjectByName(String projectName);
}
