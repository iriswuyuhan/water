<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta id="viewport" name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>申请采样设备</title>
    <!-- WeUI -->
    <link rel="stylesheet" href="https://weui.io/weui.css">
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-form.js"></script>
    <style type="text/css">
        body {
            font-size: 18px;
        }

        .z_photo {
            width: 100%;
            height: auto;
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
</head>
<body>
<div class="weui-cells__title">上传图片</div>
<div class="container">
    <!--    照片添加    -->
    <div class="z_photo">
        <form id="imageForm" action="../uploadImg" class="z_file" method="post" enctype="multipart/form-data">
            <input type="file" class="image" name="image" id="file" value="" accept="image/*"
                   onchange="imgChange('z_photo','z_file');"/>
            <input type="hidden" id="applyDate" name="applyDate">
            <input type="hidden" id="img_userID" name="img_userID">
        </form>
    </div>

</div>
</body>
<script type="text/javascript">
    //px转换为rem
    (function (doc, win) {
        var docEl = doc.documentElement,
            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function () {
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
        var date = new Date();
        var applyDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
        var applyDateStr=date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + "-" + date.getMinutes();
        $("#applyDate").val(applyDate);
        $("#img_userID").val(1);
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
                var imgUrl = "http://118.89.166.19/web_upload/"+$("#img_userID").val()+"_"+applyDateStr+".jpg";
                alert(imgUrl);
                var img = document.createElement("img");
                img.setAttribute("src", imgUrl);
                var imgAdd = document.createElement("div");
                imgAdd.setAttribute("class", "z_addImg");
                imgAdd.appendChild(img);
                imgContainer.appendChild(imgAdd);
            },
            error : function(){

            }
        });

    };
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

</script>
</html>