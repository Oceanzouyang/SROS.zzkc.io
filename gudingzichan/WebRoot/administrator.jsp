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
       <p align="center">新增用户</p>
       <table align="center">
       	 <tr>
       	 	<td>用户名:</td>
       	 	<td><input type="text" id="name"></input></td>
       	 </tr>
       	 <tr>
       	 	<td>密码:</td>
       	 	<td><input type="password" id="password"></input></td>
       	 </tr>
       	 <tr>
       	 	<td>确认密码:</td>
       	 	<td><input type="password" id="repassword"></input></td>
       	 </tr>
       	 <tr>
       	 	<td><br/></td>
       	 	<td><input type="button" id="add" value="新增"></input>&nbsp;&nbsp;<a href="show.action">返回</a></td>
       	 </tr>
       </table>
	  <p><input type="button" value="全选" id="selectAll"><input type="button" value="取消" id="cancel"></input></p>
      <table align="center" style="border: solid thin black;" >
      	<s:iterator value="listzichan">
      		<s:if test="deptname=='集团资产待分摊库'||deptname=='无锡宾馆'||deptname=='葡京369勤业店'||deptname=='鼎圣堂瑞和泰店'||deptname=='中联黄金'&&deptname!=">
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
  				alert("用户名不能为空");
  			}else if($("#password").val()==""){
  				alert("密码不能为空");
  			}else if($("#password").val()!=$("#repassword").val()){
  				alert("两次输入密码不一致");
  				$("#password").val("");
  				$("#repassword").val("");
  			}else{
  				if(choose!=""){
  					location.href="registerServlet?username="+$("#name").val()+"&password="+$("#password").val()+"&choose="+choose;
  				}else{
  					alert("请至少选择一项");
  				}
  			}
  		})  		
  		
  		//全选
  		$("#selectAll").click(function(){
        	$(".check").each(function(){
   		    	//$(this).attr("checked",true);
   		    	this.checked=true;
			//
  	    	});   	    	
        });
        //取消
   	    $("#cancel").click(function(){
  			$(".check").each(function(){
  				//$(this).attr("checked",false);
  				this.checked=false;
     		});
  		});  
  	})
  </script>
</html>
