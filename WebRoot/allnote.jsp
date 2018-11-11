<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>展示所有记录操作</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  <body>
  	<table class="layui-table">
  		<caption>会员操作记录</caption>
  	<tr>
  	<td colspan="5">
  		<form action="selectAllNote.do" method="post">
  			<input type="text" placeholder="请输入操作员:" name="user_id"> 
  			<input type="date" placeholder="请选择日期:" name="date"> 
  			<input type="submit" value="查询" class="layui-btn"> 
  		</form>
  	</td>	
  	</tr>
  	<tr>
  		<td>序号</td>
  		<td>vipID</td>
  		<td>操作时间</td>
  		<td>操作员</td>
  		<td>执行操作</td>
  	</tr>
  	<c:forEach items="${noteList }" var="note">
  		<tr>
  			<td>${note.id }</td>
  			<td>${note.vip_id }</td>
  			<td>${note.date }</td>
  			<td>${note.user_id }</td>
  			<td>${note.handle }</td>
  		</tr>
  	</c:forEach>
  	
  	
  	
  	</table>
  
  
  </body>
</html>
