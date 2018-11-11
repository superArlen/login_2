<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerOK.jsp' starting page</title>
    

  </head>
  
  <body>
  <h1>注册成功</h1>
   <h1>你好:${ru.name }</h1>
  </body>
</html>
