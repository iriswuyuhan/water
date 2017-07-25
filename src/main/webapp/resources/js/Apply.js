function onClickWaterAddr() {
    // $.ajax({
    //     url:"/chooseRiver",
    //     type:'POST',
    //     async:false,
    //     data:{"userName":$("#apply_username").val(),"userContact":$("#apply_userContact").val(),"address":$("#apply_address").val()},
    //     success:function (data) {
    window.location.href = "/address/waters";
    //     }.
}

j = 1;
$(document).ready(function(){
    $("#btn_add").click(function () {
        document.getElementById("newUpload").innerHTML += '<div id="div_' + j + '"><input  name="image" type="file"  /><input type="button" value="删除"  onclick="del(' + j + ')"/></div>';
        j = j + 1;
    });
});

function del(o) {
    document.getElementById("newUpload").removeChild(document.getElementById("div_" + o));
}

function getApply(longitude,latitude,number,address,applyDate,state,image,name,waterAddress,idUser){
    this.longitude = longitude;
    this.latitude = latitude;
    this.number = number;
    this.address = address;
    this.applyDate = applyDate;
    this.state = state;
    this.image = image;
    this.name = name;
    this.waterAddress = waterAddress;
    this.idUser = idUser;
}

$("#applyUpload").click(function(){
    $("#imageForm").submit();
    var url = "/applyUpload";
    var longitude = "";
    var latitude = "";
    var number = "";
    var address = "";
    var date = new Date();
    var applyDate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes();
    // alert(applyDate);
    var state = 0;
    var name = "";
    var waterAddress ="";
    var idUser = $("#userID").val();

    longitude = $("#longitude").val();
    latitude = $("#latitude").val();
    number = $("#contact").text();
    address = $("#add").text();
    name = $("#name").text();
    waterAddress = $("#river_place").text();
    var imgUrl = "";

    var myArray = document.getElementsByName("image");
    for(var i=0;i<myArray.length;i++){
        imgUrl += myArray[i].value + ";";
    }
    var applyData = JSON.stringify(new getApply(longitude,latitude,number,address,applyDate,state,imgUrl,name,waterAddress,idUser));
    alert(applyData);
    if(waterAddress === ""){
        alert("请选择水域地址");
    }else if(imgUrl === ""){
        alert("请上传河流图片");
    }else{
        $.ajax({
            type:"POST",
            url:url,
            async:true,
            data:{"longitude":longitude,"latitude":latitude,"number":number,"address":address,"applyDate":applyDate,
            "state":state,"imgUrl":imgUrl,"name":name,"waterAddress":waterAddress,"idUser":idUser},
            dataType:"json",
            success:function (data) {
                alert("提交成功");
                $.cookie('ret2', null,{path:'/'});
                $.cookie('name',null,{path:'/'});
                $.cookie('tel',null,{path:'/'});
                $.cookie('add2', null,{path:'/'});
                $.cookie('ret3', null,{path:'/'});
                $.cookie('longitude',null,{path:'/'});
                $.cookie('latitude',null,{path:'/'});
                $.cookie('concrete_address', null,{path:'/'});
                window.location.href = "/user/j"+userID+"/history";
            }
        })
    }
});

