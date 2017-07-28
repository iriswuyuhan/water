/**
 * Created by zhanglei on 2017/7/20.
 */
function on_unchecked_click() {
    $("#unchecked_tab").addClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").show();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").hide();
};
function on_checked_click() {
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").addClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").show();
    $("#sampling_tab_panel").hide();
};
function on_sample_click() {
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").addClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").show();
};

var type=$("#type").val();
if(type==0){
    on_unchecked_click();
}else if(type==1){
    on_checked_click();
}else if(type==2){
    on_sample_click();
}

function personal_info() {
    window.location.href='../j'+userID+'?next=default';
}

function confirmDelete() {
    $.ajax({
        url: "history/deleteUnChecked",
        type: 'get',
        async: false,
        data: {"index": deleteIndex},
        success: function (data) {
            if (data) {
                $("#dialog").hide();
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
        url: "history/jumpToUpload",
        type: 'get',
        async: false,
        data: {"index": index},
        success: function (uploadID) {
            window.location.href=basePath+"upload/j"+uploadID;
        }
    });
}

var userID = $("#userID").val();
function onConcreteApply(index, isChecked) {
    window.location.href = "history/apply?index=" + index + "&isChecked=" + isChecked;
}

function onConcreteSample(index) {
    window.location.href = "history/sample?index=" + index;
}

function onAddApply() {
    window.location.href=basePath+'init/j'+userID;
}

function noItemTip(container) {
    container.append("<div class='weui-loadmore weui-loadmore_line'>"+
        "<span class='weui-loadmore__tips'>暂无数据</span>"+
        "</div>");
}
