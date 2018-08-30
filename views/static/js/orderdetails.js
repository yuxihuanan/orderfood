var indentId;  //订单编号
$(function () {
    $.ajax({
        "url":"IndentDetails/getDetail",
        "type":"post",
        "data":"tableId=3",
        "dataType":"JSON",
        "success":function (result) {
            indentId=result[0].dIndentid;
            $(result).each(function () {
                $(".content").append("<table class=\"order_list\">" +
                    "<tr>" +
                    "<input name='detailsid' type='hidden' value='"+this.detailsid+"'/>"+
                    "<input name='d_cuisineId' type='hidden' value='"+this.dCuisineid+"'/>"+
                    "<td class=\"name\">"+this.cuisine.cuisinename+"</td><td><span class=\"dis_price\">未优惠</span></td><td></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>"+this.cuisine.price+"/份</td><td class=\"discount\"><span class='dd'>"+this.cuisine.price+"</span>元/份</td><td class=\"m_num\"><span class=\"amount\" style='width: 100%'>"+this.detailscount+"份</span></td>" +
                    "</tr>" +
                    "</table>");
            });
            jisuan();
        },
        "error":function () {
            alert("网络错误!!");
        }
    });
});


function jisuan(){
    var amount=$(".amount");
    var dd=$(".dd");
    var sum=0;
    var sumPrice=0;
    for (var i=0;i<amount.length;i++){
        sum=parseInt(sum)+parseInt(amount[i].innerHTML);
    }
    for (var i=0;i<dd.length;i++){
        sumPrice=parseInt(sumPrice)+(parseInt(dd[i].innerHTML*parseInt(amount[i].innerHTML)));
    }
    $(".sum").html(sum);
    $(".price").html(sumPrice);
}

function zhifubao(){
    /*location.href="http://localhost:8080/index";*/
}