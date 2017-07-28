var head={};
var content={};

//加载界面使用
function load(){

}

function publish(){
    var headline=document.getElementById("headline").value;
    if(null===headline||""===headline){
        alert("标题不能为空！");
    }
    else {
        var markupStr = $('#summernote').summernote('code');
        var url="/publish";
        $.ajax({
            type:"POST",
            url:url,
            async:true,
            data:{"headline":headline,"body":markupStr},
            dataType:"json",
            success:function (data){
                // head.push(headline);
                // content.push(markupStr);
                head[data]=headline;
                content[data]=markupStr;

                var list=document.getElementById("scro1");
                var item=document.createElement("li");
                item.setAttribute("id",data);
                item.setAttribute("onclick","javascript:show("+data+");");

                var a=document.createElement("a");
                a.innerHTML=headline;
                item.appendChild(a);
                var span=document.createElement("span");
                span.setAttribute("class","fa fa-angle-right");
                item.appendChild(span);

                list.appendChild(item);

                deleteAll();
            }
        });
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
    var list=document.getElementById("scro1");
    //list.removeChild(list.childNodes[id+1]);
    delete head[id];
    delete content[id];
}

