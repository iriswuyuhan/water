package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public ModelAndView uploadSampling(){
        ModelAndView modelAndView=new ModelAndView("../wx/upload_sampling_info");
        return modelAndView;
    }
}
