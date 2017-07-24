package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dell on 2017/7/16.
 */
@Controller
public class ConnectController {
    private String token="noahsark";

    @RequestMapping(value = "wx", method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request){
//        String signature=request.getParameter("signature");
//        String timestamp=request.getParameter("timestamp");
//        String nonce=request.getParameter("nonce");
//        String echstr=request.getParameter("echostr");
//
//        if(SignUtil.validSign(signature,token,timestamp,nonce)){
//            return echstr;
//        }
//        return "error";
        return "hello world";
    }
}
