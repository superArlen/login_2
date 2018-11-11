<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
    <title>修改信息</title>
    <script src="./layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="./js/style.css"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
    layui.use('layer',function(){
    
    $(function(){
    	$("#form").submit(function(){
    	var name = $("#name").val();
    	var pwd = $("#password").val();
    		if(name==""||name==""){
    			layer.msg('用户名不能为空!');
    		//	alert("用户名不能为空!");
    			return false;
    		}
    		if(pwd==""||pwd==null){
    		layer.msg('密码不能为空!');
    		//alert("密码不能为空!");
    		return false;
    		}
    	});
    });
    });
    </script>
    
  </head>
  
  <body>
  <div align="center">
  	<form action="updateAdmin.do" method="post"  id="form" >
 	
 		编号: <input type="text" class="layui-input id" lay-verify="required" placeholder="请输入id" name="id" id="id" > <br>
 		<p></p>
 		姓名: <input type="text" class="layui-input name" name="name" id="name">	<br>
 		<p></p>
 		密码: <input type="text" class="layui-input password" name="password" id="password">	<br>
 		<p></p>
 		年龄: <input type="text" class="layui-input age" >	<br>
 		<p></p>
 		生日: <input type="text" class="layui-input birthday" >	<br>
 		<p></p>
 		身份: <input type="text" class="layui-input status" >		<br>
 		<p></p>
 		<input type="submit" value="确认修改" id="btn">
 		<button type="button"  class="layui-btn layui-btn-m layui-btn-primary cancle_btn">取消</button>
 	</form>
  </div>
  </body>
</html>
