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
                file.transferTo(new File("/home/samples/"+filename+"/" + file.getOriginalFilename()));
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
        System.out.println("123123");
        String idSample=request.getParameter("idSample");
        String text = request.getParameter("description");

//        File file = new File("E:\\water\\src\\main\\webapp\\resources\\txt\\"+idSample);
//        String [] fileName = file.list();
//        List<String> nameList = Arrays.asList(fileName);
//        System.out.println(idSample+text+fileName.length);
//        for(int i=0;i<fileName.length;i++)
//            System.out.println(fileName[i]);
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
     * @return 获得所有样本编号
     * @throws Exception
     */
    @RequestMapping("/getSampleID")
    public void getSampleList(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Sample> samples = uploadService.findAll();
        ArrayList<String> sampleIDs = new ArrayList<String>();
        for(Sample temp:samples){
            sampleIDs.add(String.valueOf(temp.getIdSample()+""));
        }
        JSONArray array = JSONArray.fromObject(sampleIDs);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(array.toString());
    }

}
