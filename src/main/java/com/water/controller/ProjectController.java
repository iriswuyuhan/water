package com.water.controller;

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
     * @param response
     * @return 是否申请成功
     * @throws Exception
     */
    @RequestMapping("/publish")
    @ResponseBody
    public boolean applylist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String head=request.getParameter("headline");
        String body=request.getParameter("body");



        return false;
    }
}
