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
    <title>水污染-管理 </title>
    <!-- CSS -->
    <link rel="stylesheet" href="./resources/css/admin_work.css"/>
    <link rel="stylesheet" href="./resources/css/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">

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
                <li class="active"><a href="#"><i class="fa fa-2x fa-sitemap"></i><h4>审核申请</h4></a></li>
                <li><a href="#"><i class="fa fa-2x fa-download set_middle"></i><h4>下载采样信息</h4></a></li>
                <li><a href="#"><i class="fa fa-2x fa-upload set_right"></i><h4>上传实验结果</h4></a></li>
            </ul>
        </div>
    </header>
    <div class="main_wrapper">

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
                        <li class="active"><a>12345678</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345679</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a>12345680</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345682</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345683</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345684</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a >12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345685</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345686</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345687</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345688</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345689</a><span
                                class="fa fa-angle-right"></span></li>
                    </ul>
                    <div class=" indicator-group-content">
                        <div class="left_title">
                            <i class="fa fa-edit blue"></i><h1 id="applyid" class="number">12345678</h1>
                            <a class="time">2017-7-17 00:00:00</a>
                        </div>
                        <div class="left_content">
                            <div class="left_info">
                                <p>
                                    <span>姓名：</span>
                                    <span name="name">李四</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name="name">11111111111</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name="name">江苏省南京市栖霞区仙林大道163号</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name="name">21.5494949°</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name="name">100.545646°</span>
                                </p>
                            </div>

                            <div  id="scroll">
                                <p class="subl"><i class="fa fa-angle-left"></i><p/>
                                <p class="subr"><i class="fa fa-angle-right"></i><p/>
                                <ul>
                                    <li style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li><img src="./resources/img/backimg.png" width="" height=""></li>
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
                        <li class="active"><a>12345678</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345679</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a>12345680</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345682</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345683</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345684</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a >12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345685</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345686</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345687</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345688</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345689</a><span
                                class="fa fa-angle-right"></span></li>
                    </ul>
                    <div class=" indicator-group-content">
                        <div class="left_title">
                           <i class="fa fa-check green"></i> <h1>12345678</h1>
                            <a class="time">2017-7-17 00:00:00</a>
                        </div>
                        <div class="left_content">
                            <div class="left_info">
                                <p>
                                    <span>姓名：</span>
                                    <span name='name'>李四</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name='name'>11111111111</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name='name'>江苏省南京市栖霞区仙林大道163号</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name='name'>21.5494949°</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name='name'>100.545646°</span>
                                </p>
                            </div>

                            <div  id="scroll2">
                                <p class="subl"><i class="fa fa-angle-left"></i><p/>
                                <p class="subr"><i class="fa fa-angle-right"></i><p/>
                                <ul>
                                    <li style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li><img src="./resources/img/backimg.png" width="" height=""></li>
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
                        <li class="active"><a>12345678</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345679</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a>12345680</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345682</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345683</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345684</a><span
                                class="fa fa-angle-right"></span></li>
                        <li><a >12345681</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345685</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345686</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345687</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345688</a><span
                                class="fa fa-angle-right"></span></li>
                        <li class=""><a>12345689</a><span
                                class="fa fa-angle-right"></span></li>
                    </ul>
                    <div class=" indicator-group-content">
                        <div class="left_title">
                            <i class="fa fa-close red"></i><h1>12345678</h1>
                            <a class="time">2017-7-17 00:00:00</a>
                        </div>
                        <div class="left_content">
                            <div class="left_info">
                                <p>
                                    <span>姓名：</span>
                                    <span name="name">李四</span>
                                </p>
                                <p>
                                    <span>联系方式：</span>
                                    <span name="name">11111111111</span>
                                </p>
                                <p>
                                    <span>家庭住址：</span>
                                    <span name='name'>江苏省南京市栖霞区仙林大道163号</span>
                                </p>
                                <p>
                                    <span>经度：</span>
                                    <span name='name'>21.5494949°</span>
                                </p>
                                <p>
                                    <span>纬度：</span>
                                    <span name='name'>100.545646°</span>
                                </p>
                            </div>

                            <div id="scroll3">
                                <p class="subl"><i class="fa fa-angle-left"></i><p/>
                                <p class="subr"><i class="fa fa-angle-right"></i><p/>
                                <ul>
                                    <li style="display:block;"><img src="./resources/img/Title.png" width="" height=""></li>
                                    <li><img src="./resources/img/backimg.png" width="" height=""></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
                <div id="nothing3" style="display: none"><h3>暂无此类申请！</h3></div>
            </div>
        </div>
        <script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
        <script src="./resources/js/Admin_Work.js"></script>
        <script type="text/javascript">
            /*轮播*/
            $(function(){
                $(".a1").click(function () {
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

                })
                var i=0;
                var len=$("#scroll ul li").length-1;
                var len=$("#scroll2 ul li").length-1;
                var len=$(".scroll3 ul li").length-1;
                $(".subl").click(function(){
                    if(i==len){
                        i=-1;
                    }
                    i++;
                    $("#scroll ul li").eq(i).fadeIn().siblings().hide();
                    $("#scroll2 ul li").eq(i).fadeIn().siblings().hide();
                    $("#scroll3 ul li").eq(i).fadeIn().siblings().hide();
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
                });
            });
            /*轮播*/
        </script>
    </div>
    <!-- Footer -->
    <footer>
        <p>Copyright 2017 Water - by Noah's Ark.</p>
    </footer>
</div>
</body>

</html>
