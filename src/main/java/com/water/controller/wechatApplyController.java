package com.water.controller;

import com.water.entity.Apply;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import com.water.service.Impl.UserServiceImpl;
import com.water.service.UserService;
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

    @RequestMapping("/init/j{userID}")
    public ModelAndView uploadApply(@PathVariable String userID){
        ModelAndView modelAndView = new ModelAndView("../wx/apply");
        HttpSession session = request.getSession();
        String userName = "";
        String contact = "";
        String address = "";

//        if(session.getAttribute("userName") != null) {
//            userName = session.getAttribute("userName").toString();
//        }
//        if(session.getAttribute("contact") != null) {
//            contact = session.getAttribute("contact").toString();
//        }
//        if(session.getAttribute("address") != null) {
//            address = session.getAttribute("address").toString();
//        }
        modelAndView.addObject("userId",userID);
        User user = userService.getById(userID);
//        if(userName == null){
        userName = user.getName();
//        }
        modelAndView.addObject("userName",userName);
//        if(contact == null){
        contact = user.getNumber();
//        }
        modelAndView.addObject("contact",contact);
//        if(address == null){
        address = user.getAddress();
//        }
        modelAndView.addObject("address",address);
        return modelAndView;
    }

//    @RequestMapping("/chooseRiver")
//    public void chooseRiver(){
//        HttpSession session = request.getSession();
//        String userName = request.getParameter("userName");
//        String contact = request.getParameter("contact");
//        String address = request.getParameter("address");
//        if(userName != null && !(userName.equals(""))){
//            session.setAttribute("userName",userName);
//        }
//        if(contact != null && !(contact.equals(""))){
//            session.setAttribute("contact",contact);
//        }
//        if(address != null && !(address.equals(""))){
//            session.setAttribute("address",address);
//        }
//    }

    @RequestMapping(value = "/applyUpload",method = RequestMethod.POST)
    public String upload(@RequestPart("image") MultipartFile image[], Model model, HttpServletRequest request) throws IOException, ParseException {
        String imgUrl = "";

        File dir=new File("D:/temp");
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            if( !(file.getOriginalFilename().equals("")) ) {
                file.transferTo(new File(dir.getAbsolutePath() + "/" + file.getOriginalFilename()));
                imgUrl += dir.getAbsolutePath()+"/"+file.getOriginalFilename();
            }
        }

//        Apply apply = new Apply();
//        apply.setLongitude(Double.parseDouble(request.getParameter("longitude")));
//        apply.setLatitude(Double.parseDouble(request.getParameter("latitude")));
//        apply.setNumber(request.getParameter("number"));
//        apply.setAddress(request.getParameter("address"));
//        DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
//        apply.setApplyDate(d.parse(request.getParameter("applyDate")));
//        apply.setState(Integer.parseInt(request.getParameter("state")));
//        apply.setImage(request.getParameter("image"));
//        apply.setNumber(request.getParameter("name"));
//        apply.setWaterAddress(request.getParameter("waterAddress"));
//        User user = new User();
//        String userId = request.getParameter("idUser");
//        user = userService.getById(userId);
//        apply.setUser(user);
//        System.out.println(apply.getNumber());
//        System.out.println(apply.getAddress());
//        System.out.println(apply.getApplyDate());
//        System.out.println(apply.getState());
//        System.out.println(apply.getImage());
//        System.out.println(apply.getNumber());
//        System.out.println(apply.getWaterAddress());
//        System.out.println(userId);
//        applyService.addApply(apply);
        return "Admin_Work";
    }
}
