<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>个人中心</title>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script src="<%=basePath%>resources/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<input type="hidden" id="userID" value="${userID}"/>
<input type="hidden" id="type" value="${type}"/>
<div style="height: 35px;width: 100%;background-color: ghostwhite;border-bottom: 1px gainsboro solid;padding-bottom: 1%">
    <img onclick="personal_info()" src="<%=basePath%>resources/img/user.png"
         style="float:right;width: 35px;padding-right:2%;padding-left:2%;border-left: 1px gainsboro solid"/>
    <label style="font-size: 19px;float: right;padding-right: 2%;padding-top: 5px">${userName}</label>
</div>
<div class="weui-tab">
    <div class="weui-navbar">
        <div id="unchecked_tab" onclick="on_unchecked_click()" class="weui-navbar__item weui-bar__item_on">
            待审核
        </div>
        <div id="checked_tab" onclick="on_checked_click()" class="weui-navbar__item">
            已审核
        </div>
        <div id="sampling_tab" onclick="on_sample_click()" class="weui-navbar__item">
            已采样
        </div>
    </div>
    <div class="weui-tab__panel">
        <div id="unchecked_tab_panel" style="display: none;margin-bottom: 5%">
        </div>
        <div id="checked_tab_panel" style="display: none;margin-bottom: 5%">
        </div>
        <div id="sampling_tab_panel" style="display: none;;margin-bottom: 5%">
        </div>
    </div>
</div>
<div id="dialog" style="display: none;">
    <div class="weui-mask"></div>
    <div class="weui-dialog">
        <div class="weui-dialog__hd"><strong class="weui-dialog__title">确认删除？</strong></div>
        <div class="weui-dialog__bd">您真的要删除该采样申请？</div>
        <div class="weui-dialog__ft">
            <a href="javascript:;" onclick="$('#dialog').hide()"
               class="weui-dialog__btn weui-dialog__btn_default">取消</a>
            <a href="javascript:;" onclick="confirmDelete()" class="weui-dialog__btn weui-dialog__btn_primary">删除</a>
        </div>
    </div>
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
<script src="<%=basePath%>resources/js/selfhistory.js"></script>
<script>
    $(document).ready(function(){
        var type=$("#type").val();
        if(type==0){
            on_unchecked_click();
        }else if(type==1){
            on_checked_click();
        }else if(type==2){
            on_sample_click();
        }
    });

    //加载未审核列表
    $.ajax({
        url: "history/getUnChecked",
        type: 'get',
        async: false,
        data: {},
        success: function (data) {
            var html = "";
            data.forEach(function (goods) {
                html += loadUnchecked(goods);
            });
            $("#unchecked_tab_panel").append(html);
            if(data.length==0){
                noItemTip($("#unchecked_tab_panel"));
            }
            $("#unchecked_tab_panel").append(
                "<div class='weui-form-preview'>" +
                "<div class='weui-form-preview__ft' style='margin-top: 5%'>"+
                "<a onclick='onAddApply()' class='weui-form-preview__btn weui-form-preview__btn_primary' href='javascript:'>" +
                "<img src='<%=basePath%>resources/img/addApply.png' width='25px' style='position:relative;top:5px'/>" +
                " 添加采样申请</a>"+
                "</div></div>");
        }
    });

    //加载已审核列表
    $.ajax({
        url: "history/getChecked",
        type: 'get',
        async: false,
        data: {},
        success: function (data) {
            var html = "";
            data.forEach(function (goods) {
                html += loadChecked(goods);
            });
            $("#checked_tab_panel").append(html);
            if(data.length===0){
                noItemTip($("#checked_tab_panel"));
            }
        }
    });

    //加载已采样列表
    $.ajax({
        url: "history/getSampling",
        type: 'get',
        async: false,
        data: {},
        success: function (data) {
            var html = "";
            data.forEach(function (goods) {
                html += loadSampling(goods);
            });
            $("#sampling_tab_panel").append(html);
            if(data.length===0){
                noItemTip($("#sampling_tab_panel"));
            }
        }
    });

    function loadUnchecked(goods) {
        return "<div class='unchecked_item'" +
            "style='padding-left: 4%;padding-right:4%;padding-top: 2.6%;padding-bottom: 2.6%;" +
            "color: grey;font-size: 15px;'>" +
            "<div class='unchecked_message' style='width: 90%;float: left'>" +
            "<p>水域地址：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
            "<p>所属项目：<label style='color: black'>" + goods.project.name + "</label></p>" +
            "<p>姓名： <label style='color: black'>" + goods.name + "</label>" +
            "<label style='color: black;float:right'>" + goods.number + "</label></p>" +
            "<p>收货地址：<label style='color: black'>" + goods.address + "</label></p>" +
            "</div>" +
            "<div style='height:15%;float: right;padding-left: 2%;border-left: 1px;" +
            "border-left-style: dashed;margin-bottom: 3%'>" +
            "<br/>" +
            "<img class='delete_unchecked' src='<%=basePath%>resources/img/delete.png' style='width:25px;position: relative;top:8%'/>" +
            "</div>" +
            "</div>" +
            "<hr style='width: 100%'>";
    }

    function loadChecked(goods) {
        var result = "<div class='checked_item' style='padding-left: 4%;padding-right:4%;padding-top: 2.6%;" +
            "color: grey;font-size: 15px;'>";
        if (goods.state === 1) {
            result += "<div class='checked_message' style='width: 90%;float: left'>";
        } else if (goods.state === 2) {
            result += "<div class='checked_message' style='width: 100%'>";
        }
        result += "<p>水域地址：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
            "<p>所属项目：<label style='color: black'>" + goods.project.name + "</label></p>";
        if (goods.state === 1) {
            result += "<p>审核状态：<img src='<%=basePath%>resources/img/pass.png' style='width: 15px'/>" +
                "<label style='color: green'>已通过（材料已寄出）</label></p>";
        } else if (goods.state === 2) {
            result += "<p>审核状态：<img src='<%=basePath%>resources/img/reject.png' style='width: 15px'/>" +
                "<label style='color: red'>已拒绝</label></p>";
        }
        result+="<p>审核反馈：<label style='color: black'>" + goods.response + "</label></div>";
        if (goods.state === 1) {
            result += "<div style='height:15%;float: right;padding-left: 2%;border-left: 1px;" +
                "border-left-style: dashed;margin-bottom: 3%'>" +
                "<br/>" +
                "<img class='upload_pass' src='<%=basePath%>resources/img/upload.png' style='width:25px;position: relative;top:9%'/></div>";
        }
        result += "</div><hr style='width: 100%'>";
        return result;
    }

    function loadSampling(goods) {
        result= "<div class='sampling_item'" +
            "style='padding-left: 15px;padding-right:15px;padding-top: 10px;color: grey;font-size: 15px'>" +
            "<p>采样地点：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
            "<p>所属项目：<label style='color: black'>" + goods.project + "</label></p>"+
            "<p>经纬度：<label style='color: black'>(" + goods.longitude + ", " + goods.latitude + ")</label>" +
            "<label style='float: right'>采样体积：<label style='color: black'>" + goods.volume + "</label></label></p>";
        if (goods.state === 0) {
            result += "<p>处理状态：<img src='<%=basePath%>resources/img/toBeReceived.png' style='width: 15px'/>" +
                "<label style='color: black'>待收取</label></p>";
        } else if (goods.state === 1) {
            result += "<p>处理状态：<img src='<%=basePath%>resources/img/processing.png' style='width: 15px'/>" +
                "<label style='color: blue'>处理中</label></p>";
        }else if(goods.state===2){
            result += "<p>处理状态：<img src='<%=basePath%>resources/img/workOut.png' style='width: 15px'/>" +
                "<label style='color: green'>处理完成</label></p>";
        }
        result+="<p style='font-size: 14px'>采样时间：" + goods.sampleDate +
            "<label style='float:right'>编号：" + goods.sampleID + "</label></p>" +
            "</div>" +
            "<hr>";
        return result;
    }

    var basePath="<%=basePath%>";
    var deleteIndex;
    $(".delete_unchecked").click(function () {
        deleteIndex = $(".delete_unchecked").index(this);
        $("#dialog").show();
    });
    $(".unchecked_message").click(function () {
        var index = $(".unchecked_message").index(this);
        var isChecked = 0;
        onConcreteApply(index, isChecked);
    });
    $('.checked_message').click(function () {
        var index = $('.checked_message').index(this);
        var isChecked = 1;
        onConcreteApply(index, isChecked);
    });
    $('.upload_pass').click(function () {
        var index = $('.upload_pass').index(this);
        onUpload(index);
    });
    $('.sampling_item').click(function () {
        var index = $('.sampling_item').index(this);
        onConcreteSample(index);
    });

</script>
</html>