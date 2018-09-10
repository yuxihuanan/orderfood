var page = 1;
var CargoPageCount = 0;
var CargoLikepageCount = 0;
var pageNow = 0;
$(function () {
    pageCount();
    next();
    previous();
    indentLike(page);
});
function ds(id) {
    window.location.href = 'tail?id=' + id;
}
function del(id) {
    if (confirm("确定要删除吗？") == true) {
        $.ajax({
            'url': 'del/' + id,
            'dataType': 'JSON',
            'type': 'post',
            'success': function (result) {
                if (result > 0) {
                    alert("删除成功")
                    window.location.href = 'getAll';
                } else {
                    alert("删除失败")
                }
            }
        });
    }
}
function getInfo() {
    $(".mian_b_bg").html(" ");
    var id=$("#indentId").val();
    $.ajax({
        'url':'getInfo/'+id,
        'dataType':'JSON',
        'type':'post',
        'success':function (result) {
            var str="<tr><td>订单号</td><td>桌号</td><td>创建时间</td><td>订单备注</td><td>订单总金额</td><td>实付总金额</td><td>服务员</td></tr>";
            $(result).each(function () {
                str+="<tr style='border-top:1px #DFE2E6 solid'><td>"+this.indentcode+"</td><td>"+this.orderfoodTable.tablenumber+"</td><td>"+this.createdate+"</td><td>"+this.indentcomment+"</td><td>"+this.totalmoney+"</td><td>"+this.netmoney+"</td><td>"+this.orderfoodEmployee.employeename+"</td></tr>";
            })
            $(".mian_b_bg").append(str);
        }
    })
}
function getdel() {
    var checkbox_value = [];
    var obj=document.getElementsByName("indent")
    for(var k in obj){
        if (obj[k].checked)
            checkbox_value.push(obj[k].value)
    }
    alert(checkbox_value);
    $.ajax({
        "url": "getdel",
        "dataType": "json",
        "type": "post",
        "data":{
            'arrays[]':checkbox_value
        },
        "success": function (result) {
            if (result > 0) {
                alert("删除成功")
                window.location.href = 'getAll';
            } else {
                alert("删除失败");
            }
        },

    });
}
function next() {
    $("a[name='next']").click(function () {
        $(".tb tr:gt(0)").remove();
        page += 1;
        if (page >= CargoPageCount) page = CargoPageCount
        indentLike(page);
    })
}
function previous() {
    $("a[name='previous']").click(function () {
        $(".tb tr:gt(0)").remove();
        page -= 1;
        if(page<=0)page=1;
        indentLike(page);
    })
}
function pageCount() {
    $.ajax({
        "url": "getPageCount",
        "dataType": "json",
        "type": "post",
        "success": function (result) {
            CargoPageCount = parseInt(result);
            // for (var i = 0; i < CargoPageCount; i++) {
            //     $(".ddd").append("<div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'><a href='javascript:;' onclick='CargoPageInfo(" + (i + 1) + ")'>" + (i + 1) + "</a></div>");
            // }

        }

    })
}
function indentLike(pageno) {
    pageNow = pageno;
    $.ajax({
        "url": "indentLike/" + pageno,
        "dataType": "json",
        "type": "post",
        "success": function (result) {
            $(result).each(function () {
                $(".tb").append("<tr>\n" +
                    "  <td><input name='indent' type='checkbox' value="+this.indentid+" /></td>\n" +
                    "  <td>" + this.indentcode + "</td>\n" +
                    "  <td>" + this.orderfoodTable.tablenumber+ "</td>\n" +
                    "  <td>" + this.createdate + "</td>\n" +
                    "  <td>" + this.indentcomment + "</td>\n" +
                    "  <td>" + this.totalmoney + "</td>\n" +
                    "  <td>" + this.netmoney + "</td>\n" +
                    "  <td>" + this.orderfoodEmployee.employeename + "</td>\n" +
                    "  <td><a href='javascript:void(0)' onclick='del("+this.indentid+")'>删除</a></td>\n" +
                    "  <td><a href='javascript:void(0)' onclick='ds("+this.indentid+")'>查看详情</a></td>\n" +
                    "</tr>");
            })
        }
    });
}