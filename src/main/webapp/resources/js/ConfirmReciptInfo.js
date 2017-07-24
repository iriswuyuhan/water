/**
 * Created by zhanglei on 2017/7/18.
 */

$(function(){
    $("#butt").click(function(){
        var notnull=true;
        var name = $("#idname").val();
        var sexb = $("#x11:checked").val();
        var sexg = $("#x12:checked").val();
        var phone = $("#phone").val();
        var address = $("#address").val();
        if(name===""||phone===""||address===""){
            notnull=false;
        }
        var sex;
        if(sexb){
            sex="男";
        }
        else
            sex="女";

        if(notnull===false){
        alert("不能为空");

        }
        else {

            $.ajax({
                url: "./ad",
                type: "post",
                data: {"name": name, "sex": sex, "phone": phone, "address": address},
                success: function (data) {
                    alert(data);

                }
            });
        }
    });
    $("#address").click(function(){


    })


});

