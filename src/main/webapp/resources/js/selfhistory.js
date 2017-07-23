/**
 * Created by zhanglei on 2017/7/20.
 */
$("#unchecked_tab").click(function () {
    $("#unchecked_tab").addClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").show();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").hide();
});
$("#checked_tab").click(function () {
    if($("#loaded_checked").val()=="false"){
        $.ajax({
            url:"/user/j"+userID+"/history/getChecked",
            type:'get',
            async:false,
            data:{},
            success:function (data) {
                var html = "";
                data.forEach(function(goods){
                    html += loadChecked(goods);
                });
                $("#checked_tab_panel").append(html);
            }
        });
        $("#loaded_checked").val("true");
    }
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").addClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").show();
    $("#sampling_tab_panel").hide();
});
$("#sampling_tab").click(function () {
    if($("#loaded_sampling").val()=="false"){
        $.ajax({
            url:"/user/j"+userID+"/history/getSampling",
            type:'get',
            async:false,
            data:{},
            success:function (data) {
                var html = "";
                data.forEach(function(goods){
                    html += loadSampling(goods);
                });
                $("#sampling_tab_panel").append(html);
            }
        });
        $("#loaded_sampling").val("true");
    }
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").addClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").show();
});

function ondelete(index) {
    $.ajax({
        url:"/user/j"+userID+"/history/deleteUnChecked",
        type:'get',
        async:false,
        data:{"index":index},
        success:function (data) {
            if(data){
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') != 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                    window.location.reload();
                }, 2000);
            }
        }
    });
}

function onConcreteApply(index,isChecked) {
    window.location.href="/user/j"+userID+"/history/apply?index="+index+"&isChecked="+isChecked;
}

function onConcreteSample(index) {
    window.location.href="/user/j"+userID+"/history/sample?index="+index;
}

var userID=$("#userID").val();
//加载未审核列表
$.ajax({
    url:"/user/j"+userID+"/history/getUnChecked",
    type:'get',
    async:false,
    data:{},
    success:function (data) {
        var html = "";
        data.forEach(function(goods){
            html += loadUnchecked(goods);
        });
        $("#unchecked_tab_panel").append(html);
    }
});

function loadUnchecked(goods) {
    return "<div class='unchecked_item'"+
    "style='padding-left: 4%;padding-right:4%;padding-top: 2.6%;padding-bottom: 2.6%;"+
    "color: grey;font-size: 15px;'>"+
    "<div class='unchecked_message' style='width: 90%;float: left'>"+
        "<p>水域地址：<label style='color: black'>"+goods.waterAddress+"</label></p>"+
        "<p>姓名： <label style='color: black'>"+goods.name+"</label>"+
        "<label style='color: black;float:right'>"+goods.number+"</label></p>"+
        "<p>收货地址：<label style='color: black'>"+goods.address+"</label></p>"+
        "</div>"+
        "<div style='height:12%;float: right;padding-left: 2%;border-left: 1px;"+
    "border-left-style: dashed;margin-bottom: 3%'>"+
    "<br/>"+
    "<img class='delete_unchecked' src='/resources/img/delete.png' style='width:25px'/>"+
        "</div>"+
        "</div>"+
        "<hr style='width: 100%'>";
}

function loadChecked(goods) {
    var result= "<div class='checked_item' " +
        "style='padding-left: 15px;padding-right:15px;padding-top: 10px;padding-bottom: 10px;color: grey;font-size: 15px'>"+
        "<p>水域地址：<label style='color: black'>"+goods.waterAddress+"</label></p>"+
        "<p>姓名： <label style='color: black'>"+goods.name+"</label>"+
        "<label style='color: black;float:right'>"+goods.number+"</label></p>"+
        "<p>收货地址：<label style='color: black'>"+goods.address+"</label></p>"+
        "<p style='float:right'>";
    if(goods.state==0){
        result+="<img src='/resources/img/reject.png' style='width: 15px'/>已拒绝</p>";
    }else if(goods.state==1) {
        result+="<img src='/resources/img/pass.png' style='width: 15px'/>已通过</p>";
    }
        result+="</div><hr>";
    return result;
}

function loadSampling(goods) {
    return "<div class='sampling_item'"+
        "style='padding-left: 15px;padding-right:15px;padding-top: 10px;color: grey;font-size: 15px'>"+
        "<p>采样地点：<label style='color: black'>"+goods.waterAddress+"</label></p>"+
        "<p>经纬度：<label style='color: black'>("+goods.longitude+", "+goods.latitude+")</label>"+
        "<label style='float: right'>采样体积：<label style='color: black'>"+goods.volume+"</label></label></p>"+
        "<p style='padding-bottom: 5px'>采样备注：<label style='color: black'>"+goods.remark+"</label></p>"+
        "<p style='font-size: 14px'>采样时间："+goods.sampleDate+
        "<label style='float:right'>编号："+goods.sampleID+"</label></p>"+
        "</div>"+
        "<hr>";
}