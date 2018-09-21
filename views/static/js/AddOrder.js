
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
            });
            $(".mian_b_bg_xz tbody").append("<input type='button' value='提交' onclick='insCargo()'>")
        }
    })
})
function insCargo() {
    var count=0;
    var checks=$("input[name='stockid']");
    var cargoprices=$("input[name='cargoprice']");
    var cargoweights=$("input[name='cargoweight']");
    var o;
    for (o in checks){
        if(checks[o].checked==true){
            count++;
        }
    }
    if(count==0){
        alert("请选中要入库的材料");
        return;
    }else {
        for (o in checks){
            if(checks[o].checked==true){
               if(cargoprices[o].value.length==0){
                   alert("请输入该材料单价");
                   return;
               }else if(cargoweights[o].value.length==0){
                   alert("请输入该材料重量");
                   return;
               }
            }
        }
    }
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