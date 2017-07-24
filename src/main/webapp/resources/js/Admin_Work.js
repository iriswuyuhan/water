$(function(){
    $("#mainwrapper").show();
    $("#downloadwrapper").hide();
    $.ajax({
        url:"./applylist",
        type:'post',
        async:false,
        data:{"state":"审核通过"},
        success:function (data) {
            var obj = $.parseJSON(data);
            var passlist = obj;
            if(passlist.length>0){
                scrolist("审核通过",passlist);
                var id = passlist[0].idApply;
                setinitinfo(id);
            }
            else{
                $("#content2").hide();
                $("#nothing2").show();
            }
        }
    });
    $.ajax({
        url:"./applylist",
        type:'post',
        async:false,
        data:{"state":"未通过审核"},
        success:function (data) {
            var obj = $.parseJSON(data);
            var nolist = obj;

            if(nolist.length>0){
                scrolist("未通过审核",nolist);
                var id = nolist[0].idApply;
                setinitinfo(id);
            }
            else{
                $("#content3").hide();
                $("#nothing3").show();
            }
        }
    });
    $.ajax({
        url:"./applylist",
        type:'post',
        async:false,
        data:{"state":"待审核"},
        success:function (data) {
            var obj = $.parseJSON(data);
            var waitlist = obj;
            if(waitlist.length>0){
                scrolist("待审核",waitlist);
                var id = waitlist[0].idApply;
                setinitinfo(id);
            }
            else{
                $("#content1").hide();
                $("#nothing1").show();
            }
        }
    });
    $(".tyo").click(function () {
        $("#mainwrapper").hide();
        $("#downloadwrapper").hide();
        $("#nav li").removeClass();
        $(this).parent().prop("class","active");
        var name =    $(this).find("h4").html();
        if(name==="审核申请")
            $("#mainwrapper").show();
        if(name==="下载采样信息")
            $("#downloadwrapper").show();
    })
    $(".state").click(function () {
        $("#tabs li").prop("id","");
        $(this).parent().prop("id","current");
        $("#tab1").hide();
        $("#tab2").hide();
        $("#tab3").hide();
        var  name = $(this).html();
        if(name==="待审核"){
            $("#tab1").show();
        }
        if(name==="审核通过"){
            $("#tab2").show();
        }
        if(name==="未通过审核"){
            $("#tab3").show();
        }
    });
    function scrolist(tem,list) {
        if(tem==="待审核"){
            $("#scro1").empty();
            $("#scro1").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){
                $("#scro1").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }
        if(tem==="审核通过"){
            $("#scro2").empty();
            $("#scro2").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){
                $("#scro2").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }
        if(tem==="未通过审核"){
            $("#scro3").empty();
            $("#scro3").append("<li class='active'><a onclick='applyClick(this)'>"+list[0].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            for(var i =1;i<list.length;i++){
                $("#scro3").append("<li class=''><a onclick='applyClick(this)'>"+list[i].idApply+"</a><span class='fa fa-angle-right'></span></li>")
            }
        }

    }

    $("#search").click(function () {
        var id = $("#input").val();
        $.ajax({
            url:'./getApplyInfo',
            type:'post',
            async:'false',
            data:{"id":id},
            success: function (data) {
                var obj1 = $.parseJSON(data);
                alert(obj1);
                if (obj1!==null) {
                    var temp = obj1;
                    var obj;
                    $("#tabs li").prop("id", "");
                    $("#tab1").hide();
                    $("#tab2").hide();
                    $("#tab3").hide();

                    if (temp.state === 0) {
                        obj = $("#tab1")
                        $("#tab1").show();
                        $("#tabs").find("li[name='s1']").prop("id", "current")
                        $("#scro1").find("li").each(function () {
                            $(this).removeClass("active");
                        });

                        $("#scro1").find("a").each(function () {
                            if ($(this).html() === id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    if (temp.state === 1) {
                        obj = $("#tab2")
                        $("#tab2").show();
                        $("#tabs").find("li[name='s2']").prop("id", "current")
                        $("#scro2").find("li").each(function () {
                            $(this).removeClass("active");
                        });

                        $("#scro2").find("a").each(function () {
                            if ($(this).html() === id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    if (temp.state === 2) {
                        obj = $("#tab3")
                        $("#tab3").show();
                        $("#tabs").find("li[name='s3']").prop("id", "current")
                        $("#scro3").find("li").each(function () {
                            $(this).removeClass("active");
                        });

                        $("#scro3").find("a").each(function () {
                            if ($(this).html() === id)
                                $(this.parentNode).addClass("active");
                        })
                    }
                    $(".time").each(function () {
                        $(this).html(timeFormatter(temp.applyDate));
                    })
                    obj.find("span[name='name']").each(function (index) {
                        if (index === 0)
                            $(this).html(temp.name);
                        if (index === 1)
                            $(this).html(temp.number);
                        if (index === 2)
                            $(this).html(temp.address);
                        if (index === 3)
                            $(this).html(temp.longitude+"°");
                        if (index === 4)
                            $(this).html(temp.latitude+"°");
                        if (index === 5)
                            $(this).html(temp.waterAddress);
                    });
                    obj.find("h1").each(function () {
                        $(this).html(temp.idApply);
                    })
                }
                else{
                    alert("编号不存在");
                }
            }

        })
    })

});
function dealApply(type){
    var state;
    if(type.className==="yes button")
        state="1";
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

function  applyClick(type) {
    var id = type.innerHTML;
    $.ajax({
        url:'./getApplyInfo',
        type:'post',
        async:'false',
        data:{"id":id},
        success: function (data) {
            var obj1 = $.parseJSON(data);
            setinfo(obj1);
        }

    });
    function setinfo(temp) {
        var obj;
        if(temp.state===0){

            obj=$("#tab1");
            $("#scro1").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        if(temp.state===1){

            obj=$("#tab2");

            $("#scro2").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        if(temp.state===2){

            obj=$("#tab3");
            $("#scro3").find("li").each(function() {
                $(this).removeClass("active");
            });
            $(type.parentNode).addClass("active");
        }
        $(".time").each(function () {
            $(this).html(timeFormatter(temp.applyDate));
        });
        obj.find("span[name='name']").each(function (index) {
            if(index===0)
                $(this).html(temp.name

                );
            if(index===1)
                $(this).html(temp.number);
            if(index===2)
                $(this).html(temp.address);
            if(index===3)
                $(this).html(temp.longitude+"°");
            if(index===4)
                $(this).html(temp.latitude+"°");
            if(index===5)
                $(this).html(temp.waterAddress);
        });
        obj.find("h1").each(function () {
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
            if(temp.state===0){
                obj=$("#tab1")
            }
            if(temp.state===1){
                obj=$("#tab2")
            }
            if(temp.state===2){
                obj=$("#tab3")
            }
            $(".time").each(function () {
                $(this).html(timeFormatter(temp.applyDate));
            });
            obj.find("span[name='name']").each(function (index) {
                if(index===0)
                    $(this).html(temp.name);
                if(index===1)
                    $(this).html(temp.number);
                if(index===2)
                    $(this).html(temp.address);
                if(index===3)
                    $(this).html(temp.longitude+"°");
                if(index===4)
                    $(this).html(temp.latitude+"°");
                if(index===5)
                    $(this).html(temp.waterAddress);
            });
            obj.find("h1").each(function () {
                $(this).html(temp.idApply);
            })
        }
    })
}

function timeFormatter(value) {
    return (1900 + value.year) + "-" + (value.month + 1) + "-" + value.date + " " + value.hours + ":" + value.minutes + ":" + value.seconds;
}
/*轮播*/