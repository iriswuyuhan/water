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
    if($("#loaded_checked").val()==false){
        loadChecked();
        $("#loaded_checked").val(true);
    }
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").addClass("weui-bar__item_on");
    $("#sampling_tab").removeClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").show();
    $("#sampling_tab_panel").hide();
});
$("#sampling_tab").click(function () {
    if($("#loaded_sampling").val()==false){
        loadSampling();
        $("#loaded_sampling").val(true);
    }
    $("#unchecked_tab").removeClass("weui-bar__item_on");
    $("#checked_tab").removeClass("weui-bar__item_on");
    $("#sampling_tab").addClass("weui-bar__item_on");
    $("#unchecked_tab_panel").hide();
    $("#checked_tab_panel").hide();
    $("#sampling_tab_panel").show();
});

function loadChecked() {

}

function loadSampling() {

}