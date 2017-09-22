<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>后台管理</title>
  </head>
  
  <body style="background-color: #9ad2b2;">
       <p align="center" style="margin-top: 100px;font-size: 50px;">后台管理系统</p>
       <table align="center" style="font-size: 20px;" height="150px;">
       	<tr>
       		<td>
       			<a href="show.action">用户管理</a>
       		</td>
       	</tr>
       	<tr>
       		<td>
       			<a href="showDept.action">部门管理</a>
       		</td>
       	</tr>
       	<tr>
       		<td>
       			<a href="showType.action">资产类别管理</a>
       		</td>
       	</tr>
       	<tr>
       		<td>
       			<a href="login.jsp">返回</a>
       		</td>
       	</tr>
       </table>     
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		
  	})
  </script>
</html>
