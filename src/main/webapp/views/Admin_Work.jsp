<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/18 0018
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>审核申请 - 后台管理</title>

    <!-- CSS -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="././ico/favicon1.ico">


</head>

<body>

<!-- Top menu -->
<nav class="navbar" role="navigation">


    <div class="container">
        <div class="navbar-header">
            <a href="#" class="logo">eRiver <span>Map</span></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul id="nav" class="nav navbar-nav navbar-right">
                <li class="active"><a href="#"onclick="topnavclick(this)" name="1"><i
                        class="fa fa-2x fa-check-circle-o" ></i><br>审核申请</a></li>

                <li><a href="#" onclick="topnavclick(this)" name="2"><i
                        class="fa fa-2x fa-envelope-open-o"></i><br>采样信息</a>
                </li>

                <li><a href="#" onclick="topnavclick(this)" name="3"><i
                        class="fa fa-2x fa-sticky-note"></i><br>实验结果</a>
                </li>
                <li><a href="#" onclick="topnavclick(this)" name="4"><i
                        class="fa fa-2x fa-newspaper-o"></i><br>项目发布</a>
                </li>


                <ul class="social-links">
                    <div id="top-navigation">
                        Welcome! <a href="#"><strong>Administrator</strong></a>
                        <span>|</span>
                        <a href="Admin">Log out</a>
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
                <i class="fa fa-check-circle-o"></i>
                <h1>AUDIT APPLICATION/</h1>
                <p>审核申请</p>
            </div>
        </div>
    </div>
</div>


<!-- content -->
<div class="content">
    <div class="container">
        <div class="intro-panel">
            <div id = "mainwrapper" class="main_wrapper" style="display: block">
                <ul id="tabs">
                    <li id="current" name="s1"><a class="state" href="#" title="tab1">待审核</a></li>
                    <li name="s2"><a  class="state" href="#" title="tab2">审核通过</a></li>
                    <li name="s3"><a  class="state" href="#" title="tab3">未通过审核</a></li>
                </ul>
                <div class="search bar">
                    <form>
                        <input id= "input" type="text" placeholder="请输入申请编号">
                        <button id="search" type="button"></button>
                    </form>
                </div>
                <div id="main_content">
                    <div id="tab1">
                        <div id="content1" class="table-content" style="display: block;">
                            <ul id="scro1" class="scroll indicator-group-title" style="width:170px;height:560px;overflow:auto;">
                                <li class="active"><a>--</a><span
                                        class="fa fa-angle-right"></span></li>
                            </ul>
                            <div class=" indicator-group-content">
                                <div class="left_title">
                                    <i class="fa fa-edit blue"></i><h1 id="applyid" class="number">--</h1>
                                    <a class="time">2017-7-17 00:00:00</a>
                                </div>
                                <div class="left_content">
                                    <div class="left_info">
                                        <p>
                                            <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>联系方式：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>家庭住址：</span>
                                            <span name="name" style="color:#555;">家庭住址可能会很长长长长长长</span>
                                        </p>
                                        <p>
                                            <span>经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>水域地址：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                    </div>
                                    <div id="myCarousel" class="carousel slide">
                                        <!-- 轮播（Carousel）指标 -->
                                        <ol class="carousel-indicators">
                                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                            <li data-target="#myCarousel" data-slide-to="1"></li>
                                            <li data-target="#myCarousel" data-slide-to="2"></li>
                                        </ol>
                                        <!-- 轮播（Carousel）项目 -->
                                        <div class="carousel-inner">
                                            <div class="item active">
                                                <img src="${pageContext.request.contextPath}/resources/txt/zhs_2017-7-28 15-30_0.jpg" alt="First slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/leftArrow.png" alt="Second slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/pass.png" alt="Third slide">
                                            </div>
                                        </div>
                                        <!-- 轮播（Carousel）导航 -->
                                        <a class="carousel-control left" href="#myCarousel"
                                           data-slide="prev">&lsaquo;</a>
                                        <a class="carousel-control right" href="#myCarousel"
                                           data-slide="next">&rsaquo;</a>
                                    </div>
                                    <div class="operate">
                                        <a onclick="dealApply(this)" class="yes button"><i class="fa fa-check"></i>审核通过</a>
                                        <a   data-toggle="modal" data-target="#myModal" class="no button"><i class="fa fa-close"></i>拒绝申请</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div id="nothing1" style="display: none"><h3>暂无此类申请！</h3></div>
                    </div>
                    <div id="tab2" style="display: none">
                        <div id="content2" class="table-content" style="">
                            <ul id="scro2" class="scroll indicator-group-title" style="width:170px;height:560px;overflow:auto;">
                                <li class="active"><a>--</a><span
                                        class="fa fa-angle-right"></span></li>
                            </ul>
                            <div class=" indicator-group-content">
                                <div class="left_title">
                                    <i class="fa fa-check green"></i> <h1>--</h1>
                                    <a class="time">2017-7-17 00:00:00</a>
                                </div>
                                <div class="left_content">
                                    <div class="left_info">
                                        <p>
                                            <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                                            <span name='name' style="color:#555;">>--</span>
                                        </p>
                                        <p>
                                            <span>联系方式：</span>
                                            <span name='name' style="color:#555;">>--</span>
                                        </p>
                                        <p>
                                            <span>家庭住址：</span>
                                            <span name='name' style="color:#555;">>--</span>
                                        </p>
                                        <p>
                                            <span>经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name='name' style="color:#555;">>--</span>
                                        </p>
                                        <p>
                                            <span>纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name='name' style="color:#555;">>--</span>
                                        </p>
                                        <p>
                                            <span>水域地址：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                    </div>

                                    <div id="myCarousel2" class="carousel slide">
                                        <!-- 轮播（Carousel）指标 -->
                                        <ol class="carousel-indicators">
                                            <li data-target="#myCarousel2" data-slide-to="0" class="active"></li>
                                            <li data-target="#myCarousel2" data-slide-to="1"></li>
                                            <li data-target="#myCarousel2" data-slide-to="2"></li>
                                        </ol>
                                        <!-- 轮播（Carousel）项目 -->
                                        <div class="carousel-inner">
                                            <div class="item active">
                                                <img src="${pageContext.request.contextPath}/resources/img/background.jpg" alt="First slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/leftArrow.png" alt="Second slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/pass.png" alt="Third slide">
                                            </div>
                                        </div>
                                        <!-- 轮播（Carousel）导航 -->
                                        <a class="carousel-control left" href="#myCarousel2"
                                           data-slide="prev">&lsaquo;</a>
                                        <a class="carousel-control right" href="#myCarousel2"
                                           data-slide="next">&rsaquo;</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div id="nothing2" style="display: none"><h3>暂无此类申请！</h3></div>
                    </div>
                    <div id="tab3" style="display: none">
                        <div id="content3" class="table-content" style="">
                            <ul id="scro3" class="scroll indicator-group-title" style="width:170px;height:560px;overflow:auto;">
                                <li class="active"><a>--</a><span
                                        class="fa fa-angle-right"></span></li>
                            </ul>
                            <div class=" indicator-group-content">
                                <div class="left_title">
                                    <i class="fa fa-close red"></i><h1>--</h1>
                                    <a class="time">2017-7-17 00:00:00</a>
                                </div>
                                <div class="left_content">
                                    <div class="left_info">
                                        <p>
                                            <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                                            <span name="name" style="color:#555;" >--</span>
                                        </p>
                                        <p>
                                            <span>联系方式：</span>
                                            <span name="name" style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>家庭住址：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>水域地址：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                        <p>
                                            <span>拒绝原因：</span>
                                            <span name='name' style="color:#555;">--</span>
                                        </p>
                                    </div>

                                    <div id="myCarousel3" class="carousel slide">
                                        <!-- 轮播（Carousel）指标 -->
                                        <ol class="carousel-indicators">
                                            <li data-target="#myCarousel3" data-slide-to="0" class="active"></li>
                                            <li data-target="#myCarousel3" data-slide-to="1"></li>
                                            <li data-target="#myCarousel3" data-slide-to="2"></li>
                                        </ol>
                                        <!-- 轮播（Carousel）项目 -->
                                        <div class="carousel-inner">
                                            <div class="item active">
                                                <img src="${pageContext.request.contextPath}/resources/img/background.jpg" alt="First slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/leftArrow.png" alt="Second slide">
                                            </div>
                                            <div class="item">
                                                <img src="${pageContext.request.contextPath}/resources/img/pass.png" alt="Third slide">
                                            </div>
                                        </div>
                                        <!-- 轮播（Carousel）导航 -->
                                        <a class="carousel-control left" href="#myCarousel3"
                                           data-slide="prev">&lsaquo;</a>
                                        <a class="carousel-control right" href="#myCarousel3"
                                           data-slide="next">&rsaquo;</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div id="nothing3" style="display: none"><h3>暂无此类申请！</h3></div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
<%--模态框--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">拒绝原因</h4>
            </div>
           <textarea id="reason" placeholder="。。。。。" style="width: 100%; height: 100%;border: 0px;"></textarea>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="dealApply(this)" type="button" class="btn btn-primary">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
                        href="">Noah's Ark</a>.
                </p>
            </div>
            <div class="col-sm-5 footer-social wow fadeIn">
<%--                <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
                    class="fa fa-qq"></i></a> <a href="#"><i class="fa fa-weibo"></i></a>
                <a href="#"><i class="fa fa-wechat"></i></a>--%>
            </div>
        </div>
    </div>
</footer>


<!-- Javascript -->
<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Admin_Work.js"></script>




</body>

</html>