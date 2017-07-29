<%@ page import="com.water.entity.Project" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>

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
        }

    </script>
</head>
<body onload=load()>
<input type="hidden" id="userID" value="${userID}"/>
<input type="hidden" id="longitude"/>
<input type="hidden" id="latitude"/>
<input type="hidden" id="projectID"/>
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
            <span id="name">${userName}</span>
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
<div class="weui-cells weui_cells_form">
    <div class="weui-cell">
        <div class="weui_cell_bd weui_cell_primary">
            <div class="weui_uploader">
                <div class="weui_uploader_bd">
                    <form id="imageForm" action="/uploadImg" method="post" enctype="multipart/form-data">
                        <label>选择您要上传的图片：</label>
                        <div id="newUpload">
                            <input type="file" id="file_0" class="image" name="image" accept="image/jpeg,image/png,image/gif" multiple/><br/>
                        </div>
                        <%--<input type="button" id="btn_add" value="增加一行">--%>
                        <input type="hidden" id="applyDate" name="applyDate">
                        <input type="hidden" id="img_userID" name="img_userID">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>

<div id="imgPreview" style="width:100%;height:100px;overflow:auto;">
    <%--<img id="pre_0" src="" style="width: 100px;height: 100px;"/>--%>
    <%--<img id="pre_1" src="" style="width: 100px;height: 100px;"/>--%>
</div>
<br><br>
<a href="javascript:;" id="applyUpload" class="weui-btn weui-btn_plain-primary" style="width:90%;">提交</a>

</body>
<script type="text/javascript" src="../resources/js/split.js"></script>
<script type="text/javascript">
    var basePath='<%=basePath%>';
    var project = [
        <% ArrayList<Project> arrayList=(ArrayList)request.getAttribute("projectArray");
        for(int i=0;i<arrayList.size();i++){%>
        {
            "label": '<%=arrayList.get(i).getName()%>',
            "value": <%=arrayList.get(i).getIdProject()-1%>
        },
        <%}%>
    ]

    $("#chooseProject").on('click', function () {
        weui.picker(project, {
            onConfirm: function (result) {
                $("#projectID").val(result);
                var projectID = $("#projectID").val();
                var label = project[projectID].label;
                $("#projectName").html(label);
            }
        });
    });

</script>
<script type="text/javascript" src="../resources/js/Apply.js"></script>
</html>