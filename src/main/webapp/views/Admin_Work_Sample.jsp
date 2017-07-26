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

    <title>河流生态地图-管理 </title>
    <!-- CSS -->
    <link rel="stylesheet" href="../resources/css/admin_work.css"/>
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="../resources/css/admin_work_sample.css"/>

    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

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
    <div id="downloadwrapper" class="download_wrapper" style="display: block">
        <div class="load_wrapper" style="display:none">
            <a class="return_pon">return to list</a>
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
                                <li class="Gallery" class="Gallery"><img src="./resources/img/backimg.png" width="" height=""  onchange="img.src=this.value" ></li>
                            </ul>
                        </div>

                    </div>

                </div>
            </div>
            <div id="nothing4" style="display: none"><h3>暂无此类申请！</h3></div>
            <div class="left-content">
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
            </div>
        </div>
        <div class="list_wrapper" style="display:block">
            <div class="table_header">
                <div class="row">
                    <div class="col-xs-6 col-sm-2.5">
                        <a class="pull-left label-pon">项目编号：</a>
                        <input class="form-control pull-left" maxlength="8" required="" type="text" style="width:120px;" >
                    </div>
                    <div class="col-xs-6 col-sm-4">
                        <div class="form-group">
                            <a class="pull-left label-pon">时间段选择：</a>
                            <div class="col-xs-4">
                                <div class="input-group input-medium date-picker input-daterange pull-left" data-date-format="yyyy-mm-dd" style="width:70%";>
                                    <input name="dtBegin" class="form-control"  type="text" value="" style="width:80px;">
                                    <div class="input-group-addon">to</div>
                                    <input name="dtEnd" class="form-control" type="text" value="" style="width:80px;">
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
                        <button type="button" class="btn btn-info pull-left">查找</button>
                        <div class="download_pon pull-right">
                            <i class="fa fa-download"></i>
                        </div>
                    </div>
                </div>

            </div>

            <table class="table_list">
                <thead class="table_title">
                <tr  style="display:block;">
                    <th style="width:80px"><input id="checkbox" type="checkbox"><label for="checkbox"></label></th>
                    <th style="width:160px">样本编号</th>
                    <th style="width:160px">样本体积</th>
                    <th style="width:180px">水域地址</th>
                    <th style="width:180px">所属项目</th>
                    <th style="width:200px">采样时间</th>
                    <th style="width:200px">状态</th>
                    <th style="width:30px"><i class="fa fa-angle-right"></i></th>
                </tr>
                </thead>
                <tbody  style="display: block; height: 340px; width: 1190px; overflow-y: auto; overflow-x:hidden ">
                <tr>
                    <td style="width:80px"><input id="checkbox1" type="checkbox"><label for="checkbox1"></label></td>
                    <td style="width:160px">123456</td>
                    <td style="width:160px">10ml</td>
                    <td style="width:180px">长长长长江</td>
                    <td style="width:180px">项目ABC</td>
                    <td style="width:200px">2017-01-25 10:00:00</td>
                    <td style="width:200px"><li class="yellow dot"></li><a class="pull-left">处理中</a></td>
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
                    <td><li class="gray dot"></li><a class="pull-left">未收取</a></td>
                    <td><a><i class="fa fa-angle-right"></i></a></td>
                </tr>



                </tbody>
            </table>

        </div>
    </div>
    <!-- Footer -->
    <footer>
        <p>Copyright 2017 Water - by Noah's Ark.</p>
    </footer>
</div>


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

