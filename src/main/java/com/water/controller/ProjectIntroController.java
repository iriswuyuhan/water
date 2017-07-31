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
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("/projectIntro")
public class ProjectIntroController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    ProjectService projectService;

    @RequestMapping("/init")
    public ModelAndView initProject(){
        List<Project> p = projectService.findAllProjects();
        List<String> projectNames = new ArrayList<String>();
        for(int i=0;i<p.size();i++){
            projectNames.add(p.get(i).getName());
        }
        ModelAndView modelAndView = new ModelAndView("../public/projectIntro");
        modelAndView.addObject("projectNameArray",projectNames);
        return modelAndView;
    }
}
