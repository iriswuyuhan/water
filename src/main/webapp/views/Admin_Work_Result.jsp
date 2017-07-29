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
    <title>采样信息 - 后台管理</title>
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="../resources/css/admin_work_result.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="../resources/js/sortable.js" type="text/javascript"></script>
    <script src="../resources/js/fileinput.js" type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="//cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>
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
                        class="fa fa-2x fa-sitemap" ></i><br>审核申请</a></li>

                <li><a href="#" onclick="topnavclick(this)" name="2"><i
                        class="fa fa-2x fa-tasks"></i><br>采样信息</a>
                </li>

                <li class="active"><a href="#" onclick="topnavclick(this)" name="3"><i
                        class="fa fa-2x fa-tasks"></i><br>实验结果</a>
                </li>
                <li><a href="#" onclick="topnavclick(this)" name="4"><i
                        class="fa fa-2x fa-tasks"></i><br>项目管理</a>
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
                <i class="fa fa-sitemap"></i>
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


            <div class="row" style="padding-top:30px;padding-left:50px">
                <div class="col-xs-6 col-sm-5">
                    <a class="pull-left label-pon">样本编号：</a>
                    <input id="idSample" class="form-control pull-left" maxlength="8" required="" type="text" style="width:200px;" >
                </div>
                <div class="col-xs-6 col-sm-6">
                    <button  id="reset" type="button" class="btn btn-default pull-right" style="margin-left:20px">重置</button>
                    <button  id="save" type="button" class="btn btn-info pull-right">保存</button>

                </div>
            </div>
            <br>
            <a class="set-pon">文字编辑：</a>
            <div class="container-text">
                <form role="form">
                    <div class="form-group">
                        <textarea id="text" class="form-control" rows="12"></textarea>
                    </div>
                </form>
            </div>
            <br>
            <a class="set-pon">图片上传：</a>
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
<script src="./resources/js/Admin_Work.js"></script>
<script>
    $(function () {
        $("#reset").click(function () {
               window.location.href="to_Admin_Work_Result.do";

            })
        $("#save").click(function () {
            alert(1);
            $.ajax({
                url:"getSample",
                type:"post",
                async:false,
                data:{"id":$("#idSample").val()},
                success:function (data) {
                    alert(data);
                    if(data==null){
                        alert("样本编号不存在");
                    }
                    else{
                        $("#file-1").fileinput("upload");
                        $.ajax({
                            url:"./uploadResult",
                            type:"post",
                            data:{"idSample":$("#idSample").val(),"description":$("#text").val()},
                            success:function (data) {
                                alert(data);
                            }
                        })
                    }
                }
            })
        })
    })
    $("#file-1").fileinput({
        uploadUrl: '/uploadSampleResultImg', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        language:'zh',
        overwriteInitial: false,
        uploadAsync:false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        showUpload: false,
        previewFileIcon: "",
        uploadExtraData: function (previewId, index) {
            var data={
                "idSample" : $("#idSample").val(),
            }
            return data;
        },
    }).on("fileuploaded", function(event, data) {
        if($("#idSample").val()=="")
        {
            alert("标号未填写上传失败");
        }
    });

</script>

</html>