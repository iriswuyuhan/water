<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>申请采样设备</title>
    <!-- WeUI -->
    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>
    <!--<script>-->
    <!--alert(document.referrer);-->
    <!--var url=document.referrer.split("?");-->
    <!--window.open(url[0]);-->
    <!--</script>-->
    <script type="text/javascript" src="../resources/js/split.js"></script>
    <script type="text/javascript" src="../resources/js/Apply.js"></script>
    <!--<script type="text/javascript" src="split.js"></script>-->
    <script>
        $(function () {
            var isPageHide = false;
            window.addEventListener('pageshow', function () {
                if (isPageHide) {
                    window.location.reload();
                }
            });
            window.addEventListener('pagehide', function () {
                isPageHide = true;
            });
        });
        function resetInfo(){
            var name=encodeURI(document.getElementById("name").innerHTML);
            var contact=document.getElementById("contact").innerHTML;
            var add=encodeURI(document.getElementById("add").innerHTML);
//            window.close();
            window.location.href="../wx/confirmReciptInfo.html?name="+name+"&contact="+contact+"&add="+add;
        }
        function load(){
            alert(123);
            var url = window.location.href;
            var param = split(url);
            var name = document.getElementById("name");
            var contact = document.getElementById("contact");
            var add = document.getElementById("add");
            var useCook = $.cookie('ret2');
            if (useCook == '1') {
                alert('b');
                name.innerHTML=$.cookie('name');
                contact.innerHTML=$.cookie('tel');
                add.innerHTML = $.cookie('add2');
                $.cookie('ret2', null);
                $.cookie('name',null);
                $.cookie('tel',null);
                $.cookie('add2', null);
            }
            var useCook1 = $.cookie('ret3');
            if (useCook1 == '1') {
                $("#longitude").val($.cookie('longitude'));
                $("#latitude").val($.cookie('latitude'));
                $("#river_place").text($.cookie('concrete_address'));
                $.cookie('ret3', null);
                $.cookie('longitude',null);
                $.cookie('latitude',null);
                $.cookie('concrete_address', null);
            }
            else if (param != null && param.length == 3) {
                name.innerHTML = decodeURI(param[0]);
                contact.innerHTML = param[1];
                add.innerHTML = decodeURI(param[2]);
            }

        }
    </script>
</head>
<body onload=load()>
<input type="hidden" id="longitude"/>
<input type="hidden" id="latitude"/>
<form>
    <br>
    <hr/>
    <div class="weui-cells weui-cells_vcode" id="chooseRiver" onclick="onClickWaterAddr()" href="javascript:;">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">水域地址</label>
            </div>
            <div class="weui-cell__bd">
                <label class="weui-input" id="river_place" name="river_place" value="">请输入水域地址</label>
            </div>
        </div>
    </div>

    <div class="weui-cells weui-cells_vcode" id="chooseAddress" href="javascript:;">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <img src="../resources/img/position.png" alt="icon" style="width:20px;margin-left:5px;margin-right: 5px;display:block">
            </div>
            <div class="weui-cell__bd" onclick=resetInfo()>
                <span>收货人：</span>
                <span id="name">${userName}</span>
                <span>联系电话：</span>
                <span id="contact">${contact}</span>
                <p name="address">收货地址：<span id="add">${address}</span></p>
                <!--<a href="locate.html">收获地址:江苏省南京市栖霞区仙林街道南京大学仙林校区基础实验楼</a>-->
            </div>
        </div>
    </div>

    <div class="weui-cells__title">上传图片</div>
    <div class="weui-cells weui_cells_form">
        <div class="weui-cell">
            <div class="weui_cell_bd weui_cell_primary">
                <div class="weui_uploader">
                    <div class="weui_uploader_bd">
                        <form id="imageForm" action="/applyUpload" method="post" enctype="multipart/form-data">
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
</form>
<input type="button" id="applyUpload" value="提交">

</body>
<script type="text/javascript" src="../resources/js/Apply.js"></script>
</html>