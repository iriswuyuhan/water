package com.water.service.Impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/7/19.
 */
public class uploadVideo {
    /**
     * 模拟form表单的形式 ，上传文件 以输出流的形式把文件写入到url中，然后用输入流来获取url的响应
     * @param url 请求地址 form表单url地址
     * @param filePath 文件在服务器保存路径
     * @param title 视频标题
     * @param introduction  视频描述
     * @return
     */
    public static String postFile(String url, String filePath,String title,String introduction) {
        File file = new File(filePath);
        if(!file.exists()) {
            return null;
        }
        String result = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            String boundary = "-----------------------------"+System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);

            OutputStream output = conn.getOutputStream();
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName()).getBytes());
            output.write("Content-Type: video/mp4 \r\n\r\n".getBytes());
            byte[] data = new byte[1024];
            int len =0;
            FileInputStream input = new FileInputStream(file);
            while((len=input.read(data))>-1){
                output.write(data, 0, len);
            }
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes());
            output.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}",title,introduction).getBytes());
            output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
            output.flush();
            output.close();
            input.close();
            InputStream resp = conn.getInputStream();
            StringBuffer sb = new StringBuffer();
            while((len= resp.read(data))>-1)
                sb.append(new String(data,0,len,"utf-8"));
            resp.close();
            result = sb.toString();
            System.out.println(result);
        } catch (ClientProtocolException e) {
            System.out.println("postFile，不支持http协议");
        } catch (IOException e) {
            System.out.println("postFile数据传输失败");
        }
        return result;
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

    public static void main(String[] args) {
        String accesstoken = getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="
                + accesstoken + "&type=video";
        postFile(url, "/Users/jlusoft/Desktop/test.mp4","test","dfd");
    }
}
