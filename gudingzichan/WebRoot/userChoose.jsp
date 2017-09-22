<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
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
          <td align="center">类型</td>
       </tr>
       	<tr>
       	 <td align="center" style="display: none;" id="userid">${user.id }</td>
         <td align="center">${user.username }</td>
         <td align="center">${user.type }</td>
         <td style="display: none;" align="center"><input type="text" value="${user.choose }" id="ck"></input></td>
       </tr>
    </table>
    <br/>
    <p><input type="button" value="全选" id="selectAll"><input type="button" value="取消" id="cancel"></input></p>
    <table align="center" style="border: solid thin black;" >
    	<s:iterator value="listzichan">
      		<s:if test="deptname=='集团资产待分摊库'||deptname=='无锡宾馆'||deptname=='葡京369勤业店'||deptname=='鼎圣堂瑞和泰店'||deptname=='中联黄金'">
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span></td><tr>
      		</s:if>
      		<s:else>
      			<td><input type="checkbox" class="check"></input></td><td><span><s:property value="deptname"/></span><br></td>
      		</s:else>	
      	</s:iterator>
    </table>
    <center><input type="button" id="submit" value="确定"></input>&nbsp;&nbsp;<a href="show.action">返回</a></center>
    <input type="hidden" value="${loginer }"></input>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		if(window.location.pathname=="/gudingzichan/executeAdd.action"){
  			location.href="FenyeServlet";
  		}
  		
  		//加载自动选择checkbox
		$("input[type='checkbox']").each(function () {
 			var obj = $(this);
			var value = obj.parent("td").next().find("span").text();
			//selectId = selectId  + value + ",";
			if($("#ck").val().indexOf(value)<0){
				//alert("未包含"+value);
				//var cancel = ","+value;
				//var selectId = $("#se").val().replace(cancel,"");
				//alert("去掉后"+selectId);
				//$.ajax({
        		//type:"post",
				//url: "RemoveSession?remove="+selectId, 
             	//success: function(data) {
             	//}
				//})
			}else{
				//alert("加载选中"+$("#se").val());
				//alert("包含了"+value);
				this.checked=true;
			}
        });
          		
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
  		
  		
  		//修改后确定
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
             	alert("请至少选择一项");
             }
  		})
  		
  	})

  </script>
  
</html>
