/**
 * Created by lenovo on 2017/7/20.
 */
//跳到定位地址页面
function jump_to_receive_addr(){
    $("#receive_addr").text("江苏省南京市栖霞区仙林大道163号");
}

$("#confirm").click(function () {
    var userID=$("#userID").val();
    $.ajax({
        url:"/user/j"+userID+"/confirm",
        type:'get',
        async:false,
        data:{"name":$("#name").val(),"phone_num":$("#phone_num").val(),
            "sample_number":$("#sample_number").val()},
        success:function (data) {
            if(data){
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') != 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                }, 2000);
            }
        }
    });
});