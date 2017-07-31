package com.water.controller;

import com.water.entity.Project;
import com.water.entity.Sample;
import com.water.service.ProjectService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        Date date=new Date();
        Project project=new Project();
        project.setName(head);
        project.setDescription(body);
        project.setState(0);
        project.setDate(date);

        long id=projectService.saveProject(project);

        return id;
//        return 0;
    }

    /**
     * @param response
     * @return 项目列表
     * @throws Exception
     */
    @RequestMapping("/allProject")
    @ResponseBody
    public void getAll(HttpServletResponse response) throws IOException {
        List<Project> projects=projectService.findAllProjects();

        System.out.println(projects.get(0).getName());
        JSONArray jsonObject=JSONArray.fromObject(projects);

        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonObject);
        response.getWriter().flush();
    }

    /**
     * @param response
     * @return 项目列表
     * @throws Exception
     */
    @RequestMapping("/getProjectName")
    @ResponseBody
    public void getProjectName(HttpServletResponse response) throws IOException {
        List<Project> projects=projectService.findAllProjects();
        ArrayList<String> projectNames = new ArrayList<String>();
        for(Project temp:projects){
            projectNames.add(String.valueOf(temp.getName()+""));
        }
        JSONArray array = JSONArray.fromObject(projectNames);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(array.toString());
    }

    /**
     * @param request
     * @return boolean
     * @throws Exception
     */
    @RequestMapping("/deleteProject")
    @ResponseBody
    public boolean delete(HttpServletRequest request) throws IOException {
        String id=request.getParameter("id");
        boolean success=projectService.deleteProject(Long.parseLong(id));
        return success;
//        return true;
    }

    /**
     * @param request
     * @return boolean
     * @throws Exception
     */
    @RequestMapping("/modifyProject")
    @ResponseBody
    public boolean modify(HttpServletRequest request) throws IOException {
        long id=Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        String head=request.getParameter("headline");
        String body=request.getParameter("body");
        System.out.println(body);

        Date date=new Date();
        Project project=new Project();
        project.setIdProject(id);
        project.setName(head);
        project.setDescription(body);
        project.setDate(date);

        boolean success=projectService.updateProject(project);

        return success;
//        return true;
    }

    /**
     * @param request
     * @return boolean
     * @throws Exception
     */
    @RequestMapping("/uploadProPic")
    @ResponseBody
    public boolean upload(HttpServletRequest request){
        return false;
    }

    /**
     * @param request
     * @param response
     * @return 上传项目报告
     * @throws Exception
     */
    @RequestMapping("/uploadProjectResult")
    public void uploadProjectResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String project = request.getParameter("project");
            String filename = project+".pdf";
            boolean bool = projectService.uploadProject(project,filename);
            if(bool)
            response.getWriter().print("上传成功");
            else {
                response.getWriter().print("上传失败");
            }
    }
    /**
     * @param request
     * @return 上传项目报告文件
     * @throws Exception
     */
    @RequestMapping("/uploadProjectFile")
    @ResponseBody
    public JSONObject uploadProjectFile(@RequestParam("file") MultipartFile image, HttpServletRequest request) throws IOException {
        System.out.println("asdsad");
        String project =  request.getParameter("project");
        System.out.println(project);
        File dir=new File("/home/web_upload/");
        MultipartFile file = image;
        if( !(file.getOriginalFilename().equals("")) ) {
            file.transferTo(new File("/home/web_upload/"+project+".pdf"));
        }
        String json = "{'state':'success'}";
        JSONObject object = JSONObject.fromObject(json);
        return object;
    }

    /**
     * @param response
     * @return void
     * @throws Exception
     */
    @RequestMapping("/getLatestPro")
    @ResponseBody
    public JSONObject getLatest(HttpServletResponse response) throws IOException {
        Project project=projectService.findNewestProject();
//        Project project=new Project();
//        project.setName("北戴河");
//        project.setDescription("这是具体内容");
//        project.setIdProject(1);

        JSONObject jsonObject=JSONObject.fromObject(project);
        return jsonObject;
    }
}
