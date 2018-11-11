<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>注册</title>
<script src="./layui/layui.js"></script>
<link rel="stylesheet" href="./layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//用户名不能为空
		$("#sub").click(function() {
			var regName = $("#regName").val();
			if (regName == null || "" == regName) {
				alert("注册名不能为空");
				return false;
			}
		});
		//正则
		$("#form").submit(function() {
			var regPwd = $("#regPwd").val();
			var regPwdb = /^\d{3,11}$/;
			if (!regPwdb.test(regPwd)) {
				var $msg = $("<span>请输入3-11位密码.</span>");
				$msg.css("color", "red");
				$("span:eq(1)").replaceWith($msg);
				return false;
			}
		});
	});//1
</script>


<script type="text/javascript">
	//ajax验证用户名
	function Ajax() {
		var name = $("#regName").val();
		$.ajax({
			url : "ajax1.do",
			type : "post",
			data : {
				"name" : name
			},
			dataType : "JSON",
			success : function(data) {
				$("#show").html(data.msg);
			},
			error : function() {
			}
		});
	}
</script>

</head>

<body>
	<form action="register.do" method="post" id="form">
		<table>
			<caption>添加管理员信息</caption>
			<tr>
				<td>注册名:</td>
				<td><input type="text" name="regName" onblur="Ajax()"
					id="regName" value="${ru.name }">
				</td>
				<td><span id="show" style="color:blue;font-size:13px"></span>
				</td>
			</tr>
			<tr>
				<td>注册密码:</td>
				<td><input type="text" name="regPwd" id="regPwd"
					value="${ru.password }">
				</td>
				<td><span style="color:blue;font-size: 13px">请输入3-11位密码.</span>
				</td>
			</tr>
			<tr>
				<td>注册年龄:</td>
				<td><input type="text" name="regAge" value="${ru.age }">
				</td>
				<td></td>
			</tr>
			<tr>
				<td>注册生日:</td>
				<td><input type="text" name="regBirthday"
					value="${ru.birthday }">
				</td>
				<td>(格式:yyyy-MM-dd)</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册" id="sub">
				</td>
				<td></td>
			</tr>


		</table>




	</form>



</body>
</html>
