<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<html>
  <head>
    <title>����ʲ����</title>
  </head>
  
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�ʲ������Ϣ</p>
     <form action="addType.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
            	<td>�ʲ������</td>
            	<td><input type="text" name="ZichanType.typecode"></td>
            </tr>
            <tr>
            	<td>�ʲ��������</td>
              	<td><input type="text" name="ZichanType.type"></td>
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

  </script>
</html>
