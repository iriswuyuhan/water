package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
