<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改部门信息</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">部门信息</p>
     <form action="executeDeptUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>部门名称<input type="hidden" name="dept.id" value="${dept.id }"></input></td>
              <td>
              	<input type="text" name="dept.deptname" value="${dept.deptname }">
              </td>
            </tr>
            <tr>
            	<td>简写拼音</td>
            	<td>
            		<input type="text" name="dept.py" value="${dept.py }" />
            	</td>
            </tr>
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="提交"/>
                 <a href="showDept.action">返回</a>
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
