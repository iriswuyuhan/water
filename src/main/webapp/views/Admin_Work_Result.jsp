<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<!-- release v4.4.3, copyright 2014 - 2017 Kartik Visweswaran -->
<!--suppress JSUnresolvedLibraryURL -->
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="./resources/js/sortable.js" type="text/javascript"></script>
    <script src="./resources/js/fileinput.js" type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container kv-main">
    <form  enctype="multipart/form-data" >
        <div class="form-group">
            <input id="file-1" type="file" name="file"  class="file" data-overwrite-initial="false" multiple data-min-file-count="1">
        </div>
        <hr>
        <br>
    </form>
</div>
</body>
<script>
    $(function () {

    })
    $("#file-1").fileinput({
        uploadUrl: '/uploadSampleResultImg', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        language:'zh',
        overwriteInitial: false,
        uploadAsync:false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        showUpload: true,
        //allowedFileTypes: ['image', 'video', 'flash'],
        previewFileIcon: ""
    })
        .on("fileuploaded", function(event, data) {
            if(data.response)
            {

            }
        });

</script>
</html>