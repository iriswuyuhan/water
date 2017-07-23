package com.water.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.entity.Apply;
import com.water.entity.Sample;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.UploadService;
import com.water.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @RequestMapping("/j{userID}")
    public ModelAndView personalInfo(@PathVariable String userID, HttpSession session){
        ModelAndView modelAndView=new ModelAndView("../wx/personal_info");
        if(session.getAttribute("user_name")!=null){
            //从定位地址页面返回，获取收货地址
            modelAndView.addObject("name",session.getAttribute("user_name"));
            modelAndView.addObject("phone_num",session.getAttribute("user_number"));
            modelAndView.addObject("address",session.getAttribute("user_address"));
            //取收货地址

            session.removeAttribute("user_name");
            session.removeAttribute("user_number");
            session.removeAttribute("user_address");
        }else {
//            User user = userService.getById(userID);
//            modelAndView.addObject("name", user.getName());
//            modelAndView.addObject("phone_num", user.getNumber());
//            modelAndView.addObject("address", user.getAddress());
        }
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    @RequestMapping(value = "/j{userID}/saveUserToSession", method = RequestMethod.GET)
    @ResponseBody
    public Boolean saveUserToSession(@PathVariable String userID,HttpServletRequest request){
        String name=request.getParameter("name");
        String number=request.getParameter("phone_num");
        String address=request.getParameter("address");
        HttpSession session=request.getSession();
        session.setAttribute("user_name",name);
        session.setAttribute("user_number",number);
        session.setAttribute("user_address",address);
        return true;
    }

    @RequestMapping(value = "/j{userID}/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Boolean personalInfoConfirm(@PathVariable String userID,HttpServletRequest request){
        String name=request.getParameter("name");
        String number=request.getParameter("phone_num");
        String address=request.getParameter("address");
        User user=new User();
        user.setIdUser(userID);
        user.setName(name);
        user.setNumber(number);
        user.setAddress(address);
//        return userService.updateUser(user);
        return true;
    }
}
