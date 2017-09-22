<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 40px;">部门列表信息</p>
      <table align="center" border="1" id="tb">
      	<tr>
      		<td>部门</td>
      		<td>简写拼音</td>
      		<td>操作</td>
      	</tr>
      	<s:iterator value="deptList">
      		<tr>
      			<td>
      				<s:property value="deptname"/>
      			</td>
      			<td>
      				<s:property value="py"/>
      			</td>
      			<td>
      				<a href="updateDept.action?dept.id=<s:property value="id"/>" class="update">修改</a>
      				<a href="deleteDept.action?dept.id=<s:property value="id"/>" class="update">删除部门</a>
      			</td>
      		</tr>
      	</s:iterator>
      </table>
      <br/>
      <center>
      	<a href="addDept.jsp">新增</a>&nbsp;&nbsp;<a href="info.jsp">返回</a>
      </center>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		if(window.location.pathname=="/gudingzichan/addDept.action"){
  			location.href="showDept.action";
  		}
		$("#tb tr").click(function(){
             //alert($(this).children().eq(0).text());
             $(this).children().eq(0).find("input").css("display","block");
             
		})		  
  	})	
  </script>
</html>
