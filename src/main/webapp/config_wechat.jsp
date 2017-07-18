<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/17
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>config wechat</title>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body>
<script>
    wx.config({
        debug: false,
        appId: '${appid}',
        timestamp: '${timestamp}',
        nonceStr: '${nonceStr}',
        signature: '${signature}',
        jsApiList: ['checkJsApi', 'openLocation', 'getLocation']
    });
    wx.ready(function () {
        wx.checkJsApi({
            jsApiList: [
                'openLocation', 'getLocation'
            ],
            success: function (res) {
                alert(JSON.stringify(res));
            }
        });
        //获得地理位置
        wx.getLocation({
            type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
            success: function (res) {
                var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                var speed = res.speed; // 速度，以米/每秒计
                var accuracy = res.accuracy; // 位置精度
                alert("latitude="+latitude+", longitude="+longitude+", speed="+speed+", accuracy="+accuracy+";");
            }
        });
    });
    wx.error(function (res) {
        alert(res.errMsg);
    });
</script>
</body>
</html>
