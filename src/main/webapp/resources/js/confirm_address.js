/**
 * Created by lenovo on 2017/7/19.
 */
//确定地址按钮的相应
$("#confirm_but").click(function () {
    $.ajax({
        url:"/address/waters/confirm",
        type:'get',
        async:false,
        data:{"longitude":$("#longitude").val(),"latitude":$("#latitude").val(),
            "waters_address":$("#concrete_address").text()},
        success:function (data) {
            if(data){
                // toast
                var $toast = $('#toast');
                if ($toast.css('display') != 'none') return;
                $toast.fadeIn(100);
                setTimeout(function () {
                    $toast.fadeOut(100);
                }, 2000);
            }
        }
    });
});

//创建和初始化地图函数：
function initMap() {

    createMap();//创建地图
    setMapEvent();//设置地图事件
    addMapControl();//向地图添加控件
    geolocation.getCurrentPosition();

    // 逆地址解析（点击地图上的点得到地址，经纬度）
    map.addEventListener("click", function(e){
        var pt = e.point;
        myGeo.getLocation(pt, function(rs){
            var addComp = rs.addressComponents;
            // alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
            $("#concrete_address").text(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
            // $(".input_address").val($("#concrete_address").text());
        });
        //改变中心点
        map.panTo(pt);
        //改变定位点
        changeOverlay(pt);
        changeLocation(pt);
    });
}

var map;
var myGeo = new BMap.Geocoder();
var marker=null;
//定位
var longitude;
var latitude;
var geolocation = new BMap.Geolocation();
geolocation.getCurrentPosition(function(r){
    if(this.getStatus() == BMAP_STATUS_SUCCESS){
        var mk = new BMap.Marker(r.point);
        map.addOverlay(mk);
        map.panTo(r.point);
        changeLocation(r.point);
        myGeo.getLocation(r.point, function(rs){
            var addComp = rs.addressComponents;
            $("#concrete_address").text(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
        });
    }
    else {
        alert('failed'+this.getStatus());
    }
},{enableHighAccuracy: true});

function changeLocation(point) {
    $("#longitude").val(point.lng);
    $("#latitude").val(point.lat);
}

function changeOverlay(pt) {
    if(marker!=null) {
        map.removeOverlay(marker);
    }
    marker=new BMap.Marker(pt);
    map.addOverlay(marker);
}

function createMap() {
    map = new BMap.Map("map");
    map.centerAndZoom(new BMap.Point(longitude, latitude), 15);
}
function setMapEvent() {
    map.enableScrollWheelZoom();
    map.enableKeyboard();
    map.enableDragging();
    map.enableDoubleClickZoom()
}
function addClickHandler(target, window) {
    target.addEventListener("click", function () {
        target.openInfoWindow(window);
    });
}

//向地图添加控件
function addMapControl() {
    var scaleControl = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});
    scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
    map.addControl(scaleControl);
    var navControl = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: BMAP_NAVIGATION_CONTROL_LARGE});
    map.addControl(navControl);
    var overviewControl = new BMap.OverviewMapControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, isOpen: true});
    map.addControl(overviewControl);
}

ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    document.getElementById("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
    setPlace();
});

function setPlace(){
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        changeOverlay(pp);
        changeLocation(pp);
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
    });
    local.search(myValue);
    $("#concrete_address").text($("#searchInput").val());
}

initMap();