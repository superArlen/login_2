<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>新增或者修改</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  
  <body>
<c:if test="${role!=null }"><!--编辑  -->
  <form action="roleUpdate_Add.do" method="post">
  <input hidden="true" name="op" value="update">
  <input hidden="true" name="id" value="${role.id }">
	<table>
	<caption>编辑</caption>
		<tr>
			<td>角色名称</td>
			<td>
				<input type="text" value="${role.name }" name="roleName">
			</td>
			<td>
				<input type="submit" value="编辑">
			</td>
		</tr>	
	</table>
	</form>
</c:if>

<!--新增  -->
<c:if test="${role==null }">
  <form action="roleUpdate_Add.do" method="post">
  <input hidden="true" name="op" value="add">
	<table>
	<caption>新增</caption>
		<tr>
			<td>角色名称</td>
			<td>
				<input type="text" value="${role.name }" name="roleName">
			</td>
			<td>
				<input type="submit" value="新增">
			</td>
		</tr>	
	</table>
	</form>
</c:if>
	
	




  </body>
</html>
