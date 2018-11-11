<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>LayUi</title>
<script src="./layui/layui.js"></script>
<link rel="stylesheet" href="./layui/css/layui.css">
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

<!--外部js  -->
<script src="js/layui.js"></script>
<script type="text/javascript">
	/*这个是table  */
 	layui.use('table', function(){
  	var table = layui.table;
  	table.render({
   	 	elem: '#test'
    	,url: 'listData.do' //-------------------------------------数据接口
    	,page: true //开启分页
    	,cols: [[ //表头
      	{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      	,{field: 'name', title: '用户名', width:80}
      	,{field: 'password', title: '密码', width:80, sort: true}
      	,{field: 'age', title: '年龄', width:80} 
      	,{field: 'birthday', title: '生日', width: 177}
      	,{field: 'status', title: '身份', width: 80, sort: true}
    			]],
  });
  
}); 
	/*table  */

	layui.use([ 'laypage', 'layer' ], function() {  //这个是正确可执行的部分.
	
	//layui.use('laypage', function() {
	
		var laypage = layui.laypage, layer = layui.layer;
		//总页数低于页码总数
		laypage.render({
			elem : 'demo1',
			count : 13,//数据总数
			limit: 5
			//first: '首页',
    		//last: '尾页',
		});
		
		
		
		
		 //完整功能

	
  laypage.render({
    elem: 'demo7',//存放的页面地址
    count: 100,//共有100条
    limit: 5,//每页显示20条
   	first: '首页s',//显示首页按钮
    last: '尾页w',//显示尾页按钮
    //theme: '#c00', //设置主题
    theme: 'xxx',//设置主题
    //layout自定义排版
    layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
    jump: function(obj){
      console.log(obj);
    }
  });
  
 	
	});
	//});  		//这个是正确可执行的部分.
</script>

</head>

<body>

	<!--这个是table的前端位置  -->
		<table id="test" lay-filter="test"></table>
	<!--table  -->


	<!-- 你的HTML代码 -->
	<!--  //弹出一个提示层  -->
	<input type="button" value="弹出一个提示层" id="test1" onclick="test1()">
	<!-- 弹出一个页面层  -->
	<input type="button" value="弹出一个页面层" id="test2" onclick="test2()">
	<!-- 弹出一个iframe层  -->
	<input type="button" value="弹出一个iframe层 " id="parentIframe"
		onclick="test3()">
	<input type="button" value="tips" id="tips" onclick="tips()">
	<input type="button" value="loading" id="loading" onclick="loading()" />

<!--分页1111111111111111111111111111111111111111111111111  -->

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 30px;">
		<legend>总页数低于页码总数</legend>
	</fieldset>
	<div id="demo0"></div>
	<hr>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 30px;">
		<legend>显示完整功能</legend>
	</fieldset>
	<div id="demo7">
	
	</div>


<p>11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>

 
    
        








</body>
</html>
