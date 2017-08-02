package com.water.controller;

import com.water.entity.Project;
import com.water.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信端可选项目界面的controller
 */
@Controller
@RequestMapping("/projectList")
public class ProjectListController {

    @Autowired
    private ProjectService projectService;

    /**
     * 加载可选项目界面
     * @param request
     * @return
     */
    @RequestMapping("")
    public ModelAndView getProjectList(HttpServletRequest request){
        List<Project> projectList = projectService.findAllProjects();
        ModelAndView modelAndView = new ModelAndView("../wx/projectList");
        modelAndView.addObject("projectList",projectList);
        return modelAndView;
    }
}
