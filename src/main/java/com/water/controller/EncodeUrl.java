package com.water.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodeUrl {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode= URLEncoder.encode("http://wx.softlollipop.cn/history.html","utf-8");
        System.out.println(encode);
    }
}
