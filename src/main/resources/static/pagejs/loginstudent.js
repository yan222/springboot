$(function () {

});

function login() {
    var name=$("#name").val();
    var password=$("#password").val();
    $.ajax({
        url:'/webapi/student/login',
        data:{'userName':name,'passWord':password},
        method:"get",
        success:function (rs) {
            if(rs.code>=0){
                window.location.href="/student/list";
            }
            else {
                alert(rs.msg);
            }

        }//end of success
    })//end of ajax
    return false;

}

