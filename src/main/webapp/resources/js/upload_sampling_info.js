/**
 * Created by lenovo on 2017/7/18.
 */

$("#sample_time").on('input propertychange', function () {
    checkFullfill();
});
$("#sample_volume").on('input propertychange', function () {
    checkFullfill();
});
$("#sample_number").on('input propertychange', function () {
    checkFullfill();
});
$("#sample_remark").on('input propertychange', function () {
    checkFullfill();
});

function checkFullfill() {
    if($("#sample_time").val()===""||$("#sample_volume").val()===""||$("#sample_number").val()===""
        ||$("#sample_remark").val()===""){
        $("#upload_but").addClass("weui-btn_disabled");
        return;
    }
    //输入完成
    $("#upload_but").removeClass("weui-btn_disabled");
}

$("#upload_but").click(function () {
    if($("#upload_but").hasClass("weui-btn_disabled")){
        return;
    }
    var userID=$("#userID").val();
    var sampleID=$("#sampleID").val();
    $.ajax({
        url:"/upload/j"+sampleID+"/confirm",
        type:'get',
        async:false,
        data:{"sample_time":$("#sample_time").val(),"sample_volume":$("#sample_volume").val(),
            "sample_number":$("#sample_number").val(),"sample_remark":$("#sample_remark").val()},
        success:function (data) {
            if(data){
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') !== 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                    window.location.href="/user/j"+userID+"/history";
                }, 2000);
            }else{
                //没有上传成功
                // alert("该采样编号已存在或者该申请已上传样品");
                $("#alert").show();
            }
        }
    });
});

function hideAlert() {
    $("#alert").hide();
    $("#sample_number").val("");
    $("#upload_but").addClass("weui-btn_disabled");
}