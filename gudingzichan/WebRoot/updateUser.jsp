<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">用户密码信息</p>
     <form action="executeCommonUserUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>用户名<input type="hidden" name="user.id" value="${user.id }"></input></td>
              <td><input type="text" name="user.username" value="${user.username }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>新密码</td>
                <td><input type="text" name="user.password" value=${user.password }></td>
            </tr>
            <tr style="display: none;">
                <td>类型</td>
                <td><input type="text" name="user.type" value=${user.type }></td>
            </tr>
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="修改密码"/>
                 <a href="login.jsp">返回</a>
              </td>
            </tr>
       </table>
     </form>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	 $("#change").change(function(){
  	 	$("#status").val($("#change").val());
  	 })
  	 
  	 $(document).ready(function(){
  	 	if($("#status").val()==null||$("#status").val()==""){
  	 		$("#status").val($("#change").val());
  	 	}
  	 })
  </script>
</html>
