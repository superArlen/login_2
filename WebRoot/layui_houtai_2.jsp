<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<title>Layui后台</title>
<link rel="stylesheet" href="./layui/css/layui.css">
<script src="js/layui.js"></script>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">用户管理系统</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      
      <c:forEach items="${menuAList }" var="mA">
      
      	<li class="layui-nav-item layui-nav-itemed">
      	<c:if test="${mA.user_id eq 1 }">
          <a class="" href="${mA.address}" target="iframe">${mA.name }</a>
         </c:if>
          <dl class="layui-nav-child">
            <%-- <dd><a href="${mA.address }" target="iframe">${mA.name }</a></dd> --%>
            <!-- <dd><a href="selectAllMenu.do" target="iframe">权限管理</a></dd> -->
          </dl>
        </li>
      
      
      </c:forEach>
      
      
      
      
        
        
         <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="findByPage.do" target="iframe">会员信息</a> 
          <dl class="layui-nav-child">
            <dd><a href="selectAllNote.do" target="iframe">操作会员</a></dd>
             <dd><a href="javascript:;">会员充值</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
           <a href="javascript:;">业务订单</a> 
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    	<iframe src ="welcome.jsp" name="iframe" height="600px" width="1030px">
    
    
    
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src="../src/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>
