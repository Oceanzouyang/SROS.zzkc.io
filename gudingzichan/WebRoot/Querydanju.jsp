<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�̶��ʲ�������ת��ѯ</title>
    
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
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�̶��ʲ�������ת����</p>
  	<table align="center" style="margin-left:20%;">
  		<tr>
  			<td>��ʼʱ�䣺</td>
  			<td>
  				<input type="text" id="start"></input>
  			</td>
  			<td>����ʱ�䣺</td>
  			<td>
  				<input type="text" id="end"></input>
  			</td>
  			<td>��ת���ͣ�&nbsp;
  				<select id="choose">
  					<option value="����">����</option>
  					<option value="ת��">ת��</option>
  					<option value="ά��">ά��</option>
  					<option value="����">����</option>
  				</select>
  			</td>
  			<td>
  				<input type="button" value="��ѯ" id="queryBtn"></input>
  			</td>
  			<td>
  				<input type="button" value="����" id="download"></input>
  				&nbsp;&nbsp;<a href="FenyeServlet">����</a>
  			</td>
  		</tr>
  	</table>
    <div id="queryResult" style="width:80%;margin-left:20%;"></div>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/My97DatePickerBeta/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  <script type="text/javascript">
  	/*** ��ȡ��ǰ�µĵ�һ��*/
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
		var oDate = new Date(); //ʵ��һ��ʱ�����
		var year = oDate.getFullYear();   //��ȡϵͳ���ꣻ
		var month = oDate.getMonth()+1;   //��ȡϵͳ�·ݣ������·��Ǵ�0��ʼ���㣬����Ҫ��1
		var day = oDate.getDate(); // ��ȡϵͳ�գ�
		if(month<10){
			month = "0"+month;
		}
		if(day<10){
			day = "0"+day;
		}
		//oDate.getHours(); //��ȡϵͳʱ��
		//oDate.getMinutes(); //��
		//oDate.getSeconds(); //��
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
  	
  	//��������ѯ
  	$("#queryBtn").click(function(){
  		var choose = $("#choose").val();
  		var start = $("#start").val();
  		var end = $("#end").val();
  		if(choose=="����"){
  			typedan(start,end);
  		}
  		if(choose=="ת��"){
  			zhuanyi(start,end);
  		}
  		if(choose=="ά��"){
  			weixiu(start,end);
  		}
  		if(choose=="����"){
  			chuzhi(start,end);
  		}
  	});
  	
  	//����
  	$("#download").click(function(){
  		var choose = $("#choose").val();
  		var start = $("#start").val();
  		var end = $("#end").val();
  		if(choose=="����"){
  			typedan(start,end);
  		}
  		if(choose=="ת��"){
  			zhuanyi(start,end);
  		}
  		if(choose=="ά��"){
  			weixiu(start,end);
  		}
  		if(choose=="����"){
  			chuzhi(start,end);
  		}
  		location.href="DownloadDanju?choose="+choose+"&start="+start+"&end="+end;
  	});
  </script>
</html>
