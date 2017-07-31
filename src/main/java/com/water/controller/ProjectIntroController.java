package com.water.controller;

import com.water.entity.Project;
import com.water.service.ProjectService;
import net.sf.json.JSONObject;
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
@RequestMapping(value = "/projectIntro")
public class ProjectIntroController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/init")
    public ModelAndView initProject(){
        List<Project> p = projectService.findAllProjects();
        List<String> projectNames = new ArrayList<String>();
        for(int i=0;i<p.size();i++){
            projectNames.add(p.get(i).getName());
        }
        Project firstProject = projectService.findProjectByName("一般申请");
        ModelAndView modelAndView = new ModelAndView("../public/projectIntro");
        modelAndView.addObject("projectName",firstProject.getName());
        modelAndView.addObject("description",firstProject.getDescription());
        modelAndView.addObject("date",firstProject.getDate());
        modelAndView.addObject("projectNameArray",projectNames);
        return modelAndView;
    }

    @RequestMapping(value = "/getInfo")
    public JSONObject getInfo(){
        String projectName = request.getParameter("projectName");
        Project p = projectService.findProjectByName(projectName);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("description2",p.getDescription());
        jsonObject.put("projectName2",p.getName());
        jsonObject.put("report2",p.getReport());
        jsonObject.put("state2",p.getState());
        jsonObject.put("date2",p.getDate());
        return jsonObject;
    }
}
