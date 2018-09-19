
$(function () {
    $.ajax({
        "url":"adUnitl",
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            $(result).each(function () {
                $(".mian_b_bg_xz tbody").append("<tr>"+
                    "<td width=\"5%\" class='btnClick'>"+
                "<div><input name='stockid' type=\"checkbox\" value='"+this.stockid+"' /></div>"+
                "</td>"+
                "<td width=\"7%\" valign=\"center\">"+this.stockname+"</td>"+
                "<td width=\"15%\">单价："+
                "<input name='cargoprice' type=\"text\" />"+
                "</td>"+
                "<td width=\"20%\">重量："+
                "<input name='cargoweight' type=\"text\" />"+
                " </td>"+
                "</tr>");
            })
        }
    })
})
function insCargo() {
    var jsons=new Array();
    var datajson={}
    var obj = document.getElementsByName("stockid");
    for (var k in obj) {
        if (obj[k].checked){
            datajson={
                cStockid:obj[k].value,
                cargoprice:$("input[name='stockid']:eq("+k+")").parents("tr").find("input[name='cargoprice']").val(),
                cargoweight:$("input[name='stockid']:eq("+k+")").parents("tr").find("input[name='cargoweight']").val(),
                stock:{
                    stockname:$("input[name='stockid']:eq("+k+")").parents("tr").find("td:eq(1)").html()
                }
            }
            jsons.push(datajson);
        }

    }
    $.ajax({
        "url":"insCargo",
        "dataType":"json",
        "data":{
            jsonArray:JSON.stringify(jsons)
        },
        "type":"post",
        "success":function (result) {
            if(result>0){
                alert("入库成功");
                window.location.href='toCargo';
            }else {
                alert("数据库异常");
            }
        }
    })
}