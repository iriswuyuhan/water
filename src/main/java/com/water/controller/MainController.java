package com.water.controller;

import com.alibaba.fastjson.JSONObject;
import com.water.entity.User;
import com.water.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by bxh on 2017/7/14.
 */
@Controller
public class MainController {
    //测试
    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUser() {
        userService.saveUser();
        return "success!";
    }

    @RequestMapping(value = "saveUser2")
    @ResponseBody
    public Object saveUser2(String Id, String Password,String Name,String TelephoneNumber, String HomeAddress,String PostCode) {
        Long userId = userService.saveUser(Id,Password,Name,TelephoneNumber,HomeAddress,PostCode);
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
    }
}