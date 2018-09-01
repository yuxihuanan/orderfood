var page=1;
var CargoPageCount=0;
var CargoLikepageCount=0;
var pageNow=0;
$(function () {
    pageCount();
    CargoPageInfo(page);
    next();
    previous();
    first();
    last();
    selClick();

})
function manydel() {
    var flag=confirm("确定删除吗？");
    if(flag!=true)return
    var obj = document.getElementsByName("cargoid");
    var check_val = [];
    for (var k in obj) {
        if (obj[k].checked)
            check_val.push(obj[k].value);
    }
    if(check_val.length==0){
        alert("删谁啊？！");
        return;
    }
    $.ajax({
        "url":"mandel",
        "dataType":"json",
        "type":"post",
        "data":{
            'arrays[]':check_val
        },
        "success":function (result) {
            if(result>0){
                alert("删除成功");
                window.location.href='toCargo'
            }else {
                alert("数据库异常");
            }
        }
    })
}
function toEditor(Cargoid) {
    window.location.href='toEditor/'+Cargoid;
}
function CargoPageInfo(pageno) {
    pageNow=pageno;
    $("#pageInfo tr:gt(0)").remove();
    $(".mian_b1_list div:eq("+(pageNow-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
    $.ajax({
        "url":"ShowCargoInfo/"+pageno,
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            $(result).each(function () {
                $("#pageInfo").append("<tr>\n" +
                    "  <td width=\"3%\">\n" +
                    "    <input name=\"cargoid\" type=\"checkbox\" value='"+this.cargoid+"'/>\n" +
                    "  </td>\n" +
                    "  <td>"+this.cargoid+"</td>\n" +
                    "  <td>"+this.stock.stockname+"</td>\n" +
                    "  <td>"+this.cargoprice+"</td>\n" +
                    "  <td>"+this.cargoweight+"</td>\n" +
                    "  <td>"+this.stock.stockunit+"</td>\n" +
                    "  <td class=\"mian_b_icon_01\" width=\"5%\"><a href=\"javascript:;\" onclick='toEditor("+this.cargoid+")'>编辑</a></td>\n" +

                    "</tr>");
            })
        }
    })
}

function next() {
    $("a[title='下一页']").click(function () {
        /*if($("input[name=stockname]").val().length==0){
            alert("搜索框为空");*/
            $("#pageInfo tr:gt(0)").remove();
            page+=1;
            $(".mian_b1_list div:eq("+(pageNow-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
            if(page>=CargoPageCount)page=CargoPageCount
            CargoPageInfo(page);
        /*}else {
            alert("搜索框不为空");
            $("#pageInfo tr:gt(0)").remove();
            page+=1;
            alert(page);
            $(".mian_b1_list div:eq("+(pageNow-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
            if(page>=CargoLikepageCount)page=CargoLikepageCount
            showLikeCargoInfo(page);
        }*/
    })
}
function previous() {
    $("a[title='上一页']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page-=1;
        $(".mian_b1_list div:eq("+(pageNow-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
        CargoPageInfo(page);
    })
}
function first() {
    $("a[title='最前']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page=1;
        $(".mian_b1_list div:eq("+(pageNow-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
        CargoPageInfo(page);
    })
}
function last() {
    $("a[title='最后']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page=CargoPageCount;
        $(".mian_b1_list div:eq("+(page-1)+")").css("background-color","gray").siblings().css("background-color","#D3D3D3");
        CargoPageInfo(page);
    })
}
function pageCount() {
    $.ajax({
        "url":"getPageCount",
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            CargoPageCount=parseInt(result);
            for (var i=0;i<CargoPageCount;i++)
            {
                    $(".mian_b1_list").append("<div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'><a href='javascript:;' onclick='CargoPageInfo("+(i+1)+")'>"+(i+1)+"</a></div>");
                    $(".mian_b1_list div:eq(0)").css("background-color","gray");
            }

        }

    })
}
function selClick() {
    $("a[title='搜索']").click(function () {

        showLikeCargoInfo(page);
    })
}
function showLikeCargoInfo(pageno) {
    $("#pageInfo tr:gt(0)").remove();
    $.ajax({
        "url":"findLike/"+pageno,
        "data":{
            'stockname':$("input[name=stockname]").val()
        },
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            $(result).each(function () {
                $("#pageInfo").append("<tr>\n" +
                    "  <td width=\"3%\">\n" +
                    "    <input name=\"cargoid\" type=\"checkbox\" value='"+this.cargoid+"'/>\n" +
                    "  </td>\n" +
                    "  <td>"+this.cargoid+"</td>\n" +
                    "  <td>"+this.stock.stockname+"</td>\n" +
                    "  <td>"+this.cargoprice+"</td>\n" +
                    "  <td>"+this.cargoweight+"</td>\n" +
                    "  <td>"+this.stock.stockunit+"</td>\n" +
                    "  <td class=\"mian_b_icon_01\" width=\"5%\"><a href=\"javascript:;\" onclick='toEditor("+this.cargoid+")'>编辑</a></td>\n" +
                    "  <td class=\"mian_b_icon_02\" width=\"5%\"><a href=\"toOrderClass\">查看</a></td>\n" +
                    "</tr>");
            })
        }
    })
    LikepageCount();
}
function LikepageCount() {
    $(".mian_b1_list").html(" ");
    $.ajax({
        "url":"getLikePageCount",
        "data":{
            'stockname':$("input[name=stockname]").val()
        },
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            CargoLikepageCount=parseInt(result);
            for (var i=0;i<CargoPageCount;i++)
            {
                $(".mian_b1_list").append("<div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'><a href='javascript:;' onclick='CargoPageInfo("+(i+1)+")'>"+(i+1)+"</a></div>");
                $(".mian_b1_list div:eq(0)").css("background-color","gray");
            }

        }

    })
}