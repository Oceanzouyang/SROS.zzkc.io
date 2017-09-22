<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>固定资产单据流转查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #C7EDCC;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">固定资产单据流转下载</p>
  	<table align="center" style="margin-left:20%;">
  		<tr>
  			<td>开始时间：</td>
  			<td>
  				<input type="text" id="start"></input>
  			</td>
  			<td>结束时间：</td>
  			<td>
  				<input type="text" id="end"></input>
  			</td>
  			<td>流转类型：&nbsp;
  				<select id="choose">
  					<option value="新增">新增</option>
  					<option value="转移">转移</option>
  					<option value="维修">维修</option>
  					<option value="处置">处置</option>
  				</select>
  			</td>
  			<td>
  				<input type="button" value="查询" id="queryBtn"></input>
  			</td>
  			<td>
  				<input type="button" value="下载" id="download"></input>
  				&nbsp;&nbsp;<a href="FenyeServlet">返回</a>
  			</td>
  		</tr>
  	</table>
    <div id="queryResult" style="width:80%;margin-left:20%;"></div>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/My97DatePickerBeta/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  <script type="text/javascript">
  	/*** 获取当前月的第一天*/
	function getCurrentMonthFirst(){
 		var date=new Date();
 		date.setDate(1);
 		return date;
	}
  
  //typedan
  function typedan(start,end){
  	$.ajax({
  		url:"AjaxQueryTypedan?sqlwhere= where getdate>='"+start+"' and getdate<='"+end+"' ORDER BY getdate",
  		type:"post",
  		success:function(data){
  			$("#queryResult").html(data);
  			$("#ajaxadd td").click(function(){
  				//alert($(this).attr('class'));
  				$.ajax({
  					url:"AjaxDelete?operate=add&delid="+$(this).attr('class'),
  					type:"post",
  					success:function(){
  						typedan(start,end);
  					}
  				});				
  			});
  		}
  	});	
  }
  //zhuanyi
  function zhuanyi(start,end){
  	$.ajax({
  		url:"AjaxQueryZhuanyi?sqlwhere= where kaidandate>='"+start+"' and kaidandate<='"+end+"' ORDER BY kaidandate",
  		type:"post",
  		success:function(data){
  			$("#queryResult").html(data);
  			$("#ajaxzhuanyi td").click(function(){
  				//alert($(this).attr('class'));
  				$.ajax({
  					url:"AjaxDelete?operate=zhuanyi&delid="+$(this).attr('class'),
  					type:"post",
  					success:function(){
  						zhuanyi(start,end);
  					}
  				});				
  			});
  		}
  	});	  
  }
  //weixiu
  function weixiu(start,end){
  	$.ajax({
  		url:"AjaxQueryWeixiu?sqlwhere= where dengjidate>='"+start+"' and dengjidate<='"+end+"' ORDER BY dengjidate",
  		type:"post",
  		success:function(data){
  			$("#queryResult").html(data);
  			$("#ajaxweixiu td").click(function(){
  				//alert($(this).attr('class'));
  				$.ajax({
  					url:"AjaxDelete?operate=weixiu&delid="+$(this).attr('class'),
  					type:"post",
  					success:function(){
  						weixiu(start,end);
  					}
  				});				
  			});
  		}
  	});	  
  }  
  //chuzhi
  function chuzhi(start,end){
  	$.ajax({
  		url:"AjaxQueryChuzhi?sqlwhere= where baofeidate>='"+start+"' and baofeidate<='"+end+"' ORDER BY baofeidate",
  		type:"post",
  		success:function(data){
  			$("#queryResult").html(data);
  			$("#ajaxchuzhi td").click(function(){
  				//alert($(this).attr('class'));
  				$.ajax({
  					url:"AjaxDelete?operate=chuzhi&delid="+$(this).attr('class'),
  					type:"post",
  					success:function(){
  						chuzhi(start,end);
  					}
  				});				
  			});
  		}
  	});	  
  }
  
    
  	$(document).ready(function(){
		var oDate = new Date(); //实例一个时间对象；
		var year = oDate.getFullYear();   //获取系统的年；
		var month = oDate.getMonth()+1;   //获取系统月份，由于月份是从0开始计算，所以要加1
		var day = oDate.getDate(); // 获取系统日，
		if(month<10){
			month = "0"+month;
		}
		if(day<10){
			day = "0"+day;
		}
		//oDate.getHours(); //获取系统时，
		//oDate.getMinutes(); //分
		//oDate.getSeconds(); //秒
		//alert(year+"-"+month+"-"+day);
		//$("#start").val(year+"-"+month+"-01");
		$("#start").val(year+month+"01");
		//$("#end").val(year+"-"+month+"-"+day);
		$("#end").val(year+month+day);
		//var start = year+"-"+month+"-01 "+"00:00:00";
		//var end = year+"-"+month+"-"+day+" "+"23:59:59";
		var start = year+month+"01";
		var end = year+month+day;
		typedan(start,end);
  	});
  	
  	//按条件查询
  	$("#queryBtn").click(function(){
  		var choose = $("#choose").val();
  		var start = $("#start").val();
  		var end = $("#end").val();
  		if(choose=="新增"){
  			typedan(start,end);
  		}
  		if(choose=="转移"){
  			zhuanyi(start,end);
  		}
  		if(choose=="维修"){
  			weixiu(start,end);
  		}
  		if(choose=="处置"){
  			chuzhi(start,end);
  		}
  	});
  	
  	//下载
  	$("#download").click(function(){
  		var choose = $("#choose").val();
  		var start = $("#start").val();
  		var end = $("#end").val();
  		if(choose=="新增"){
  			typedan(start,end);
  		}
  		if(choose=="转移"){
  			zhuanyi(start,end);
  		}
  		if(choose=="维修"){
  			weixiu(start,end);
  		}
  		if(choose=="处置"){
  			chuzhi(start,end);
  		}
  		location.href="DownloadDanju?choose="+choose+"&start="+start+"&end="+end;
  	});
  </script>
</html>
