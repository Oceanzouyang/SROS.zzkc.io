<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
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
       </tr>
       	<tr>
       	 <td align="center" style="display: none;" id="userid">${user.id }</td>
         <td align="center">${user.username }</td>
         <td align="center">${user.type }</td>
         <td style="display: none;" align="center"><input type="text" value="${user.choose }" id="ck"></input></td>
       </tr>
    </table>
    <br/>
    <p><input type="button" value="ȫѡ" id="selectAll"><input type="button" value="ȡ��" id="cancel"></input></p>
    <table align="center" style="border: solid thin black;" >
    	<s:iterator value="listzichan">
      		<s:if test="deptname=='�����ʲ�����̯��'||deptname=='��������'||deptname=='�Ͼ�369��ҵ��'||deptname=='��ʥ�����̩��'||deptname=='�����ƽ�'">
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span></td><tr>
      		</s:if>
      		<s:else>
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span><br></td>
      		</s:else>	
      	</s:iterator>
    </table>
    <center><input type="button" id="submit" value="ȷ��"></input>&nbsp;&nbsp;<a href="show.action">����</a></center>
    <input type="hidden" value="${loginer }"></input>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		if(window.location.pathname=="/gudingzichan/executeAdd.action"){
  			location.href="FenyeServlet";
  		}
  		
  		//�����Զ�ѡ��checkbox
		$("input[type='checkbox']").each(function () {
 			var obj = $(this);
			var value = obj.parent("td").next().find("span").text();
			//selectId = selectId  + value + ",";
			if($("#ck").val().indexOf(value)<0){
				//alert("δ����"+value);
				//var cancel = ","+value;
				//var selectId = $("#se").val().replace(cancel,"");
				//alert("ȥ����"+selectId);
				//$.ajax({
        		//type:"post",
				//url: "RemoveSession?remove="+selectId, 
             	//success: function(data) {
             	//}
				//})
			}else{
				//alert("����ѡ��"+$("#se").val());
				//alert("������"+value);
				this.checked=true;
			}
        });
          		
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
  		
  		
  		//�޸ĺ�ȷ��
  		$("#submit").click(function(){
  			var choose = "";
  			$("input[type='checkbox']:checked").each(function () {
 				var obj = $(this);
				var value = obj.parent("td").next().find("span").text();
				//alert(value);
				choose = choose + value + ",";
             });
             choose = choose.substring(0,choose.length-1);
             if(choose!=""){
             	location.href="executeUpdateChoose.action?user.id="+$("#userid").text()+"&user.choose="+choose;
             }else{
             	alert("������ѡ��һ��");
             }
  		})
  		
  	})

  </script>
  
</html>
