<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>�ʲ���Ϣ��ѯ���</title>
  </head>
    <style type="text/css">
  		table 
  		{
  			border-collapse:collapse;
  		}
  		.zichanid
  		{
  			cursor:pointer;
  		}
  	</style>
  <body style="background-color: #9ad2b2;">
  	<input type="hidden" value="${keyType }" id="keyType"></input>
  	<input type="hidden" value="${key }" id="key"></input>
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�ʲ���Ϣ��ѯ���</p>
  	<p align="center">��ѯ������${shuliang }</p><p align="center">��${qiuhe }</p>
  	<center>
    	&nbsp;&nbsp;&nbsp;&nbsp;<a href="FenyeServlet">����</a>
    	<input type="button" value="����" id="download"></input><br/><br/>
    </center>
  	<c:if test="${not empty loginid&&loginer=='baoxiao'}">
   		<p align="center">
   			<span>����</span>��<input type="text" id="content"></input>
   			<input type="button" value="��������" id="baoxiao"></input>
   		</p>
   	</c:if>
    <table id="zichanTable" align="center" width="90%" border="2">
       <tr>
       	  <td align="center">���</td>
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
         <td align="center">${zc.xuhao }</td>
         <td align="center"><a class="zichanid">${zc.zichanid }</a></td>
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
         <td align="center" id="danjuhao">${zc.danjuhao }</td>
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
          		<!--a href="shenhe.action?zichan.id=${zc.id }">���</a-->
          		<input onclick="shenhe(${currentPage},0,${zc.id });" type="button" value="���"></input>
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='0'}">
        	 <td align="center">
          		<!--a href="shenhe(1)">ȡ�����</a-->
          		<input onclick="shenhe(${currentPage},1,${zc.id });" type="button" value="ȡ�����"></input>
         	 </td>
         </c:if>
         <c:if test="${loginer=='baoxiao'}">
        	 <td align="center">
          		<a href="baoxiao.action?zichan.id=${zc.id }">����</a>
         	 </td>
         </c:if>
       </tr>
      </c:forEach>
      </table>
      <table align="center">
      <c:if test="${not empty list}">
      <tr>
	   	<td colspan="25" align="right">
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
	    		<select id="xiala" style="display: none;"></select>
	    		<input type="text" style="width: 30px;" id="number"></input><input type="button" value="��ת" id="dump"></input>
	    	</td>
	    </tr>
	    </c:if>
    </table>
    <input type="hidden" value="${loginer }"></input>
    <input type="hidden" value="${countPage}" id="ne"></input>
    <input type="hidden" value="${name}" id="name"></input>
    <input type="hidden" value="${dept}" id="dept"></input>
    <input type="hidden" value="${place}" id="place"></input>
    <input type="hidden" value="${user}" id="user"></input>
    <input type="hidden" value="${baoguan}" id="baoguan"></input>
    <input type="hidden" value="${status}" id="status"></input>
    <input type="hidden" value="${zichanid}" id="zichanid"></input>
    <input type="hidden" value="${shenhe}" id="shenhe"></input>
    <input type="hidden" value="${date}" id="date"></input>
    <input type="hidden" value="${danjuhao}" id="danjuhao"></input>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  		
  	//����ʲ���Ŵ��������ݺ�
  //	$("#zichanTable td").click(function(){
		//alert();
	//	location.href="QueryName?name="+$(this).text();
	//});
  		$(".zichanid").click(function(){
  			location.href="QueryName?name="+$(this).text();
  		});
  
  	$(document).ready(function(){
  		if(window.location.pathname=="/gudingzichan/executeAdd.action"){
  			location.href="FenyeServlet";
  		}
  		
  		//�жϵ�ǰҳ���Ƿ����2
  		if($("#ne").val()>2){
			var num = $("#ne").val();
			//alert(num);
			for(var i=2;i<num;i++){
				var content = $("#next").html();
      			content = content + "<a class='fen' style='cursor: pointer;color: blue;' onclick="+"fenye("+i+")"+">"+i+"</a>"+"  ";
                $("#next").html(content);
				$("#xiala").append("<option value="+i+">"+i+"</option>");
			}
			//$("#next").html();
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
  		//alert($("#key").val()+"=="+$("#keyType").val());
  		//alert($("#danjuhao").val()+"=="+i+"=="+$("#danjuhao").text());
  		location.href="ResultServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").text();
  	}
  	
  	function shenhe(i,a,b){
  		location.href="ShenheServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").val()+"&shenhe="+a+"&id="+b;
  	}
  	
  	
  	//����
  	$("#download").click(function(){
  		location.href="CreateFileServlet?name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").val()+"&count=1";
  	})
  	
  	//������������
  	$("#baoxiao").click(function(){
  		//alert($("#danjuhao").text()+"=="+$("#content").val());
  		location.href="executeBaoxiaoAll.action?zichan.danjuhao='"+$("#danjuhao").text()+"'&zichan.baoxiao='"+$("#content").val()+"'";
  	});
  </script>
  
</html>
