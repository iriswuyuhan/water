package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2017/7/18.
 */
@Controller
public class UploadSamplingController {

    @RequestMapping("/upload")
    public ModelAndView uploadSampling(){
        ModelAndView modelAndView=new ModelAndView("../wx/upload_sampling_info");
        return modelAndView;
    }
}
