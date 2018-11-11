<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>    
    <title>超级管理员展示信息</title>
  </head>
  <style>
  	/* div{padding: 0 20px;margin: 0 45px;} */
  	div h2:nth-child(even) {background: #EAF3F5;height: 50px;}
	div h2:nth-child(odd) {background: #FFF;height: 50px;}
  	caption	{font-size: 18px;font-weight: bold;height: 20px;}
  	table tr:nth-child(even) {background: #EAF3F5;height: 50px;}
	table tr:nth-child(odd) {background: #FFF;height: 50px;}
  </style>
  <body>
  
  <div style=";float: left;">
  
  <fieldset class="solid" style="height: 500px; width: 450px;">
	<legend>管理员信息</legend>
    <h2>你好:${u.name }</h2>
     <h2>年龄:${u.age}</h2>
      <h2>生日:
      <fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd"/>
      </h2>
       <h2>编号:${u.id }</h2>
       <h2>密码:${u.password }</h2>
       <h2>身份:${u.status eq 1?"管理员":"超级管理员" }</h2>   <!--三元表达式显示身份  -->
       </fieldset>
   </div>
   
  
      
 
      
  </body>
</html>
