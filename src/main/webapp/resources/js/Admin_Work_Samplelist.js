/**
 * Created by Administrator on 2017/7/26 0026.
 */
var samplelist;
$(function(){

    $.ajax({
        url:"./getSampleList",
        type:"post",
        async:false,
        success:function (data) {
            var obj = $.parseJSON(data);
            samplelist=obj;
            if(samplelist.length>0) {
                setlist(samplelist);
            }
            else{
                    $("#tbody").empty();
                    $("#tbody").append("<tr><td>暂无样本</td></tr>");
            }
        }
    })
    $(".tyo").click(function () {
        $("#nav li").removeClass();
        $(this).parent().prop("class","active");
        var name =    $(this).find("h4").html();
        if(name==="审核申请")
            window.location.href="toAdmin.do";
        if(name==="下载采样信息")
            window.location.href="toAdmin_Sample.do"
    })
$("#query").click(function () {
    var project = $("#project").val();
    var begin = $("#databegin").val();
    var end = $("#dataend").val();
    if($("#databegin").val()==""||$("#dataend").val()==""||$("#project").val()==""){
        alert("信息填写不完整");
    }
    else {
        var sample ;
        for(var temp in samplelist){
            if(samplelist[temp].idSample==project){
                sample.add(samplelist[temp]);
            }
        }
        if(sample){
            setlist(sample);
        }
        else {
            $("#tbody").empty();
            $("#tbody").append("<tr><td>无符号要求的样本</td></tr>");
        }

    }

})

    //全选框的监听
    $("#checkbox").click(function () {
        if($(this).prop("checked")==true){
            $("input[name='checkbox1']").prop("checked",true);
        }
        else {
            $("input[name='checkbox1']").prop("checked",false);
        }
    })

})

//列表项加载
function  setlist(data) {
    $("#tbody").empty();
    for(var i =0;i<data.length;i++){
        $("#tbody").append("<tr>"+
            "<td style='width:80px'><input id='checkbox"+i+"' name='checkbox1' type='checkbox'><label for='checkbox"+i+"'></label></td>"+
           " <td name='sampleid' style='width:160px'>"+data[i].idSample+"</td>"+
            "<td style='width:160px'>"+data[i].volume+"</td>"+
        "<td style='width:180px'>"+data[i].apply.waterAddress+"</td>"+
            "<td style='width:180px'>"+data[i].idSample+"</td>"+
           " <td style='width:200px'>"+timeFormatter1(data[i].sampleDate)+"</td>"+
         "<td style='width:200px'><li class='yellow dot'></li><a class='pull-left'>"+data[i].idSample+"</a></td>"+
            "<td style='width:30px'><a onclick='sampleinfo(this)'><i class='fa fa-angle-right'></i></a></td>"+"</tr>");

    }

}
function  sampleinfo(type) {
   var sample= $(type).parent().parent().find("td[name='sampleid']").html();
   alert(sample);
   $("#content5").show();
   $("#list").hide();
    $.ajax({
        url: "./getSample",
        type: "post",
        async: false,
        data: {"id": id},
        success: function (data) {
            var obj = $.parseJSON(data);
            setSampleInfo(obj);
            $("#scro4").find("li").each(function () {
                $(this).removeClass("active");
            });
            $("#scro4").find("a").each(function () {
                if ($(this).html() === id)
                    $(this.parentNode).addClass("active");
            })
        }
    });
}
function clickbut() {
    var str = "样本编号,样本体积,水域地址,所属项目,采样时间,状态\n";
    $("input[name='checkbox1']").each(function () {
        if($(this).prop("checked")==true){

           $(this).parent().parent().find("td").each(function (index) {
               alert(index);
               if(index!=0&&index!=7){
                   if(index==6){
                       str+=$(this).find("a").html()+"\n";
                   }
                   else {
                       str += $(this).html() + ",";
                   }
               }
           });

        }
    })
    alert(str);
    str =  encodeURIComponent(str);
    $("#csv").attr("href","data:text/csv;charset=utf-8,\ufeff"+str);
    $("#csv").attr("download","doon.csv");
    $("#csv").click;
}
function  additem(temp) {
    var str = temp.idSample+","+temp.volume+","+temp.apply.waterAddress+","+temp.idSample+","+timeFormatter1(temp.sampleDate)+","+temp.idSample+"\n";
    return str
}