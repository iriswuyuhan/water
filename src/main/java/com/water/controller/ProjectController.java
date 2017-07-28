package com.water.controller;

import com.water.entity.Project;
import com.water.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * @param request
     * @return 项目id
     * @throws Exception
     */
    @RequestMapping("/publish")
    @ResponseBody
    public long publishProject(HttpServletRequest request) throws IOException {
        String head=request.getParameter("headline");
        String body=request.getParameter("body");

        Project project=new Project();
        project.setName(head);
        project.setDescription(body);

        //long id=projectService.saveProject(project);
        System.out.println("success");
        return 0;
    }

    /**
     * @param request
     * @param response
     * @return void
     * @throws Exception
     */
    @RequestMapping("/all")
    @ResponseBody
    public void getAll(HttpServletRequest request,HttpServletResponse response) throws IOException {

    }

    /**
     * @param request
     * @param response
     * @return boolean
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        return false;
    }


}
