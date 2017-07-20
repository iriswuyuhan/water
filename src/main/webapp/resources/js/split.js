
function split(add){
    var url=add.split("?");
    if(url.length>1){
        url=url[1].split("&");
        var param=[];
        for(var i=0;i<url.length;i++){
            param.push(url[i].split("=")[1]);
        }
        return param;
    }
    else{
        return null;
    }
}