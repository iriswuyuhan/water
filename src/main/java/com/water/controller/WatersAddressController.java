package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 确认水域地址界面的controller
 */
@Controller
@RequestMapping("/address/waters")
public class WatersAddressController {

    /**
     * 加载确认水域地址界面
     * @return
     */
    @RequestMapping("")
    public ModelAndView waterAddressPage(){
        ModelAndView modelAndView=new ModelAndView("../wx/confirm_address");
        return modelAndView;
    }

//    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
//    @ResponseBody
//    public Boolean waterAddressConfirm(HttpServletRequest request){
//        double longitude=Double.parseDouble(request.getParameter("longitude"));
//        double latitude=Double.parseDouble(request.getParameter("latitude"));
//        String waters_addr=request.getParameter("waters_address");
//        HttpSession session=request.getSession();
//        session.setAttribute("waters_addr_lng",longitude);
//        session.setAttribute("waters_addr_lat",latitude);
//        session.setAttribute("waters_addr",waters_addr);
//        return true;
//    }
}
