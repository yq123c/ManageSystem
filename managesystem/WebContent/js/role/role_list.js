$(document).ready(function(){
	//表格的事件
    window.operateEvents = {
    	    'click .btn-delete': function(e, value, row, index) {
    	    	var id =[];
    	    	id.push(row.id);    	    	
    	    	layer.confirm("确定要删除吗?",{btn: ['确定', '取消'],title:"提示"},function(){
    	    		$.ajax({
    	    			   type: "post",
    	    			   url: "../../role/delete.do",
    	    			   data: "id="+row.id,
    	    			   success: function(result){
    	    				   if (result.state == 1){
    	    					   $('#roleList-table').bootstrapTable('remove', { field:'id', values:id });
    	    					   layer.msg("删除成功", {icon: 1});
    	    				   }else{
    	    					   layer.msg(result.messages, {icon: 2});
    	    				   }    	                       
    	    			   }
    	    			});
    	    	});    	    			    		
    	    },
    		'click .btn-detail': function(e, value, row, index){    			    		
    			setURLValue("row",row);
    	    },
    	    'click .btn-edit': function(e, value, row, index){
    			var item =getURLValue("row");    			   			
    			console.log(item);
    	    }
    }
    
	//加载表格数据
    $('#roleList-table').bootstrapTable({
        url:"../../role/get_list.do",
        method:"get",
        striped: true, // 隔行加亮
        resizable: false,
        pagination: true,//是否显示分页（*）
        sidePagination: 'server',//分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,//初始化加载第一页，默认第一页,并记录
        pageSize: 10,//每页的记录行数（*）
        pageList: [1,2,3,'All'],//可供选择的每页的行数（*）
        search: false,//是否显示表格搜索
        showRefresh: false,//是否显示刷新按钮
        showToggle: false, //是否显示详细视图和列表视图的切换按钮
        showColumns: false,//是否显示所有的列（选择显示的列）
        queryParams: function (params) {
            var temp = {  
                    limit: params.limit,   //单页记录数
                    offset: params.offset,  //页码
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order //排序方式
                };
                return temp;
            },
    	columns: [{
            field: 'ID',
            title: 'id'
        },{
            field: 'name',
            title: '角色名',
            align: 'center',
            sortable: true,
            events: operateEvents,
            formatter:function(value,row,index){
            	return '<a class="btn btn-default text-primary btn-detail" href = "role_detail.html" target="role_list">'+value+'</a>'
            }
        },{
            field: 'description',
            title: '描述',
            align: 'center',
            sortable: true
        },{
            field: 'create_person',
            title: '创建人',
            align: 'center',
            sortable: true
        },{
            field: 'create_time',
            title: '创建时间',
            align: 'center'
        },{
        	field: 'operation',
        	title: '操作',
        	align: 'center',
        	events: operateEvents,
        	formatter: function(value, row, index) {
            	return  '<button type="button" class="btn btn-xs btn-primary btn-edit">编辑</button> <button type="button" class="btn btn-xs btn-danger btn-delete">删除</button>';
            }             	
        }]
    });
    
    //隐藏id列
    $('#roleList-table').bootstrapTable('hideColumn', 'ID');
	
	//保存修改
	$("#btn_submit").on("click", function(){
		$.ajax({
			   type: "post",
			   url: "",
			   data:$("#update-form").serialize(),
			   success: function(result){
				   		alert(result);
			   }
		},"json");
	});
});