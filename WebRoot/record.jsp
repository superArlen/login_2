<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%Date d = new Date();SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");String now = df.format(d);%>
<html>
<head>
<title>充值会员</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="js/layui.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function search(){
		var name = $("#recordVip").val();
		//alert(name);
		$.ajax({
		//alert(123);
			url:"ajaxRecord.do",
			type:"post",
			data:{"name":name},
			dataType:"JSON",
			success:function(data){
				$("#show").html(data.msg);
			},
			error:function(){
				//alert("请输入vip用户名.");
			}
		});
	}


</script>
</head>
<body>
	<form action="addRecord.do" method="post" class="layui-form">
		<div class="layui-form-item">
				<label class="layui-form-label">${u.name }序号:</label>
				<div class="layui-input-block">
					<input type="text" value="${u.id }" class="layui-input" readonly="readonly" name="recordUser">
				</div>
				<label class="layui-form-label">充值时间</label>
				<div class="layui-input-block">
					<input type="text" value="<%=now %>" name="recordTime" class="layui-input" readonly="readonly">
				</div>
				<label class="layui-form-label">会员姓名</label>
				<div class="layui-input-block" style="width: 500px">
					<input type="text" name="recordVip" class="layui-input" id="recordVip" onblur="search()">
					<span id="show" style="color: red"></span>
				</div>
				<label class="layui-form-label">充值金额</label>
				<div class="layui-input-block">
					<input type="text" name="recordAmount" class="layui-input" id="recordAmount" onblur="search2()">
					<span id="show2" style="color: red"></span>
				</div>
				<div class="layui-input-block">
					<input type="submit" value="确认">
				</div>
		</div>
	</form>

</body>
</html>
