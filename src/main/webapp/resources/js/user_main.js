var id=-1;

function load() {
    var url="/getLatestPro";
    $.ajax({
        type:"Post",
        url:url,
        async:true,
        success:function (data) {
            // alert(data);
            var objects=$.parseJSON(data);

            var headline=document.getElementById("proName");
            var body=document.getElementById("proContent");

            id=objects.idProject;
            var name=objects.name;
            var content=objects.description;

            headline.innerHTML=name;
            body.innerHTML=content;
        }
    })
}

function gotoProDetail() {
    window.location.href="projectIntro.jsp?id="+id;
}