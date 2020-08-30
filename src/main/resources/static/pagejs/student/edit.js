$(function () {
    var url=window.location.href;

    var urlsplit=url.split("/");
    var len=urlsplit.length;
    var idstr=urlsplit[len-1];

    $.ajax({
        url:"/webapi/student/"+idstr,
        method:"get",
        success:function (rs) {
            if(rs.code>=0) {
                data = rs.data;

                $("#id").val(data.id);
                $("#name").val(data.name);
                $("#sex").val(data.sex);
                $("#score").val(data.score);
               // var newdate=data.birthday.split(" ")[0];
                $("#birthday").val(data.birthday);
            }
            else {
                alert(data.msg);
            }
        }
    })

});

/*
通过ajax向后台发送对话的信息
* */
function updateDlg() {
    var data=$("#frmStudent").serialize();
    console.log(data);
    $.ajax({
        url:"/webapi/student/update",
        method: "post",
        contentType:"application/x-www-form-urlencoded",
        data:data,
        success:function (rs) {
            if(rs.code>=0){
                if(parent!=null){
                    parent.layer.closeAll();
                    parent._childDom.bootstrapTable('refresh');
                }
            }
            else {
                alert(rs.msg);
            }

        }//end of ajax
    })

}//end of updateDlg