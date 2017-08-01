<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传采样信息</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <!--<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>-->
    <script type="text/javascript" src="<%=basePath%>resources/PhotoSwipe-master/klass.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/PhotoSwipe-master/jquery-1.8.2.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="<%=basePath%>resources/PhotoSwipe-master/code.photoswipe-3.0.5.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/PhotoSwipe-master/jquery.transit.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/PhotoSwipe-master/hammer.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/PhotoSwipe-master/jquery.hammer.js"></script>

    <link href="<%=basePath%>resources/PhotoSwipe-master/styles.css" type="text/css" rel="stylesheet"/>
    <link href="<%=basePath%>resources/PhotoSwipe-master/photoswipe.css" type="text/css" rel="stylesheet"/>
</head>
<body style="background-color: white">
<input type="hidden" id="sampleID" value="${applyID}"/>
<input type="hidden" id="userID" value="${userID}"/>
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
<!--申请采样的信息-->
<div class="weui-form-preview">
    <div class="weui-form-preview__bd">
        <p>
            <label class="weui-form-preview__label">采样地点名称</label>
            <span class="weui-form-preview__value">${waterAddress}</span>
        </p>
        <p>
            <label class="weui-form-preview__label">采样位置</label>
            <span class="weui-form-preview__value">${latitude}, ${longitude}</span>
        </p>
    </div>
</div>
<div class="fill-in-info">
    <form>
        <div class="weui-cells__title">补充信息</div>
        <div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">采样时间</label></div>
                <div class="weui-cell__bd">
                    <input id="sample_time" class="weui-input" type="datetime-local" required="true" value="${curTime}"
                           placeholder=""/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">采样体积</label></div>
                <div class="weui-cell__bd">
                    <input id="sample_volume" class="weui-input" type="number" required="true" pattern="[0-9]*"
                           placeholder="采样体积"/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">采样编号</label></div>
                <div class="weui-cell__bd">
                    <input id="sample_number" class="weui-input" type="number" pattern="[0-9]*" required="true"
                           placeholder="采样编号"/>
                </div>
            </div>
        </div>
        <div class="weui-cells__title">采样备注</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea id="sample_remark" class="weui-textarea" required="true" placeholder="请输入文本"
                              rows="3"></textarea>
                    <%--<div class="weui-textarea-counter"><span>0</span>/200</div>--%>
                </div>
            </div>
        </div>
    </form>
</div>
<p style="padding-top: 15px;margin-bottom: 5%">
    <a id="upload_but" style="line-height: 38px;width: 85%;align-self: center" href="javascript:;"
       class="weui-btn weui-btn_primary weui-btn_disabled">上传</a>
</p>
<!--toast-->
<div id="toast" style="display: none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-icon-success-no-circle weui-icon_toast"></i>
        <p class="weui-toast__content">上传成功</p>
    </div>
</div>
<!--alert-->
<div style="display: none;" id="alert">
    <div class="weui-mask"></div>
    <div class="weui-dialog">
        <div class="weui-dialog__hd"><strong class="weui-dialog__title">上传失败</strong></div>
        <div class="weui-dialog__bd">采样编号已存在</div>
        <div class="weui-dialog__ft">
            <a href="javascript:;" onclick="hideAlert()" class="weui-dialog__btn weui-dialog__btn_primary">确定</a>
        </div>
    </div>
</div>
</body>
<script>
    var basePath="<%=basePath%>";
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
<script src="<%=basePath%>resources/js/upload_sampling_info.js"></script>
</html>