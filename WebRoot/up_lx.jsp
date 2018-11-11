<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>My JSP 'up_lx.jsp' starting page</title>
    

  </head>
  
  <body>
  <form id="form" name="form" class="form-horizontal" action="addStore.do" method="post" enctype="multipart/form-data">
  	    <div class="controls">
        	<label class="control-label">身份证正面照片：</label>  <input class="input-file"  type="file" name="file" required="required"  multiple="multiple">
        	
        </div>
  	<input class="btn btn-success" id="accept" type="submit" />
  
  
  </form>
  
  
  </body>
</html>
