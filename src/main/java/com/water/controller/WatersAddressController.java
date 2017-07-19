package com.water.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2017/7/19.
 */
@Controller
public class WatersAddressController {

    @RequestMapping("/address/waters")
    public ModelAndView uploadSampling(){
        ModelAndView modelAndView=new ModelAndView("../wx/confirm_address");
        return modelAndView;
    }

    /**
     * 确认地址
     * @return
     */
    @RequestMapping(value = "/address/waters/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Boolean addUpload(HttpServletRequest request){
        double longitude=Double.parseDouble(request.getParameter("longitude"));
        double latitude=Double.parseDouble(request.getParameter("latitude"));
        String waters_addr=request.getParameter("waters_address");
        HttpSession session=request.getSession();
        session.setAttribute("waters_addr_lng",longitude);
        session.setAttribute("waters_addr_lat",latitude);
        session.setAttribute("waters_addr",waters_addr);
        return true;
    }
}
