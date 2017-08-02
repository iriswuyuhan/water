package com.water.controller;

import com.water.entity.Project;
import com.water.service.ProjectService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if(firstProject != null){
            if(firstProject.getName() != null){
                modelAndView.addObject("projectName", firstProject.getName());
            }else{
                modelAndView.addObject("projectName", "");
            }
            if(firstProject.getDescription() != null){
                modelAndView.addObject("description",firstProject.getDescription());
            }else{
                modelAndView.addObject("description","");
            }
            if(firstProject.getDescription() != null){
                Date date = firstProject.getDate();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String d = df.format(date);
                modelAndView.addObject("date",d);
            }else{
                modelAndView.addObject("date","");
            }
        }
        if(projectNames.size() == 0){
            projectNames.add("暂无样本");
        }
        modelAndView.addObject("projectNameArray",projectNames);
        modelAndView.addObject("projectArray",p);

        return modelAndView;
    }

    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public JSONObject getInfo(){
        String projectName = request.getParameter("projectName");
        Project p = projectService.findProjectByName(projectName);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("description2",p.getDescription());
        jsonObject.put("projectName2",p.getName());
        jsonObject.put("state2",p.getState());
        Date date = p.getDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = df.format(date);
        jsonObject.put("date2",d);
        return jsonObject;
    }
}
