<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸��ʲ������Ϣ</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�ʲ������Ϣ</p>
     <form action="executeTypeUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>�ʲ����ͱ��<input type="hidden" name="ZichanType.id" value="${ZichanType.id }"></input></td>
              <td><input type="text" name="ZichanType.typecode" value="${ZichanType.typecode }"></td>
            </tr>
            <tr>
              <td>�ʲ���������</td>
              <td><input type="text" name="ZichanType.type" value="${ZichanType.type }"></td>
            </tr>
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="�ύ"/>
                 <a href="showType.action">����</a>
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
