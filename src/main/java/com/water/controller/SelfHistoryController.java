package com.water.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.entity.Apply;
import com.water.entity.Sample;
import com.water.service.ApplyService;
import com.water.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/22.
 */
@Controller
@RequestMapping("/user")
public class SelfHistoryController {

    ApplyService applyService;
    UploadService uploadService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @RequestMapping("/j{userID}/history")
    public ModelAndView getSelfHistory(@PathVariable String userID){
        ModelAndView modelAndView=new ModelAndView("../wx/selfhistory");
        modelAndView.addObject("userID",userID);
        return modelAndView;
    }

    @RequestMapping("/j{userID}/history/getUnChecked")
    @ResponseBody
    public JSONArray getUnCheckedHistory(@PathVariable String userID){
        JSONArray jsonArray=new JSONArray();
//        ArrayList<Apply> applyArrayList= applyService.findCheckedApply(userID,"待审核");
        ArrayList<Apply> applyArrayList=new ArrayList<Apply>();
        Apply apply=new Apply();
        apply.setWaterAddress("12345");
        apply.setName("zhs");
        apply.setNumber("3456789");apply.setAddress("aaaaaaaaaaaa");
        applyArrayList.add(apply);applyArrayList.add(apply);
        for(Apply apply1:applyArrayList){
            jsonArray.add(apply1);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/deleteUnChecked")
    @ResponseBody
    public boolean deleteUnChecked(@PathVariable String userID,HttpServletRequest request){
        int index=Integer.parseInt(request.getParameter("index"));
//        ArrayList<Apply> applyArrayList= applyService.findCheckedApply(userID,"待审核");
//        long deleteID=applyArrayList.get(index).getIdApply();
//        return applyService.deleteApply(deleteID);
        return true;
    }

    @RequestMapping("/j{userID}/history/getChecked")
    @ResponseBody
    public JSONArray getCheckedHistory(@PathVariable String userID){
        JSONArray jsonArray=new JSONArray();
//        ArrayList<Apply> applyArrayList= applyService.findCheckedApply(userID,"已审核");
        ArrayList<Apply> applyArrayList=new ArrayList<Apply>();
        for(Apply apply1:applyArrayList){
            jsonArray.add(apply1);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/getSampling")
    @ResponseBody
    public JSONArray getSampllingHistory(@PathVariable String userID){
        JSONArray jsonArray=new JSONArray();
//        ArrayList<Sample> sampleArrayList=uploadService.alreadySample(userID);
        ArrayList<Sample> sampleArrayList=new ArrayList<Sample>();
        for(Sample sample:sampleArrayList){
            JSONObject object=new JSONObject();
            object.put("waterAddress",sample.getApply().getWaterAddress());
            object.put("longitude",sample.getApply().getLongitude());
            object.put("latitude",sample.getApply().getLatitude());
            object.put("volume",sample.getVolume());
            object.put("remark",sample.getRemark());
            object.put("sampleDate",sdf.format(sample.getSampleDate()));
            object.put("sampleID",sample.getIdSample());
            jsonArray.add(object);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/apply")
    @ResponseBody
    public ModelAndView selfHistoryApply(@PathVariable String userID,HttpServletRequest request){
        int index=Integer.parseInt(request.getParameter("index"));
        int isChecked=Integer.parseInt(request.getParameter("isChecked"));
        ModelAndView modelAndView=new ModelAndView("../wx/selfhistory_apply");
        modelAndView.addObject("userID",userID);
        modelAndView.addObject("index",index);
        ArrayList<Apply> applyArrayList=null;
//        if(isChecked==0) {
//            applyArrayList = applyService.findCheckedApply(userID, "待审核");
//        }else{
//            applyArrayList = applyService.findCheckedApply(userID, "已审核");
//        }
//        Apply apply=applyArrayList.get(index);
        Apply apply=new Apply();
        apply.setWaterAddress("123");apply.setLongitude(12.0);apply.setLatitude(23.0);
        apply.setImage("/resources/img/delete.png");apply.setName("123");apply.setNumber("123456788");
        apply.setAddress("2456");apply.setApplyDate(new Date());apply.setState(0);
        modelAndView.addObject("waterAddress", apply.getWaterAddress());
        String latitude = keepTwoDecimal(Math.abs(apply.getLatitude()));
        if (apply.getLatitude() >= 0) {
            modelAndView.addObject("latitude", "北纬" + latitude + "度");
        } else {
            modelAndView.addObject("latitude", "南纬" + latitude + "度");
        }
        String longitude = keepTwoDecimal(Math.abs(apply.getLongitude()));
        if (apply.getLongitude() >= 0) {
            modelAndView.addObject("longitude", "东经" + longitude + "度");
        } else {
            modelAndView.addObject("longitude", "西经" + longitude + "度");
        }
        //解析图片路径
        ArrayList<String> imageArray = new ArrayList<String>();
        if (apply.getImage() != null) {
            String[] images = apply.getImage().split(";");
            for (String image : images) {
                if(!image.equals(""))
                    imageArray.add(image);
            }
        }
        modelAndView.addObject("imageArray",imageArray);
        modelAndView.addObject("applyDate",sdf.format(apply.getApplyDate()));
        modelAndView.addObject("name",apply.getName());
        modelAndView.addObject("phoneNum",apply.getNumber());
        modelAndView.addObject("address",apply.getAddress());
        modelAndView.addObject("state",apply.getState());
        return modelAndView;
    }

    @RequestMapping("/j{userID}/history/sample")
    @ResponseBody
    public ModelAndView selfHistorySample(@PathVariable String userID,HttpServletRequest request){
        int index=Integer.parseInt(request.getParameter("index"));
        ModelAndView modelAndView=new ModelAndView("../wx/selfhistory_sample");
//        ArrayList<Sample> sampleArrayList=uploadService.alreadySample(userID);
//        Sample sample=sampleArrayList.get(index);
//        Apply apply=sample.getApply();
        Sample sample=new Sample();
        sample.setSampleDate(new Date());sample.setVolume(12.9);
        sample.setIdSample(123);sample.setRemark("23467");
        Apply apply=new Apply();
        apply.setWaterAddress("123");apply.setLongitude(12.0);apply.setLatitude(23.0);
        apply.setImage("/resources/img/delete.png");apply.setName("123");apply.setNumber("123456788");
        apply.setAddress("2456");apply.setApplyDate(new Date());apply.setState(0);
        modelAndView.addObject("sampleDate",sample.getSampleDate());
        modelAndView.addObject("sampleVolume",sample.getVolume());
        modelAndView.addObject("sampleID",sample.getIdSample());
        modelAndView.addObject("sampleRemark",sample.getRemark());
        modelAndView.addObject("waterAddress", apply.getWaterAddress());
        String latitude = keepTwoDecimal(Math.abs(apply.getLatitude()));
        if (apply.getLatitude() >= 0) {
            modelAndView.addObject("latitude", "北纬" + latitude + "度");
        } else {
            modelAndView.addObject("latitude", "南纬" + latitude + "度");
        }
        String longitude = keepTwoDecimal(Math.abs(apply.getLongitude()));
        if (apply.getLongitude() >= 0) {
            modelAndView.addObject("longitude", "东经" + longitude + "度");
        } else {
            modelAndView.addObject("longitude", "西经" + longitude + "度");
        }
        //解析图片路径
        ArrayList<String> imageArray = new ArrayList<String>();
        if (apply.getImage() != null) {
            String[] images = apply.getImage().split(";");
            for (String image : images) {
                if(!image.equals(""))
                    imageArray.add(image);
            }
        }
        modelAndView.addObject("imageArray",imageArray);
        modelAndView.addObject("applyDate",sdf.format(apply.getApplyDate()));
        modelAndView.addObject("name",apply.getName());
        modelAndView.addObject("phoneNum",apply.getNumber());
        modelAndView.addObject("address",apply.getAddress());
        modelAndView.addObject("state",apply.getState());
        return modelAndView;
    }

    public String keepTwoDecimal(Double db) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(db);
    }

    @RequestMapping("/j{userID}/history/apply/delete")
    @ResponseBody
    public boolean deleteApply(@PathVariable String userID,HttpServletRequest request){
        int index=Integer.parseInt(request.getParameter("index"));
//        ArrayList<Apply> applyArrayList= applyService.findCheckedApply(userID,"待审核");
//        long deleteID=applyArrayList.get(index).getIdApply();
//        return applyService.deleteApply(deleteID);
        return true;
    }
}
