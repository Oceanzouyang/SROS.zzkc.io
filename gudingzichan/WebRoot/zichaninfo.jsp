<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>�ʲ���Ϣ</title>
  </head>
  
  <% List list = (List)request.getAttribute("list"); %>
  
  
  <style type="text/css">
  	table {
  		border-collapse:collapse;
  	}
  </style>
  <body style="background-color: #9ad2b2;">
   <div style="position: absolute;float: left;margin-left: 100px;">
   		<span> 
   			��ǰ��½�û�:${loginer }  
   			<c:if test="${not empty loginid&&loginer!='admin'}">
   				<a href="updateUser.action?user.id=${loginid}">�޸�����</a>
   			</c:if>
   		</span>
		<br/>
		<br/>
  		<table>
  			<tr>
  				<td>
  					���ƣ�
 				</td>
 				<td>
 					<input type="text" id="nameValue"></input>
 				</td>
 				<td>
  					״̬��
 				</td>
 				<td>
 					<!--input type="text" id="statusValue"></input-->
 					<select id="statusValue">
 						<option value=""></option>
 						<option value="ʹ��">ʹ��</option>
 						<option value="ͣ��">ͣ��</option>
 						<option value="����">����</option>
 						<option value="����">����</option>
 						<option value="*">*</option>
 					</select>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					��ŵص㣺
 				</td>
 				<td>
 					<input type="text" id="placeValue"></input>
 				</td>
 				<td>
  					ʹ���ˣ�
 				</td>
 				<td>
 					<input type="text" id="userValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					ʹ�ò��ţ�
 				</td>
 				<td>
 					<input type="text" id="deptValue"></input>
 				</td>
 				<td>
  					�����ˣ�
 				</td>
 				<td>
 					<input type="text" id="baoguanValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					�ʲ���ţ�
 				</td>
 				<td>
 					<input type="text" id="zichanValue"></input>
 				</td>
 				<td>
 					�������ڣ�
 				</td>
 				<td>
 					<input type="text" id="dateValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					�������ݺţ�
 				</td>
 				<td>
 					<input type="text" id="danjuhaoValue"></input>
 				</td>
 				<td><br></td>
 				<td><input type="button" value="��ѯ" id="result"></input></td>
 			</tr>
 			<tr>
 				<td>
 					<input type="button" value="�����޸�" id="piliang"></input>
 				</td>
 				<td>
 					<c:if test="${loginer=='admin'}">
    					<center>
    						<a href="add.action">����</a>&nbsp;&nbsp;<a href="addPiliang.action">��������</a>&nbsp;&nbsp;<a href="login.jsp">����</a>
    					</center>
    				</c:if>
    				<c:if test="${loginer=='baoxiao'}">
    					<center>
    						<a href="FenyeServlet">����</a>
    					</center>
    				</c:if>
 				</td>
 				<td></td>
 				<td><a href="Querydanju.jsp">�ʲ�����������ת</a></td>
 			</tr>
  		</table>	
  	</div>
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�ʲ���Ϣ</p>
    <table  align="center" width="90%" border="2" style="margin-top: 150px;">
       <tr>
          <td align="center">�ʲ����</td>
          <td align="center">����</td>
          <td align="center">����ͺ�</td>
          <td align="center">��λ</td>
          <td align="center">����</td>
          <td align="center">ԭֵ</td>
          <td align="center">�����۾�</td>
          <td align="center">��ֵ</td>
          <td align="center">ת��ʱ��</td>
          <td align="center">ת��ʱ��</td>
          <td align="center">��������</td>
          <td align="center">ʹ�ò���</td>
          <td align="center">��ŵص�</td>
          <td align="center">ʹ����</td>
          <td align="center">������</td>
          <td align="center">ת������</td>
          <td align="center">ת���ص�</td>
          <td align="center">��Ӧ��</td>        
          <td align="center">ƾ֤</td>
          <td align="center">����</td>
          <td align="center">�������ݺ�</td>
          <td align="center">ת�Ƶ��ݺ�</td>
          <td align="center">���õ��ݺ�</td>
          <td align="center">״̬</td>
          <td align="center">��ע</td>
          <c:if test="${loginer=='admin'}">
          	<td align="center">����</td>
          </c:if>
          <c:if test="${loginer=='shenhe'}">
          	<td align="center">����</td>
          </c:if>
          <c:if test="${loginer=='baoxiao'}">
          	<td align="center">����</td>
          </c:if>
       </tr>
        <c:forEach items="${list}" var="zc">
       <tr>
         <td align="center">${zc.zichanid }</td>
         <td align="center">${zc.name }</td>
         <td align="center">${zc.type }</td>
         <td align="center">${zc.danwei }</td>
         <td align="center">${zc.num }</td>
         <td align="center">${zc.jine }</td>
         <td align="center">${zc.jitizhejiu }</td>
         <td align="center">${zc.jingzhi }</td>
         <td align="center">${zc.zhuanrudate }</td>
         <td align="center">${zc.zhuanchudate }</td>
         <td align="center">${zc.date }</td>
         <td align="center">${zc.dept }</td>
         <td align="center">${zc.place }</td>
         <td align="center">${zc.user }</td>
         <td align="center">${zc.baoguan }</td>
         <td align="center">${zc.zhuanchudept }</td>
         <td align="center">${zc.zhuanchuplace }</td>
         <td align="center">${zc.gongyingshang }</td>
         <td align="center">${zc.pingzheng }</td>
         <td align="center">${zc.baoxiao }</td>
         <td align="center">${zc.danjuhao }</td>
         <td align="center">${zc.zhuanyidan }</td>
         <td align="center">${zc.chuzhidan }</td>
         <td align="center">${zc.status }</td>
         <td align="center">${zc.beizhu }</td>
         <c:if test="${loginer=='admin'&&zc.shenhe=='1'}">
        	 <td align="center">
          		<a href="update.action?zichan.id=${zc.id }">�޸�</a>
          		<!--a href="delete.action?zichan.id=${zc.id }">ɾ��</a-->
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='1'}">
        	 <td align="center">
          		<a href="shenhe.action?zichan.id=${zc.id }">���</a>
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='0'}">
        	 <td align="center">
          		<a href="cancelShenhe.action?zichan.id=${zc.id }">ȡ�����</a>
         	 </td>
         </c:if>
         <c:if test="${loginer=='baoxiao'}">
        	 <td align="center">
          		<a href="baoxiao.action?zichan.id=${zc.id }">����</a>
         	 </td>
         </c:if>
       </tr>
       </c:forEach>
      <tr>
	   	<td colspan="26" align="right">
	    	<c:if test="${currentPage != 1}">
	    		<a onclick="fenye(1)" style='cursor: pointer;color: blue;'>��ҳ</a>
	    		<a onclick="fenye(${currentPage - 1})" style='cursor: pointer;color: blue;'>��һҳ</a>
	    	</c:if>
	    	<c:if test="${currentPage == 1}">
	    		<font color="#AAAAAA">��ҳ</font>
	    		<font color="#AAAAAA">��һҳ</font>
	    	</c:if>
				<!--a id="next"></a-->
	    	<c:if test="${currentPage != countPage}">
	    		<a onclick="fenye(${currentPage + 1})" style='cursor: pointer;color: blue;'>��һҳ</a>
	    		<a onclick="fenye(${countPage})" style='cursor: pointer;color: blue;'>βҳ</a>
	    	</c:if>
	    	<c:if test="${currentPage == countPage}">
	    		<font color="#AAAAAA">��һҳ</font>
	    		<font color="#AAAAAA">βҳ</font>
	    	</c:if>
	    		${currentPage}/${countPage}
	    		<select id="xiala" style="display: none;">
	    		</select>
	    		<input type="text" style="width: 30px;" id="number"></input><input type="button" value="��ת" id="dump"></input>
	    	</td>
	    </tr>
    </table>
    <input type="hidden" value="${loginer }" id="loginer"></input>
    <input type="hidden" value="${countPage}" id="ne"></input>
    <input type="hidden" value="${currentPage}" id="currentPage"></input>
    
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		if(window.location.pathname=="/gudingzichan/executeAdd.action"||window.location.pathname=="/gudingzichan/executeUpdate.action"){
  			//alert(123+"---"+window.location.pathname);
  			location.href="FenyeServlet";
  		}
  		
  		//�û���ʱ�䲻�������ص���½ҳ��
  		if($("#loginer").val()==""){
  			location.href="login.jsp";
  		}
  		
  		$("#xiala").change(function(){
    		fenye($(this).val())
  		});
  		//�жϵ�ǰҳ���Ƿ����2
  		if($("#ne").val()>2){
			var num = $("#ne").val();
			var currentPage=$("#currentPage").val();
			//alert(num);
			for(var i=2;i<num;i++){
				var content = $("#next").html();
      			content = content + "<a class='fen' style='cursor: pointer;color: blue;' onclick="+"fenye("+i+")"+">"+i+"</a>"+"  ";
                $("#next").html(content);
                $("#xiala").append("<option value="+i+">"+i+"</option>");
			}
		}
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
        		alert("��������������"); 
        		$("#number").val(""); 
    		}  			
  		}
  	})
  	
  	//�����һҳ��һҳǰҳβҳ�ȷ�ҳ����
  	function fenye(i){
  		location.href="FenyeServlet?currentPage="+i;
  	}
  	
  	//���ݹؼ��ֲ�ѯ
  	$("#query").click(function(){
  		//alert($("#sel").val());
  		if($("#key").val()!=""){
  			location.href="QueryName?name="+$("#key").val()+"&keyType="+$("#sel").val();
  		}else{
  			alert("������ؼ���");
  		}	
  	})
  	
  	//���������ϲ�ѯ
  	$("#result").click(function(){
  		if($("#nameValue").val()==""&&$("#placeValue").val()==""&&$("#deptValue").val()==""&&$("#userValue").val()==""&&$("#baoguanValue").val()==""&&$("#statusValue").val()==""&&$("#zichanValue").val()==""&&$("#dateValue").val()==""&&$("#danjuhaoValue").val()==""){
			alert("������ؼ���");
  		}else{
  			location.href="ResultServlet?name="+$("#nameValue").val()+"&place="+$("#placeValue").val()+"&dept="+$("#deptValue").val()+"&user="+$("#userValue").val()+"&baoguan="+$("#baoguanValue").val()+"&status="+$("#statusValue").val()+"&zichanid="+$("#zichanValue").val()+"&date="+$("#dateValue").val()+"&danjuhao="+$("#danjuhaoValue").val();
  		}
  	})
  	
  	$(function(){ 
  		document.onkeydown = function(e){ 
  			var ev = document.all ? window.event : e; 
  			if(ev.keyCode==13) { 
  				//$('#FormId).submit();//�����¼� 
  				if($("#nameValue").val()==""&&$("#placeValue").val()==""&&$("#deptValue").val()==""&&$("#userValue").val()==""&&$("#baoguanValue").val()==""&&$("#statusValue").val()==""&&$("#zichanValue").val()==""&&$("#dateValue").val()==""&&$("#danjuhaoValue").val()==""){
					alert("������ؼ���");
  				}else{
  					location.href="ResultServlet?name="+$("#nameValue").val()+"&place="+$("#placeValue").val()+"&dept="+$("#deptValue").val()+"&user="+$("#userValue").val()+"&baoguan="+$("#baoguanValue").val()+"&status="+$("#statusValue").val()+"&zichanid="+$("#zichanValue").val()+"&date="+$("#dateValue").val()+"&danjuhao="+$("#danjuhaoValue").val();
  				}
			} 
		} 
	});
	
	$("#piliang").click(function(){
		location.href="updateAll.jsp";
	});
  </script>
</html>
