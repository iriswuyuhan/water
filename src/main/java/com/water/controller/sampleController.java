package com.water.controller;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
import com.water.entity.Apply;
import com.water.entity.Sample;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
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
@Controller
public class sampleController {
    @RequestMapping(value = "/uploadSampleResultImg", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public JSONObject uploadImg(@RequestParam("file") MultipartFile[] image) throws IOException {
        File dir=new File("E:\\water\\src\\main\\webapp\\resources\\txt\\a");
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            if( !(file.getOriginalFilename().equals("")) ) {
                file.transferTo(new File("E:\\water\\src\\main\\webapp\\resources\\txt\\a\\" + file.getOriginalFilename()));
            }
        }
        String json = "{'state':'success'}";
        JSONObject object = JSONObject.fromObject(json);
        return object;
    }
}
