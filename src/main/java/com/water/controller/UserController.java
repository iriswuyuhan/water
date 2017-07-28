package com.water.controller;

import com.water.entity.User;
import com.water.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/7/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/wx")
    public ModelAndView wxAccessToUser(HttpServletRequest request){
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("../wx/personnal_info");
        return modelAndView;
    }

    @RequestMapping("/j{userID}")
    public ModelAndView personalInfo(@PathVariable String userID, HttpSession session){
        ModelAndView modelAndView=new ModelAndView("../wx/personal_info");
            User user = userService.getById(userID);
//        User user=new User();
//        user.setName("zhs");user.setNumber("15050582771");user.setAddress("江苏省南京市栖霞区");
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("phone_num", user.getNumber());
        modelAndView.addObject("address", user.getAddress());
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
        User user=userService.getById(userID);
        user.setName(name);
        user.setNumber(number);
        user.setAddress(address);
        return userService.updateUser(user);
//        return true;
    }
}
