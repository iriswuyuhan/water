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

    <style type="text/css">
        .z_photo {
            width: 100%;
            height:auto;
            padding: 0.5rem;
            clear: both;
            margin-left: auto;
            margin-bottom: 10rem;
            margin-right: auto;
        }

        .z_photo img {
            width: 8rem;
            height: 8rem;
        }

        .z_addImg {
            float: left;
            margin-right: 0.2rem;
        }

        .z_file {
            width: 8rem;
            height: 8rem;
            background: url(../resources/img/z_add.png) no-repeat;
            background-size: 100% 100%;
            float: left;
            margin-right: 0.2rem;
        }

        .z_file input::-webkit-file-upload-button {
            width: 8rem;
            height: 8rem;
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
        /*遮罩层*/

        .z_mask {
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, .5);
            position: fixed;
            top: 0;
            left: 0;
            z-index: 999;
            display: none;
        }

        .z_alert {
            width: 10rem;
            height: 5rem;
            border-radius: .2rem;
            background: #fff;
            font-size: 1rem;
            text-align: center;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -1.5rem;
            margin-top: -2rem;
        }

        .z_alert p:nth-child(1) {
            line-height: 1.5rem;
        }

        .z_alert p:nth-child(2) span {
            display: inline-block;
            width: 49%;
            height: .5rem;
            line-height: .5rem;
            float: left;
            border-top: 1px solid #ddd;
        }

        .z_cancel {
            border-right: 1px solid #ddd;
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

    <!--遮罩层-->
    <div class="z_mask">
        <!--弹出框-->
        <div class="z_alert">
            <p>确定要删除这张图片吗？</p>
            <p>
                <span class="z_cancel">取消</span>
                <span class="z_sure">确定</span>
            </p>
        </div>
    </div>
</div>
<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>

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
                alert(projectID);
                var label = project[projectID].label;
                $("#projectName").html(label);
            }
        });
    });

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
        //获取点击的文本框
        var file = document.getElementById("file");
        //存放图片的父级元素
        var imgContainer = document.getElementsByClassName(obj1)[0];
        //获取的图片文件
        var fileList = file.files;
        //文本框的父级元素
        var input = document.getElementsByClassName(obj2)[0];
        var imgArr = [];
        //遍历获取到得图片文件
        for (var i = 0; i < fileList.length; i++) {
            var imgUrl = window.URL.createObjectURL(file.files[i]);
            imgArr.push(imgUrl);
            var img = document.createElement("img");
            img.setAttribute("src", imgArr[i]);
            var imgAdd = document.createElement("div");
            imgAdd.setAttribute("class", "z_addImg");
            imgAdd.appendChild(img);
            imgContainer.appendChild(imgAdd);
        };
        imgRemove();
    };

    function imgRemove() {
        var imgList = document.getElementsByClassName("z_addImg");
        var mask = document.getElementsByClassName("z_mask")[0];
        var cancel = document.getElementsByClassName("z_cancel")[0];
        var sure = document.getElementsByClassName("z_sure")[0];
        for (var j = 0; j < imgList.length; j++) {
            imgList[j].index = j;
            imgList[j].onclick = function() {
                var t = this;
                mask.style.display = "block";
                cancel.onclick = function() {
                    mask.style.display = "none";
                };
                sure.onclick = function() {
                    mask.style.display = "none";
                    t.style.display = "none";
                };

            }
        };
    };

</script>
<script type="text/javascript" src="../resources/js/Apply.js"></script>
</html>