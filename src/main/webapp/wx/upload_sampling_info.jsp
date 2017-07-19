<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传采样信息</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script src="//cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <!--<script src="//cdn.bootcss.com/jquery-weui/1.0.1/js/jquery-weui.min.js"></script>-->
    <script type="text/javascript" src="../resources/PhotoSwipe-master/klass.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../resources/PhotoSwipe-master/jquery-1.8.2.js"></script>
    <script type="text/javascript" charset="utf-8" src="../resources/PhotoSwipe-master/code.photoswipe-3.0.5.js"></script>
    <script type="text/javascript" charset="utf-8" src="../resources/PhotoSwipe-master/jquery.transit.js"></script>
    <script type="text/javascript" charset="utf-8" src="../resources/PhotoSwipe-master/hammer.js"></script>
    <script type="text/javascript" charset="utf-8" src="../resources/PhotoSwipe-master/jquery.hammer.js"></script>

    <link href="../resources/PhotoSwipe-master/styles.css" type="text/css" rel="stylesheet" />
    <link href="../resources/PhotoSwipe-master/photoswipe.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="../resources/css/upload_sampling_info.css"/>
</head>
<body style="background-color: white">
<div class="uploaded-imgs">
    <div class="weui-cells__title">已传图片</div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <div class="weui-uploader__bd">
                    <ul class="weui-uploader__files" id="Gallery">
                        <li class="uploaded-img weui-uploader__file">
                            <a href="../resources/img/backimg.png">
                                <img style="width: 80px;height: 80px" src="../resources/img/backimg.png" alt="Image 01" /></a>
                        </li>
                        <li class="uploaded-img weui-uploader__file">
                            <a href="../resources/img/backimg.png">
                                <img style="width: 80px;height: 80px" src="../resources/img/backimg.png" alt="Image 02" /></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="weui-form-preview">
    <div class="weui-form-preview__bd">
        <p>
            <label class="weui-form-preview__label">采样地点名称</label>
            <span class="weui-form-preview__value">九乡河</span>
        </p>
        <p>
            <label class="weui-form-preview__label">采样位置</label>
            <span class="weui-form-preview__value">北纬xx度</span>
        </p>
    </div>
</div>
<div class="fill-in-info">
    <div class="weui-cells__title">补充信息</div>
    <div class="weui-cells">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">采样时间</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="datetime-local" value="" placeholder=""/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">采样体积</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" pattern="[0-9]*" placeholder="采样体积"/>
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">采样编号</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" pattern="[0-9]*" placeholder="采样编号"/>
            </div>
        </div>
    </div>
    <div class="weui-cells__title">采样备注</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea class="weui-textarea" placeholder="请输入文本" rows="3"></textarea>
                <div class="weui-textarea-counter"><span>0</span>/200</div>
            </div>
        </div>
    </div>
</div>
<p style="padding-top: 15px;">
    <a style="line-height: 38px;width: 85%;align-self: center" href="javascript:;" class="weui-btn weui-btn_plain-primary">上传</a>
</p>
</body>
<script>
    //图片预览
(function(window, PhotoSwipe){
    document.addEventListener('DOMContentLoaded', function(){
        var options = {
                fullscreenEl : false,
                //点击图片关闭
                tapToClose: true,
            },
            instance = PhotoSwipe.attach( window.document.querySelectorAll('#Gallery a'), options );
    }, false);
}(window, window.Code.PhotoSwipe));
</script>
</html>