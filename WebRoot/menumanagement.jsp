<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>权限管理</title>
     <link rel="stylesheet" href="./layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  
 <body>
  	<table class="layui-table">
  		<caption>权限管理</caption>
  	<tr>
  		<td>角色序号</td>
  		<td>角色名称</td>
  		<td>操作</td>
  	</tr>
  	<c:forEach items="${roleList }" var="r">
  		<tr>
  			<td>${r.id }</td>
  			<td>${r.name }</td>
  			<td>
  				<input type="button" value="新增" class="layui-btn layui-btn-xs" onclick="location='addAndupdate.do?id=-1'">
  				<input type="button" value="修改" class="layui-btn layui-btn-xs" onclick="location='addAndupdate.do?id=${r.id}'">
  				<input type="button" value="授权" class="layui-btn layui-btn-xs">
  			</td>
  		</tr>
  	</c:forEach>   
  	</table>
  <!--把用户页面嵌进来  -->
	<div style="background-color: gray;">
		<a href="dianyuan.jsp" style="color: red;font-size: 16px;">所有用户信息</a>
	</div>
  
  </body>
</html>
