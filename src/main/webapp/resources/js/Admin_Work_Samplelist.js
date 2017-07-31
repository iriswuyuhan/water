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

    //切换list info
    $(".load_wrapper").show();
    $(".list_wrapper").hide();

    $("#show-info").click(function () {
        $("#show-info").addClass("active").siblings().removeClass("active"),
            $(".list_wrapper").fadeOut("fast",function () {
                $(".load_wrapper").fadeIn()
            })
    })

    $("#show-list").click(function () {
        $("#show-list").addClass("active").siblings().removeClass("active"),
            $(".load_wrapper").fadeOut("fast", function () {
/*                setlist(samplelist);
                $("#project").html("");
                $("#databegin").html("");
                $("#dataend").html("");*/
                $(".list_wrapper").fadeIn()
            }), $(window).trigger("resize");
    })

$("#query").click(function () {
    var project = $("#project").val();
    var begin = $("#databegin").val();
    var end = $("#dataend").val();
    if($("#databegin").val()==""||$("#dataend").val()==""||$("#project").val()==""){
        alert("信息填写不完整");
    }
    else {
        var sample=new Array() ;
        for(var temp in samplelist){
            if(samplelist[temp].apply.project.name==project){
                var begindate = new Date(begin.replace(/-/g,   "/"));
                var enddate = new Date(end.replace(/-/g,   "/"));
                var sampledate = (1900 + samplelist[temp].sampleDate.year) + "-" + (samplelist[temp].sampleDate.month + 1) + "-" + samplelist[temp].sampleDate.date;
                var sampled = new Date(sampledate.replace(/-/g,   "/"));
                if(begindate<=sampled){
                    if(sampled<=enddate) {
                        sample.push(samplelist[temp]);
                    }
                }
            }
        }
        if(sample.length>0){
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
        var state;
        var color;
        if(data[i].state=="0"){
            state = "待收取";
            color = "gray";
        } else
        if(data[i].state=="1"){
            state = "处理中";
            color = "yellow";
        } else
        if(data[i].state=="2"){
            state = "已上传实验结果";
            color = "green";
        }
        $("#tbody").append("<tr>"+
            "<td style='width:80px;'><input id='checkbox"+i+"' name='checkbox1' type='checkbox'><label for='checkbox"+i+"'></label></td>"+
           " <td name='sampleid' style='width:140px'>"+data[i].idSample+"</td>"+
            "<td style='width:140px;'>"+data[i].volume+"</td>"+
        "<td style='width:200px;'>"+data[i].apply.waterAddress+"</td>"+
            "<td style='width:180px;'>"+data[i].apply.project.name+"</td>"+
           " <td style='width:200px;'>"+timeFormatter1(data[i].sampleDate)+"</td>"+
         "<td style='width:200px;'><li id='addColor"+i+"'></li><a class='pull-left'>"+state+"</a></td>"+
            "<td style='width:30px;'><a onclick='sampleinfo(this)'><i class='fa fa-angle-right'></i></a></td>"+"</tr>");
        var colorID = "#addColor"+i;
        $(colorID).addClass("dot");
        $(colorID).addClass(color);
    }

}
function  sampleinfo(type) {
   var sample= $(type).parent().parent().find("td[name='sampleid']").html();
   $(".load_wrapper").show();
   $("#list").hide();
    $.ajax({
        url: "./getSample",
        type: "post",
        async: false,
        data: {"id": sample},
        success: function (data) {
            var obj = $.parseJSON(data);
            setSampleInfo(obj);
            $("#scro4").find("li").each(function () {
                $(this).removeClass("active");
            });
            $("#scro4").find("a").each(function () {
                if ($(this).html() === sample)
                    $(this.parentNode).addClass("active");
            })
            $("#show-info").addClass("active").siblings().removeClass("active");
        }
    });
}
function clickbut() {
    var str = "样本编号,样本体积,水域地址,所属项目,采样时间,状态\n";
    $("input[name='checkbox1']").each(function () {
        if($(this).prop("checked")==true){

           $(this).parent().parent().find("td").each(function (index) {
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
    str =  encodeURIComponent(str);
    $("#csv").attr("href","data:text/csv;charset=utf-8,\ufeff"+str);
    $("#csv").attr("download","doon.csv");
    $("#csv").click;
}
function  additem(temp) {
    var str = temp.idSample+","+temp.volume+","+temp.apply.waterAddress+","+temp.idSample+","+timeFormatter1(temp.sampleDate)+","+temp.idSample+"\n";
    return str
}