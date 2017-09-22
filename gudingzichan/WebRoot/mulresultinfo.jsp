<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>资产信息查询结果</title>
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
  	<p align="center" style="font-size: 30px;margin-top: 30px;">资产信息查询结果</p>
  	<p align="center">查询数量：${shuliang }</p><p align="center">金额：${qiuhe }</p>
  	<center>
    	&nbsp;&nbsp;&nbsp;&nbsp;<a href="FenyeServlet">返回</a>
    	<input type="button" value="下载" id="download"></input><br/><br/>
    </center>
  	<c:if test="${not empty loginid&&loginer=='baoxiao'}">
   		<p align="center">
   			<span>报销</span>：<input type="text" id="content"></input>
   			<input type="button" value="批量报销" id="baoxiao"></input>
   		</p>
   	</c:if>
    <table id="zichanTable" align="center" width="90%" border="2">
       <tr>
       	  <td align="center">序号</td>
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
          			<a href="update.action?zichan.id=${zc.id }">修改</a>
          		<!--a href="delete.action?zichan.id=${zc.id }">删除</a-->
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='1'}">
        	 <td align="center">
          		<!--a href="shenhe.action?zichan.id=${zc.id }">审核</a-->
          		<input onclick="shenhe(${currentPage},0,${zc.id });" type="button" value="审核"></input>
         	 </td>
         </c:if>
         <c:if test="${loginer=='shenhe'&&zc.shenhe=='0'}">
        	 <td align="center">
          		<!--a href="shenhe(1)">取消审核</a-->
          		<input onclick="shenhe(${currentPage},1,${zc.id });" type="button" value="取消审核"></input>
         	 </td>
         </c:if>
         <c:if test="${loginer=='baoxiao'}">
        	 <td align="center">
          		<a href="baoxiao.action?zichan.id=${zc.id }">报销</a>
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
	    		<select id="xiala" style="display: none;"></select>
	    		<input type="text" style="width: 30px;" id="number"></input><input type="button" value="跳转" id="dump"></input>
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
  		
  	//点击资产编号打开新增单据号
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
  		
  		//判断当前页数是否大于2
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
  		//alert($("#key").val()+"=="+$("#keyType").val());
  		//alert($("#danjuhao").val()+"=="+i+"=="+$("#danjuhao").text());
  		location.href="ResultServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").text();
  	}
  	
  	function shenhe(i,a,b){
  		location.href="ShenheServlet?currentPage="+i+"&name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").val()+"&shenhe="+a+"&id="+b;
  	}
  	
  	
  	//下载
  	$("#download").click(function(){
  		location.href="CreateFileServlet?name="+$("#name").val()+"&place="+$("#place").val()+"&dept="+$("#dept").val()+"&user="+$("#user").val()+"&baoguan="+$("#baoguan").val()+"&status="+$("#status").val()+"&zichanid="+$("#zichanid").val()+"&date="+$("#date").val()+"&danjuhao="+$("#danjuhao").val()+"&count=1";
  	})
  	
  	//试行批量报销
  	$("#baoxiao").click(function(){
  		//alert($("#danjuhao").text()+"=="+$("#content").val());
  		location.href="executeBaoxiaoAll.action?zichan.danjuhao='"+$("#danjuhao").text()+"'&zichan.baoxiao='"+$("#content").val()+"'";
  	});
  </script>
  
</html>
