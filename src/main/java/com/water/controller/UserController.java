package com.water.controller;

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
    public ModelAndView uploadSampling(@PathVariable String userID){
        ModelAndView modelAndView=new ModelAndView("../wx/personal_info");
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    @RequestMapping(value = "/j{userID}/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Boolean addUpload(@PathVariable String userID,HttpServletRequest request){
        return true;
    }

    @RequestMapping("/j{userID}")
    public ModelAndView getSelfHistory (@PathVariable String userID){
        ModelAndView modelAndView=new ModelAndView("../wx/selfhistory");
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }
}
