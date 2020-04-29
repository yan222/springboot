$(function () {
    $.ajax({
        url:"/webapi/student/list",
        type:"GET",
        success:function (data) {
            var html=""
            for(var i=0;i<data.length;i++){
                var item=data[i];
                html+="<tr>"
                html+="<td>"+item.id+"</td>";
                html+="<td>"+item.name+"</td>";
                html+="<td>"+item.score+"</td>";
                html+="</tr>";
            }

            $("#students").html(html);
            console.log(data);

        }
    });

})