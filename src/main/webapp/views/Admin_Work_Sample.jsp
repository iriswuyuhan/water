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
    <title>采样信息 - 后台管理</title>

    <!-- CSS -->

    <link href="//cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.css" rel="stylesheet">


    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link rel="stylesheet" href="../resources/css/admin_work_sample.css">
    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="//cdn.bootcss.com/sortable/0.8.0/js/sortable.js"></script>
    <script src="//cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.js"></script>

    <![endif]-->
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
            <ul id="nav" class="nav navbar-nav navbar-right">
                <li><a href="#"onclick="topnavclick(this)" name="1"><i
                        class="fa fa-2x fa-check-circle-o" ></i><br>审核申请</a></li>

                <li class="active"><a href="#" onclick="topnavclick(this)" name="2"><i
                        class="fa fa-2x fa-envelope-open-o"></i><br>采样信息</a>
                </li>

                <li><a href="#" onclick="topnavclick(this)" name="3"><i
                        class="fa fa-2x fa-sticky-note"></i><br>实验结果</a>
                </li>
                <li><a href="#" onclick="topnavclick(this)" name="4"><i
                        class="fa fa-2x fa-newspaper-o"></i><br>项目管理</a>
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
                <i class="fa fa-envelope-open-o"></i>
                <h1>SAMPLING INFO/</h1>
                <p>采样信息</p>
            </div>
            <div class=" list-switch" style="margin-right:20px; margin-top:10px;"><ul><li id="show-list" class=""></li><li id="show-info" class="active"></li></ul></div>
        </div>
    </div>
</div>


<!-- content -->
<div class="content">
    <div class="container">
        <div class="intro-panel">
            <div class="load_wrapper" style="display:block;">

                <div id="content4" class="table-content" style="display: block;">
                    <div class="row space">
                        <div class="col-xs-6 col-sm-7">
                            <div id="searchdiv"class="orther_search bar1">
                                <form>
                                    <input id= "input1" type="text" placeholder="请输入样本编号">
                                    <button id="search1"></button>
                                </form>
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-5">
                            <%--<a id="come-list" href="#" class="return_pon">Come to list&nbsp;<i class="fa fa-angle-double-right"></i><i class="fa fa-angle-double-right"></i><i class="fa fa-angle-double-right"></i></a>--%>

                        </div>
                    </div>

                    <ul id="scro4" class="scroll indicator-group-title">
                        <li class="active"><a>--</a><span
                                class="fa fa-angle-right"></span></li>
                    </ul>
                    <div class=" indicator-group-content">
                        <div class="left_title">
                            <i class="fa fa-file-text-o blue"></i><h1 id="sample" class="number">--</h1>

                            <a class="setpon">采样时间：</a>
                            <a class="sample_time">2017-7-17 00:00:00</a>
                        </div>
                        <div class="left_content">
                            <div class="left_info" id="left-info">
                                <p>
                                    <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>申请编号：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>申请时间：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>样本体积：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>水域地址：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>样本状态：</span>
                                    <span name="name" style="color:#000;">待收取</span>
                                    <a id="confirm" href="#"onclick="confirmClik(this)" class="confirm btn-success" style="display:none;">确认收取</a>
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
                                        <img src="../resources/img/background.jpg" alt="First slide">
                                    </div>
                                    <div class="item">
                                        <img src="../resources/img/leftArrow.png" alt="Second slide">
                                    </div>
                                    <div class="item">
                                        <img src="../resources/img/pass.png" alt="Third slide">
                                    </div>
                                </div>
                                <!-- 轮播（Carousel）导航 -->
                                <a class="carousel-control left" href="#myCarousel"
                                   data-slide="prev">&lsaquo;</a>
                                <a class="carousel-control right" href="#myCarousel"
                                   data-slide="next">&rsaquo;</a>
                            </div>

                            <div class="operate">
                                <a id="downlo1" download="" href=""  class="button btn-info"><i class="fa fa-download"></i>下载信息</a>
                            </div>

                        </div>

                    </div>
                </div>
                <div id="nothing4" style="display: none"><h3>暂无此类申请！</h3></div>
            </div>
            <div id="list" class="list_wrapper" style="display:none;">
                <div class="table_header">
                    <div class="row">
                        <div class="col-xs-6 col-sm-3">
                            <a class="pull-left label-pon">项目名称：</a>
                            <input id="project" class="form-control pull-left" maxlength="8" required="" type="text" style="width:120px;" >
                        </div>
                        <div class="col-xs-6 col-sm-4">
                            <div class="form-group">
                                <a class="pull-left label-pon">时间段选择：</a>
                                <div class="col-xs-4">
                                    <div class="input-group input-medium date-picker input-daterange pull-left" data-date-format="yyyy-mm-dd" style="width:70%";>
                                        <input id="databegin" name="dtBegin" class="form-control"  type="text" value="" style="width:120px;">
                                        <div class="input-group-addon">to</div>
                                        <input  id="dataend" name="dtEnd" class="form-control" type="text" value="" style="width:120px;">
                                    </div>

                                    <script type="text/javascript">
                                        $(".date-picker").datepicker({
                                            language: "zh-CN",
                                            autoclose: true,
                                            format:"yyyy-mm-dd"
                                        });
                                    </script>
                                </div>

                            </div>
                        </div>
                        <!-- Optional: clear the XS cols if their content doesn't match in height -->
                        <div class="clearfix visible-xs-block"></div>
                        <div class="col-xs-6 col-sm-5">
                            <button  id="query" type="button" class="btn btn-info">查找</button>
                          <%--  <a id="back-info" href="#" class="return_pon">Back Info&nbsp;<i class="fa fa-angle-double-right"></i><i class="fa fa-angle-double-right"></i></a>--%>
                            <%--<div class="list-switch"><ul><li id="show-table" class="how-table"></li><li id="show-graph" class="show-info"></li></ul></div>--%>
                            <a id="csv" onclick="clickbut()" class="btn-info"  style="margin-left:240px;" ><i class="fa fa-download">下载</i></a>
                            <!--<div class="list-switch"><ul><li id="show-table2" class="active"></li><li id="show-graph2" class=""></li></ul></div>-->
                        </div>
                    </div>

                </div>

                <table class="table_list">
                    <thead class="table_title">
                    <tr  style="display:block;">
                        <th style="width:60px;padding-left:13px;"><input id="checkbox" type="checkbox"><label for="checkbox"></label></th>
                        <th style="width:120px;padding-left:40px;">样本编号</th>
                        <th style="width:120px;padding-left:45px;">样本体积</th>
                        <th style="width:180px;padding-left:80px;">水域地址</th>
                        <th style="width:180px;padding-left:70px;">所属项目</th>
                        <th style="width:200px;padding-left:60px;">采样时间</th>
                        <th style="width:180px;">状态</th>
                        <th style="width:30px;"><i class="fa fa-angle-right"></i></th>
                    </tr>
                    </thead>
                    <tbody id="tbody"  style="display: block; height: 500px; width:1070px; overflow-y: auto; overflow-x:hidden ">
                    <tr>
                        <td style="width:60px"><input id="checkbox1" type="checkbox"><label for="checkbox1"></label></td>
                        <td style="width:120px">123456</td>
                        <td style="width:120px">10ml</td>
                        <td style="width:180px">长长长长江</td>
                        <td style="width:180px">项目ABC</td>
                        <td style="width:200px">2017-01-25 10:00:00</td>
                        <td style="width:180px"><li class="yellow dot"></li><a class="pull-left">处理中</a></td>
                        <td style="width:30px"><a><i class="fa fa-angle-right"></i></a></td>
                    </tr>
                    <tr>
                        <td><input id="checkbox2" type="checkbox"><label for="checkbox2"></label></td>
                        <td>123457</td>
                        <td>15ml</td>
                        <td>黄黄黄黄河</td>
                        <td>项目ABC</td>
                        <td>2017-01-25 10:00:00</td>
                        <td><li class="green dot"></li><a class="pull-left">已上传结果</a></td>
                        <td><a><i class="fa fa-angle-right"></i></a></td>
                    </tr>
                    <tr>
                        <td style="width:80px"><input id="checkbox3" type="checkbox"><label for="checkbox3"></label></td>
                        <td>123457</td>
                        <td>15ml</td>
                        <td>渤渤渤渤海</td>
                        <td>项目ABC</td>
                        <td>2017-01-25 10:00:00</td>
                        <td><li class="gray dot"></li><a class="pull-left">待收取</a></td>
                        <td><a><i class="fa fa-angle-right"></i></a></td>
                    </tr>



                    </tbody>
                </table>

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
<script src="//cdn.bootcss.com/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>
<script src="./resources/js/Admin_Work.js"></script>
<script src="./resources/js/Admin_work_sample.js"></script>
<script src="./resources/js/Admin_Work_Samplelist.js"></script>
<script type="text/javascript">
    $(function () {

        $(".load_wrapper").show();
        $(".list_wrapper").hide();

        $("#show-info").click(function () {
            $("#show-info").addClass("active").siblings().removeClass("active"),
                $(".list_wrapper").fadeOut("fast",function () {
                    $(".load_wrapper").fadeIn()
                })
        })

        $("#show-list").click(function () {
            $("#show-list").addClass("active").siblings().removeClass("active"),
                $(".load_wrapper").fadeOut("fast",function () {
                    $(".list_wrapper").fadeIn()
                }), $(window).trigger("resize");

    })
</script>
</body>

</html>

