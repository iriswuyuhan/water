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
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").addClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").show();
    $("#sampling_tab_panel").hide();
});
$("#sampling_tab").click(function () {
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").addClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").show();
});

function ondelete(index) {
    $.ajax({
        url: "/user/j" + userID + "/history/deleteUnChecked",
        type: 'get',
        async: false,
        data: {"index": index},
        success: function (data) {
            if (data) {
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') !== 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                    window.location.reload();
                }, 2000);
            }
        }
    });
}

function onUpload(index) {
    $.ajax({
        url: "/user/j" + userID + "/history/jumpToUpload",
        type: 'get',
        async: false,
        data: {"index": index},
        success: function (uploadID) {
            window.location.href="/upload/j"+uploadID;
        }
    });
}

var userID = $("#userID").val();
function onConcreteApply(index, isChecked) {
    window.location.href = "/user/j" + userID + "/history/apply?index=" + index + "&isChecked=" + isChecked;
}

function onConcreteSample(index) {
    window.location.href = "/user/j" + userID + "/history/sample?index=" + index;
}

function onAddApply() {
    window.location.href='/init/j'+userID;
}

//加载未审核列表
$.ajax({
    url: "/user/j" + userID + "/history/getUnChecked",
    type: 'get',
    async: false,
    data: {},
    success: function (data) {
        var html = "";
        data.forEach(function (goods) {
            html += loadUnchecked(goods);
        });
        $("#unchecked_tab_panel").append(html);
        if(data.length==0){
            noItemTip($("#unchecked_tab_panel"));
        }
        $("#unchecked_tab_panel").append(
            "<div class='weui-form-preview'>" +
            "<div class='weui-form-preview__ft' style='margin-top: 5%'>"+
        "<a onclick='onAddApply()' class='weui-form-preview__btn weui-form-preview__btn_primary' href='javascript:'>" +
            "<img src='/resources/img/addApply.png' width='25px' style='position:relative;top:5px'/>" +
            " 添加采样申请</a>"+
            "</div></div>");
    }
});

//加载已审核列表
$.ajax({
    url: "/user/j" + userID + "/history/getChecked",
    type: 'get',
    async: false,
    data: {},
    success: function (data) {
        var html = "";
        data.forEach(function (goods) {
            html += loadChecked(goods);
        });
        $("#checked_tab_panel").append(html);
        if(data.length===0){
            noItemTip($("#checked_tab_panel"));
        }
        // $("#checked_tab_panel").append("<script>$('.checked_message').click(function () {"+
        //     "var index=$('.checked_message').index(this);"+
        //     "var isChecked=1;"+
        //     "onConcreteApply(index,isChecked);});" +
        //     "$('.upload_pass').click(function(){" +
        //     "var index=$('.upload_pass').index(this);" +
        //     "onUpload(index);  });" +
        //     "</script>");
    }
});

//加载已采样列表
$.ajax({
    url: "/user/j" + userID + "/history/getSampling",
    type: 'get',
    async: false,
    data: {},
    success: function (data) {
        var html = "";
        data.forEach(function (goods) {
            html += loadSampling(goods);
        });
        $("#sampling_tab_panel").append(html);
        if(data.length===0){
            noItemTip($("#sampling_tab_panel"));
        }
        // $("#sampling_tab_panel").append("<script>$('.sampling_item').click(function () {"+
        //     "var index=$('.sampling_item').index(this);"+
        //     "onConcreteSample(index);"+
        //     "});</script>");
    }
});

function noItemTip(container) {
    container.append("<div class='weui-loadmore weui-loadmore_line'>"+
        "<span class='weui-loadmore__tips'>暂无数据</span>"+
        "</div>");
}

function loadUnchecked(goods) {
    return "<div class='unchecked_item'" +
        "style='padding-left: 4%;padding-right:4%;padding-top: 2.6%;padding-bottom: 2.6%;" +
        "color: grey;font-size: 15px;'>" +
        "<div class='unchecked_message' style='width: 90%;float: left'>" +
        "<p>水域地址：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
        "<p>姓名： <label style='color: black'>" + goods.name + "</label>" +
        "<label style='color: black;float:right'>" + goods.number + "</label></p>" +
        "<p>收货地址：<label style='color: black'>" + goods.address + "</label></p>" +
        "</div>" +
        "<div style='height:12%;float: right;padding-left: 2%;border-left: 1px;" +
        "border-left-style: dashed;margin-bottom: 3%'>" +
        "<br/>" +
        "<img class='delete_unchecked' src='/resources/img/delete.png' style='width:25px'/>" +
        "</div>" +
        "</div>" +
        "<hr style='width: 100%'>";
}

function loadChecked(goods) {
    var result = "<div class='checked_item' style='padding-left: 4%;padding-right:4%;padding-top: 2.6%;" +
        "color: grey;font-size: 15px;'>";
    if (goods.state === 1) {
        result += "<div class='checked_message' style='width: 90%;float: left'>";
    } else if (goods.state === 2) {
        result += "<div class='checked_message' style='width: 100%'>";
    }
    result += "<p>水域地址：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
        "<p>姓名： <label style='color: black'>" + goods.name + "</label>" +
        "<label style='color: black;float:right'>" + goods.number + "</label></p>" +
        "<p>收货地址：<label style='color: black'>" + goods.address + "</label></p>";
    if (goods.state === 1) {
        result += "<p>状态：<img src='/resources/img/pass.png' style='width: 15px'/>已通过</p></div>";
    } else if (goods.state === 2) {
        result += "<p>状态：<img src='/resources/img/reject.png' style='width: 15px'/>已拒绝</p></div>";
    }
    if (goods.state === 1) {
        result += "<div style='height:86px;float: right;padding-left: 2%;border-left: 1px;" +
            "border-left-style: dashed;margin-bottom: 3%'>" +
            "<br/>" +
            "<img class='upload_pass' src='/resources/img/upload.png' style='padding-top:10px;width:25px'/></div>";
    }
    result += "</div><hr style='width: 100%'>";
    return result;
}

function loadSampling(goods) {
    return "<div class='sampling_item'" +
        "style='padding-left: 15px;padding-right:15px;padding-top: 10px;color: grey;font-size: 15px'>" +
        "<p>采样地点：<label style='color: black'>" + goods.waterAddress + "</label></p>" +
        "<p>经纬度：<label style='color: black'>(" + goods.longitude + ", " + goods.latitude + ")</label>" +
        "<label style='float: right'>采样体积：<label style='color: black'>" + goods.volume + "</label></label></p>" +
        "<p style='padding-bottom: 5px'>采样备注：<label style='color: black'>" + goods.remark + "</label></p>" +
        "<p style='font-size: 14px'>采样时间：" + goods.sampleDate +
        "<label style='float:right'>编号：" + goods.sampleID + "</label></p>" +
        "</div>" +
        "<hr>";
}