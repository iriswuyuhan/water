package com.water.controller;

import com.water.entity.User;
import com.water.service.UserService;
import com.water.util.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 微信端填写个人资料的页面
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 微信端个人资料按钮的响应，这是未知userID(openID)时填写个人资料界面的入口
     * @param request
     * @param response
     */
    @RequestMapping("/wx")
    public void wxAccessToUser(HttpServletRequest request, HttpServletResponse response){
        String code=request.getParameter("code");
        LoginProcessor loginProcessor=new LoginProcessor();
        String openID=null;
        try {
            openID=loginProcessor.getOpenId(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(openID!=null){
            User user=userService.getById(openID);
            if(user==null){
                //在数据库添加该用户
                userService.addUser(openID);
            }
        }
        String url="j"+openID+"?next=default";
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这是已知userID时的填写个人资料界面的入口
     * @param userID
     * @param request
     * @return
     */
    @RequestMapping("/j{userID}")
    public ModelAndView personalInfo(@PathVariable String userID, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("../wx/personal_info");
        String nextUrl=request.getParameter("next");
        User user = userService.getById(userID);
        modelAndView.addObject("next",nextUrl);
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("phone_num", user.getNumber());
        modelAndView.addObject("address", user.getAddress());
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    /**
     * 个人资料界面的确认按钮的响应
     * @param userID
     * @param request
     * @return
     */
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
    }

//    @RequestMapping(value = "/j{userID}/deleteUser", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean deleteUser(@PathVariable String userID,HttpServletRequest request){
//        User user=userService.getById(userID);
//        boolean result=false;
//        if((user.getName()==null||user.getName().equals(""))&&(user.getNumber()==null||user.getNumber().equals(""))
//                &&(user.getAddress()==null||user.getAddress().equals(""))){
//            result=userService.deleteUser(userID);
//        }
//        return result;
//    }
}
