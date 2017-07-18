/**
 * Created by Administrator on 2017/7/18 0018.
 */
$(function () {
    var list;
    $.ajax({
        url:"./applylist",
        type:'post',
        async:false,
        data:{"name":"待审核"},
        success:function (data) {
            var obj = $.parseJSON(data);
            list = obj;
            scrolist("待审核");
            if(list.length>0){
                var id = list[0].idApply;
                setinitinfo(id);
            }
        }
    });


    $(".state").click(function () {
        $("#tabs li").prop("id","");
        $(this).parent().prop("id","current");
        $("#tab1").hide();
        $("#tab2").hide();
        $("#tab3").hide();
       var  name = $(this).html();
        if(name=="待审核"){
            $("#tab1").show();
        }
        if(name=="审核通过"){
            $("#tab2").show();
        }
        if(name=="未通过审核"){
            $("#tab3").show();
        }
         $.ajax({
            url:"./applylist",
            type:'post',
            async:false,
            data:{"name":name},
            success:function (data) {
                var obj =$.parseJSON(data);
                list=obj;
                if(list.length>0) {
                    scrolist(name);
                }
            }
        })


    })
    function scrolist(tem) {
        if(tem=="待审核"){
            $("#scro1").empty();
            $("#scro1").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){

                $("#scro1").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }
        if(tem=="审核通过"){
            $("#scro2").empty();
            $("#scro2").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){
                $("#scro2").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }
        if(tem=="未通过审核"){
            $("#scro3").empty();
            $("#scro3").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){
                $("#scro3").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }

    }

    $("#search").click(function () {
        var id = $("#input").val();
        setinitinfo(id);
    })

})
 function dealApply(type){
    var state;
    if(type.className=="yes button")
        state="1"
     else
         state="0";
    var id = $("#applyid").html();
     $.ajax({
         url:"./dealApply",
         type:'post',
         data:{"id":id,"state":state},
         success:function (data) {
             alert(data);
             window.location.href="toAdmin.do";
         }
     })

 }
function  applyClick(type) {
   var id = type.innerHTML;
    $.ajax({
        url:'./getApplyInfo',
        type:'post',
        async:'false',
        data:{"id":id},
        success: function (data) {
            var obj = $.parseJSON(data);
            setinfo(obj,type);
        }

    });
    function setinfo(temp) {
        var obj;
        if(temp.state==0){
            obj=$("#tab1")
            $("#scro1").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        if(temp.state==1){
            obj=$("#tab2")
            $("#scro2").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        if(temp.state==2){
            obj=$("#tab3")
            $("#scro3").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        $(".time").each(function () {
            $(this).html(temp.address);
        })
        obj.find("span[name='name']").each(function (index) {
            if(index==0)
                $(this).html(temp.address);
            if(index==1)
                $(this).html(temp.number);
            if(index==2)
                $(this).html(temp.address);
            if(index==3)
                $(this).html(temp.longitude);
            if(index==4)
                $(this).html(temp.latitude);
        });

        obj.find("h4").each(function () {
            $(this).html(temp.idApply);
        })

    }

}
function  setinitinfo(id) {
    $.ajax({
        url:'./getApplyInfo',
        type:'post',
        async:'false',
        data:{"id":id},
        success: function (data) {
            var obj1 = $.parseJSON(data);
            var temp = obj1;
            var obj;
            if(temp.state==0){
                obj=$("#tab1")
            }
            if(temp.state==1){
                obj=$("#tab2")
            }
            if(temp.state==2){
                obj=$("#tab3")
            }
            $(".time").each(function () {
                $(this).html(temp.address);
            })
            obj.find("span[name='name']").each(function (index) {
                if(index==0)
                    $(this).html(temp.address);
                if(index==1)
                    $(this).html(temp.number);
                if(index==2)
                    $(this).html(temp.address);
                if(index==3)
                    $(this).html(temp.longitude);
                if(index==4)
                    $(this).html(temp.latitude);
            });
            obj.find("h4").each(function () {
                $(this).html(temp.idApply);
            })
        }
    })
}