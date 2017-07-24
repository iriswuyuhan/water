package com.water.controller;

/**
 * Created by Administrator on 2017/7/21.
 */
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/***
 * 文件上传控制类
 * @author swinglife
 *
 */
@Controller
public class FileUploadController {

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/filesUpload")
    public void filesUpload() throws IllegalStateException, IOException {
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    saveFile(file);
                }
            }
        }
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
        System.out.print("success");
    }

    /***
     * 保存文件
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                System.out.println(file.getOriginalFilename());
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

