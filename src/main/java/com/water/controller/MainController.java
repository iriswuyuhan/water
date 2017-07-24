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
/*----------------------------------对Apply逻辑调用数据增删改查方法的测试----------------------------------------*/
    @Autowired
    private ApplyService applyService;

    //测试增加Apply方法
    @RequestMapping(value = "addApply", method = RequestMethod.GET)
    @ResponseBody
    public String addApply(){
        applyService.addApply();
        return "success!";
    }

    //测试是否返回对应状态的列表
    @RequestMapping(value = "findApply", method = RequestMethod.GET)
    @ResponseBody
    public String findApply(){
        System.out.println(applyService.getApplicationList(0).get(0).getAddress());
        return "success!";
    }

    //测试按id搜索 不包括id不存在情况处理 id不存在
    @RequestMapping(value = "searchApply", method = RequestMethod.GET)
    @ResponseBody
    public String searchApply(){
        System.out.println(applyService.searchApplication(Long.valueOf(285561975)).getWaterAddress());
        return "success!";
    }

    //测试更新申请状态 如果id不存在 会返回false
    @RequestMapping(value = "updateState", method = RequestMethod.GET)
    @ResponseBody
    public String updateState(){
        System.out.println(applyService.updateState(Long.valueOf(46464646),0));
        return "success!";
    }

    //测试删除Apply
    @RequestMapping(value = "deleteApply", method = RequestMethod.GET)
    @ResponseBody
    public String deleteApply(){
        System.out.println(applyService.deleteApply(Long.valueOf(55555555)));
        return "success!";
    }
    /*------------------------------------------------End--------------------------------------------------------*/

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "addUpload", method = RequestMethod.GET)
    @ResponseBody
    public String addUpload(){
        uploadService.addUpload();
        return "success!";
    }

    @RequestMapping(value = "searchSample", method = RequestMethod.GET)
    @ResponseBody
    public String searchSample(){
        System.out.println(uploadService.searchSample(Long.valueOf(1564654)).getApply().getName());
        return "success!";
    }

/*    @RequestMapping(value = "testTxt", method = RequestMethod.GET)
    @ResponseBody
    public String testTxt(){
        Sample sample = uploadService.searchSample(Long.valueOf(1564654));
        test t = new test();
        t.addtxt(sample);
        return "success!";
    }*/

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