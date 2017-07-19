/**
 * Created by lenovo on 2017/7/19.
 */
//创建和初始化地图函数：
function initMap() {

    geolocation.getCurrentPosition();
    createMap();//创建地图
    setMapEvent();//设置地图事件
    addMapControl();//向地图添加控件
    addMapOverlay();//向地图添加覆盖物

    // 创建地址解析器实例
    var myGeo = new BMap.Geocoder();
    // 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("北京市海淀区上地10街", function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            alert("您选择地址没有解析到结果!");
        }
    }, "北京市");
}

//定位
var longitude;
var latitude;
var geolocation = new BMap.Geolocation();
geolocation.getCurrentPosition(function(r){
    if(this.getStatus() == BMAP_STATUS_SUCCESS){
        var mk = new BMap.Marker(r.point);
        map.addOverlay(mk);
        map.panTo(r.point);
        // alert('您的位置：'+r.point.lng+','+r.point.lat);
        longitude=r.point.lng;
        latitude=r.point.lat;
    }
    else {
        alert('failed'+this.getStatus());
    }
},{enableHighAccuracy: true})

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
function addMapOverlay() {
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
var map;
initMap();