package com.water.service;

import com.water.entity.Project;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface ProjectService {

    /**
     * 查找所有项目
     *
     * @return 项目列表
     */
    public List<Project> findAllProjects();

    /**
     * 根据id查找项目
     *
     * @param idProject
     * @return 项目
     */
    public Project findProjectByID(long idProject);

    /**
     * 发布项目
     *
     * @param project
     * @return 是否发布成功
     */
    public long saveProject(Project project);

    /**
     * 删除项目
     * @param projectID
     * @return 是否删除成功
     */
    public boolean deleteProject(long projectID);

    public boolean updateProject(Project project);

    /**
     * \根据项目名称找到项目后上传结果
     * @param projectName
     * @param pdf
     * @return
     */
    public boolean uploadProject(String projectName , String pdf);
}
