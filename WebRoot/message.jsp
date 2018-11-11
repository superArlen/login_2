<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    
    <title>超级管理员记事本功能</title>
    <script type="text/javascript" src="js/wangEditor.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	/* 	$(function(){
			var text 
		
		
		
		}); */
		


</script>
  </head>
  
  <body>
  <p>wangEditor</p>

	<div id="div1" style="width :500px;">
		<p>初始化的内容</p>
		<p>初始化的内容</p>
	</div>
	<button id="btn1">获取html</button>
	<button id="btn2">获取text</button>
	</div>
	<script type="text/javascript">
		var E = window.wangEditor;
		var editor = new E('#div1');
		editor.customConfig.menus = ['head','bold','italic','underline' ];
		editor.create();
		//在输入框追加内容
		//editor.txt.html('<p>用 JS 设置的内容</p>');
		//获取内容
/* 		
		document.getElementById('btn1').addEventListener('click', function() {
			// 读取 html
			var text = editor.txt.html();
			var id=1;
			alert(text);
		}, false); */

/*  */
	//换个方式
	



/*  */



		document.getElementById('btn2').addEventListener('click', function() {
			// 读取 text
			alert(editor.txt.text());
		}, false);
	</script>
  
  
  
  </body>
</html>
