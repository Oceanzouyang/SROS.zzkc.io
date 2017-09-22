<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>资产信息</title>
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
   			当前登陆用户:${loginer }  
   			<c:if test="${not empty loginid&&loginer!='admin'}">
   				<a href="updateUser.action?user.id=${loginid}">修改密码</a>
   			</c:if>
   		</span>
		<br/>
		<br/>
  		<table>
  			<tr>
  				<td>
  					名称：
 				</td>
 				<td>
 					<input type="text" id="nameValue"></input>
 				</td>
 				<td>
  					状态：
 				</td>
 				<td>
 					<!--input type="text" id="statusValue"></input-->
 					<select id="statusValue">
 						<option value=""></option>
 						<option value="使用">使用</option>
 						<option value="停用">停用</option>
 						<option value="报废">报废</option>
 						<option value="处置">处置</option>
 						<option value="*">*</option>
 					</select>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					存放地点：
 				</td>
 				<td>
 					<input type="text" id="placeValue"></input>
 				</td>
 				<td>
  					使用人：
 				</td>
 				<td>
 					<input type="text" id="userValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					使用部门：
 				</td>
 				<td>
 					<input type="text" id="deptValue"></input>
 				</td>
 				<td>
  					保管人：
 				</td>
 				<td>
 					<input type="text" id="baoguanValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					资产编号：
 				</td>
 				<td>
 					<input type="text" id="zichanValue"></input>
 				</td>
 				<td>
 					入账日期：
 				</td>
 				<td>
 					<input type="text" id="dateValue"></input>
 				</td>
 			</tr>
 			<tr>
 				<td>
 					新增单据号：
 				</td>
 				<td>
 					<input type="text" id="danjuhaoValue"></input>
 				</td>
 				<td><br></td>
 				<td><input type="button" value="查询" id="result"></input></td>
 			</tr>
 			<tr>
 				<td>
 					<input type="button" value="批量修改" id="piliang"></input>
 				</td>
 				<td>
 					<c:if test="${loginer=='admin'}">
    					<center>
    						<a href="add.action">新增</a>&nbsp;&nbsp;<a href="addPiliang.action">批量新增</a>&nbsp;&nbsp;<a href="login.jsp">返回</a>
    					</center>
    				</c:if>
    				<c:if test="${loginer=='baoxiao'}">
    					<center>
    						<a href="FenyeServlet">返回</a>
    					</center>
    				</c:if>
 				</td>
 				<td></td>
 				<td><a href="Querydanju.jsp">资产单据数据流转</a></td>
 			</tr>
  		</table>	
  	</div>
  	<p align="center" style="font-size: 30px;margin-top: 30px;">资产信息</p>
    <table  align="center" width="90%" border="2" style="margin-top: 150px;">
       <tr>
          <td align="center">资产编号</td>
          <td align="center">名称</td>
          <td align="center">规格型号</td>
          <td align="center">单位</td>
          <td align="center">数量</td>
          <td align="center">原值</td>
          <td align="center">计提折旧</td>
          <td align="center">净值</td>
          <td align="center">转入时间</td>
          <td align="center">转出时间</td>
          <td align="center">入账日期</td>
          <td align="center">使用部门</td>
          <td align="center">存放地点</td>
          <td align="center">使用人</td>
          <td align="center">保管人</td>
          <td align="center">转出部门</td>
          <td align="center">转出地点</td>
          <td align="center">供应商</td>        
          <td align="center">凭证</td>
          <td align="center">报销</td>
          <td align="center">新增单据号</td>
          <td align="center">转移单据号</td>
          <td align="center">处置单据号</td>
          <td align="center">状态</td>
          <td align="center">备注</td>
          <c:if test="${loginer=='admin'}">
          	<td align="center">操作</td>
          </c:if>
          <c:if test="${loginer=='shenhe'}">
          	<td align="center">操作</td>
          </c:if>
          <c:if test="${loginer=='baoxiao'}">
          	<td align="center">操作</td>
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
          		<a href="update.action?zichan.id=${zc.id }">修改</a>
          		<!--a href="delete.action?zichan.id=${zc.id }">删除</a-->
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='1'}">
        	 <td align="center">
          		<a href="shenhe.action?zichan.id=${zc.id }">审核</a>
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='0'}">
        	 <td align="center">
          		<a href="cancelShenhe.action?zichan.id=${zc.id }">取消审核</a>
         	 </td>
         </c:if>
         <c:if test="${loginer=='baoxiao'}">
        	 <td align="center">
          		<a href="baoxiao.action?zichan.id=${zc.id }">报销</a>
         	 </td>
         </c:if>
       </tr>
       </c:forEach>
      <tr>
	   	<td colspan="26" align="right">
	    	<c:if test="${currentPage != 1}">
	    		<a onclick="fenye(1)" style='cursor: pointer;color: blue;'>首页</a>
	    		<a onclick="fenye(${currentPage - 1})" style='cursor: pointer;color: blue;'>上一页</a>
	    	</c:if>
	    	<c:if test="${currentPage == 1}">
	    		<font color="#AAAAAA">首页</font>
	    		<font color="#AAAAAA">上一页</font>
	    	</c:if>
				<!--a id="next"></a-->
	    	<c:if test="${currentPage != countPage}">
	    		<a onclick="fenye(${currentPage + 1})" style='cursor: pointer;color: blue;'>下一页</a>
	    		<a onclick="fenye(${countPage})" style='cursor: pointer;color: blue;'>尾页</a>
	    	</c:if>
	    	<c:if test="${currentPage == countPage}">
	    		<font color="#AAAAAA">下一页</font>
	    		<font color="#AAAAAA">尾页</font>
	    	</c:if>
	    		${currentPage}/${countPage}
	    		<select id="xiala" style="display: none;">
	    		</select>
	    		<input type="text" style="width: 30px;" id="number"></input><input type="button" value="跳转" id="dump"></input>
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
  		
  		//用户长时间不操作返回到登陆页面
  		if($("#loginer").val()==""){
  			location.href="login.jsp";
  		}
  		
  		$("#xiala").change(function(){
    		fenye($(this).val())
  		});
  		//判断当前页数是否大于2
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
  	
  	//输入数字进行分页跳转
  	$("#dump").click(function(){
  		if($("#number").val()==""||parseInt($("#number").val())>parseInt($("#ne").val())){
  			alert("请输入小于"+$("#ne").val()+"数字");
  			$("#number").val("");
  		}else{
  			if((/^(\+|-)?\d+$/.test($("#number").val()))&&$("#number").val()>0){
				fenye($("#number").val());
    		}else{  
        		alert("请输入正整数！"); 
        		$("#number").val(""); 
    		}  			
  		}
  	})
  	
  	//点击上一页下一页前页尾页等分页操作
  	function fenye(i){
  		location.href="FenyeServlet?currentPage="+i;
  	}
  	
  	//根据关键字查询
  	$("#query").click(function(){
  		//alert($("#sel").val());
  		if($("#key").val()!=""){
  			location.href="QueryName?name="+$("#key").val()+"&keyType="+$("#sel").val();
  		}else{
  			alert("请输入关键字");
  		}	
  	})
  	
  	//多条件联合查询
  	$("#result").click(function(){
  		if($("#nameValue").val()==""&&$("#placeValue").val()==""&&$("#deptValue").val()==""&&$("#userValue").val()==""&&$("#baoguanValue").val()==""&&$("#statusValue").val()==""&&$("#zichanValue").val()==""&&$("#dateValue").val()==""&&$("#danjuhaoValue").val()==""){
			alert("请输入关键字");
  		}else{
  			location.href="ResultServlet?name="+$("#nameValue").val()+"&place="+$("#placeValue").val()+"&dept="+$("#deptValue").val()+"&user="+$("#userValue").val()+"&baoguan="+$("#baoguanValue").val()+"&status="+$("#statusValue").val()+"&zichanid="+$("#zichanValue").val()+"&date="+$("#dateValue").val()+"&danjuhao="+$("#danjuhaoValue").val();
  		}
  	})
  	
  	$(function(){ 
  		document.onkeydown = function(e){ 
  			var ev = document.all ? window.event : e; 
  			if(ev.keyCode==13) { 
  				//$('#FormId).submit();//处理事件 
  				if($("#nameValue").val()==""&&$("#placeValue").val()==""&&$("#deptValue").val()==""&&$("#userValue").val()==""&&$("#baoguanValue").val()==""&&$("#statusValue").val()==""&&$("#zichanValue").val()==""&&$("#dateValue").val()==""&&$("#danjuhaoValue").val()==""){
					alert("请输入关键字");
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
