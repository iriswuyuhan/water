<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>项目介绍 - VicQuant</title>

    <!-- CSS -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link rel="stylesheet" href="../resources/css/test.css">
    <link rel="stylesheet" href="../resources/css/projectIntro.css">

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
            <a href="#" class="logo">Noah's <span>Ark</span></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#"><i
                        class="fa fa-2x fa-tasks"></i><br>首页</a></li>

                <li><a href="#"><i
                        class="fa fa-2x fa-handshake-o"></i><br>公众参与</a>
                </li>

                <li><a href="#"><i
                        class="fa fa-2x fa-list-alt"></i><br>信息发布</a>
                </li>
                <li><a href="#"><i
                        class="fa fa-2x fa-file-text-o"></i><br>项目介绍</a>
                </li>


                <ul class="social-links">
                    <div id="top-navigation">
                        Welcome! <a href="#"><strong>Administrator</strong></a>
                        <span>|</span>
                        <a href="#">Log out</a>
                    </div>
                </ul>
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
            <div id = "mainwrapper" class="main_wrapper" style="display: block">

                <div class="top">
                    <div class="search bar">
                        <form>
                            <input type="text" placeholder="请输入项目名称">
                            <button></button>
                        </form>
                    </div>
                </div>

                <div class="content-panel">
                    <div class="left">
                        <table class="projectList" id="projectList">
                            <%--<tr>--%>
                            <%--<td>淮河采样计划</td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<td>黄河采样计划</td>--%>
                            <%--</tr>--%>
                        </table>
                    </div>

                    <div class="right">
                        <p class="projectName">淮河采样计划</p>
                        <p class="introduction">淮河位于中国东部，介于长江与黄河之间，是中国七大河之一。古称淮水，与长江、黄河和济水并称“四渎”，是中国七大江河之一。淮河发源于河南省南阳市桐柏县西部的桐柏山主峰太白顶西北侧河谷，干流流经河南、安徽、江苏三省，淮河干流可以分为上游、中游、下游三部分，全长1000公里，总落差200米。洪河口以上为上游，长360公里，地面落差178米，流域面积3.06万平方公里；洪河口以下至洪泽湖出口中渡为中游，长490公里，地面落差16米，中渡以上流域面积15.8万平方公里；中渡以下至三江营为下游入江水道，长150公里，三江营以上流域面积为16.46万平方公里。 </p>
                        <div style="text-align: center"><img src="../resources/img/projectMap.png" class="projectMap"/></div>
                        <p class="introduction">淮河流域地跨河南、湖北、安徽、江苏和山东五省，流域面积约为27万平方公里，以废黄河为界，整个流域分成淮河和沂沭泗河两大水系，流域面积分别为19万平方公里和8万平方公里。 </p>
                        <p class="introduction">现征集志愿者参与淮河流域采样(项目ID：001)，时间为2017年8月至10月。</p>
                        <br><br>
                        <a class="projectPaper">查看项目报告</a>
                    </div>
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
    <% ArrayList<String> projectNames = (ArrayList)request.getAttribute("projectNameArray");
    for(int i=0;i<projectNames.size();i++){%>
    var name = "<tr><td><%=projectNames.get(i)%></td></tr>";
    $("#projectList").append(name);
    <%}%>

</script>
</html>