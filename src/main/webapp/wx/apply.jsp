<%@ page import="com.water.entity.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  ArrayList<Project> arrayList=(ArrayList)request.getAttribute("projectArray"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>申请采样设备</title>
    <!-- WeUI -->
    <link rel="stylesheet" href="https://weui.io/weui.css">
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script type="text/javascript" src="../resources/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-form.js"></script>

    <style type="text/css">
        body{
            font-size:18px;
        }
        .z_photo {
            width: 100%;
            height:auto;
            padding: 0.5rem;
            clear: both;
            margin-left: auto;
            margin-bottom: 2rem;
            margin-right: auto;
        }

        .z_photo img {
            width: 2rem;
            height: 2rem;
        }

        .z_addImg {
            float: left;
            margin-right: 0.2rem;
        }

        .z_file {
            width: 2rem;
            height: 2rem;
            background: url(../resources/img/z_add.png) no-repeat;
            background-size: 100% 100%;
            float: left;
            margin-right: 0.2rem;
        }

        .z_file input::-webkit-file-upload-button {
            width: 2rem;
            height: 2rem;
            border: none;
            position: absolute;
            outline: 0;
            opacity: 0;
        }

        .z_file input#file {
            display: block;
            width: auto;
            border: 0;
            vertical-align: middle;
        }

    </style>

    <script type="text/javascript">
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
            var url = window.location.href;
            var param = split(url);
            var name = document.getElementById("name");
            var contact = document.getElementById("contact");
            var add = document.getElementById("add");
            var useCook = $.cookie('ret2');
            if (useCook == '1') {
                name.innerHTML=$.cookie('name');
                contact.innerHTML=$.cookie('tel');
                add.innerHTML = $.cookie('add2');
            }
            var useCook1 = $.cookie('ret3');
            if (useCook1 == '1') {
                $("#longitude").val($.cookie('longitude'));
                $("#latitude").val($.cookie('latitude'));
                $("#river_place").text($.cookie('concrete_address'));
            }
            else if (param != null && param.length == 3) {
                name.innerHTML = decodeURI(param[0]);
                contact.innerHTML = param[1];
                add.innerHTML = decodeURI(param[2]);
            }
            var useCook2 = $.cookie('ret4');
            if(useCook2 == '1'){
                if($.cookie('projectName') == "undefined"){
                    $("#projectName").text("选择项目");
                }else{
                    $("#projectName").text($.cookie('projectName'));
                }
            }
        }

    </script>
</head>
<body>
<input type="hidden" id="userID" value="${userID}"/>
<input type="hidden" id="longitude"/>
<input type="hidden" id="latitude"/>
<input type="hidden" id="projectID"/>
<input type="hidden" id="url"/>
<br>

<div class="page__bd page__bd_spacing">
    <a href="javascript:;" class="weui-btn weui-btn_default" id="chooseProject"><span id="projectName">选择项目</span></a>
</div>

<div class="weui-cells weui-cells_vcode" id="chooseRiver" onclick="onClickWaterAddr()" href="javascript:;">
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">水域地址</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-input" id="river_place" name="river_place" value="">请选择水域地址</label>
        </div>
        <div class="weui-cell__ft" img>
            <img src="../resources/img/rightArrow2.png" style="width:10px;margin-left:5px;margin-right: 5px;">
        </div>
    </div>
</div>

<div class="weui-cells weui-cells_vcode" id="chooseAddress" href="javascript:;">
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <img src="../resources/img/position.png" alt="icon" style="width:20px;margin-left:5px;margin-right: 5px;display:block">
        </div>&nbsp;
        <div class="weui-cell__bd" onclick=resetInfo()>
            <span>收货人：</span>
            <span id="name">${userName}</span><br>
            <span>联系电话：</span>
            <span id="contact">${contact}</span>
            <p name="address">收货地址：<span id="add">${address}</span></p>
        </div>
        <div class="weui-cell__ft" img>
            <img src="../resources/img/rightArrow2.png" style="width:10px;margin-left:5px;margin-right: 5px;">
        </div>
    </div>
</div>

<div class="weui-cells__title">上传图片</div>
<div class="container">
    <!--    照片添加    -->
    <div class="z_photo">
        <form id="imageForm" action="../uploadImg" class="z_file" method="post" enctype="multipart/form-data">
            <input type="file" class="image" name="image" id="file" value="" accept="image/*" multiple onchange="imgChange('z_photo','z_file');" />
            <input type="hidden" id="applyDate" name="applyDate">
            <input type="hidden" id="img_userID" name="img_userID">
        </form>
    </div>

    <div id="z_mask" style="display: none;">
        <div class="weui-mask"></div>
        <div class="weui-dialog" id="z_alert">
            <div class="weui-dialog__hd"><strong class="weui-dialog__title">删除当前图片</strong></div>
            <div class="weui-dialog__ft">
                <a href="javascript:;" id="z_cancel" class="weui-dialog__btn weui-dialog__btn_default">取消</a>
                <a href="javascript:;" id="z_sure" class="weui-dialog__btn weui-dialog__btn_primary">确定</a>
            </div>
        </div>
    </div>

</div>
<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>

<a href="javascript:;" id="applyUpload" class="weui-btn weui-btn_plain-primary" style="width:90%;">提交</a>

</body>
<script type="text/javascript" src="../resources/js/split.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        load();

        if($("#projectName").text() != "选择项目"){
            var name = $("#projectName").text();
            <%for(int i=0;i<arrayList.size();i++){%>
            if('<%=arrayList.get(i).getName()%>' == name){
                $("#projectID").val('<%=arrayList.get(i).getIdProject()%>');
            }
            <%}%>
        }
    })

    var basePath='<%=basePath%>';
    var project = [
        <%for(int i=0;i<arrayList.size();i++){%>
        {
            "label": '<%=arrayList.get(i).getName()%>',
            "value": '<%=i%>',
        },
        <%}%>
    ]

    $("#chooseProject").on('click', function () {
        weui.picker(project, {
            onConfirm: function (result) {
                var label = project[result].label;
                $("#projectName").text(label);
                <%for(int i=0;i<arrayList.size();i++){%>
                    if('<%=arrayList.get(i).getName()%>' == label){
                        $("#projectID").val('<%=arrayList.get(i).getIdProject()%>');
                    }
                <%}%>
                set(label);
            }
        });
    });

    function set(projectName){
        $.cookie('ret4','1',{path:'/'});
        $.cookie('projectName',projectName,{path:'/'});
    }

    //px转换为rem
    (function(doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function() {
                var clientWidth = docEl.clientWidth;
                if (!clientWidth) return;
                if (clientWidth >= 640) {
                    docEl.style.fontSize = '20px';
                } else {
                    docEl.style.fontSize = 100 * (clientWidth / 640) + 'px';
                }
            };

        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);

    function imgChange(obj1, obj2) {
        var idUser = $("#userID").val();
        var date = new Date();
        var applyDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        var applyDateStr=date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + "-" + date.getMinutes() + "-" + date.getSeconds();
        $("#applyDate").val(applyDate);
        $("#img_userID").val(idUser);
        $("#url").val($("#url").val() + idUser + "_" + applyDateStr + ".jpg;");

        $("#imageForm").ajaxSubmit({
            url : "../uploadImg", // 请求的url
            type : "post", // 请求方式
            data: {},
            dataType: "json",
            async :true, // 异步
            success: function (data) {
                var imgContainer = document.getElementsByClassName(obj1)[0];
                //文本框的父级元素
                var input = document.getElementsByClassName(obj2)[0];
                //遍历获取到得图片文件
                var imgUrl = "http://106.14.185.185/web_upload/"+$("#img_userID").val()+"_"+applyDateStr+".jpg";
                var img = document.createElement("img");
                img.setAttribute("src", imgUrl);
                var imgAdd = document.createElement("div");
                imgAdd.setAttribute("class", "z_addImg");
                imgAdd.appendChild(img);
                imgContainer.appendChild(imgAdd);
            },
            error : function(){
                alert("fail");
            }
        });

        $(document).ready(function () {
            $("#imageForm").ajaxForm({
                url : "../uploadImg", // 请求的url
                type : "post", // 请求方式
                data: {},
                dataType: "json",
                async :true, // 异步
                success : function(data){
                    alert(data);
                },
                error : function(data){
                    alert("数据加载失败！");
                }
            });

        });

    };

</script>
<script type="text/javascript" src="../resources/js/Apply.js"></script>
</html>