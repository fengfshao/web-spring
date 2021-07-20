$(document).ready(function(){
    $("#helloQuery").click(function(){
       $.ajax({
                type: "post",
                url: "/query",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify({"name":"yd","pwd":"123456"}) ,
                dataType: "json",
                success:function (message) {
                    alert("提交成功"+JSON.stringify(message));
                },
                error:function (message) {
                    alert("提交失败"+message);
                }
            });
    });
});