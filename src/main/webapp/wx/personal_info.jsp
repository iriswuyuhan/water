<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>
</head>
<body onload="load()">
<input type="hidden" id="userID" value="${userID}"/>
<input type="hidden" id="next" value="${next}"/>
<div class="weui-cells">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label" style="color: grey">姓名</label></div>
        <div class="weui-cell__bd">
            <input id="name" class="weui-input" type="text" value="${name}" placeholder="姓名"/>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label" style="color: grey">联系方式</label></div>
        <div class="weui-cell__bd">
            <input id="phone_num" class="weui-input" type="number" value="${phone_num}" pattern="[0-9]*" placeholder=""/>
        </div>
    </div>
    <div class="weui-cell weui-cell_access" href="javascript:;" onclick="jump_to_receive_addr()">
        <div class="weui-cell__hd" style="display: block">
            <p style="color: grey">收货地址：</p>
        </div>
        <div class="weui-cell__bd">
            <p id="receive_addr" onclick="reLoc()">${address}</p>
        </div>
        <div class="weui-cell__ft">
        </div>
    </div>
</div>
<p style="padding-top: 15px">
    <a id="confirm" style="width: 85%;align-self: center" href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_primary">确认</a>
</p>
<!--toast-->
<div id="toast" style="display: none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-icon-success-no-circle weui-icon_toast"></i>
        <p class="weui-toast__content">已修改</p>
    </div>
</div>
</body>
<script src="<%=basePath%>resources/js/personal_info.js"></script>
</html>