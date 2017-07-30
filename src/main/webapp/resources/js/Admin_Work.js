$(function () {
    init("待审核");
    init("审核通过");
    init("未通过审核");
    function init(state) {
        $.ajax({
            url:"./applylist",
            type:'post',
            async:false,
            data:{"state":state},
            success:function (data) {
                var obj = $.parseJSON(data);
                var waitlist = obj;
                if(waitlist.length>0){
                    scrolist(state,waitlist);
                    setinitinfo(waitlist[0]);
                }
                else{
                    if(state=="待审核"){
                        $("#content1").hide();
                        $("#nothing1").show();}
                    if(state=="审核通过"){
                        $("#content2").hide();
                        $("#nothing2").show();
                    }
                    if(state=="未通过审核"){
                        $("#content3").hide();
                        $("#nothing3").show();
                    }
                }
            }
        });
    }
    //左侧导航列表的实现
    function scrolist(tem,list) {
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
    //申请导航的跳转
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
    })


    //搜索功能
    $("#search").click(function () {
        var id = $("#input").val();
        $.ajax({
            url:'./getApplyInfo',
            type:'post',
            async:'false',
            data:{"id":id},
            success: function (data) {
                var obj1 = $.parseJSON(data);
                if (obj1!==null) {
                    var temp = obj1;
                    var obj;
                    $("#tabs li").prop("id", "");
                    $("#tab1").hide();
                    $("#tab2").hide();
                    $("#tab3").hide();
                    if (temp.state == 0) {
                        obj = $("#tab1")
                        $("#tab1").show();
                        $("#tabs").find("li[name='s1']").prop("id", "current")
                        $("#scro1").find("li").each(function () {
                            $(this).removeClass("active");
                        });
                        $("#scro1").find("a").each(function () {
                            if ($(this).html() == id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    if (temp.state == 1) {
                        obj = $("#tab2")
                        $("#tab2").show();
                        $("#tabs").find("li[name='s2']").prop("id", "current")
                        $("#scro2").find("li").each(function () {
                            $(this).removeClass("active");
                        });

                        $("#scro2").find("a").each(function () {
                            if ($(this).html() == id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    if (temp.state == 2) {
                        obj = $("#tab3")
                        $("#tab3").show();
                        $("#tabs").find("li[name='s3']").prop("id", "current")
                        $("#scro3").find("li").each(function () {
                            $(this).removeClass("active");
                        });

                        $("#scro3").find("a").each(function () {
                            if ($(this).html() == id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    setinitinfo(obj1);
                }
                else{
                    alert("编号不存在");
                }
            }

        })
    })
})
//处理申请的实现
function dealApply(type){
    alert(1);
    var state;
    if(type.className=="yes button")
        state="1"
    else
        state="2";
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
function topnavclick(type) {
    if(type.name==="1"){
        window.location.href="toAdmin.do"
    }
    if(type.name==="2"){
        window.location.href="toAdmin_Sample.do"
    }
    if(type.name==="3"){
        window.location.href="toAdmin_Sample_Result.do"
    }
    if(type.name==="4"){
        window.location.href="toAdmin_Project.do"
    }
}
//导航点击事件的监听
function  applyClick(type) {
    var id = type.innerHTML;
    $.ajax({
        url: './getApplyInfo',
        type: 'post',
        async: 'false',
        data: {"id": id},
        success: function (data) {
            var obj1 = $.parseJSON(data);
            setactive(type, obj1);
            setinitinfo(obj1);
        }

    });
}
//设置导航为active状态的方法
function setactive(type,temp) {
    var obj;
    if(temp.state==0){
        obj=$("#tab1")
        $("#scro1").find("li").each(function() {
            $(this).removeClass("active");
        });
        $(type.parentNode).addClass("active");
    }
    if(temp.state==1) {
        obj = $("#tab2")
        $("#scro2").find("li").each(function () {
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

}
//初始化信息界面
function  setinitinfo(temp) {
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
    obj.find("ol").each(function () {
        $(this).empty();
        for(var i=0;i<temp.image.length;i++){
            $(this).append("<li data-target='#myCarousel3' data-slide-to='"+i+"'></li>");
        }
    })
    obj.find(".carousel-inner").each(function () {
        $(this).empty();
        $(this).append("<div class='item active'>"+
            "<img src='../resources/txt/"+temp.image[0]+"' alt='Second slide'></div>");
        for(var i=1;i<temp.image.length;i++){
            $(this).append("<div class='item'>"+
                "<img src='../resources/txt/"+temp.image[i]+"' alt='Second slide'></div>");
        }
    })
    $(".time").each(function () {
        $(this).html(timeFormatter(temp.applyDate));
    })
    obj.find("span[name='name']").each(function (index) {
        if(index==0)
            $(this).html(temp.name);
        if(index==1)
            $(this).html(temp.number);
        if(index==2)
            $(this).html(temp.address);
        if(index==3)
            $(this).html(temp.longitude);
        if(index==4)
            $(this).html(temp.latitude);
        if(index==5)
            $(this).html(temp.waterAddress);
    });
    obj.find("h1").each(function () {
        $(this).html(temp.idApply);
    })

}

//时间变成str的方法
function timeFormatter(value) {
    return (1900 + value.year) + "-" + (value.month + 1) + "-" + value.date + " " + value.hours + ":" + value.minutes + ":" + value.seconds;
}