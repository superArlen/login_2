<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="./js/style.css"/>
     <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
		$(function(){
		//验证不能为空
			$("#form").submit(function(){
				//获取用户名和密码
				var loginName = $("#loginName").val(); 
				var loginPwd = $("#loginPwd").val();
				if(loginName==""||loginName==null){
					alert("用户名不能为空!!!!");
					return false;
				}
				if(loginPwd==""||loginPwd==null){
					alert("密码不能为空!");
					return false;
				}
			});//提交
			//验证密码长度 不能低于三位
			$("#loginPwd").blur(function(){
 				var loginPwd = $("#loginPwd").val();
 				var Pwd = /^\d{3,11}$/;
 				if(!Pwd.test(loginPwd)){
 					var $msg = $("<span>3-11位.</span>");
 					$msg.css({"color":"red","font-size":"12px"});
					$("span:eq(0)").replaceWith($msg);
						return false;
 				}
			});//密码
		});
		
		
    </script>
    
  </head>
  <body>
    <form action="login1.do" method="post" id="form">
    <table style="background-color: #EFEFEF;height: 260px;width: 600px ;border="1" align="center";">
    	<caption style="font-size: 30px">请登录</caption>
    
    	<tr>
    		<td style="font-size: 20px">登陆名:</td>
    		<td><input type="text" name="loginName" id="loginName" value="${Name }"></td>
    	</tr>
    	
    	<tr>
    		<td style="font-size: 20px">登陆密码:</td>
    		<td>
    			<input type="text" name="loginPwd" id="loginPwd" value="${Pwd }"> 
    			<span style="color: blue;font-size: 12px;">3-11位.</span> 
    		</td>
    		
    	</tr>
    	<!-- 
    	<tr>
    		<td style="font-size: 20px">身份:</td>	
    		<td>
    			<select name="status">
    				<option value="0">超级管理员</option>
    				<option value="1">管理员</option>
    			</select>
    		</td>
    		
    	</tr> -->
    	<tr>
    		<td></td>
    		<td>
    			<input type="submit" value="登陆" id="btn" name="btn" > 
    			
    		</td>
    		
    	</tr>
    	<tr>
    		<td></td>
    		<td>
    		<input type="button" value="用户注册" id="btn" onclick="location='register2.jsp'">
    		</td>
    	
    	</tr>
    </table>
    </form>
    
    
   
    
  </body>
</html>
