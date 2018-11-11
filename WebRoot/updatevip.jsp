<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>修改Vip信息</title>
     <link rel="stylesheet" href="layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  
  <body>
	<form class="layui-form" action="updateVip.do?id=${vip1.id }" method="post" >
	<div class="layui-form-item">
		<label class="layui-form-label">姓名:</label>
	 <div class="layui-input-block">
		<input type="text" value="${vip1.name }" name="vipname" class="layui-input"> 
	</div>
		<label class="layui-form-label">卡号:</label>
	<div class="layui-input-block">
		<input type="text" value="${vip1.number }" name="vipnumber" class="layui-input">
		</div>
		<label class="layui-form-label">余额:</label>
	<div class="layui-input-block">
		<input type="text" value="${vip1.remain }" name="vipremain" class="layui-input" readonly="readonly">
	</div>
		<label class="layui-form-label">身份:</label>
	<div class="layui-input-block">
		<input type="text" value="${vip1.type }" name="viptype" class="layui-input">
	</div>
	<div class="layui-input-block">
		<input class="layui-btn" type="submit" value="提交" >
	</div>
	</div>
	</form>

  </body>
</html>
