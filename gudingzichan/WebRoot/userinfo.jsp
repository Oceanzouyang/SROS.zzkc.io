<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>资产管理系统用户</title>
  </head>
    <style type="text/css">
  		table {
  			border-collapse:collapse;
  		}
  	</style>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">用户信息列表</p>
    <table  align="center" width="90%" border="2">
       <tr>
       	  <td align="center">用户名</td>
          <td align="center">密码</td>
          <td align="center">类型</td>
          <td align="center">查看</td>
          <td align="center">操作</td>
       </tr>
      <s:iterator value="list">
      	<tr>
        	<td align="center">
         		<s:if test="type=='普通'">
         			<a href="updateChoose.action?user.id=<s:property value="id"/>"><s:property value="username"/></a>
         		</s:if>
         		<s:else>
         			<s:property value="username"/>
         		</s:else>
         	</td>
         	<td align="center"><s:property value="password"/></td>
         	<td align="center"><s:property value="type"/></td>
         	<td align="center"><s:property value="choose"/></td>
         	<td align="center">
         		<a href="updateUser.action?user.id=<s:property value="id"/>">修改密码</a>
         		<a href="deleteUser.action?user.id=<s:property value="id"/>">删除</a>
         	</td>
       	</tr>	
      </s:iterator>
      
    </table>
    <center><a href="addUser.action">新增</a>&nbsp;&nbsp;<a href="info.jsp">返回</a></center>
    <input type="hidden" value="${loginer }"></input>
    <input type="hidden" value="${countPage}" id="ne"></input>
    <input type="hidden" value="${name}" id="name"></input>
    <input type="hidden" value="${dept}" id="dept"></input>
    <input type="hidden" value="${place}" id="place"></input>
    <input type="hidden" value="${user}" id="user"></input>
    <input type="hidden" value="${baoguan}" id="baoguan"></input>
    <input type="hidden" value="${status}" id="status"></input>
    <input type="hidden" value="${zichanid}" id="zichanid"></input>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		if(window.location.pathname=="/gudingzichan/UserLogin"||window.location.pathname=="/gudingzichan/registerServlet"){
  			location.href="show.action";
  		}
  		//判断当前页数是否大于2
  		if($("#ne").val()>2){
			var num = $("#ne").val();
			for(var i=2;i<num;i++){
				var content = $("#next").html();
      			content = content + "<a class='fen' style='cursor: pointer;color: blue;' onclick="+"fenye("+i+")"+">"+i+"</a>"+"  ";
                $("#next").html(content);
				$("#xiala").append("<option value="+i+">"+i+"</option>");
			}
		}
		$("#xiala").change(function(){
    		fenye($(this).val())
  		});
  	})
  	
  	
  	//输入数字进行分页跳转
  	$("#dump").click(function(){
  		if($("#number").val()==""||parseInt($("#number").val())>parseInt($("#ne").val())){
  			alert("请输入小于"+$("#ne").val()+"数字");
  			$("#number").val("");
  		}else{
  			if((/^(\+|-)?\d+$/.test($("#number").val()))&&$("#number").val()>0){  
				fenye($("#number").val());
    		}else{  
        		alert("数量中请输入正整数！"); 
        		$("#number").val(""); 
    		}  		
  		}
  	})
  	//点击上一页下一页前页尾页等分页操作
  	function fenye(i){
  		location.href="ResultServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val();
  	}
  	
  </script>
  
</html>
