<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>用户信息</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
	<script src="js/layui.js"></script>
  </head>
  
  <body>
	<table class="layui-table">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>卡号</th>
			<th>余额</th>
			<th>身份</th>
		</tr>
		
	<c:forEach items="${vipPage.vipList }" var="vip">
		<tr>
			<td>${vip.id }</td>
			<td>${vip.name }</td>
			<td>${vip.number }</td>
			<td>${vip.remain }</td>
			<td>${vip.type }</td>
			<!--修改入口  -->
			<td><a href="getOneVip.do?id=${vip.id }"><input type="button" value="修改" class="layui-btn layui-btn-xs"/></a></td>
			<!--删除入口  -->
			<td><input type="button" value="删除" onclick="if(confirm('确认删除?')) location='deleteVip.do?id=${vip.id}'" class="layui-btn layui-btn-xs"> </td>
		</tr>
	</c:forEach>
	<!--翻页数据  -->
		<tr>
			<td colspan="7" style="text-align: right; font-size: 15px">	
			<p>
			共有${vipPage.counts }条记录,
				当前${vipPage.page }/${vipPage.pages } 页.
			<a href="findByPage.do
				<c:if test='${name != null }'>&name=${name}</c:if>
				<c:if test='${number != null }'>&number=${number}</c:if>">
				首页
			</a>
			<a href="findByPage.do?page=${vipPage.page -1}
				<c:if test='${name != null }'>&name=${name}</c:if>
				<c:if test='${ number!= null }'>&number=${number}</c:if>">
				上一页
			</a>
			<a href="findByPage.do?page=${vipPage.page +1}
				<c:if test='${name != null }'>&name=${name}</c:if>
				<c:if test='${number != null }'>&number=${number}</c:if>">
				下一页
			</a>
			<a href="findByPage.do?page=${vipPage.pages }
				<c:if test='${name != null }'>&name=${name}</c:if>
				<c:if test='${number != null }'>&number=${number}</c:if>">
				末页
			</a>
			</p>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<form action="findByPage.do" method="post" style="float: right;">
					<input style="width: 100px" placeholder="请输入卡号:" type="text" name="number" value="${number1 }"> 
					<input style="width: 100px" placeholder="请输入姓名:" type="text" name="name" value="${name1 }"> 
					<input type="submit" value="查询" class="layui-btn layui-btn-xs">
				</form><a href="addVip.jsp" style="float: left;"><input type="button" value="新增" class="layui-btn layui-btn-xs"></a> 
			</td>
		</tr>

	</table>


  </body>
</html>
