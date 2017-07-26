package com.water.controller;

import com.water.entity.User;
import com.water.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class LoginProcessor {
    private final String appid="wx2014311796d1a614";
    private final String appSecret="5259ea60a8084e00eb12d78d03fcd28d";

    private String getOpenId(String code) throws IOException {

//        String code=request.getParameter("code");

        if(null!=code&&!"".equalsIgnoreCase(code)){
            StringBuffer jsonInfo=new StringBuffer();
            String urlStr="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+
                    appid+"&secret=" +appSecret+ "&code="+code+"&grant_type=authorization_code";
            URL url=new URL(urlStr);

            URLConnection connection=url.openConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    "utf-8"));

            String input="";
            while((input=br.readLine())!=null){
                jsonInfo.append(input);
            }

            br.close();

            JSONObject object=JSONObject.fromObject(jsonInfo.toString());
            String openId=object.getString("openid");

            return openId;
        }
        return null;
    }
}
