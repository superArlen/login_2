<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>充值记录</title>
     <link rel="stylesheet" href="./layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  
 <body>
  	<table class="layui-table">
  		<caption>会员充值记录</caption>
  	<tr>
  		<td colspan="4"></td>
  		<td><input type="button" value="充值" onclick="location='record.jsp'" class="layui-btn layui-btn-xs"></td>
  	</tr>
  	<tr>
  		<td>序号</td>
  		<td>操作人员</td>
  		<td>充值时间</td>
  		<td>充值金额</td>
  		<td>会员信息</td>
  		
  	</tr>
  	<c:forEach items="${recordList }" var="r">
  		<tr>
  			<td>${r.id }</td>
  			<td>${r.user_id }</td>
  			<td>${r.time }</td>
  			<td>${r.amount }</td>
  			<td>${r.vip_id }</td>
  		</tr>
  	</c:forEach>
  	
  	
  	
  	</table>
  
  
  </body>
</html>
