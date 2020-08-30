function DeleteByIds(id) {
    if(confirm("一旦删除，不可恢复!!")){
        $.ajax({
            url:"/webapi/student/delete/"+id,
            method: "delete",
            success:function (rs) {
                console.log("删除成功");
               // window.location.reload();
                $("#students").bootstrapTable('refresh');
            }
        })
    }
}

function EditViewById(id){
    layer.open({
        area:['600px','400px'],
        type:2,
        title:"编辑信息",
        content:"/student/edit/"+id,

    })
    //window.open("/student/edit/"+id,"_blank");
}

$(function () {
    function actionFormatter(value, row, index) {
        var id = value;
        var result = "";
        //result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
        result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + row.id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
        result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + row.id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
        return result;
    }

    window._childDom=$("#students");//给window一个附加对象，方便我们再child窗口控制操作


    function fomatSex(value,row,index) {
        if (value == 1) {
            return "男";
        } else if (value == 2) {
            return "女";
        } else return "未知";
    }

    function formatAvatar(value,row,index) {
        var result=value;
        if(row.avatar!==null && row.avatar!=""){
            result+="<img src='"+row.avatar+"' width='50px'>";
        }
        return result;

    }

    $("#students").bootstrapTable({
        method: 'get', // 服务器数据的请求方式 get or post
        url:"/webapi/student/list", // 服务器数据的加载地址
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 3, //每页的记录行数（*）
        pageList: [3,5, 25, 50, 100], //可供选择的每页的行数（*）
        strictSearch: false,
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        uniqueId: "id", //每一行的唯一标识，一般为主键列
        cardView: false,
        detailView: false, //是否显示详细视图
        smartDisplay: false,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1
            };
        },
        columns: [{
            checkbox: true
        },{
            field: 'id',
            title: '角色ID'
        },{
            field: 'name',
            title: '学生姓名',
            formatter:formatAvatar
        }, {
            field: 'sex',
            title: '性别',
            formatter:fomatSex
        }, {
            field: 'score',
            title: '成绩',
        }, {
                field: 'birthday',
                title: '生日',
        },
        {
            title: '操作',
            width: 120,
            align: 'center',
            valign: 'middle',
            formatter: actionFormatter
        }]
    });
})

