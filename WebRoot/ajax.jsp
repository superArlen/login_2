<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
  <head>
    <title>Ajax</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function Ajax() {
			$("#btn").click(function(){
			var name = $("#name").val();
			if(name==null||""==name){
				alert("用户名不能为空");
				return;
				}
			$.ajax({
				url:"ajax.do",
				type:"post",
				data:{"name":name},
				dataType:"JSON",
				success:function(data){
				alert("123");
					$("#show").html(data.msg);
				},		
				error:function(){
				}	
			});			
		});
		}
		
	
	</script>

  </head>
  
  <body>
  	<p>
  	姓名:<input type="text" id="name" onblur="Ajax">
  	</p>
  <p>
  	<input type="button" value="提交" id="btn">
  </p>
  <p id="show" style="color: red"></p>
  
  </body>
  
   
</html>
