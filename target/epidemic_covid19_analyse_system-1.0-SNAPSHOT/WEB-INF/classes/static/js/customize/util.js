function transferData(url,data,cb){
    $.ajax({
        url : url,
        type : 'get',
        data : data,
        dataType : 'json',
        success : function(res){
            cb(res);
        },
        error : function(e){
            console.log(e.status,e.statusText);
        }
    })
}