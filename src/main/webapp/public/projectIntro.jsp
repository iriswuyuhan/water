<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<% String parameter = request.getParameter("name"); %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eRivermap-项目介绍</title>

    <!-- CSS -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link rel="stylesheet" href="../resources/css/test.css">
    <link rel="stylesheet" href="../resources/css/projectIntro.css">
    <link rel="stylesheet" href="../resources/js/jquery.media.js">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="././ico/favicon1.ico">


</head>

<body>

<!-- Top menu -->
<nav class="navbar" role="navigation">


    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../index.jsp"><i
                        class="fa fa-2x fa-tasks"></i><br>首页</a></li>

                <li><a href="../public/engagement.html"><i
                        class="fa fa-2x fa-handshake-o"></i><br>公众参与</a>
                </li>

                <li class="active"><a href="../projectIntro/init"><i
                        class="fa fa-2x fa-list-alt"></i><br>信息发布</a>
                </li>
                <li><a href="../public/introduction.html"><i
                        class="fa fa-2x fa-file-text-o"></i><br>项目介绍</a>
                </li>
                <li><a href="../public/sampleMap.jsp"><i
                        class="fa fa-2x fa-map-marker "></i><br>样本地图</a>
                </li>

            </ul>



        </div>
    </div>


</nav>

<!-- Page Title -->
<div class="page-title-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-7 wow fadeIn">
                <i class="fa fa-file-text-o"></i>
                <h1><span>PROJECT</span>&nbsp;&nbsp;&nbsp;<span>INTRODUCTION</span>/</h1>
                <p>项目介绍</p>
            </div>
        </div>
    </div>
</div>


<!-- content -->
<div class="content">
    <div class="container">

        <div class="intro-panel">
            <div id="mainwrapper" class="main_wrapper" style="display: block">
                <div id="main_content">
                    <div class="table-content" style="display: block;">
                        <br/>
                        <ul id="scro1" class="scroll indicator-group-title">
                        </ul>
                        <div id="scrol_content">
                            <div id="total_intro_panel" class="tab_panel indicator-group-content">
                                <div class="left_title">
                                    <i class="fa fa-edit blue"></i>
                                    <h1 class="number" id="projectName" style="font-size: 25px">${projectName}</h1>
                                    <a class="time" id="projectDate">${date}</a>
                                </div>
                                <div class="left_content" style="text-align: left">
                                    <p id="projectDescription">自主选择水域</p>
                                    <p style="float: right"><a id="repostHref" class="media">查看项目报告</a></p>
                                    <input type="hidden" id="projectState">
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--<div id="annotation" style="display: none">--%>
                        <%--<p>暂未上传实验报告</p>--%>
                    <%--</div>--%>

                </div>
            </div>
        </div>

    </div>
</div>


<!-- Footer -->
<footer>
    <div class="container">
        <!--        <div class="row">
                    <div class="col-sm-12 wow fadeIn">
                        <div class="footer-border"></div>
                    </div>
                </div>-->
        <div class="row">
            <div class="col-sm-7 footer-copyright wow fadeIn">
                <p>
                    Copyright 2017 河流生态地图后台 - by <a
                        href="http://azmind.com/free-bootstrap-themes-templates/">Noah's Ark</a>.
                </p>
            </div>
            <div class="col-sm-5 footer-social wow fadeIn">
                <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
                    class="fa fa-qq"></i></a> <a href="#"><i class="fa fa-weibo"></i></a>
                <a href="#"><i class="fa fa-wechat"></i></a>
            </div>
        </div>
    </div>
</footer>


<!-- Javascript -->
<script src="//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>

</body>

<script type="text/javascript">

    $("#repostHref").click(function () {
        if ($("#projectState").val() == 0){
            alert("暂未上传实验报告");
        }else{
            $("#repostHref").prop("href","http://118.89.166.19/web_upload/" + $("#projectName").text() + ".pdf");
        }
    })

    <% ArrayList<String> projectNames = (ArrayList)request.getAttribute("projectNameArray");
    for(int i=0;i<projectNames.size();i++){%>
    var name = "<li class=''><a onclick='changeContent(this)'><%=projectNames.get(i)%></a> <span class='fa fa-angle-right'></span></li>";
    $("#scro1").append(name);
    <%}%>

    <% if(parameter == null) {
        parameter = "一般申请";%>
        var parameter = '<%=parameter%>'.toString()+"";
    <%}else{%>
        var parameter = decodeURI('<%=parameter%>');
    <%}%>

    for(var i=0;i<$("#scro1 li").length;i++) {
        $("#scro1 li").removeClass("active");
        var element = $("#scro1 li").eq(i);
        var tem = element.text().toString();
        var tem2=tem.substr(0,tem.length-1);
        var tem1 = parameter.toString();
        if(tem1 == tem2){
            $("#scro1 li").eq(i).addClass("active");
            break;
        }
    }

    function changeContent(data){
        for(var i=0;i<$("#scro1 li").length;i++) {
            $("#scro1 li").removeClass("active");
        }
        $(data).parent().addClass("active");
        var url="../projectIntro/getInfo";
        $.ajax({
            type:'POST',
            url:url,
            data:{"projectName":data.innerHTML},
            success:function (data) {
                if(data != null){
                    $("#projectDescription").html("");
                    $("#projectName").html(data.projectName2);
                    $("#projectDescription").html(data.description2);
                    $("#projectDate").html(data.date2);
                    $("#projectState").val(data.state2);
                }else{
                    alert("fail");
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //这个error函数调试时非常有用，如果解析不正确，将会弹出错误框
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus); // parser error;
            }
        })
    }

</script>
</html>