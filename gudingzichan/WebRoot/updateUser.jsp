<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸�����</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�û�������Ϣ</p>
     <form action="executeCommonUserUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>�û���<input type="hidden" name="user.id" value="${user.id }"></input></td>
              <td><input type="text" name="user.username" value="${user.username }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>������</td>
                <td><input type="text" name="user.password" value=${user.password }></td>
            </tr>
            <tr style="display: none;">
                <td>����</td>
                <td><input type="text" name="user.type" value=${user.type }></td>
            </tr>
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="�޸�����"/>
                 <a href="login.jsp">����</a>
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
