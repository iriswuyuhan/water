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
                'checkJsApi',
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo',
                'hideMenuItems',
                'showMenuItems',
                'hideAllNonBaseMenuItem',
                'showAllNonBaseMenuItem',
                'translateVoice',
                'startRecord',
                'stopRecord',
                'onRecordEnd',
                'playVoice',
                'pauseVoice',
                'stopVoice',
                'uploadVoice',
                'downloadVoice',
                'chooseImage',
                'previewImage',
                'uploadImage',
                'downloadImage',
                'getNetworkType',
                'openLocation',
                'getLocation',
                'hideOptionMenu',
                'showOptionMenu',
                'closeWindow',
                'scanQRCode',
                'chooseWXPay',
                'openProductSpecificView',
                'addCard',
                'chooseCard',
                'openCard'
            ],
            success: function (res) {
                alert(JSON.stringify(res));
            }
        });
    });
    wx.error(function (res) {
        alert(res.errMsg);
    });
</script>
</body>
</html>
