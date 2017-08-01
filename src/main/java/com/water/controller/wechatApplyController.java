package com.water.controller;

import com.water.entity.Apply;
import com.water.entity.Project;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import com.water.service.Impl.UserServiceImpl;
import com.water.service.ProjectService;
import com.water.service.UserService;
import com.water.util.LoginProcessor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
@Controller
public class wechatApplyController {

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest request;

    @Autowired
    ApplyService applyService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping("/init/wx")
    public void wxAccessToHistory(HttpServletRequest request, HttpServletResponse response){
        String code=request.getParameter("code");
        LoginProcessor loginProcessor=new LoginProcessor();
        String openID=null;
        try {
            openID=loginProcessor.getOpenId(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url=null;
        if(openID!=null){
            User user=userService.getById(openID);
            if(user==null){
                //在数据库添加该用户
                userService.addUser(openID);
                url="../user/j"+openID+"?next=apply";
            }else{
                url="../init/j"+openID;
            }
            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/init/j{userID}")
    public ModelAndView uploadApply(@PathVariable String userID){
        ModelAndView modelAndView = new ModelAndView("../wx/apply");
        String userName = "";
        String contact = "";
        String address = "";
        List<Project> p = projectService.findAllProjects();
//        List<Project> p = new ArrayList<Project>();
//        Project project = new Project();
//        project.setIdProject(1);
//        project.setName("一般申请");
//        project.setDescription("志愿者自行选择河流区域");
//        p.add(project);
//        System.out.println(p.get(0));

        modelAndView.addObject("userID",userID);
        User user = userService.getById(userID);
        userName = user.getName();
        modelAndView.addObject("userName",userName);

        contact = user.getNumber();
        modelAndView.addObject("contact",contact);

        address = user.getAddress();
        modelAndView.addObject("address",address);
        modelAndView.addObject("projectArray",p);
        return modelAndView;
    }

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public void upload(@RequestPart("image") MultipartFile image[], HttpServletRequest request) throws IOException {
        String date = request.getParameter("applyDate");
        date = date.replace(":","-");
        String userID = request.getParameter("img_userID");
        String fileName = userID + "_" + date + "_";
        File dir=new File("/home/web_upload");
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            if( !(file.getOriginalFilename().equals("")) ) {
                String s = fileName + i + ".jpg";
                file.transferTo(new File(dir + "/" + s));
            }
        }
    }

    @RequestMapping(value = "/applyUpload",method = RequestMethod.POST)
    @ResponseBody
    public boolean upload(HttpServletRequest request) throws ParseException{

        Apply apply = new Apply();
        System.out.print(request.getParameter("longitude"));
        apply.setLongitude(Double.parseDouble(request.getParameter("longitude")));
        apply.setLatitude(Double.parseDouble(request.getParameter("latitude")));
        apply.setNumber(request.getParameter("number"));
        apply.setAddress(request.getParameter("address"));
        DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        apply.setApplyDate(d.parse(request.getParameter("applyDate")));
        apply.setState(Integer.parseInt(request.getParameter("state")));
        String imgUrl = request.getParameter("imgUrl");
        String s[] = imgUrl.split(";");
        List<String> img = new ArrayList<String>();
        for(int i=0;i<s.length;i++){
            img.add(s[i]);
        }
        apply.setImage(img);
        apply.setName(request.getParameter("name"));
        apply.setWaterAddress(request.getParameter("waterAddress"));
        User user = new User();
        String userId = request.getParameter("idUser");
        user = userService.getById(userId);
        apply.setUser(user);
        apply.setResponse("");
        int idProject = Integer.parseInt(request.getParameter("projectID")) + 1;
        Project project = projectService.findProjectByID(idProject);
        apply.setProject(project);
//        System.out.println(apply.getNumber());
//        System.out.println(apply.getAddress());
//        System.out.println("apply:"+apply.getApplyDate());
//        System.out.println(apply.getState());
//        System.out.println(apply.getImage());
//        System.out.println(apply.getName());
//        System.out.println(apply.getWaterAddress());
//        System.out.println(userId);
//        System.out.println(apply.getResponse());
//        System.out.println(apply.getProject().getName());
        boolean f = applyService.addApply(apply);
//        System.out.println(f);
        return f;
    }
}