/**
 * Created by lenovo on 2017/7/20.
 */
function load() {
    var useCook=$.cookie('ret1');
    if(useCook==='1'){
        $("#receive_addr").text($.cookie('add1'));
        $.cookie('ret1',null,{path:'/'});
        $.cookie('add1',null,{path:'/'});
        checkFullfill();
    }
}

function reLoc(){
    var url="../wx/locate.html?add=";
    var curAdd=document.getElementById("receive_addr").innerHTML;
    window.location.href=url+curAdd;
}

$("#confirm").click(function () {
    if($("#confirm").hasClass("weui-btn_disabled")){
        return;
    }
    var userID=$("#userID").val();
    $.ajax({
        url:"../user/j"+userID+"/confirm",
        type:'get',
        async:false,
        data:{"name":$("#name").val(),"phone_num":$("#phone_num").val(),
            "address":$("#receive_addr").text()},
        success:function (data) {
            if(data){
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') !== 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                    nextPage();
                }, 2000);
            }else{
                alert("修改信息失败");
            }
        }
    });
});

//跳到下一个界面
var userID=$("#userID").val();
function nextPage() {
    var nextUrl=$("#next").val();
    if(nextUrl=="apply"){
        window.location.href="../init/j"+userID;
    }else if(nextUrl=="sample"){
        window.location.href="j"+userID+"/history?type=1";
    }else if(nextUrl=="default"){
        window.location.href="j"+userID+"/history?type=0";
    }
}

//确认按钮状态转换
function checkFullfill() {
    if($("#name").val()===""||$("#phone_num").val()===""||$("#receive_addr").text()===""){
        $("#confirm").addClass("weui-btn_disabled");
        return;
    }
    //输入完成
    $("#confirm").removeClass("weui-btn_disabled");
}

$("#name").on('input propertychange', function () {
    checkFullfill();
});
$("#phone_num").on('input propertychange', function () {
    checkFullfill();
});