<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>新增会员</title>
    <link rel="stylesheet" href="layui/css/layui.css">
	<script src="js/layui.js"></script>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  </head>
  <script type="text/javascript">
	function remain(){
		var remain = $("#vipRemain").val();
		if(remain>=1000){
		alert("充值金额不能大于1000");
		return false;
		}
	}  	
  	
  	
  
  
  </script>
  
  
  <body>
  	<form action="addVip.do" method="post" class="layui-form">
		<div class="layui-form-item">
				<label class="layui-form-label">会员姓名:</label>
				<div class="layui-input-block">
					<input type="text" name="vipName" class="layui-input">
				</div>
				<label class="layui-form-label">卡号:</label>
				<div class="layui-input-block">
					<input type="text" name="vipNumber" class="layui-input">
				</div>
				<label class="layui-form-label">余额:</label>
				<div class="layui-input-block">
					<input type="text" name="vipRemain" id="vipRemain" onblur="remain()" class="layui-input" >
				</div>
				<label class="layui-form-label">身份:</label>
				<div class="layui-input-block">
					<input type="text" name="vipType" class="layui-input">
				</div>
				<div class="layui-input-block">
					<input type="submit" value="确认" class="layui-btn">
				</div>
		</div>
	</form>
  
  </body>
</html>
