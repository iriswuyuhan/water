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
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">

    <title>水污染-管理 </title>
    <!-- CSS -->
    <link rel="stylesheet" href="./resources/css/admin_work.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <!--    &lt;!&ndash; Favicon and touch icons &ndash;&gt;
        <link rel="shortcut icon" href="assets/ico/favicon.ico">-->

</head>
<body>
<div class="content">
    <header>
        <div class="header_top">
            <div class="top_container">
                <h1><a>Noah's</a> Ark</h1>
                <div id="top-navigation">
                    Welcome! <a href="#"><strong>Administrator</strong></a>
                    <span>|</span>
                    <a href="#">Log out</a>
                </div>

            </div>
        </div>
        <div class="header_main">
            <ul id="nav">
                <li class="active"><a class="tyo" href="#"><i class="fa fa-2x fa-sitemap"></i><h4>审核申请</h4></a></li>
                <li ><a class="tyo" href="#" ><i class="fa fa-2x fa-download set_middle"></i><h4>下载采样信息</h4></a></li>
                <li ><a class="tyo" href="#"><i class="fa fa-2x fa-upload set_right"></i><h4>上传实验结果</h4></a></li>
            </ul>
        </div>
    </header>
    <div id = "mainwrapper" class="main_wrapper" style="display: none">
        <ul id="tabs">
            <li id="current" name="s1"><a class="state" href="#" title="tab1">待审核</a></li>
            <li name="s2"><a  class="state" href="#" title="tab2">审核通过</a></li>
            <li name="s3"><a  class="state" href="#" title="tab3">未通过审核</a></li>
        </ul>
        <div class="search bar">
            <form>
                <input id= "input" type="text" placeholder="请输入申请编号">
                <button id="search" ></button>
            </form>
        </div>
        <div id="main_content">
            <div id="tab1">
                <div id="content1" class="table-content" style="display: block;">
                    <ul id="scro1" class="scroll indicator-group-title">
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
                                    <span>姓名：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>水域地址：</span>
                                    <span name="name">--</span>
                                </p>
                            </div>

                            <div  id="scroll">
                                <p>
                                    <span class="toGray">水域照片：</span>
                                </p>
                                <p class="subl"><i class="fa fa-arrow-left"></i> <p/>
                                <p class="subr"><i class="fa fa-arrow-right"></i><p/>
                                <ul>
                                    <li class="Gallery" style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li class="Gallery"><img src="./resources/img/backimg.png" width="" height=""></li>
                                </ul>
                            </div>
                            <div class="operate">
                                <a onclick="dealApply(this)" class="yes button"><i class="fa fa-check"></i>审核通过</a>
                                <a  onclick="dealApply(this)" class="no button"><i class="fa fa-close"></i>拒绝申请</a>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="nothing1" style="display: none"><h3>暂无此类申请！</h3></div>
            </div>
            <div id="tab2" style="display: none">
                <div id="content2" class="table-content" style="">
                    <ul id="scro2" class="scroll indicator-group-title">
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
                                    <span>姓名：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>水域地址：</span>
                                    <span name='name'>--</span>
                                </p>
                            </div>

                            <div  id="scroll2">
                                <p>
                                    <span class="toGray">水域照片：</span>
                                </p>
                                <p class="subl"><i class="fa fa-arrow-left"></i> <p/>
                                <p class="subr"><i class="fa fa-arrow-right"></i><p/>
                                <ul>
                                    <li class="Gallery" style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li class="Gallery"><img src="./resources/img/backimg.png" width="" height=""></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="nothing2" style="display: none"><h3>暂无此类申请！</h3></div>
            </div>
            <div id="tab3" style="display: none">
                <div id="content3" class="table-content" style="">
                    <ul id="scro3" class="scroll indicator-group-title">
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
                                    <span>姓名：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name="name">--</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name='name'>--</span>
                                </p>
                                <p>
                                    <span>水域地址：</span>
                                    <span name='name'>--</span>
                                </p>
                            </div>

                            <div id="scroll3">
                                <p>
                                    <span class="toGray">水域照片：</span>
                                </p>
                                <p class="subl"><i class="fa fa-arrow-left"></i> <p/>
                                <p class="subr"><i class="fa fa-arrow-right"></i><p/>
                                <ul>
                                    <li class="Gallery" style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li class="Gallery"><img src="./resources/img/backimg.png" width="" height=""></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="nothing3" style="display: none"><h3>暂无此类申请！</h3></div>
            </div>
        </div>

    </div>
    <div id="downloadwrapper" class="download_wrapper" style="display: block">
        <div class="load_wrapper">
            <div id="content4" class="table-content" style="display: block;">
                <ul id="scro4" class="scroll indicator-group-title">
                    <div id="searchdiv"class="orther_search bar1">
                        <form>
                            <input id= "input1" type="text" placeholder="请输入样本编号">
                            <button id="search1" ></button>
                        </form>
                    </div>
                    <li class="active"><a>--</a><span
                            class="fa fa-angle-right"></span></li>
                </ul>
                <div class=" indicator-group-content">
                    <div class="left_title">
                        <i class="fa fa-file-text-o blue"></i><h1 id="sample" class="number">--</h1>
                        <a id="downlo1" download="" href=""  class="button"><i class="fa fa-download"></i>下载信息</a>
                        <a class="setpon">采样时间：</a>
                        <a class="sample_time">2017-7-17 00:00:00</a>
                    </div>
                    <div class="left_content">
                        <div class="left_info" id="left-info">
                            <p>
                                <span>姓名：</span>
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
                                <span>备注：</span>
                                <span name="name">--</span>
                            </p>
                        </div>
                        <div class="middle_info" id="middle-info">
                            <p>
                                <span>联系方式：</span>
                                <span name="name">--</span>
                            </p>
                            <p>
                                <span>经度：</span>
                                <span name="name">--</span>
                            </p>
                            <p>
                                <span>纬度：</span>
                                <span name="name">--</span>
                            </p>
                        </div>

                        <div  id="scroll4">
                            <p>
                                <span class="toGray">水域照片：</span>
                            </p>
                            <p class="subl"><i class="fa fa-arrow-left"></i> <p/>
                            <p class="subr"><i class="fa fa-arrow-right"></i><p/>
                            <ul>
                                <li class="Gallery" style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                <li class="Gallery" class="Gallery"><img src="./resources/img/backimg.png" width="" height=""></li>
                            </ul>
                        </div>

                    </div>

                </div>
            </div>
            <div id="nothing4" style="display: none"><h3>暂无此类申请！</h3></div>
            <%--            <div class="left-content">
                        <div id="user-left-nav" class="left-nav">
                            <ul class="top-nav list-unstyled">
                                <li class="active">
                                    <a href="#" class="value"><i class="fa fa-file"></i>111111</a>
                                </li>
                                <li>
                                    <a href="#" class="value"><i class="fa fa-file"></i>222222</a>
                                </li>
                                <li>
                                    <a href="#" class="value"><i class="fa fa-file"></i>33333</a>
                                </li>
                                <li>
                                    <a href="#" class="value"><i class="fa fa-file"></i>44444</a>
                                </li>
                                <li>
                                    <a href="#"  class="value"><i class="fa fa-file"></i>55555</a>
                                </li>
                                <li>
                                    <a href="#"  class="value"><i class="fa fa-file"></i>66666</a>
                                </li>

                            </ul>
                        </div>
                        </div>--%>
        </div>
    </div>
    <!-- Footer -->
    <footer>
        <p>Copyright 2017 Water - by Noah's Ark.</p>
    </footer>
</div>


<script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
<script src="./resources/js/Admin_Work.js"></script>
<script src="./resources/js/Admin_work_sample.js"></script>

<script type="text/javascript">
    /*轮播*/
    $(function(){

        /*               $(".a1").click(function () {
         $("#tabs li").prop("id","");
         $("#tab1").show();
         $("#tab2").hide();
         $("#tab3").hide();
         $(".a1").parent().prop("id","current");

         });
         $(".a2").click(function () {
         $("#tabs li").prop("id","");
         $("#tab2").show();
         $("#tab1").hide();
         $("#tab3").hide();
         $(".a2").parent().prop("id","current");

         })
         $(".a3").click(function () {
         $("#tabs li").prop("id","");
         $("#tab3").show();
         $("#tab2").hide();
         $("#tab1").hide();
         $(".a3").parent().prop("id","current");

         })*/
        var i=0;
        var len=$("#scroll ul li").length-1;
        var len=$("#scroll2 ul li").length-1;
        var len=$(".scroll3 ul li").length-1;
        var len=$(".scroll4 ul li").length-1;
        $(".subl").click(function(){
            if(i==len){
                i=-1;
            }
            i++;
            $("#scroll ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll2 ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll3 ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll4 ul li").eq(i).fadeIn().siblings().hide();
        });
//到这里分开！上面的是上一张点击的效果代码，下面的是下一张点击的效果代码．
        $(".subr").click(function(){//获取类名的点击事件．
            if(i==0){
                i=len+1;
            }
            i--;
            $("#scroll ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll2 ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll3 ul li").eq(i).fadeIn().siblings().hide();
            $("#scroll4 ul li").eq(i).fadeIn().siblings().hide();
        });
    });


</script>
</body>

</html>
