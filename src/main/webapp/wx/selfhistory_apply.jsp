<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>采样申请详细信息</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <!--<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>-->
    <script type="text/javascript" src="/resources/PhotoSwipe-master/klass.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/PhotoSwipe-master/jquery-1.8.2.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="/resources/PhotoSwipe-master/code.photoswipe-3.0.5.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/PhotoSwipe-master/jquery.transit.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/PhotoSwipe-master/hammer.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/PhotoSwipe-master/jquery.hammer.js"></script>

    <link href="/resources/PhotoSwipe-master/styles.css" type="text/css" rel="stylesheet"/>
    <link href="/resources/PhotoSwipe-master/photoswipe.css" type="text/css" rel="stylesheet"/>
</head>
<body style="background-color: white">
<input type="hidden" id="userID" value="${userID}"/>
<input type="hidden" id="index" value="${index}"/>
<input type="hidden" id="applyID" value="${applyID}"/>
<div class="uploaded-imgs">
    <div class="weui-cells__title">已传图片</div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <div class="weui-uploader__bd">
                    <ul class="weui-uploader__files" id="Gallery">
                        <%
                        ArrayList<String> imageArray=(ArrayList<String>) request.getAttribute("imageArray");
                        for(int i=0;i<imageArray.size();i++){
                        String imagePath=imageArray.get(i);
                        %>
                        <li class="uploaded-img weui-uploader__file">
                            <a href="<%=imagePath%>">
                                <img style="width: 80px;height: 80px" src="<%=imagePath%>"
                                     alt="Image 01"/></a>
                        </li>
                        <%}%>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="weui-form-preview">
    <div class="weui-form-preview__bd">
        <p>
            <label class="weui-form-preview__label">审核状态</label>
            <%
                int state=(Integer) request.getAttribute("state");
                if(state==0){%>
            <span class="weui-form-preview__value" style="color: black">未审核</span>
            <%}else if(state==1){%>
            <span class="weui-form-preview__value" style="color: green">已通过（材料已寄出）</span>
            <%}else if(state==2){%>
            <span class="weui-form-preview__value" style="color: red">已拒绝</span>
            <%}%>
        </p>
        <%if(state==1||state==2){%>
        <p>
            <label class="weui-form-preview__label">审核反馈</label>
            <span class="weui-form-preview__value" style="color: black">${response}</span>
        </p>
        <%}%>
        <p>
            <label class="weui-form-preview__label">所属项目</label>
            <span class="weui-form-preview__value"style="color: black">${project}</span>
        </p>
        <p>
            <label class="weui-form-preview__label">水域地址</label>
            <span class="weui-form-preview__value">${waterAddress}</span>
        </p>
        <p>
            <label class="weui-form-preview__label">采样位置</label>
            <span class="weui-form-preview__value">${latitude}, ${longitude}</span>
        </p>
        <p>
            <label class="weui-form-preview__label">申请时间</label>
            <em class="weui-form-preview__value">${applyDate}</em>
        </p>
        <p>
            <label class="weui-form-preview__label">名字</label>
            <span class="weui-form-preview__value">${name}</span>
        </p>
        <p>
            <label class="weui-form-preview__label">联系方式</label>
            <em class="weui-form-preview__value">${phoneNum}</em>
        </p>
        <p>
            <label class="weui-form-preview__label">收货地址</label>
            <span class="weui-form-preview__value">${address}</span>
        </p>
    </div>
    <div class="weui-form-preview__ft">
        <a onclick="window.location.href='/user/j'+userID+'/history'" class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:">返回</a>
    </div>
    <%if(state==0){%>
    <a onclick="deleteApply()" href="javascript:;" class="weui-btn weui-btn_warn">删除</a>
    <%}else if(state==1){%>
    <a onclick="uploadSample()" href="javascript:;" class="weui-btn weui-btn_primary">上传采样信息</a>
    <%}%>
</div>
<!--toast-->
<div id="toast" style="display: none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-icon-success-no-circle weui-icon_toast"></i>
        <p class="weui-toast__content">已删除</p>
    </div>
</div>
</body>
<script>
    var userID=$("#userID").val();
    function deleteApply() {
        var index=$("#index").val();
         $.ajax({
             url:"/user/j"+userID+"/history/apply/delete",
             type:'get',
             async:false,
             data:{"index":index},
             success:function (data) {
                 if(data){
                     // toast
                     var $toast = $('#toast');
                     if ($toast.css('display') != 'none') return;
                     $toast.fadeIn(100);
                     setTimeout(function () {
                         $toast.fadeOut(100);
                         window.location.href="/user/j"+userID+"/history";
                     }, 2000);
                 }
             }
         });
    }

    function uploadSample() {
        var applyID=$("#applyID").val();
        window.location.href="/upload/j"+applyID;
    }
    //图片预览
    (function (window, PhotoSwipe) {
        document.addEventListener('DOMContentLoaded', function () {
            var options = {
                    fullscreenEl: false,
                    //点击图片关闭
                    tapToClose: true,
                },
                instance = PhotoSwipe.attach(window.document.querySelectorAll('#Gallery a'), options);
        }, false);
    }(window, window.Code.PhotoSwipe));
</script>
</html>