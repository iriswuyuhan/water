/**
 * Created by lenovo on 2017/7/20.
 */
//跳到定位地址页面
function jump_to_receive_addr(){
    $.ajax({
        url:"/user/j"+userID+"/saveUserToSession",
        type:'get',
        async:false,
        data:{"name":$("#name").val(),"phone_num":$("#phone_num").val(),
            "address":$("#receive_addr").val()},
        success:function (data) {
            //跳转到定位地址

        }
    });
}

function load() {
   var useCook=$.cookie('ret1');
   if(useCook==='1'){
        $("#receive_addr").val($.cookie('add1'));
        $.cookie('ret1',null);
        $.cookie('add1',null);
   }
}

function reLoc(){
    var url="/wx/locate.html?add=";
    var curAdd=document.getElementById("receive_addr").innerHTML;
    window.location.href=url+curAdd;
}

$("#confirm").click(function () {
    if($("#confirm").hasClass("weui-btn_disabled")){
        return;
    }
    var userID=$("#userID").val();
    $.ajax({
        url:"/user/j"+userID+"/confirm",
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
                    window.location.href="/user/j"+userID+"/history";
                }, 2000);
            }else{
                alert("修改信息失败");
            }
        }
    });
});

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
$("#receive_addr").on('input propertychange', function () {
    checkFullfill();
});