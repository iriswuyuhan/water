package com.water.service.Impl;

import com.water.dao.ProjectDao;
import com.water.entity.Project;
import com.water.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;

    public List<Project> findAllProjects() {
        return projectDao.findAll();
    }

    @Override
    public Project findProjectByID(long idProject) {
        return projectDao.get(idProject);
    }

    @Override
    public Project findProjectByName(String projectName) {
        return projectDao.findProjectByName(projectName);
    }

    @Override
    public long saveProject(Project project) {
        projectDao.save(project);
        return project.getIdProject();
    }

    @Override
    public boolean deleteProject(long projectID) {
        return projectDao.delete(projectID);
    }

    @Override
    public boolean updateProject(Project project) {
        return projectDao.saveOrUpdate(project);
    }

    @Override
    public boolean uploadProject(String projectName, String pdf) {
        Project project = projectDao.findProjectByName(projectName);
        project.setState(1);
        project.setReport(pdf);
        return projectDao.saveOrUpdate(project);
    }

    @Override
    public Project findNewestProject() {
        List<Project> projects = projectDao.findAll();
        Comparator<Project> cmp = new ComparatorUser();
        Collections.sort(projects, cmp);
        return projects.get(0);
    }

    class ComparatorUser implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            Long a = o1.getIdProject();
            Long b = o2.getIdProject();
            int flag = b.compareTo(a);
            return flag;
        }
    }

}
