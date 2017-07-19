package com.water.controller;


import com.water.service.ApplyService;
import com.water.service.UploadService;
import com.water.service.UserService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by bxh on 2017/7/14.
 */
@Controller
public class MainController {
    //测试

//    @Autowired
//    private PersonService personService;
//
//    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
//    @ResponseBody
//    public String savePerson(){
//        personService.savePerson();
//        return "success!";
//    }
    @Autowired
    private UserService userService;

    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    @ResponseBody
    public String addUser(){
        userService.addUser1();
        return "success!";
    }

    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "addApply", method = RequestMethod.GET)
    @ResponseBody
    public String addApply(){
        applyService.addApply();
        return "success!";
    }

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "addUpload", method = RequestMethod.GET)
    @ResponseBody
    public String addUpload(){
        uploadService.addUpload();
        return "success!";
    }

/*    @RequestMapping(value = "saveUser2")
    @ResponseBody
    public Object saveUser2(String username, String password, String address) {
        Long userId = userService.saveUser(username, password, address);
        JSONObject obj = new JSONObject();
        if (userId != null && userId > 0) {
            obj.put("result", 1);
            obj.put("obj", userId);
        } else {
            obj.put("result", 0);
        }

        return obj;
    }

    @RequestMapping(value = "getUser")
    @ResponseBody
    public Object getUser(long id) {
        User user = userService.getById(id);
        JSONObject obj = new JSONObject();
        if (user != null) {
            obj.put("result", 1);
            obj.put("obj", user);
        } else {
            obj.put("result", 0);
        }
        return obj;
    }*/


    /**
     * @param request
     * @param response
     * @return 登录验证
     * @throws Exception
     */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }
    @RequestMapping(value="/toAdmin.do")
    public String toAdmin() throws IOException{
        return "Admin_Work";
    }

}