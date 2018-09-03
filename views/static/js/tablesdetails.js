var flagD=false; //如果俩分钟到了之后设置为true;
var flag=false;//判断是否修改过菜品数量
var inId=0;  //订单编号
var sta; //判断当前的操作状态

/**
 * 订单的撤回,取消订单
 */
function chehui(tableId){

}

/**
 * 当用户从正在使用的桌子进来时,调用此方法查看订单详情：statu=1
 * @param url
 * @param tableId
 */
function init(url,tableId) {
    $.ajax({
        "url":url,
        "type":"post",
        "data":"tableId="+tableId,
        "dataType":"JSON",
        "success":function (result) {
            inId=result[0].indent.indentid;
            $(result).each(function () {
                indentId=this.dIndentid;
                $(".content").append("<table class=\"order_list\">" +
                    "<tr>" +
                    "<input name='detailsid' type='hidden' value='"+this.detailsid+"'/>"+
                    "<input name='d_cuisineId' type='hidden' value='"+this.dCuisineid+"'/>"+
                    "<input name='sta' type='hidden' value='0'/>"+  //sta=1时,为修改过的,0为没有
                    "<td class=\"name\">"+this.cuisine.cuisinename+"</td><td><span class=\"dis_price\">未优惠</span></td><td></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>"+this.cuisine.price+"/份</td><td class=\"discount\"><span class='dd'>"+this.cuisine.price+"</span>元/份</td><td class=\"m_num\"><span class=\"count\" name='jia' onclick='jia($(this),"+this.detailscount+")'>+</span><span class=\"amount\">"+this.detailscount+"</span><span class=\"count\" name='jian' onclick='jian($(this),"+this.detailscount+")'>-</span></td>" +
                    "</tr>" +
                    "</table>");
            });
            jisuan();
            ustatu(parseInt(new Date().getTime())-parseInt(new Date(result[0].indent.createdate).getTime()));
        },
        "error":function () {
            alert("网络错误!");
        }
    });
}

/**
 * 当用户使用订单页面访问过来时,加载此方法
 * @param url
 */
function init2(url,indentId) {
    $.ajax({
        "url":url,
        "type":"post",
        "data":"indentId="+indentId,
        "dataType":"JSON",
        "success":function (result) {
            inId=indentId;
            $(result).each(function () {
                $(".content").append("<table class=\"order_list\">" +
                    "<tr>" +
                    "<input name='detailsid' type='hidden' value='"+this.detailsid+"'/>"+
                    "<input name='d_cuisineId' type='hidden' value='"+this.id+"'/>"+
                    "<td class=\"name\">"+this.name+"</td><td><span class=\"dis_price\">未优惠</span></td><td></td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>"+this.price+"/份</td><td class=\"discount\"><span class='dd'>"+this.price+"</span>元/份</td><td class=\"m_num\"><span class=\"count\" onclick='jia($(this))'>+</span><span class=\"amount\">"+this.num+"</span><span class=\"count\" onclick='jian($(this),0)'>-</span></td>" +
                    "</tr>" +
                    "</table>");
            });
            jisuan();
        },
        "error":function () {
            alert("网络错误2!!");
        }
    });
}

/**
 * 判断用户加菜的数量
 * @param j
 */
function jia(j,num){
    var index=j.parent().parent().parent().parent().index();
    var number=$("table:eq("+index+") .amount" ).html();
    if(flagD){
        $("input[name=up]").removeClass("gray_btn").addClass("orange_btn").removeAttr("disabled");
    }
    if(number<100){
        $("table:eq("+index+") .amount" ).html(parseInt($("table:eq("+index+") .amount" ).html())+1);
        $("table:eq("+index+") [name=jian]").show();
        jisuan();
    }else{
      alert("已经点的够多了!");
    }
    if($("table:eq("+index+") .amount" ).html()==num&&sta==1){
        $("table:eq("+index+") [name=sta]" ).val(0);
    }else{
        $("table:eq("+index+") [name=sta]" ).val(1);
    }
}

/**
 * 判断用户减菜的数量
 * @param j
 */
function jian(j,num){
    var index=j.parent().parent().parent().parent().index();
    var number=$("table:eq("+index+") .amount" ).html();
    console.log(flagD);
    if(number-1==num&&flagD==true){
        $("input[name=up]").removeClass("orange_btn").addClass("gray_btn").attr("disabled","disabled");
        $("[name=jian]").hide();
    }
    if(number-1>0){
        $("table:eq("+index+") .amount" ).html(parseInt($("table:eq("+index+") .amount" ).html())-1);
    }else{
        if(confirm("在减就没有了!")){
            $("table:eq("+index+") .amount" ).html(parseInt($("table:eq("+index+") .amount" ).html())-1);
            //判断当前菜品存在于缓存还是数据库
            if(sta==0||sta==2){
                deleteCache($("table:eq("+index+") [name=d_cuisineId]").val());
            }else{
                dele(index);
            }
            $("table:eq("+index+")").remove();
        }
    }
    if($("table:eq("+index+") .amount" ).html()==num&&sta==1){
        $("table:eq("+index+") [name=sta]" ).val(0);
    }else{
        $("table:eq("+index+") [name=sta]" ).val(1);
    }
    jisuan();
}

/**
 * 删除缓存
 */
function deleteCache(cuisineid){
    $.ajax({
        "url":"",
        "type":"post",
        "data":"cuisineid="+cuisineid,
        "success":function () {
            if($("table").length==0){
                location.href="OrderTableUpadte/0";
            }
        },
        "error":function () {
            alert("删除缓存错误!!!");
        },
    });
}


/**
 * 计算菜的数量以及总价
 */
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

/**
 * 使用jQuery定时函数,让更新菜单在俩分钟后禁用
 */
function ustatu(time) {
    if(time>=120000){
        $("input[name=up]").removeClass("orange_btn").addClass("gray_btn").attr("disabled","disabled");
        $("[name=jian]").hide();
        flagD=true;
    }else{
        setTimeout(function () {
            $("input[name=up]").removeClass("orange_btn").addClass("gray_btn").attr("disabled","disabled");
            $("[name=jian]").hide();
            flagD=true;
        },120000-time);
    }

}

function updateTime(){
    $.ajax({
        "url":"",
        "type":"post",
        "data":"indentId="+inId,
        "success":function () {

        },
        "error":function () {
            alert("更新时间错误");
        },
    });
}

/**
 * 生成订单详情对象,并调用u方法更新订单详情
 */

function upda(statu,detailId) {
    if(statu==2){
        ustatu(119999);
        addDetails(detailId);
    }else{
        var s=$("[name=sta]");
        //判断是否有修改
        for(var i=0;i<s.length;i++) {
            if (s[i].value == 1) {
                flag = true;
                break;
            }
        }
        // var tables=$("table").size();
        // for(var i=0;i<tables;i++){
        //     var data={
        //         detailsid:$("table:eq("+i+") [name=detailsid]").val(),//订单详情编号
        //         dCuisineid:$("table:eq("+i+") [name=d_cuisineId]").val(),//菜品编号
        //         detailscount:$("table:eq("+i+") .amount").html(),//数量
        //         dIndentid:inId
        //     }
        //     if(i==s.length-1){
        //
        //     }
        // }
        if(flag) {
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
                    location.href="OrdrTableShow";
                }
            }
        }else{
            alert("您还没有对菜品进行更新!!");
        }
    }
}

/**
 * 更新订单详情
 * @param data
 */
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
function dele(index){
    var data={
        detailsid:$("table:eq("+index+") [name=detailsid]").val(),//订单详情编号
        dCuisineid:$("table:eq("+index+") [name=d_cuisineId]").val(),//菜品编号
        detailscount:$("table:eq("+index+") .amount").html(),//数量
        dIndentid:inId
    }
    $.ajax({
        "url":"IndentDetails/deleteDetaiils",
        "type":"post",
        "data":data,
        "dataType":"JSON",
        "success":function (result) {
            if(result<0){
                alert("数据库堵死!!!!");
            }else{
                if($("table").length==0){
                    deleteIndent();
                }
            }
        },
        "error":function (result) {
            alert("更新错误!!");
        }
    });
}

/**
 * 结账时跳转页面
 * @param tableId
 */
function jie(tableId){
    location.href="orderDetails?tableId="+tableId;
}

/**
 * 生成订单详情对象,并调用add()，添加订单详情
 * @param d_indentId
 */
function addDetails(d_indentId) {
    var tables=$("table").size();
    for(var i=0;i<tables;i++){
        var data={
            dCuisineid:$("table:eq("+i+") [name=d_cuisineId]").val(),//菜品编号
            detailscount:$("table:eq("+i+") .amount").html(),//数量
            dIndentid:d_indentId
        }
        add(data);
        if(i==tables-1){
            alert("下单成功!!");
            //下单成功调用定时函数
            ustatu(119999);
            dayin(d_indentId);
            location.href="OrderTableUpadte/1";
        }
    }
}

/**
 * 添加订单详情
 * @param data
 */
function add(data){
    $.ajax({
        "url":"IndentDetails/addDetails",
        "type":"post",
        "data":data,
        "async":false,
        "dataType":"JSON",
        "success":function () {

        },
        "error":function (result) {
            alert("添加错误2!!");
        }
    });
}

/**
 * 删除订单
 */
function deleteIndent(){
    $.ajax({
        "url":"IndentDetails/deleteIndent",
        "type":"post",
        "data":"indentid="+inId,
        "dataType":"JSON",
        "success":function (result) {
            if(result>0){
                location.href="OrderTableUpadte/0";
            }
        },
        "error":function (result) {
            alert("添加错误1!!");
        }
    });
}

/**
 * 添加订单,返回一个订单编号id,并调用addDetails(),进行订单详情的添加
 */
function addIndent(tableId){
    $("input[name=sure]").removeClass("orange_btn").addClass("gray_btn");
    $("input[name=up]").removeClass("gray_btn").addClass("orange_btn").removeAttr("disabled");
    $("input[name=j]").removeClass("gray_btn").addClass("orange_btn").attr("disabled","false").removeAttr("disabled");

    var data={
        iTableid:tableId,//所属桌号id
        indentcomment:$(".note").val(),//备注
        totalmoney:$(".price").html() //订单总金额
    }
    $.ajax({
        "url":"IndentDetails/addIndent",
        "type":"post",
        "data":data,
        "async":false,
        "dataType":"JSON",
        "success":function (result) {
            addDetails(result);
        },
        "error":function (result) {
            alert("添加错误1!!");
        }
    });
}

/**
 * 添加菜品
 */
function addCuisine(){
    $("input[name=up]").removeClass("gray_btn").addClass("orange_btn").removeAttr("disabled");
    $("[name=jian]").show();
    if(inId==0){
        location.href="OrdermealShowTwo?statu=0&indentId="+inId;
    }else{
        location.href="OrdermealShowTwo?statu=2&indentId="+inId;
    }
}

/**
 * 返回选桌页面
 */
function retu(){
    location.href="OrdrTableShow";
}

function dayin(indentId){
    $.ajax({
        "url":"IndentDetails/dayinIndent",
        "type":"post",
        "data":"indentId="+indentId+"&sta=1",
        "dataType":"JSON",
        "success":function () {
            alert(1);
            u();
        },
        "error":function () {
            alert("打印机坏了!!")
        }
    });
}
