package com.water.controller;

import com.water.entity.Apply;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import com.water.service.Impl.UserServiceImpl;
import com.water.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
@Controller
public class wechatApplyController {

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/init")
    public ModelAndView uploadApply(){
        ModelAndView modelAndView = new ModelAndView("../wx/apply2.jsp");
        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        String userId = session.getAttribute("userId").toString();
        String userName = session.getAttribute("userName").toString();
        String contact = session.getAttribute("contact").toString();
        String address = session.getAttribute("address").toString();
        String river_place = session.getAttribute("waters_addr").toString();
        double longitude = Double.parseDouble(session.getAttribute("water_addr_lng").toString());
        double latitude = Double.parseDouble(session.getAttribute("water_addr_lat").toString());
        modelAndView.addObject("userId",userId);
//        User user = userService.getById(userId);
//        if(userName == null){
//            userName = user.getName();
//        }
//        modelAndView.addObject("userName",userName);
//        if(contact == null){
//            contact = user.getNumber();
//        }
//        modelAndView.addObject("contact",contact);
//        if(address == null){
//            address = user.getAddress();
//        }
//        modelAndView.addObject("address",address);
//        if(river_place == null){
//            river_place = "";
//        }
        modelAndView.addObject("river_place",river_place);
        modelAndView.addObject("longitude",longitude);
        modelAndView.addObject("latitude",latitude);
        return modelAndView;
    }

    @RequestMapping("/chooseRiver")
    public void chooseRiver(){
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        session.setAttribute("userName",userName);
        session.setAttribute("contact",contact);
        session.setAttribute("address",address);
    }

    @RequestMapping(value = "/imagesUpload",method = RequestMethod.POST)
    public void upload(@RequestPart("image") MultipartFile image[], Model model, HttpServletRequest request) throws IOException {
        File dir=new File(request.getSession().getServletContext().getRealPath("/upload"));
        System.out.println(request.getSession().getServletContext().getRealPath("/upload"));
        if(!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0;i<image.length;i++){
            MultipartFile file = image[i];
            file.transferTo(new File(dir.getAbsolutePath()+"/"+file.getOriginalFilename()));
            System.out.println(dir.getAbsolutePath()+"/"+file.getOriginalFilename());
        }
    }

//    @RequestMapping("/uploadImage")
//    public Model uploadFile(HttpServletResponse reponse, Model model) throws Exception, IOException {
//        CommonsMultipartResolver multi = new CommonsMultipartResolver(request.getSession().getServletContext());
//        if (multi.isMultipart(request)) {
//            MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
//            Iterator it = mr.getFileNames();
//            System.out.println(mr.getFileNames().toString());
//            int i = 0;
//            while (it.hasNext()) {
//                i++;
//                MultipartFile file = mr.getFile((String) it.next());
//                if (file != null) {
//                    String fileName = file.getOriginalFilename();
//                    System.out.println(fileName);
//                    String currentFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
//                    /**构建图片保存的目录**/
//                    String logoPathDir = "../resources/upload/" + currentFileName;
//                    /**得到图片保存目录的真实路径**/
//                    String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
//                    System.out.println(logoRealPathDir);
//                    File localFile = new File(logoRealPathDir);
//                    //写文件到本地
//                    file.transferTo(localFile);
//                    model.addAttribute(fileName,logoRealPathDir);
//                    System.out.println(fileName);
//                }
//            }
//        }
//        return model;
//    }

//    @RequestMapping("filesUpload")
//    public String filesUpload( DefaultMultipartHttpServletRequest multipartRequest) {
//        if (multipartRequest != null) {
//            Iterator iterator = multipartRequest.getFileNames();
//            while (iterator.hasNext()) {
//                MultipartFile multifile = multipartRequest.getFile((String) iterator.next());
//                saveFile(multifile);
//            }
//        }
//        // 重定向
//        return "redirect:/list.html";
//    }
//
//    /***
//     * 保存文件
//     * @param file
//     * @return
//     */
//    private boolean saveFile(MultipartFile file) {
//        // 判断文件是否为空
//        if (!file.isEmpty()) {
//            try {
//                // 文件保存路径
//                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
//                        + file.getOriginalFilename();
//                // 转存文件
//                file.transferTo(new File(filePath));
//                return true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    /***
//     * 读取上传文件中得所有文件并返回
//     *
//     * @return
//     */
//    @RequestMapping("list")
//    public ModelAndView list() {
//        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
//        ModelAndView mav = new ModelAndView("list");
//        File uploadDest = new File(filePath);
//        String[] fileNames = uploadDest.list();
//        for (int i = 0; i < fileNames.length; i++) {
//            System.out.println(fileNames[i]);
//        }
//        return mav;
//    }

    @RequestMapping("/getApply")
    public void getApplyInfo(){
//        Apply apply = request.getParameter("applyData");
        ApplyService applyService = new ApplyServiceImpl();
        applyService.addApply();
    }
}
