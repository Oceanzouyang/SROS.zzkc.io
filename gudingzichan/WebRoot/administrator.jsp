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
       <p align="center">�����û�</p>
       <table align="center">
       	 <tr>
       	 	<td>�û���:</td>
       	 	<td><input type="text" id="name"></input></td>
       	 </tr>
       	 <tr>
       	 	<td>����:</td>
       	 	<td><input type="password" id="password"></input></td>
       	 </tr>
       	 <tr>
       	 	<td>ȷ������:</td>
       	 	<td><input type="password" id="repassword"></input></td>
       	 </tr>
       	 <tr>
       	 	<td><br/></td>
       	 	<td><input type="button" id="add" value="����"></input>&nbsp;&nbsp;<a href="show.action">����</a></td>
       	 </tr>
       </table>
	  <p><input type="button" value="ȫѡ" id="selectAll"><input type="button" value="ȡ��" id="cancel"></input></p>
      <table align="center" style="border: solid thin black;" >
      	<s:iterator value="listzichan">
      		<s:if test="deptname=='�����ʲ�����̯��'||deptname=='��������'||deptname=='�Ͼ�369��ҵ��'||deptname=='��ʥ�����̩��'||deptname=='�����ƽ�'&&deptname!=">
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span></td><tr>
      		</s:if>
      		<s:else>
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span><br></td>
      		</s:else>	
      	</s:iterator>
      </table>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function() {
  		$("#add").click(function(){
  			var choose = "";
  			$("input[type='checkbox']:checked").each(function () {
 				var obj = $(this);
				var value = obj.parent("td").next().find("span").text();
				//alert(value);
				choose = choose + value + ",";
             });
             choose = choose.substring(0,choose.length-1);
             //alert(choose);
  			if($("#name").val()==""){
  				alert("�û�������Ϊ��");
  			}else if($("#password").val()==""){
  				alert("���벻��Ϊ��");
  			}else if($("#password").val()!=$("#repassword").val()){
  				alert("�����������벻һ��");
  				$("#password").val("");
  				$("#repassword").val("");
  			}else{
  				if(choose!=""){
  					location.href="registerServlet?username="+$("#name").val()+"&password="+$("#password").val()+"&choose="+choose;
  				}else{
  					alert("������ѡ��һ��");
  				}
  			}
  		})  		
  		
  		//ȫѡ
  		$("#selectAll").click(function(){
        	$(".check").each(function(){
   		    	//$(this).attr("checked",true);
   		    	this.checked=true;
			//
  	    	});   	    	
        });
        //ȡ��
   	    $("#cancel").click(function(){
  			$(".check").each(function(){
  				//$(this).attr("checked",false);
  				this.checked=false;
     		});
  		});  
  	})
  </script>
</html>
