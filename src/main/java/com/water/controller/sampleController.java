package com.water.controller;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
import com.sun.org.apache.regexp.internal.RE;
import com.water.entity.Apply;
import com.water.entity.Result;
import com.water.entity.Sample;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import com.water.service.ResultService;
import com.water.service.UploadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class sampleController {

    protected Logger log = Logger.getLogger(wechatApplyController.class);
    @Autowired
    private ResultService resultService;
    @Autowired
    private UploadService uploadService;
    /**
     * @param request
     * @return 上传实验结果的图片
     * @throws Exception
     */
    @RequestMapping(value = "/uploadSampleResultImg",produces = "application/json;charset=utf8")
    @ResponseBody
    public JSONObject uploadImg(@RequestParam("file") MultipartFile[] image,HttpServletRequest request) throws IOException {
        System.out.println("asdsad");
        System.out.println(request.getParameter("idSample")+"$$$$$$$$");
        String filename = request.getParameter("idSample");
        File dir=new File("/home/samples/"+filename);
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            if( !(file.getOriginalFilename().equals("")) ) {
                file.transferTo(new File("/home/web_upload/"+filename+"/" + file.getOriginalFilename()));
            }
        }
        String json = "{'state':'success'}";
        JSONObject object = JSONObject.fromObject(json);
        return object;
    }
    /**
     * @param request
     * @param response
     * @return 上传实验结果
     * @throws Exception
     */
    @RequestMapping("/uploadResult")
    @ResponseBody
    public void uploadResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSample=request.getParameter("idSample");
        String text = request.getParameter("description");
        System.out.println(idSample);
        Result result  = new Result();
        result.setIdResult(Integer.valueOf(idSample));
        result.setDescription(text);
     //   result.setImage(nameList);
       boolean bool= resultService.addResult(result);
       if(bool){
            boolean bool1 = uploadService.updateSample(Long.valueOf(idSample),2);
       }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }

    /**
     * @param request
     * @param response
     * @return 修改样本实验结果
     * @throws Exception
     */
    @RequestMapping("/modifyResult")
    @ResponseBody
    public void modifyResult(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idSample=request.getParameter("idSample");
        String text = request.getParameter("description");
        boolean bool= resultService.modifyResult(Long.valueOf(idSample),text);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(bool);
    }

    /**
     * @param request
     * @param response
     * @return 改变样本状态
     * @throws Exception
     */
    @RequestMapping("/sampleState")
    @ResponseBody
    public void sampleState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSample=request.getParameter("idSample");
        String state = request.getParameter("state");
        boolean bool = uploadService.updateSample(Long.valueOf(idSample),Integer.valueOf(state));
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(bool);
    }
    /**
     * @param request
     * @param response
     * @return 根据经纬度返回样本
     * @throws Exception
     */
    @RequestMapping("/getSampleReport")
    @ResponseBody
    public void getSampleReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String longtitude=request.getParameter("longtitude");
        String latitude= request.getParameter("latitude");

        Result result = resultService.getResultbyLocation(Double.valueOf(longtitude),Double.valueOf(latitude));
        JSONObject jsonObject = JSONObject.fromObject(result);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(jsonObject.toString());
    }
    /**
     * @param request
     * @param response
     * @return 获得所有样本编号
     * @throws Exception
     */
    @RequestMapping("/getSampleID")
    @ResponseBody
    public void getSampleID(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Sample> samples = uploadService.findAll();
        ArrayList<String> sampleIDs = new ArrayList<String>();
        for(Sample temp:samples){
            sampleIDs.add(String.valueOf(temp.getIdSample()+""));
        }
        log.info("test1");
        log.info("test2");
        log.info("test3");
        JSONArray array = JSONArray.fromObject(sampleIDs);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(array.toString());
    }

    /**
     * @param request
     * @param response
     * @return 根据ID得到实验结果
     * @throws Exception
     */
    @RequestMapping("/getSampleResult")
    @ResponseBody
    public void getSampleResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSample=request.getParameter("idSample");
        String result = resultService.findResultByID(Long.valueOf(idSample)).getDescription();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
    }
    /**
     * @param request
     * @param response
     * @return 获得样本信息
     * @throws Exception
     */
    @RequestMapping("/getSample")
    public void getSample(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Long id1 = Long.valueOf(id);
        Sample sample = uploadService.searchSample(id1);
        if(sample!=null){
            uploadService.addTxt(sample);}
        JSONObject object = JSONObject.fromObject(sample);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(object.toString());

    }
    /**
     * @param request
     * @param response
     * @return 该样本是否可以上传实验结果
     * @throws Exception
     */
    @RequestMapping("/getSampleResultTest")
    public void sampleResultTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Long id1 = Long.valueOf(id);
        int res = uploadService.judgeByID(id1);
        response.getWriter().print(String.valueOf(res));

    }

    /**
     * @param request
     * @param response
     * @return 获得所有样本信息
     * @throws Exception
     */
    @RequestMapping("/getSampleList")
    public void getSampleList(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Sample> samples = uploadService.findAll();
        log.error("asdk");
        if (samples.size() > 0)
            uploadService.addTxt(samples.get(0));
        JSONArray array = JSONArray.fromObject(samples);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(array.toString());
    }

}
