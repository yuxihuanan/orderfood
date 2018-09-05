var indentId;  //订单编号
$(function () {

    getAlls(1);
    aa();
    $(".stockName").attr("disabled","disabled");
    $(".stockName3").click(function () {
        $(this).parent().prev().prev().prev().find("input").removeAttr("disabled").css({background:"#eeeeee"});
    })
});


function  upda(id) {
    alert(1)
   $("#"+id+"").next().find("input").removeAttr("disabled").css({background:"#eeeeee"})
}




function aa() {
    $(".stockName").parent().dblclick(function () {
        $(this).find(".stockName").css({background: "#eeeeee"}).removeAttr("disabled");
    });
    $(".stockName").attr("disabled","disabled");
    $(".stockName").css({background:"transparent"}).blur(function (){
        $(this).attr("disabled","disabled").css({background:"transparent"});
        var id = $(this).parent().prev().html();
        var name = $(this).val();
        upd(id,name);
    });
}

function upd(id,name) {
    $.ajax({
        "url":"upds",
        "dataType":"JSON",
        "type":"post",
        "data":{
            classifyid:id,
            classifyname:name
        },
        "success":function (result) {
            if(result>0){
                alert("修改成功")
                getAlls();
            }else{
                alert("修改失败");
            }
        }
    });
}
function getAlls(pageIndexss) {
    $.ajax({
        "url": "getAlls/"+pageIndexss,
        "data":"pageIndexss="+pageIndexss,
        "dataType": "Json",
        "type":"post",
        "success": function (result) {
            $("table").html("");
            $(result.stuss).each(function () {
                $("table").append("<tr><td><input type='checkbox' name='del' value="+this.classifyid+"  ></td><td  id='"+this.classifyid+"'>" + this.classifyid+ "</td><td><input value='"+this.classifyname+"' class='stockName' /></td><td><a href='javascript:void(0)' onclick='del("+this.classifyid+")'>删除</a></td><td><a href='javascript:void(0)'  class='stockName3' onclick='upda("+this.classifyid+")'>修改</a></td></td>")
            })
            aa();
            $("table").append
  ("<div id=\"sy\"><button id=\"shouye_id\" type=\"button\" onclick=\"getAlls(1)\">首页</button></div>"+
  "<div id=\"syy\" ><button id=\"shangyiye_id\" type=\"button\"  onclick=getAlls("+(parseInt(result.pageIndexss)-1)+") >上一页</button></div>"+
  "<div id=\"xyy\" ><button id=\"xiayiye_id\" type=\"button\"  onclick=\"getAlls("+(parseInt(result.pageIndexss)+1)+")\"  >下一页</button></div>"+
  "<div id=\"wy\"><button id=\"weiye_id\" type=\"button\"  onclick=\"getAlls("+result.pageSumss+")\"  >尾页</button></div>"+
  "<div id=\"sum\">共"+result.pageSumss+"页</div> ");
        }

    })

}





function getcaibyfen() {
    var name = $("#grade").val();
    alert(name);
    $.ajax({
        "url": "getcaibyfen/"+name,
        "dataType": "Json",
        "type":"post",
        "success": function (result) {
            $("table").html("");
            $(result).each(function () {
                $("table").append("<tr><td>"+this.cuisinename+"</td></tr>");
            })
            aa()
        }
    })
}



function delpiliang(){
    var checkbox_value  = [];
    var msg = "您真的确定要删除吗？或许从表还有数据，清谨慎考虑\n\n请确认！";
    if (confirm(msg)==true){
        $("input[name='del']:checked").each(function(){
            checkbox_value.push($(this).val());
            alert(checkbox_value)
        });
        if(checkbox_value.length<=0){
            alert("你还没选择任何内容");
        }else{
            $.ajax({
                "url":"delpiliang/"+checkbox_value,
                "dataType":"json",
                "type":"get",
                "success":function(result){
                    alert(result)
                    if(result>0){
                        alert("删除成功")
                        getAlls(1);
                    }else{
                        alert("删除失败");
                    }
                },
            });
        }
        return true;
    }else {
        return false;
    }


}







    function index() {
        var name = $("#name").val();
        if (name.value==null){
            getAlls()
        }
        $.ajax({
            "url": "SelectCuisineClassifyById/"+name,
            "dataType": "Json",
            "type":"post",
            "success": function (result) {
                $(result).each(function () {
                    $("table").html("");
                    $("table").append("<tr><td>" + this.classifyname + "</td><td><a href='javascript:void(0)' onclick='del("+this.classifyid+")'>删除</a><td><a href='javascript:void(0)' onclick='updval("+this.classifyname+")'>修改</a></td></tr>")
                })
            }
        })
    }

function del(classifyid) {
    var msg = "您真的确定要删除吗？或许从表还有数据，清谨慎考虑\n\n请确认！";
    if (confirm(msg)==true){
        $.ajax({
            "url":"delss/"+classifyid,
            "dataType":"json",
            "success":function (result) {
                if (result>0){
                    alert("删除成功")
                    getAlls();
                } else{
                    alert("对不起请先删除菜品")
                }
            },
        })
        return true;
    }else{
        return false;
    }
}


function  go() {
    window.location.href="go";
}

function add() {
    var  ad = $("#shijian").val();
    if (ad=="") {
        alert("类别不能为空")
        return false;
    }else{
        $.ajax({
            "url":"add",
            "data":{
                "classifyname":ad,
            },
            "dataType":"json",
            "success":function (result) {
                if (result>0){
                    alert("添加成功")
                    window.location.href="go"
                } else{
                    alert("添加失败")
                }
            },
        })
    }
}

function  fanhui() {
    window.location.href="fanhui"
}

function ad() {

}





function getId() {
    var C1
    C1 = window.location.href.split("=")[1];
}

function updval(classifyname) {
    $("#shijian").val(classifyname)
}



function getAllbyId() {
    $.ajax({
        "url": "getAllbyId/"+C1,
        "dataType": "Json",
        "type":"post",
        "success": function (result) {
            $(result).each(function () {
                $("#shijian").val(this.classifyname);
            })
        }
    })
}



function quanxuan(){

    var allcheck=document.getElementById("allcheck");
    var choice=document.getElementsByName("del");
    alert(allcheck)
    alert(choice)
    for(var i=0;i<choice.length;i++){
        choice[i].checked=allcheck.checked;
    }


}





