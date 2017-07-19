/**
 * Created by zhanglei on 2017/7/18.
 */

$(function(){
    $("#butt").click(function(){
        var name = $("#idname").val();
        var sexb = $("#x11:checked").val();
        var sexg = $("#x12:checked").val();
        var sex;
        if(sexb){
            sex="男";
        }
        else
            sex="女";
        var phone = $("#phone").val();
        var address = $("#address").val();
        $.ajax({
            url:"./ad",
            type:"post",
            data:{"name":name,"sex":sex,"phone":phone,"address":address},
            success:function (data) {
                alert(data);

            }
        });
    })
    $("#address").click(function(){


    })


})

