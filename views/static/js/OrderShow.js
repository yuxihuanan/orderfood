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
    toCargoEditor();
})
function toCargoEditor() {
    $.ajax({
        "url":"toCargoEditor",
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            $("#textfield").val(result.cargoprice);
            $("#text7").val(result.cargoweight);
            $("#stockName").val(result.stock.stockid);
            $("#stockUnitl").val(resultstock.stockunit);
        }

    })
}
function updCargo() {
    $.ajax({
        "url":"updCargo",
        "dataType":"json",
        "data":{
            cargoprice:$("#textfield").val(),
            cargoweight:$("#text7").val()
        },
        "type":"post",
        "success":function (result) {
            if(result>0){
                alert("修改成功");
            }else {
                alert("数据库异常");
            }
        }
    })
}