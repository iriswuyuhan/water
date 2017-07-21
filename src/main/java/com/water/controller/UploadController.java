package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 朱晨乾 on 2017/7/17.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );

    @RequestMapping("/j{applyID}")
    public ModelAndView uploadSamplePage(@PathVariable String applyID){
        ModelAndView modelAndView=new ModelAndView("../wx/upload_sampling_info");
        //设置当前时间
        Date date=new Date();
        String timeStr=sdf.format(date);
        String[] split_time=timeStr.split(" ");
        String curTime=split_time[0]+"T"+split_time[1];

        modelAndView.addObject("applyID",applyID);
        modelAndView.addObject("curTime",curTime);
        return modelAndView;
    }

    @RequestMapping(value = "/j{applyID}/confirm", method = RequestMethod.GET)
    @ResponseBody
    public Boolean addUpload(@PathVariable String applyID,HttpServletRequest request){
        String sample_time=request.getParameter("sample_time");
        String[] split_date=sample_time.split("T");
        sample_time=split_date[0]+" "+split_date[1];
        Date sample_date=null;
        try {
            sample_date=sdf.parse(sample_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double sample_volume=Double.parseDouble(request.getParameter("sample_volume"));
        int sample_number=Integer.parseInt(request.getParameter("sample_number"));
        String sample_remark=request.getParameter("sample_remark");

        return true;
    }
}
