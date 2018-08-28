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
                    "<td class=\"name\">"+this.cuisine.cuisinename+"</td><td><span class=\"dis_price\">折扣价</span></td><td></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>"+this.cuisine.price+"/份</td><td class=\"discount\"><span class='dd'>"+this.cuisine.price+"</span>元/份</td><td class=\"m_num\"><span class=\"count\" onclick='jia($(this))'>+</span><span class=\"amount\">"+this.detailscount+"</span><span class=\"count\" onclick='jian($(this))'>-</span></td>" +
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
function jia(j){
    var index=j.parent().parent().parent().parent().index();
    var number=$("table:eq("+index+") .amount" ).html();
    if(number<10){
        $("table:eq("+index+") .amount" ).html(parseInt($("table:eq("+index+") .amount" ).html())+1);
        jisuan();
    }else{
      alert("已经点的够多了!");
    }
}
function jian(j){
    var index=j.parent().parent().parent().parent().index();
    var number=$("table:eq("+index+") .amount" ).html();
    if(number-1>0){
        $("table:eq("+index+") .amount" ).html(parseInt($("table:eq("+index+") .amount" ).html())-1);
    }else{
        if(confirm("在减就没有了!")){
            dele($("table:eq("+index+") [name=detailsid]").val());
            $("table:eq("+index+")").remove();
        }
    }
    jisuan();
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

function upda() {
    var tables=$("table").size();
    for(var i=0;i<tables;i++){
        var data={
            detailsid:$("table:eq("+i+") [name=detailsid]").val(),//订单详情编号
            dCuisineid:$("table:eq("+i+") [name=d_cuisineId]").val(),//菜品编号
            detailscount:$("table:eq("+i+") .amount").html(),//数量
            dIndentid:indentId
        }
        u(data);
        if(i==tables-1){
            alert("订单更新成功!!");
        }
    }
}

function u(data){
    $.ajax({
        "url":"IndentDetails/updateDetails",
        "type":"post",
        "data":data,
        "async":false,
        "dataType":"JSON",
        "success":function () {

        },
        "error":function (result) {
            alert("更新错误!!");
        }
    });
}

/**
 * 删除菜品
 * @param detailsId
 */
function dele(detailsId){
    $.ajax({
        "url":"IndentDetails/deleteDetaiils",
        "type":"post",
        "data":"id="+detailsId,
        "dataType":"JSON",
        "success":function (result) {
            if(result<0){
                alert("数据库堵死!!!!")
            }
        },
        "error":function (result) {
            alert("更新错误!!");
        }
    });
}