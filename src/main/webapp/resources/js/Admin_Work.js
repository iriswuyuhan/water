/**
 * Created by Administrator on 2017/7/18 0018.
 */
$(function () {
    $(".state").click(function () {
        $("#tab1").hide();
        $("#tab2").hide();
        $("#tab3").hide();
        alert($(this).html());
        name = $(this).html();
        if(name=="待审核"){
            $("#tab1").show();
        }
        if(name=="审核通过"){
            $("#tab1").show();
        }
        if(name=="未审核通过"){
            $("#tab1").show();
        }
        $.ajax({
            url:"./applylist",
            type:'post',
            data:{"name":name},
            success:function (data) {
                alert(data);
            }
        })

    })
    // $(".a1").click(function () {
    //     $("#tabs li").prop("id","");
    //     $("#tab1").show();
    //     $("#tab2").hide();
    //     $("#tab3").hide();
    //     $(".a1").parent().prop("id","current");
    //
    // });
    // $(".a2").click(function () {
    //     $("#tabs li").prop("id","");
    //     $("#tab2").show();
    //     $("#tab1").hide();
    //     $("#tab3").hide();
    //     $(".a2").parent().prop("id","current");
    //
    // })
    // $(".a3").click(function () {
    //     $("#tabs li").prop("id","");
    //     $("#tab3").show();
    //     $("#tab2").hide();
    //     $("#tab1").hide();
    //     $(".a3").parent().prop("id","current");
    //
    // })
})