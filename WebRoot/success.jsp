<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
  <head>
    
    <title>下载文件</title>
    

  </head>
  
  <body>
   <h2>上传成功</h2>
   
   <p>
   	点击<a href="download.do?fileName=${fileName }">这里</a>下载文件
   </p>
   
   <img alt="图片" src="http://localhost:6060/20180708_login/uploadfiles/${fileName }">
   
  </body>
</html>
