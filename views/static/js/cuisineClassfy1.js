var indentId;  //订单编号

var C1;
$(function () {

    C1 = window.location.href.split("=")[1];
    $("#classifyid").val(C1)
    getAllbyId();



});

function  fanhui() {
    window.location.href="cuisineClassifyAll"
}



function getAllbyId() {
    $.ajax({
        "url": "getAllbyId/"+C1,
        "dataType": "Json",
        "type":"post",
        "success": function (result) {
            $(result).each(function () {
                $("#shijian").val(this.classifyname);
            })
        }
    })
}


function upd() {
    var  a = $("#shijian").val();
    $.ajax({
        "url":"upd",
        "dataType":"Json",
        "type":"post",
        "data":{
            'classifyid':C1,
            'classifyname':a,
        },
        "success":function (result) {
            if(result>0){
                alert("修改成功")
            }else{
                alert("修改失败");
            }
        },
    });
}










