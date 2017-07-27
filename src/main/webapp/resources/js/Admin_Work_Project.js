function publish(){
    var headline=document.getElementById("headline");
    if(null===headline||""===headline){
        alert("标题不能为空！");
    }
    else {
        var markupStr = $('#summernote').summernote('code');
        var url="./publish"
        $.ajax({
            type:"POST",
            url:url,
            async:true,
            data:{"headline":headline,"body":markupStr},
            dataType:"json",
            success:function (data){

            }
        });

        deleteAll();
    }
}

function deleteAll(){
    var markupStr = '';
    $('#summernote').summernote('code', markupStr);
    $('#summernote').summernote('focus',true);
}
