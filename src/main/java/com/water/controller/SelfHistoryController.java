package com.water.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.entity.Apply;
import com.water.entity.Result;
import com.water.entity.Sample;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.ResultService;
import com.water.service.UploadService;
import com.water.service.UserService;
import com.water.util.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/22.
 */
@Controller
@RequestMapping("/user")
public class SelfHistoryController {

    @Autowired
    ApplyService applyService;

    @Autowired
    UserService userService;

    @Autowired
    UploadService uploadService;

    @Autowired
    ResultService resultService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @RequestMapping("/wx/history")
    public void wxAccessToHistory(HttpServletRequest request, HttpServletResponse response){
        String code=request.getParameter("code");
        Integer type=Integer.parseInt(request.getParameter("type"));
        LoginProcessor loginProcessor=new LoginProcessor();
        String openID=null;
        try {
            openID=loginProcessor.getOpenId(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url=null;
        if(openID!=null){
            User user=userService.getById(openID);
            if(user==null){
                //在数据库添加该用户
                userService.addUser(openID);
                url="../j"+openID+"?next=default";
            }else{
                url="../j"+openID+"/history?type="+type;
            }
            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/j{userID}/history")
    public ModelAndView getSelfHistory(@PathVariable String userID,HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("../wx/selfhistory");
        int type=Integer.parseInt(request.getParameter("type"));
        modelAndView.addObject("type",type);
        modelAndView.addObject("userID", userID);
        User user = userService.getById(userID);
        modelAndView.addObject("userName", user.getName());
        return modelAndView;
    }

    @RequestMapping("/j{userID}/history/getUnChecked")
    @ResponseBody
    public JSONArray getUnCheckedHistory(@PathVariable String userID) {
        JSONArray jsonArray = new JSONArray();
        ArrayList<Apply> applyArrayList = applyService.findCheckedApply(userID, "待审核");
        for (Apply apply1 : applyArrayList) {
            jsonArray.add(apply1);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/deleteUnChecked")
    @ResponseBody
    public boolean deleteUnChecked(@PathVariable String userID, HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        ArrayList<Apply> applyArrayList = applyService.findCheckedApply(userID, "待审核");
        long deleteID = applyArrayList.get(index).getIdApply();
        return applyService.deleteApply(deleteID);
    }

    @RequestMapping("/j{userID}/history/getChecked")
    @ResponseBody
    public JSONArray getCheckedHistory(@PathVariable String userID) {
        JSONArray jsonArray = new JSONArray();
        ArrayList<Apply> applyArrayList = applyService.findCheckedApply(userID, "已审核");
        for (Apply apply1 : applyArrayList) {
            jsonArray.add(apply1);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/getSampling")
    @ResponseBody
    public JSONArray getSamplingHistory(@PathVariable String userID) {
        JSONArray jsonArray = new JSONArray();
        ArrayList<Sample> sampleArrayList = uploadService.alreadySample(userID);
        for (Sample sample : sampleArrayList) {
            JSONObject object = new JSONObject();
            object.put("waterAddress", sample.getApply().getWaterAddress());
            object.put("longitude", sample.getApply().getLongitude());
            object.put("latitude", sample.getApply().getLatitude());
            object.put("project", sample.getApply().getProject().getName());
            object.put("volume", sample.getVolume());
            object.put("remark", sample.getRemark());
            object.put("sampleDate", sdf.format(sample.getSampleDate()));
            object.put("sampleID", sample.getIdSample());
            object.put("state", sample.getState());
            jsonArray.add(object);
        }
        return jsonArray;
    }

    @RequestMapping("/j{userID}/history/apply")
    @ResponseBody
    public ModelAndView selfHistoryApply(@PathVariable String userID, HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        int isChecked = Integer.parseInt(request.getParameter("isChecked"));
        ModelAndView modelAndView = new ModelAndView("../wx/selfhistory_apply");
        modelAndView.addObject("userID", userID);
        modelAndView.addObject("index", index);
        ArrayList<Apply> applyArrayList = null;
        if (isChecked == 0) {
            applyArrayList = applyService.findCheckedApply(userID, "待审核");
        } else {
            applyArrayList = applyService.findCheckedApply(userID, "已审核");
        }
        Apply apply = applyArrayList.get(index);
        modelAndView.addObject("project", apply.getProject().getName());
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
        ArrayList<String> imageArray = imageArray(apply.getImage());
        modelAndView.addObject("applyID", apply.getIdApply());
        modelAndView.addObject("imageArray", imageArray);
        modelAndView.addObject("applyDate", sdf.format(apply.getApplyDate()));
        modelAndView.addObject("name", apply.getName());
        modelAndView.addObject("phoneNum", apply.getNumber());
        modelAndView.addObject("address", apply.getAddress());
        modelAndView.addObject("state", apply.getState());
        modelAndView.addObject("response", apply.getResponse());
        return modelAndView;
    }

    @RequestMapping("/j{userID}/history/sample")
    @ResponseBody
    public ModelAndView selfHistorySample(@PathVariable String userID, HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        ModelAndView modelAndView = new ModelAndView("../wx/selfhistory_sample");
        modelAndView.addObject("userID", userID);
        ArrayList<Sample> sampleArrayList = uploadService.alreadySample(userID);
        Sample sample = sampleArrayList.get(index);
        Apply apply = sample.getApply();
        modelAndView.addObject("sampleDate", sample.getSampleDate());
        modelAndView.addObject("sampleVolume", sample.getVolume());
        modelAndView.addObject("sampleID", sample.getIdSample());
        modelAndView.addObject("sampleRemark", sample.getRemark());
        modelAndView.addObject("state", sample.getState());
        modelAndView.addObject("response",apply.getResponse());
        modelAndView.addObject("waterAddress", apply.getWaterAddress());
        modelAndView.addObject("project", apply.getProject().getName());
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
        ArrayList<String> imageArray = imageArray(apply.getImage());
        modelAndView.addObject("imageArray", imageArray);
        modelAndView.addObject("applyDate", sdf.format(apply.getApplyDate()));
        modelAndView.addObject("name", apply.getName());
        modelAndView.addObject("phoneNum", apply.getNumber());
        modelAndView.addObject("address", apply.getAddress());
        //实验结果
        if (sample.getState() == 2) {
            Result result = resultService.findResultByID(sample.getIdSample());
            ArrayList<String> resultImage = imageArray(result.getImage());
            modelAndView.addObject("resultImage",resultImage);
            modelAndView.addObject("resultDescription",result.getDescription());
        }
        return modelAndView;
    }

    public String keepTwoDecimal(Double db) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(db);
    }

    @RequestMapping("/j{userID}/history/apply/delete")
    @ResponseBody
    public boolean deleteApply(@PathVariable String userID, HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        ArrayList<Apply> applyArrayList = applyService.findCheckedApply(userID, "待审核");
        long deleteID = applyArrayList.get(index).getIdApply();
        return applyService.deleteApply(deleteID);
//        return true;
    }

    @RequestMapping("/j{userID}/history/jumpToUpload")
    @ResponseBody
    public String jumpToUpload(@PathVariable String userID, HttpServletRequest request) {
        int index = Integer.parseInt(request.getParameter("index"));
        ArrayList<Apply> applyArrayList = applyService.findCheckedApply(userID, "已审核");
        long uploadID = applyArrayList.get(index).getIdApply();
        return String.valueOf(uploadID);
//        return "1";
    }

    //解析图片路径
    private ArrayList<String> imageArray(List<String> image) {
        ArrayList<String> imageArray = new ArrayList<String>();
        if (image != null) {
            List<String> images = image;
            for (String path : images) {
                if (!path.equals(""))
                    imageArray.add(path);
            }
        }
        return imageArray;
    }
}