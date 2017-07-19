<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>确认地址</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <!--引用百度地图API-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="百度地图,百度地图API，百度地图自定义工具，百度地图所见即所得工具" />
    <meta name="description" content="百度地图API自定义地图，帮助用户在可视化操作下生成百度地图" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=X6CxGSyvVtNop7RGgaVAGtyWzM4xpYiG"></script>

</head>
<body>
<div id="map" style="width:100%;height:450px;border:#ccc solid 1px;font-size:12px"></div>
<div id="location_message">
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <img src="../resources/img/position.png" alt="" style="width:20px;margin-right:10px;display:block">
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" placeholder="地址" style="color:black;"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__bd" style="color: grey"><p>详细地址</p></div>
        </div>
    </div>
    <p style="padding-top: 10px;padding-bottom: 10px">
        <a style="width: 85%;align-self: center;line-height: 35px" href="javascript:;"
           class="weui-btn weui-btn_plain-primary">确定</a>
    </p>
</div>
</body>
<script src="../resources/js/confirm_address.js"></script>
</html>