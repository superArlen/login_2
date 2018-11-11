<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--展示所有店员信息,只有超级管理员可以修改信息  -->
<html>
<head>

<title>所有店员</title>
<script src="./layui/layui.js"></script>
<link rel="stylesheet" href="./layui/css/layui.css">
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">
	/*这个是table  */
 	layui.use('table', function(){
  	var table = layui.table;
  	table.render({
   	 	elem: '#test'
    	,url: 'listData.do' //-------------------------------------数据接口
    	,page: true //开启分页
    	//field:设定字段名,title:设定标题名称,width:设定列宽（默认自动分配）,
    	//type:设定列类型,fixed:固定列,sort:是否允许排序,edit:是否可以编辑
    	,cols: [[ //表头
      	 {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      	,{field: 'name', title: '用户名', width:80}
      	,{field: 'password', title: '密码', width:80, sort: true,width:300}
      	,{field: 'age', title: '年龄', width:80} 
      	,{field: 'birthday', title: '生日', width: 177}
      	,{field: 'status', title: '身份', width: 80, sort: true}
      	/*操作位置  */
      	,{field: 'reight', width:178, align:'center', toolbar: '#barDemo'}
    			]],
    		id:"listData",
  });
}); 
	
			function add(){
				layer.open({
  				type: 2, 
  				area:['500','500'],
  				content: 'adduser_rbac.jsp' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
				}); 
			}

</script>


<body>


  <button class="layui-btn"  id="add" onclick="add()">新增</button>




<!--这个是table的前端位置  -->
	<table id="test" lay-filter="test"></table>
	<!--table  -->
<!--操作栏  -->	
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
	



//编辑选项

layui.use('table', function(){
  var table = layui.table;
  //监听工具条
  table.on('tool(test)', function(obj){ //tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data;				//获得当前行数据
    if(obj.event === 'detail'){			//获取事件
      layer.msg('ID：'+ data.id+data.name);
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
			//这里怎么写从数据库删除?
		
      });
    } else if(obj.event === 'edit'){
      var index = layui.layer.open({
        title : "编辑用户",
        type : 2,
        area: ['500px', '500px'],
        content : "update.jsp",//弹出层页面
        success : function(layero, index){
            var body = layui.layer.getChildFrame('body', index);
            if(data){
                // 取到弹出层里的元素，并把编辑的内容放进去
                body.find(".id").val(data.id);  //id
                body.find(".name").val(data.name);  //姓名
                body.find(".password").val(data.password);  //密码
                body.find(".age").val(data.age);  //年龄
                body.find(".birthday").val(data.birthday);  //生日
                body.find(".status").val(data.status);	//身份
                form.render();
            }
        },	
        	
    });
    		
    		//layer.close(index);
    		//parent.window.location.reload();
}
});


    
    
    
    
    
});
	
	
	
	
</script>


</body>
</html>
