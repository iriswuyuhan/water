<%@ page import="com.water.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/7/31
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>可选项目</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 引入 WeUI -->
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script src="http://code.changer.hk/jquery/plugins/jquery.cookie.js"></script>
</head>
<body style="margin-bottom: 15px">
<div class="weui-cells__title" style="font-size: 16px">可选项目</div>
<div class="weui-cells">
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<Project> projectList = (List<Project>) request.getAttribute("projectList");
        for (int i = 0; i < projectList.size(); i++) {
            Project project = projectList.get(i);
    %>
    <a class="project_item weui-cell weui-cell_access" href="javascript:;">
        <div class="weui-cell__bd">
            <p><%=project.getName()%>
            </p>
        </div>
        <label style="float: right">
            <img class="pull_toggle_img hide" src="./resources/img/pullDown.png" style="width: 20px"/>
        </label>
    </a>
    <div class="project_content" style="display:none">
        <div class="project_time weui-cell" style="border-bottom: 0.5px gainsboro solid;border-top: 0.5px gainsboro solid;">
            <div class="weui-cell__bd">
                <p style="color: grey;font-size: 14px">发布时间</p>
            </div>
            <div class="weui-cell__ft" style="font-size: 15px"><%=sdf.format(project.getDate())%></div>
        </div>
        <div class="weui-cells__title">项目描述</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p style="font-size: 15px"><%=project.getDescription()%></p>
                </div>
            </div>
        </div>
        <a style="margin-top: 10px;margin-bottom: 10px;width: 80%" href="javascript:;"
           class="apply_project weui-btn weui-btn_plain-primary">参与项目</a>
        <input type="hidden" class="projectId" value="<%=project.getIdProject()%>"/>
    </div>
    <%}%>
</div>
</body>
<script>
    $(".project_item").click(function () {
       var index=$(".project_item").index(this);
       var tag=$(".pull_toggle_img").eq(index);
       $(".project_content").slideUp();
       if(tag.hasClass("hide")){
           tag.attr("src","./resources/img/pullUp.png");
           $(".project_content").eq(index).slideDown();
           tag.removeClass("hide");
       }else{
           tag.attr("src","./resources/img/pullDown.png");
           $(".project_content").eq(index).slideUp();
           tag.addClass("hide");
       }
    });

    //参与项目按钮
    $(".apply_project").click(function () {
       var index=$(".apply_project").index(this);
       var projectId=$(".projectId").eq(index).val();
       window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2014311796d1a614&redirect_uri=http%3a%2f%2fnju.softlollipop.cn%2fwater%2finit%2fwx&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
    });
</script>
</html>
