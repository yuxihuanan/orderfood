var page=1;
var CargoPageCount=0;
var CargoLikepageCount=0;
var pageNow=0;
var j=0;
$(function () {
    $("#datastatement").css({
        border: '0',
        height: '22px',
        width: '140px',
        margin: '1px 0 0 0px',
        background: 'transparent'
    });
    $("input").css({
        border: '0',
        height: '22px',
        width: '140px',
        margin: '1px 0 0 0px',
        background: 'transparent'
    });
    $(".mian_b1_sousuo").css({
        border: '0',
        height: '22px',
        width: '140px',
        margin: '13px 0 0 30px',
        float: 'left',
        background: 'images/sousuo_28.gif'
    });
    $(".cl").css({height: '26px', width: '50px', float: 'left', margin: '15px 5px 5px 15px '});
    selectRunningDataPages(page);
    next();
    previous();
    first();
    last();


});

function next() {
    $("a[title='下一页']").click(function () {
        var i=1;
        $("#pageInfo tr:gt(0)").remove();
        page+=1;
        if(page>=CargoPageCount){
            page=CargoPageCount;
        }
        selectRunningDataPages(page);
    })
}
function previous() {
    $("a[title='上一页']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page-=1;
        if(page==0){
            page=1;
        }
        pageNow=page;
        selectRunningDataPages(page);
    })
}
function first() {
    $("a[title='最前']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page=1;
        pageNow=page;
        selectRunningDataPages(page);
    })
}
function last() {
    $("a[title='最后']").click(function () {
        $("#pageInfo tr:gt(0)").remove();
        page=CargoPageCount;
        pageNow=page;
        selectRunningDataPages(page);
    })
}
// function pageCount() {
//     var data = $("#data").serialize();
//     $(".mian_b1_list").empty();
//     $.ajax({
//         "url":"RunningDataCount",
//         "data":data,
//         "dataType":"json",
//         "type":"post",
//         "success":function (result) {
//             CargoPageCount=parseInt(result);
//             selectRunningDataPages(page);
//             //selectRunningDataPages(page,CargoPageCount);
//             // for (var i=0;i<CargoPageCount;i++)
//             // {
//             //     if(i<3) {
//             //         $(".mian_b1_list").append("<a href='javascript:;' onclick='selectRunningDataPages(" + (i + 1) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i + 1) + "</div></a>");
//             //         $(".mian_b1_list div:eq(0)").css("background-color", "gray");
//             //     }
//             // }
//         }
//     });
// }






function selectRunningData(){
    var data = $("#data").serialize();
    var str = "";
    var date=new Date();
    var startDate = new Date(Date.parse($("[name=startDate]").val()));
    var stopDate = new Date(Date.parse($("[name=stopDate]").val()));
    if($("[name=stopDate]").val()!='' && $("[name=startDate]").val()==''){
        alert("请选择开始时间！");
    }else if(startDate>date){
        alert("开始时间不能超过当前时间哦");
        $("[name=startDate]").val("");
    }else if (startDate!=null && stopDate > date) {
        alert("结束时间不能超过当前时间哦");
        $("[name=stopDate]").val("");
    }else if (startDate > stopDate) {
        alert("截止时间不能低于开始时间呢！");
        $("[name=stopDate]").val("");
    }else {
        $(".dataprice").empty();
        $.ajax({
            "url": "selectrunningData",
            "data": data,
            "dataType": "json",
            "type": "post",
            "success": function (result) {
                if (null != result) {
                    var shou = 0;
                    var zhi = 0;
                    var zong = 0;
                    var suan = "";
                    $(result).each(function () {
                        if (this.datastatement == '收') {
                            shou += this.dataprice;
                        } else if (this.datastatement == '支') {
                            zhi += this.dataprice;
                        }
                    });
                    if ($("#datastatement").val().trim() == '收') {
                        suan += "<span id='shou'>总收入</span>：<span id='shouprice'>" + shou + "</span><br/>";
                        $(".dataprice").append(suan);
                    }
                    if ($("#datastatement").val().trim() == '支') {
                        suan += "<span id='zhi'>总支出</span>：<span id='zhiprice'>" + zhi + "</span><br/>";
                        $(".dataprice").append(suan);
                    }
                    if ($("#datastatement").val().trim() == "") {
                        suan += "<span id='shou'>总收入</span>：<span id='shouprice'>" + shou + "</span><br/>";
                        suan += "<span id='zhi'>总支出</span>：<span id='zhiprice'>" + zhi + "</span><br/>";
                        zong = shou - zhi;
                        if (zong >= 0) {
                            suan += "<span id='zong'>盈利</span>：<span id='zongprice'>" + zong + "</span><br/>";
                            $(".dataprice").append(suan);
                            $(".dataprice #zong").css({color: 'green', fontSize: '50px'});
                        } else {
                            suan += "<span id='zong'>亏&nbsp;损</span>：<span id='zongprice'>" + Math.abs(zong);
                            +"</span><br/>";
                            $(".dataprice").append(suan);
                            $(".dataprice #zong").css({color: 'red', fontSize: '50px'});
                        }
                    }
                    $(".dataprice #shou").css({color: 'blue', fontSize: '50px'});
                    $(".dataprice #zhi").css({color: 'yellow', fontSize: '50px'});
                }
            },
            "error": function () {
                alert("服务器异常！");
            }
        });
    }
}

function exports() {

    $("#export").attr("disabled", true);
    var data = $("#data").serialize();
    var str = "";
    var date = new Date();
    var startDate = new Date(Date.parse($("[name=startDate]").val()));
    var stopDate = new Date(Date.parse($("[name=stopDate]").val()));
    if ($("[name=stopDate]").val() != '' && $("[name=startDate]").val() == '') {
        alert("请选择开始时间！");
    } else if (startDate!=null && startDate > date) {
        alert("开始时间不能超过当前时间哦");
        $("[name=startDate]").val("");
    } else if (stopDate > date) {
        alert("结束时间不能超过当前时间哦");
        $("[name=stopDate]").val("");
    } else if (startDate > stopDate) {
        alert("截止时间不能低于开始时间呢！");
        $("[name=stopDate]").val("");
    } else {
        $.ajax({
            "url": "export",
            "data": data,
            "dataType": "json",
            "type": "post",
            "success": function (result) {
                setTimeout(function () {
                    if (result>0) {
                        alert("打印成功");
                    } else {
                        alert("打印失败");
                    }
                    $("#export").attr("disabled",false );
                },'3000');

            },
            "error": function () {
                alert("服务器异常！");
            }
        });
    }
}

function selectRunningDataPages(pagethis) {
    var data = $("#data").serialize();
    var str = "";
    $.ajax({
        "url":"RunningDataCount",
        "data":data,
        "dataType":"json",
        "type":"post",
        "success":function (result) {
            CargoPageCount=parseInt(result);
    pageNow=page;
    page=pagethis;
    if(j>=3){
        j=0;
    }
        if (pagethis >= 2) {
        if(pagethis<CargoPageCount){
            $(".mian_b1_list").empty();
            for (var i=pagethis-1;i<=CargoPageCount;i++)
            {
                if(j<3){
                    $(".mian_b1_list").append("<a href='javascript:void(0)' onclick='selectRunningDataPages(" + (i) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i) + "</div></a>");
                    j++;
                }
            }
            $(".mian_b1_list a:eq(1) div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
        }
        }else {
            $(".mian_b1_list a:eq(" + (pagethis - 1) + ") div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
        }
        if(CargoPageCount==pagethis){
            if (CargoPageCount >= 3) {
                $(".mian_b1_list").empty();
                for (var i = pagethis - 2; i <= CargoPageCount; i++) {
                    if (j < 3) {
                        $(".mian_b1_list").append("<a href='javascript:void(0)' onclick='selectRunningDataPages(" + (i) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i) + "</div></a>");
                        j++;
                    }
                }
                $(".mian_b1_list a:eq(2) div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
            }
            if(CargoPageCount < 3) {
                $(".mian_b1_list").empty();
                for (var i = 1; i <= CargoPageCount; i++) {
                    $(".mian_b1_list").append("<a href='javascript:void(0);' onclick='selectRunningDataPages(" + (i) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i) + "</div></a>");
                }
                $(".mian_b1_list a:eq(1) div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
            }
            }
        if(pagethis==1) {
            if (CargoPageCount >= 3) {
                $(".mian_b1_list").empty();
                for (var i = 1; i <= 3; i++) {
                    $(".mian_b1_list").append("<a href='javascript:void(0);' onclick='selectRunningDataPages(" + (i) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i) + "</div></a>");
                }
                $(".mian_b1_list a:eq(0) div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
            }else{
                $(".mian_b1_list").empty();
                for (var i = 1; i <= CargoPageCount; i++) {
                    $(".mian_b1_list").append("<a href='javascript:void(0);' onclick='selectRunningDataPages(" + (i) + ")'><div style='float: left;width: 20px;padding-left:14px;margin-left:1px ;margin-right:4px;margin-top:11px;height: 25px;line-height: 26px;border: 1px solid gray;border-radius:19px;'>" + (i) + "</div></a>");
                }
                $(".mian_b1_list a:eq(0) div").css("background-color", "gray").parent().siblings().find(" div").css("background-color", "#D3D3D3");
            }
        }

    var date=new Date();
    var startDate = new Date(Date.parse($("[name=startDate]").val()));
    var stopDate = new Date(Date.parse($("[name=stopDate]").val()));
    if($("[name=stopDate]").val()!='' && $("[name=startDate]").val()==''){
        alert("请选择开始时间！");
    }else if(startDate>date){
        alert("开始时间不能超过当前时间哦");
        $("[name=startDate]").val("");
    }else if (startDate!=null && stopDate > date) {
        alert("结束时间不能超过当前时间哦");
        $("[name=stopDate]").val("");
    }else if (startDate > stopDate) {
        alert("截止时间不能低于开始时间呢！");
        $("[name=stopDate]").val("");
    }else {
        $(".mian_b_bg tr:gt(0)").remove();
        $(".dataprice").empty();
        $.ajax({
            "url": "selectrunningDataPages/"+pagethis,
            "data": data,
            "dataType": "json",
            "type": "post",
            "success": function (result) {
                if (null != result) {
                    var shou = 0;
                    var zhi = 0;
                    var zong = 0;
                    var suan = "";
                    $(result).each(function () {
                        str += "<tr></tr>\n" +
                            "                  <td>" + this.dataid + "</td>\n" +
                            "                  <td>" + this.datastatement + "</td>\n" +
                            "                  <td>" + this.dataprice + "</td>\n" +
                            "                  <td>" + this.createdate + "</td>\n" +
                            "                  <td>" + this.datacomment + "</td>" +
                            "</tr>";
                    });
                    $(".mian_b_bg").append(str);
                    selectRunningData();

                }
            },
            "error": function () {
                alert("服务器异常！");
            }
        });
    }
        }
    });
}