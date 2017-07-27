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
    <title>河流生态地图-管理 </title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"/>

    <!--    &lt;!&ndash; Favicon and touch icons &ndash;&gt;
        <link rel="shortcut icon" href="assets/ico/favicon.ico">-->


</head>

<body>
<div id="content">
    <!-- Begin Content -->


    <form name="login-form" class="login-form" action="" method="post">

        <div class="header">
            <img src="${pageContext.request.contextPath}/resources/img/Title.png">
            <hr>
        </div>

        <div class="content">
            <input name="username" type="text" class="input username" placeholder="Username" />
            <div class="user-icon"></div>
            <input name="password" type="password" class="input password" placeholder="Password" />
            <div class="pass-icon"></div>
        </div>

        <div class="footer">
            <a href="#" id="login" class="button">Login</a>
        </div>
        <script src="http://code.jquery.com/jquery-1.6.3.min.js"></script>
        <script type="text/javascript">
            $(function () {

                $("#login").click(function () {
                    if($(".username").val()==""||$(".password").val()==""){
                        alert("信息填写不完整")
                    }
                    else{

                        $.ajax({
                           url:'./login',
                            type:'post',
                            data:{"username":$(".username").val(),"password":$(".password").val()},
                            success:function (data) {
                               window.location.href="toAdmin.do"
                            }

                        });
                    }
                })
            })
        </script>
    </form>

</div>
<!-- End Content -->
</div>
</body>

</html>