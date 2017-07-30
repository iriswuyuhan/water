$(function () {
    $.ajax({
        url:"./getSampleList",
        type:"post",
        async:false,
        success:function (data) {
            var obj = $.parseJSON(data);
            var  sampleList = obj;
            if(sampleList.length>0){
                sampleScro(sampleList);
                setSampleInfo(sampleList[0]);
            }
            else{
                $("#content4").hide();
                $("#nothing4").show();

            }
        }
    });
    $(".tyo").click(function () {
        $("#nav li").removeClass();
        $(this).parent().prop("class","active");
        var name =    $(this).find("h4").html();
        if(name==="审核申请")
            window.location.href="toAdmin.do";
        if(name==="下载采样信息")
            window.location.href="toAdmin_Sample.do"
    })
    $("#search1").click(function () {
        var id = $("#input1").val();
        $.ajax({
            url: "./getSample",
            type: "post",
            async: false,
            data:{"id":id},
            success: function (data) {
                var obj = $.parseJSON(data);
                if(obj!==null){
                setSampleInfo(obj);
                    $("#scro4").find("li").each(function() {
                        $(this).removeClass("active");
                    });
                    $("#scro4").find("a").each(function () {
                        if($(this).html()===id)
                            $(this.parentNode).addClass("active");
                    })}
                else {
                    alert("样本编号不存在");
                }
            }
        });

    });
    function  sampleScro(list) {
        $("#scro4").find("li").remove();
        $("#scro4").append("<li class='active'><a onclick='sampleClick(this)'>"+list[0].idSample+"</a><span class='fa fa-angle-right'></span></li>")
        for(var i =1;i<list.length;i++){
            $("#scro4").append("<li class=''><a onclick='sampleClick(this)'>"+list[i].idSample+"</a><span class='fa fa-angle-right'></span></li>")
        }
    }

})
function  setSampleInfo(temp) {
    $("#sample").html(temp.idSample);
    $(".sample_time").html(timeFormatter1(temp.sampleDate));
    $("#content4").find("span[name='name']").each(function (index) {
        if(index===0)
            $(this).html(temp.apply.name);
        if(index===1)
            $(this).html(temp.apply.idApply);
        if(index===2)
            $(this).html(timeFormatter1(temp.apply.applyDate));
        if(index===3)
            $(this).html(temp.volume);
        if(index===4)
            $(this).html(temp.apply.waterAddress);
        if(index===5)
            $(this).html(temp.remark);
        if(index===6)
            $(this).html(temp.apply.number);
        if(index==7)
            $(this).html(temp.apply.longitude+"°");
        if(index==8)
            $(this).html(temp.apply.latitude+"°");
        if(index==9){
            if(temp.state==1) {
                $(this).html("处理中");
                $("#confirm").hide();
            }
            if(temp.state==2) {
                $(this).html("已上传实验结果");
                $("#confirm").hide();
            }
            if(temp.state==0) {
                $(this).html("待收取");
                $("#confirm").show();
            }
        }


        $("#downlo1").attr("href","/samples/"+temp.idSample+".txt");
        $("#downlo1").attr("download",temp.idSample+".txt");

    })
    $("#content4").find("ol").each(function () {
        $(this).empty();
        for(var i=0;i<temp.apply.image.length;i++){
            $(this).append("<li data-target='#myCarousel3' data-slide-to='"+i+"'></li>");
        }
    })
    $("#content4").find(".carousel-inner").each(function () {
        $(this).empty();
        $(this).append("<div class='item active'>"+
            "<img src='../resources/txt/"+temp.apply.image[0]+"'></div>");
        for(var i=1;i<temp.apply.image.length;i++){
            $(this).append("<div class='item'>"+
                "<img src='../resources/txt/"+temp.apply.image[i]+"'></div>");
        }
    })
}
function  sampleClick(type) {
    var id = type.innerHTML;
    $.ajax({
        url: "./getSample",
        type: "post",
        async: false,
        data:{"id":id},
        success: function (data) {
            var obj = $.parseJSON(data);
            setSampleInfo(obj)
        }
    });

    $("#scro4").find("li").each(function() {
        $(this).removeClass("active");
    });
    $(type.parentNode).addClass("active");
}

function confirmClik(type) {
        if(confirm("确认更改状态")){
            var id = $("#sample").html();
            $.ajax({
                url: "./sampleState",
                type: "post",
                async: false,
                data:{"idSample":id,"state":1},
                success: function (data) {
                    var bool = $.parseJSON(data);
                    if(bool){
                        alert("已改为处理中");
                        location.reload();
                    }
                }
            });
        }
        else{
            alert("取消");
        }
}
function timeFormatter1(value) {
    return (1900 + value.year) + "-" + (value.month + 1) + "-" + value.date + " " + value.hours + ":" + value.minutes + ":" + value.seconds;
}