function init(tableId){
    $.ajax({
        "url":"IndentDetails/getDetail",
        "type":"post",
        "data":"tableId="+tableId,
        "dataType":"JSON",
        "success":function (result) {
            $(result).each(function () {
                $(".content").append("<table class=\"order_list\">" +
                    "<tr>" +
                    "<input name='detailsid' type='hidden' value='"+this.detailsid+"'/>"+
                    "<input name='d_cuisineId' type='hidden' value='"+this.dCuisineid+"'/>"+
                    "<td class=\"name\">"+this.cuisine.cuisinename+"</td>" +
                    "<td class=\"name\"><span class='dd'>"+this.cuisine.price+"</span>元/份</td><td class=\"m_num\"><span class=\"amount\" style='width: 100%'>"+this.detailscount+"份</span></td>" +
                    "</tr>" +
                    "</table>");
            });
            jisuan();
        },
        "error":function () {
            alert("网络错误!!");
        }
    });
}

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
    u();
    /*location.href="http://localhost:8080/index";*/
}

function xianjin(tableId){
    $.ajax({
        "url":"IndentDetails/dayinIndent",
        "type":"post",
        "data":"indentId="+tableId+"&sta=0",
        "dataType":"JSON",
        "success":function () {
            u();
        },
        "error":function () {
            alert("打印机坏了!!")
        }
    });
    /*location.href="http://localhost:8080/index";*/
}
function u(){
    location.href="OrderTableUpadte/0";
}
function updatadindan(tableId) {
    alert(tableId)
    location.href="updateDingDan/"+tableId;
}