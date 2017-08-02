<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>实验结果 - 后台管理</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/admin_work_result.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.bootcss.com/jquery-ui-bootstrap/0.5pre/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet">

    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/sortable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/fileinput.js" type="text/javascript"></script>
    <script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-ui-bootstrap/0.5pre/assets/js/jquery-ui-1.10.0.custom.min.js"></script>
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
                <li><a href="#"onclick="topnavclick(this)" name="1"><i
                        class="fa fa-2x fa-check-circle-o" ></i><br>审核申请</a></li>

                <li><a href="#" onclick="topnavclick(this)" name="2"><i
                        class="fa fa-2x fa-envelope-open-o"></i><br>采样信息</a>
                </li>

                <li class="active"><a href="#" onclick="topnavclick(this)" name="3"><i
                        class="fa fa-2x fa-sticky-note"></i><br>实验结果</a>
                </li>
                <li><a href="#" onclick="topnavclick(this)" name="4"><i
                        class="fa fa-2x fa-newspaper-o"></i><br>项目发布</a>
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
                <i class="fa fa-sticky-note"></i>
                <h1>EXPERIMENTAL RESULT /</h1>
                <p>实验结果</p>
            </div>
        </div>
    </div>
</div>


<!-- content -->
<div class="content">
    <div class="container">
        <div class="intro-panel">
            <div class="choose-type">
                <label style="margin-right:50px;">
                    <input type="radio" name="options" id="option1" value="1" checked="checked"> 上传样本结果
                </label>
                <label style="margin-left:50px;">
                    <input type="radio" name="options" id="option2" value="2"> 上传实验报告
                </label>
            </div>

            <div class="row">
                <div class="col-sm-10 services-title wow fadeIn" style="margin-left:70px;">
                </div>
            </div>

            <div class="row" style="padding-top:30px;padding-left:50px">

                <div id="show-sample" class="col-xs-6 col-sm-5" style="display: block;">
                    <a class="pull-left label-pon">样本编号：</a>
                    <input id="tags" class="ui-autocomplete-input" autocomplete="off">

                </div>

                <div id="show-project" class="col-xs-6 col-sm-5" style="display: none">
                    <a class="pull-left label-pon">项目名称：</a>
                    <input id="tags-project" class="ui-autocomplete-input" autocomplete="off">
                </div>

                <div class="col-xs-6 col-sm-6">
                    <button  id="reset" type="button" class="btn btn-default pull-right" style="margin-left:20px">重置</button>
                    <button  id="save" type="button" class="btn btn-info pull-right">保存</button>

                </div>
            </div>
            <br>

            <div id="text-pon" style="display:block;">
            <a class="set-pon">文字编辑：</a>
            <div class="container-text">
                <form role="form">
                    <div class="form-group">
                        <textarea id="text" class="form-control" rows="22" style="width: 1025px;"></textarea>
                    </div>
                </form>
            </div>
            </div>

            <div id="pdf-pon" style="display: none;">
            <a class="set-pon" style="margin-top:-30px;">上传实验报告：</a>
            <div class="container-img kv-main">
                <form  enctype="multipart/form-data" >
                    <div class="form-group">
                        <input id="file-1" type="file" name="file"  class="file" data-overwrite-initial="false" multiple data-min-file-count="1">
                    </div>
                    <hr>
                    <br>
                </form>
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


<!-- Javascript &ndash;&gt;
<script src="//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>

--></body>
<script>
    function topnavclick(type) {
        if(type.name==="1"){
            window.location.href="toAdmin.do"
        }
        if(type.name==="2"){
            window.location.href="toAdmin_Sample.do"
        }
        if(type.name==="3"){
            window.location.href="toAdmin_Sample_Result.do"
        }
        if(type.name==="4"){
            window.location.href="toAdmin_Project.do"
        }
    }

    $(function () {

        $("#reset").click(function () {
               window.location.href="to_Admin_Work_Result.do";

            })
        $("#save").click(function (){
            if($("#option1").prop("checked")==true) {
                if($("#text").val()==""||$("#tags").val()==""){
                    alert("信息填写不完整");}
                else {
                    $.ajax({
                        url: "./getSampleResultTest",
                        type: "post",
                        async: false,
                        data: {"id": $("#tags").val()},
                        success: function (data) {
                            if(data==1){
                                $.ajax({
                                    url: "./uploadResult",
                                    type: "post",
                                    data: {"idSample": $("#tags").val(), "description": $("#text").val()},
                                    success: function (data) {
                                        alert(data);
                                    }
                                })
                            }
                            if(data==-1){
                                alert("样本编号不存在");
                            }
                            if(data==0){
                                alert("样本尚未收取");
                            }
                            if(data==2){
                                alert("该样本已上传实验结果");
                            }
                        }

                    })
                }
            }
            else {
                if($("#tags-project").val()==""){
                    alert("项目名称未填写");
                }
                else{
                    $.ajax({
                        url:"./uploadProjectResult",
                        type:"POST",
                        data:{"project":$("#tags-project").val()},
                        success:function (data) {
                            alert(data);
                            $("#file-1").fileinput("upload");
                        }
                    })
                }

            }

        })
    })
    $("#file-1").fileinput({
        uploadUrl: './uploadProjectFile', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['pdf'],
        language:'zh',
        overwriteInitial: false,
        uploadAsync:false,
        maxFileSize: 10000,
        maxFilesNum: 10,
        showUpload: false,
        previewFileIcon: "",
        uploadExtraData: function (previewId, index) {
            var data={
                "project" : $("#tags-project").val(),
            }
            return data;
        },
    }).on("fileuploaded", function(event, data) {
        if($("#tags").val()=="")
        {
            alert("标号未填写上传失败");
        }
    });

    $("#option1").click(function () {
        $("#show-sample").show();
        $("#show-project").hide();
        $("#text-pon").show();
        $("#pdf-pon").hide();
    })

    $("#option2").click(function () {
        $("#show-sample").hide();
        $("#show-project").show();
        $("#text-pon").hide();
        $("#pdf-pon").show();
    })
</script>

<script type="text/javascript">
    $.ajax({
        url:"getSampleID",
        type:"post",
        async:false,
        success:function (data) {
            var availableTags = $.parseJSON(data);
            $("#tags").autocomplete({
                source: availableTags
            });
        }
    })


</script>
<script>
    $.ajax({
        url:"getProjectName",
        type:"post",
        async:false,
        success:function (data) {
            var availableTag = $.parseJSON(data);
            $("#tags-project").autocomplete({
                source: availableTag
            });
        }
    })
</script>
</html>