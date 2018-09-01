var indentId;  //订单编号
$(function () {

    getAlls();
    C1 = window.location.href.split("=")[1];
    $("#classifyid").val(C1)
});


function aa() {
    $(".name").parent().dblclick(function () {
        $(this).find(" .name").css({background: "#eeeeee"}).removeAttr("disabled");
    });
    $(".name").attr("disabled", "disabled");
    $(".name").css({background: "transparent"}).blur(function () {
        $(this).attr("disabled", "disabled").css({background: "transparent"});
        var id = $(this).parent().prev().html();
        var name = $(this).val();
        alert(id)
        alert(name)
        upd(id, name);
    });
}

function getAlls() {

    $.ajax({
        "url": "getAlls",
        "dataType": "Json",
        "type":"post",
        "success": function (result) {
            $("table").html("");
            $(result).each(function () {
                $("table").append("<tr><td><input type='checkbox' name='del' value="+this.classifyid+"></td><td>" + this.classifyid+ "</td><td><input value='"+this.classifyname+"' class='name'/></td><td><a href='javascript:void(0)' onclick='del("+this.classifyid+")'>删除</a></td><td><a href='javascript:void(0)' onclick='updval(\""+this.classifyname+"\")'>修改</a></td></td>")
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
        });
        if(checkbox_value.length<=0){
            alert("你还没选择任何内容");
        }else{
            $.ajax({
                "url":"delpiliang/"+checkbox_value,
                "dataType":"json",
                "type":"get",
                "success":function(result){
                    if(result>0){
                        alert("删除成功")
                        getAlls();
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
            "url":"del/"+classifyid,
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


function  upd(classifyid) {
    window.location.href="biaoganxiangmuList2?classifyid="+classifyid;
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

function upd(id,name) {
    alert(id)
    alert(name)
    var  a = $("#shijian").val();
    $.ajax({
        "url":"upd",
        "dataType":"Json",
        "type":"post",
        "data":{
            'classifyid':id,
            'classifyname':name
        },
        "success":function (result) {
            if(result>0){
                alert("修改成功")
            }else{
                alert("修改失败");
            }
        },
    });
}




