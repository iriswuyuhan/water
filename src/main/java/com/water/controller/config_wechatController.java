package com.water.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by lenovo on 2017/7/17.
 */
@Controller
@RequestMapping(value = "/config_wechat")
public class config_wechatController {

    @RequestMapping(value = "")
    public ModelAndView configWechat(HttpServletRequest request) {
        HttpSession session=request.getSession();
        //1、获取AccessToken
        String accessToken=null;
        if(session.getAttribute("access_token")==null||session.getAttribute("access_token").equals("")) {
            accessToken = getAccessToken();
            session.setAttribute("access_token",accessToken);
        }else{
            accessToken=(String)session.getAttribute("access_token");
        }
//        String accessToken="oFG-6X7HWf1jnp2Wr7QCM4c_FwzrDjBevH-G64MdLTh1Dv-seYySN4hSu8uBnS-xyad8w-gcavEAso7m0mGIT7VjSZs_EsfupeuFAis91NNKwAOETNQKqmhdzqwnOQ-HYZQcAJAMNE";
        //2、获取Ticket
        String jsapi_ticket =null;
        if(session.getAttribute("jsapi_ticket")==null||session.getAttribute("jsapi_ticket").equals("")) {
            jsapi_ticket =getTicket(accessToken);
            session.setAttribute("jsapi_ticket",jsapi_ticket);
        }else{
            jsapi_ticket=(String)session.getAttribute("jsapi_ticket");
        }
//        String jsapi_ticket ="HoagFKDcsGMVCIY2vOjf9vI8gcuU0ERPP5mYkCvNYPD3cWyp_acnTEpg0nWrzY2RH2LXzpfsMXHW6DZY22xwYg";
        String appid="wxe7e1893b40f0e63d";

        //3、时间戳和随机字符串
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳

        System.out.println("accessToken:"+accessToken+"\njsapi_ticket:"+jsapi_ticket+"\n时间戳："+timestamp+"\n随机字符串："+noncestr);

        //4、获取url
        String url = "";
        url = request.getScheme() +"://" + request.getServerName()
                + ":" +request.getServerPort()
                + request.getServletPath();
        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
//        String url="http://localhost:8080/wechat";
    /*根据JSSDK上面的规则进行计算，这里比较简单，我就手动写啦
    String[] ArrTmp = {"jsapi_ticket","timestamp","nonce","url"};
    Arrays.sort(ArrTmp);
    StringBuffer sf = new StringBuffer();
    for(int i=0;i<ArrTmp.length;i++){
        sf.append(ArrTmp[i]);
    }
    */

        //5、将参数排序并拼接字符串
        String str = "jsapi_ticket="+jsapi_ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;

        //6、将字符串进行sha1加密
        String signature =SHA1(str);
        System.out.println("参数："+str+"\n签名："+signature+"\n");
        ModelAndView modelAndView=new ModelAndView("../config_wechat");
//        modelAndView.addObject("appid","wx8d1a9ca47548f954");
        modelAndView.addObject("appid",appid);
        modelAndView.addObject("timestamp",timestamp);
        modelAndView.addObject("nonceStr",noncestr);
        modelAndView.addObject("signature",signature);
        return modelAndView;
    }

    public static String getAccessToken() {
        String access_token = "";
        String grant_type = "client_credential";//获取access_token填写client_credential
        //String AppId="wx51e1417b4ad8bcd4";//第三方用户唯一凭证
        //String secret="cf3d7ce15a9f67f36553fceb24eb9c8a ";//第三方用户唯一凭证密钥，即appsecret
//        String AppId="wx8d1a9ca47548f954";
        String AppId="wxe7e1893b40f0e63d";
//        String secret="19c5556b12c7fcf983dfadc134cb0c77";
        String secret="1bf7220efb7718a72a9b237097e4e2b1";
        //这个url链接地址和参数皆不能变
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.parseObject(message);
            System.out.println("JSON字符串："+demoJson);
            access_token = demoJson.getString("access_token");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public static String getTicket(String access_token) {
        String ticket = null;
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.parseObject(message);
            System.out.println("JSON字符串："+demoJson);
            ticket = demoJson.getString("ticket");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public static String SHA1(String decrypt) {
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decrypt.getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

