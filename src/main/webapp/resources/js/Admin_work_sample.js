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
                setSampleInfo(obj)
                    $("#scro4").find("li").each(function() {

                        $(this).removeClass("active");
                    });
                    $("#scro4").find("a").each(function () {
                        if($(this).html()==id)
                            $(this.parentNode).addClass("active");
                    })}
                else {
                    alert("样本编号不存在");
                }
            }
        });

    })
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
        if(index==0)
            $(this).html(temp.apply.name);
        if(index==1)
            $(this).html(temp.apply.idApply);
        if(index==2)
            $(this).html(timeFormatter1(temp.apply.applyDate));
        if(index==3)
            $(this).html(temp.volume);
        if(index==4)
            $(this).html(temp.apply.waterAddress);
        if(index==5)
            $(this).html(temp.remark);
        if(index==6)
            $(this).html(temp.apply.number);
        if(index==7)
            $(this).html(temp.longitude);
        if(index==8)
            $(this).html(temp.latitude);

    });
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
function timeFormatter1(value) {
    return (1900 + value.year) + "-" + (value.month + 1) + "-" + value.date + " " + value.hours + ":" + value.minutes + ":" + value.seconds;
}