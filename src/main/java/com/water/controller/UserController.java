package com.water.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/7/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/j{userID}")
    public ModelAndView personalInfo(@PathVariable String userID){
        ModelAndView modelAndView=new ModelAndView("../wx/personal_info");
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    @RequestMapping(value = "/j{userID}/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Boolean personalInfoConfirm(@PathVariable String userID,HttpServletRequest request){
        return true;
    }

    @RequestMapping("/j{userID}/history")
    public ModelAndView getSelfHistory(@PathVariable String userID){
        ModelAndView modelAndView=new ModelAndView("../wx/selfhistory");
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    @RequestMapping("/j{userID}/history/getChecked")
    public JSONArray getCheckedHistory(@PathVariable String userID){
        JSONArray jsonArray=new JSONArray();
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/getSampling")
    public JSONArray getSampllingHistory(@PathVariable String userID){
        JSONArray jsonArray=new JSONArray();
        return jsonArray;
    }
}
