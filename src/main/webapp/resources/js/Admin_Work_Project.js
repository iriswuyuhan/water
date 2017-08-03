var head={};
var content={};

//加载界面使用
function load(){
    var url="./allProject";
    $.ajax({
        type:"Post",
        url:url,
        async:true,
        success:function (data) {
            var objects=$.parseJSON(data);
            for(var i=0;i<data.length;i++){
                var id=objects[i].idProject;
                var headline=objects[i].name;
                var markupstr=objects[i].description;
                addOne(id,headline,markupstr);
            }
        }

    })
}

function publish(){
    var headline=document.getElementById("headline").value;
    if(null===headline||""===headline){
        alert("标题不能为空！");
    }
    else {
        var markupStr = $('#summernote').summernote('code');
        var active=$("#scro1").find(".active");
        var id=active.eq(0).attr('id');
        if(id!=="add"){
            var url="./modifyProject";
            $.ajax({
                type:"POST",
                url:url,
                async:true,
                data:{"id":id,"headline":headline,"body":markupStr},
                dataType:"json",
                success:function (data) {
                    if(data==false){
                        alert("修改失败！请重试！");
                    }
                    else{
                        head[id]=headline;
                        content[id]=markupStr;
                        alert("修改成功！");
                    }
                }
            })
        }
        else{
            var url="./publish";
            $.ajax({
                type:"POST",
                url:url,
                async:true,
                data:{"headline":headline,"body":markupStr},
                dataType:"json",
                success:function (data){
                    // head.push(headline);
                    // content.push(markupStr);
                    if(parseInt(data)==-1){
                        alert("发布失败！请重试！");
                    }
                    else{
                        addOne(data,headline,markupStr);

                        alert("发布成功！");
                        deleteAll();
                    }
                },
                error:function () {
                    alert("发布失败！可能是格式错误！")
                }
            });
        }
    }
}

function deleteAll(){
    var markupStr = "";
    document.getElementById("headline").value= null;
    $('#summernote').summernote('code', markupStr);
    $('#summernote').summernote('focus',true);
}

function show(id){
    $("#scro1").find("li").each(function() {
        $(this).removeClass("active");
    });
    document.getElementById(id).setAttribute("class","active");

    var cancel = document.getElementById("cancel");
    if(id=="add"){
        document.getElementById("headline").value="";
        $('#summernote').summernote('code', "");

        cancel.innerHTML = "取消";
        cancel.setAttribute("onclick", "javascript:deleteAll();");
    }

    else {
        document.getElementById("headline").value = head[id];
        $('#summernote').summernote('code', content[id]);

        cancel.innerHTML = "删除";
        cancel.setAttribute("onclick", "javascript:del(" + id + ");");
    }
}

//to be continued
function del(id){
    var url="./deleteProject";
    $.ajax({
        type:"POST",
        url:url,
        async:true,
        data:{"id":id},
        dataType:"json",
        success:function (data){
            if(data==false){
                alert("删除失败！请重试！");
            }
            else{
                var node=document.getElementById(id);
                node.parentNode.removeChild(node);

                delete head[id];
                delete content[id];

                alert("删除成功！");
                show("add");
            }
        }
    })
}

function addOne(id,headline,markupStr) {
    head[id]=headline;
    content[id]=markupStr;

    var list=document.getElementById("scro1");
    var item=document.createElement("li");
    item.setAttribute("id",id);
    item.setAttribute("onclick","javascript:show("+id+");");

    var a=document.createElement("a");
    a.innerHTML=headline;
    item.appendChild(a);
    var span=document.createElement("span");
    span.setAttribute("class","fa fa-angle-right");
    item.appendChild(span);

    list.appendChild(item);
}

function topnavclick(type) {
    if(type.name==="1"){
        window.location.href="toAdmin.do"
    }
    if(type.name==="2"){
        window.location.href="toAdmin_Sample.do"
    }
    if(type.name==="3"){
        window.location.href="toAdmin_Sample_Result.do"
    }
    if(type.name==="4"){
        window.location.href="toAdmin_Project.do"
    }
}
//导航点击事件的监听
function  applyClick(type) {
    var id = type.innerHTML;
    $.ajax({
        url: './getApplyInfo',
        type: 'post',
        async: 'false',
        data: {"id": id},
        success: function (data) {
            var obj1 = $.parseJSON(data);
            setactive(type, obj1);
            setinitinfo(obj1);
        }

    });
}
//设置导航为active状态的方法
function setactive(type,temp) {
    if(temp.state===0){
        $("#scro1").find("li").each(function() {
            $(this).removeClass("active");
        });
        $(type.parentNode).addClass("active");
    }
    if(temp.state===1) {
        $("#scro2").find("li").each(function () {
            $(this).removeClass("active");
        });
        $(type.parentNode).addClass("active");
    }
    if(temp.state===2){
        $("#scro3").find("li").each(function() {
            $(this).removeClass("active");
        });
        $(type.parentNode).addClass("active");
    }

}
