<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>申请采样设备</title>
    <!-- WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script type="text/javascript" src="../resources/js/Apply.js"></script>
</head>
<body>
<div class="weui-cells">
    <a class="weui-cell weui-cell_access" id="chooseRiver" href="javascript:;">
        <div class="weui-cell_hd">
            <p>水域地址</p>
        </div>&nbsp;&nbsp;&nbsp;
        <div class="weui-cell__bd">
            <input class="weui-input" id="river_place" name="river_place" placeholder="选择水域地址" value="${river_place}">
        </div>
        <div class="weui-cell__ft">
        </div>
    </a>
    <a class="weui-cell weui-cell_access" id="chooseAddress" href="javascript:;">
        <div class="weui-cell__hd"><img src="../resources/img/position.png" alt="收货地址" style="width:20px;margin-right:5px;display:block"></div>
        &nbsp;
        <div class="weui-cell__bd">
            <span class="name" name="name">收货人：</span>
            <span id="#apply_userName">${userName}</span>
            <span id="apply_userContact" class="contact" name="contact">${contact}</span>
            <p name="address">收货地址:<span id="apply_address">${address}</span></p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
</div>

<div class="weui-cells__title">上传图片</div>
<div class="weui-cells weui_cells_form">
    <div class="weui-cell">
        <div class="weui_cell_bd weui_cell_primary">
            <div class="weui_uploader">
                <div class="weui_uploader_bd">
                    <form id="imageForm" action="/imagesUpload" method="post" enctype="multipart/form-data">
                        <label>选择您要上传的图片：</label>
                        <div id="newUpload">
                            <input type="file" name="image" accept="image/jpeg,image/png,image/gif"><br/>
                        </div>
                        <input type="button" id="btn_add" value="增加一行">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<input type="button" id="applyUpload" value="提交">

</body>
<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script type="text/javascript" src="../resources/js/Apply.js"></script>
</html>