<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>�ʲ�����ϵͳ�û�</title>
  </head>
    <style type="text/css">
  		table {
  			border-collapse:collapse;
  		}
  	</style>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�û���Ϣ�б�</p>
    <table  align="center" width="90%" border="2">
       <tr>
       	  <td align="center">�û���</td>
          <td align="center">����</td>
          <td align="center">����</td>
          <td align="center">�鿴</td>
          <td align="center">����</td>
       </tr>
      <s:iterator value="list">
      	<tr>
        	<td align="center">
         		<s:if test="type=='��ͨ'">
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
         		<a href="updateUser.action?user.id=<s:property value="id"/>">�޸�����</a>
         		<a href="deleteUser.action?user.id=<s:property value="id"/>">ɾ��</a>
         	</td>
       	</tr>	
      </s:iterator>
      
    </table>
    <center><a href="addUser.action">����</a>&nbsp;&nbsp;<a href="info.jsp">����</a></center>
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
  		//�жϵ�ǰҳ���Ƿ����2
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
  	
  	
  	//�������ֽ��з�ҳ��ת
  	$("#dump").click(function(){
  		if($("#number").val()==""||parseInt($("#number").val())>parseInt($("#ne").val())){
  			alert("������С��"+$("#ne").val()+"����");
  			$("#number").val("");
  		}else{
  			if((/^(\+|-)?\d+$/.test($("#number").val()))&&$("#number").val()>0){  
				fenye($("#number").val());
    		}else{  
        		alert("��������������������"); 
        		$("#number").val(""); 
    		}  		
  		}
  	})
  	//�����һҳ��һҳǰҳβҳ�ȷ�ҳ����
  	function fenye(i){
  		location.href="ResultServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val();
  	}
  	
  </script>
  
</html>
