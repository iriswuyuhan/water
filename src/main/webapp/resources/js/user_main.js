var id=-1;
function load() {
    var url="./getLatestPro";
    $.ajax({
        type:"Post",
        url:url,
        async:true,
        success:function (data) {
            var objects=data;
            // var objects=JSON.parse(data);
            var headline=document.getElementById("proName");
            var body=document.getElementById("proContent");
            var time=document.getElementById("proDate");

            id=objects.idProject;
            var name=objects.name;
            var content=getText(objects.description).substring(0,301)+'...';
            var year=parseInt(objects.date['year'])+1900;
            var month=parseInt(objects.date['month'])+1;
            var day=objects.date['date'];
            var date=year+'-'+month+'-'+day;

            headline.innerHTML=name;
            body.innerHTML=content;
            time.innerHTML=date;
        }
    })
}

function gotoProDetail() {
    window.location.href="projectIntro.jsp?id="+id;
}

function getText(str){
    str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
    str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
    str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
    str=str.replace(/&nbsp;/ig,'');//去掉&nbsp;
    str=str.replace(/\s/g,''); //将空格去掉
    return str;
}