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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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
import java.util.ArrayList;
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

    @RequestMapping("/init")
    public ModelAndView uploadApply(){
        ModelAndView modelAndView = new ModelAndView("../wx/apply2.jsp");
        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        String userId = session.getAttribute("userId").toString();
        String userName = session.getAttribute("userName").toString();
        String contact = session.getAttribute("contact").toString();
        String address = session.getAttribute("address").toString();
        String river_place = session.getAttribute("waters_addr").toString();
        double longitude = Double.parseDouble(session.getAttribute("water_addr_lng").toString());
        double latitude = Double.parseDouble(session.getAttribute("water_addr_lat").toString());
        modelAndView.addObject("userId",userId);
        User user = userService.getById(userId);
        if(userName == null){
            userName = user.getName();
        }
        modelAndView.addObject("userName",userName);
        if(contact == null){
            contact = user.getNumber();
        }
        modelAndView.addObject("contact",contact);
        if(address == null){
            address = user.getAddress();
        }
        modelAndView.addObject("address",address);
        if(river_place == null){
            river_place = "";
        }
        modelAndView.addObject("river_place",river_place);
        modelAndView.addObject("longitude",longitude);
        modelAndView.addObject("latitude",latitude);
        return modelAndView;
    }

    @RequestMapping("/chooseRiver")
    public void chooseRiver(){
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        if(userName != null && !(userName.equals(""))){
            session.setAttribute("userName",userName);
        }
        if(contact != null && !(contact.equals(""))){
            session.setAttribute("contact",contact);
        }
        if(address != null && !(address.equals(""))){
            session.setAttribute("address",address);
        }
    }

    @RequestMapping(value = "/imagesUpload",method = RequestMethod.POST)
    public String upload(@RequestPart("image") MultipartFile image[], Model model, HttpServletRequest request) throws IOException {
        File dir=new File(request.getSession().getServletContext().getRealPath("/upload"));
        System.out.println(request.getSession().getServletContext().getRealPath("/upload"));
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            if(file.getOriginalFilename() != "") {
                System.out.println(22);
                file.transferTo(new File(dir.getAbsolutePath() + "/" + file.getOriginalFilename()));
                System.out.println(dir.getAbsolutePath()+"/"+file.getOriginalFilename());
            }

        }
        return "Admin_Work";
    }

    @RequestMapping("/getApply")
    public void getApplyInfo(){
//        Apply apply = request.getParameter("applyData");
        ApplyService applyService = new ApplyServiceImpl();
        applyService.addApply();
    }
}
