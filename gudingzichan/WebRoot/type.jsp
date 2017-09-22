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
    <title>资产类别管理</title>
  </head>
  
  <body  style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 40px;">资产类别列表信息</p>
      <table align="center" border="1" id="tb" style="display: none;">
      	<tr>
      		<td>类别</td>
      		<td>编码</td>
      		<td>操作</td>
      	</tr>
      	<s:iterator value="zichanTypeList">
      		<tr>
      			<td>
      				<s:property value="type"/>
      			</td>
      			<td>
      				<s:property value="typecode"/>
      			</td>
      		</tr>
      	</s:iterator>
      </table>
      <br/>
      <center>
      	<a href="addType.jsp">新增</a>&nbsp;&nbsp;<a href="info.jsp">返回</a>
      </center>  
       ${requestScope.req}
       ${requestScope.req1}
      <!--%=session.getAttribute("ses")%-->
  </body>
   <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		if(window.location.pathname=="/gudingzichan/addType.action"){
  			location.href="showType.action";
  		}
		//$("#tb tr").click(function(){
             //alert($(this).children().eq(0).text());
        //     $(this).children().eq(0).find("input").css("display","block");
             
		//})
		$(".deleteType").click(function(){
			if(confirm("确定删除数据吗")){
				//alert($(this).attr("id"));
				location.href="deleteType.action?ZichanType.id="+$(this).attr("id");
			}else{
				//alert("cancel");
			}
		});		  
  	})	
  </script>
</html>
