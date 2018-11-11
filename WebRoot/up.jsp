<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
  <head>
    
    <title>文件上传</title>
    

  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="upload.do" method="post" enctype="multipart/form-data">
    	<p>
    		文件描述:<input type="text" name="desc">
    	</p>
    	<p>
    		<label class="control-label">文件：</label>  <input class="input-file"  type="file" name="file" required="required"  multiple="multiple">
    	</p>
    	<p>
    		<input type="submit" value="上传">
    	</p>
    	
    </form>
    
  </body>
</html>
