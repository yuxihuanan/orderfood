
$(function () {
    $.ajax({
        "url":"adUnitl",
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            $(result).each(function () {
                $("#stockName").append("<option value='"+this.stockid+"'>"+this.stockname+"</option>");
            })
        }
    })
})
function insCargo() {
    $.ajax({
        "url":"insCargo",
        "dataType":"json",
        "data":{
            cStockid:$("#stockName").val(),
            cargoprice:$("#textfield").val(),
            cargoweight:$("#text7").val(),
            dataprice:$("#textfield").val(),
            datacomment:$("#datacomment").val()
        },
        "type":"post",
        "success":function (result) {
            alert(result);
            if(result>0){
                alert("入库成功");
                $("#stockName").val(" ");
                $("#textfield").val(" ");
                $("#text7").val(" ");
                $("#datacomment").val(" ");
            }else {
                alert("数据库异常");
            }
        }
    })
}