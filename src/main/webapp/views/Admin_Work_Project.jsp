<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2017/7/29
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible"><!-- content="IE=edge">-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>项目发布 - 后台管理</title>

    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/styles.css">
    <link rel="stylesheet" href="../resources/css/test.css">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/test.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_work_project.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="././ico/favicon1.ico">

    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/summernote.js"></script>

    <!--<script src="lang/summernote-zh-CN.js"></script>-->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.6/lang/summernote-zh-CN.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/Admin_Work_Project.js"></script>

</head>

<body onload=load()>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            placeholder:"请输入内容",
            lang: 'zh-CN', // default: 'en-US'
            height: 400,
            focus:true,
            toolbar: [
                ['style', ['style']],
                ['font', ['bold', 'underline', 'clear']],
                ['fontname', ['fontname']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['table', ['table']],
                ['view', ['fullscreen', 'codeview']]
            ],
            airMode: false,

            width: null,

            tabSize: 4,
            styleWithSpan: false,
            shortcuts: true,
            textareaAutoSync: true,
            direction: null,

            styleTags: ['p', 'blockquote', 'pre', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6'],

            fontNames: [
                'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New',
                'Helvetica Neue', 'Helvetica', 'Impact', 'Lucida Grande',
                'Tahoma', 'Times New Roman', 'Verdana'
            ],

            fontSizes: ['8', '9', '10', '11', '12', '14', '18', '24', '36'],

            // pallete colors(n x n)
            colors: [
                ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
                ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
                ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
                ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
                ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
                ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
                ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
                ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
            ],

            lineHeights: ['1.0', '1.2', '1.4', '1.5', '1.6', '1.8', '2.0', '3.0'],

            tableClassName: 'table table-bordered',

            insertTableMaxSize: {
                col: 10,
                row: 10
            }
        });
    });
</script>

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

                <li><a href="#" onclick="topnavclick(this)" name="3"><i
                        class="fa fa-2x fa-sticky-note"></i><br>实验结果</a>
                </li>
                <li class="active"><a href="#" onclick="topnavclick(this)" name="4"><i
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
                <i class="fa fa-newspaper-o"></i>
                <h1>PUBLISH PROJECT/</h1>
                <p>项目发布</p>
            </div>
        </div>
    </div>
</div>


<!-- content -->
<div class="content">
    <div class="container">

        <div class="intro-panel">
            <div id = "mainwrapper" class="main_wrapper" style="display: block">
                <div id="main_content">
                    <div id="tab1" style="padding-top:40px;">
                        <div id="content1" class="table-content" style="display: block;">
                            <ul id="scro1" class="scroll indicator-group-title" style="width:170px;height:560px;overflow:auto;">
                                <li id="add" class="active" onclick=show("add")><a>新增项目</a><span class="fa fa-angle-right"></span></li>
                            </ul>
                            <div class="indicator-group-content">
                                <div style="padding-bottom:10px;">
                                    <form class="bs-example bs-example-form" role="form">
                                        <div class="input-group">
                                            <span class="input-group-addon">项目标题</span>
                                            <input id="headline" type="text" class="form-control" placeholder="请输入标题"/>
                                        </div>
                                    </form>
                                </div>
                                <div id="specialAlign">
                                    <div id="summernote"></div>
                                </div>
                                <div id="buttons">
                                    <button id="confirm" onclick="publish()" class="btn-info text-sign" style="padding:2px 7px 2px 7px;">提交</button>
                                    <button id="cancel" onclick="deleteAll()" class="btn-info text-sign" style="padding:2px 7px 2px 7px;">取消</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-sm-7 footer-copyright wow fadeIn">
                <p>
                    Copyright 2017 河流生态地图后台 - by <a
                        href="#">Noah's Ark</a>.
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
<script src="http://cdn.bootcss.com/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
<script src="http://cdn.bootcss.com/wow/1.1.2/wow.min.js"></script>
</body>

</html>
