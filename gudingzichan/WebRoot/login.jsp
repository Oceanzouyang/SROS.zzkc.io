<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��½</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body style="background-image: url('img/login.jpg');">
    <!--p align="center" ><img src="img/logo1.jpg"  width="200px;" height="200px;"></img></p-->
  	<p style="font-size: 30px;margin-top: 260px;margin-left: 800px;">�ʲ�����ϵͳ</p>
    <table style="margin-top: 10px;margin-left: 780px;">
    	<tr>
    		<td>�û�����</td>
    		<td><input type="text" id="name"></input></td>
    	</tr>
    	<tr>
    		<td>���룺</td>
    		<td><input type="password" id="password"></input></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="button" value="��½" id="login"></input></td>
    	</tr>
    </table>
    <input type="hidden" value="${loginer}" id="error"></input>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		if($('#error').val()=="error"){
  			alert("�û����������");
  		}
  	})
  
  	//��½
  	$("#login").click(function(){
  		if($("#name").val()==""||$("#password").val()==""){
  			alert("�û��������벻��Ϊ��");
  		}else{
  			location.href="UserLogin?name="+$("#name").val()+"&password="+$("#password").val();
  		}
  	})  	
  	
  	
  	//�س���½
  	$(function(){ 
  		document.onkeydown = function(e){ 
  			var ev = document.all ? window.event : e; 
  			if(ev.keyCode==13) { 
  				if($("#name").val()==""||$("#password").val()==""){
  					alert("�û��������벻��Ϊ��");
  				}else{
  					location.href="UserLogin?name="+$("#name").val()+"&password="+$("#password").val();
  				}
			} 
		} 
	});
  </script>
</html>
