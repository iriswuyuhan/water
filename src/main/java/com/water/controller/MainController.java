package com.water.controller;


//import com.water.entity.User;
//import com.water.service.UserService;
import com.water.model.ApplyEntity;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 * Created by bxh on 2017/7/14.
 */
@Controller
public class MainController {
    //测试
    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "saveApply", method = RequestMethod.GET)
    @ResponseBody
    public String saveApply(){
        applyService.saveApply();
        return "success!";
    }

/*    @RequestMapping(value = "saveUser2")
    @ResponseBody
    public Object saveUser2(String Id, String Password,String Name,String TelephoneNumber, String HomeAddress,String PostCode) {
//        Long userId = userService.saveUser(Id,Password,Name,TelephoneNumber,HomeAddress,PostCode);
        JSONObject obj = new JSONObject();
//        if (userId != null && userId > 0) {
//            obj.put("result", 1);
//            obj.put("obj", userId);
//        } else {
//            obj.put("result", 0);
//        }

        return obj;
    }

    @RequestMapping(value = "getUser")
    @ResponseBody
    public Object getUser(long id) {
//        User user = userService.getById(id);
        JSONObject obj = new JSONObject();
//        if (user != null) {
//            obj.put("result", 1);
//            obj.put("obj", user);
//        } else {
//            obj.put("result", 0);
//        }
        return obj;
    }*/
    /**
     * @param request
     * @param response
     * @return 登录验证
     * @throws Exception
     */
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }
    @RequestMapping(value="/toAdmin.do")
    public String toAdmin() throws IOException{
        return "Admin_Work";
    }

}