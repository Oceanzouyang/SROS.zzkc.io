<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="com.yatai.model.*" %>
<html>
  <head>
    <title>�̶��ʲ�������ת</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tag.css" type="text/css"></link>
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
  </head>  
  
  <body style="background-color: #C7EDCC;"> 
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�̶��ʲ�������ת</p>
  	<div align="center"><a href="Querydanju.jsp">�ʲ�����������ת</a>&nbsp;&nbsp;&nbsp;<a href="FenyeServlet">����</a></div>
  	<br/>
    <table  align="center" width="80%" border="1" id="zichanTable">
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
         <td align="center" class="oldzichan"><a class="zichanid">${zc.zichanid }</a></td>
         <td align="center" class="oldname">${zc.name }</td>
         <td align="center" class="oldtype">${zc.type }</td>
         <td align="center" class="olddanwei">${zc.danwei }</td>
         <td align="center" class="oldnum">${zc.num }</td>
         <td align="center" class="oldjine">${zc.jine }</td>
         <td align="center" class="oldjitizhejiu">${zc.jitizhejiu }</td>
         <td align="center" class="oldjingzhi">${zc.jingzhi }</td>
         <td align="center" class="oldzhuanrudate">${zc.zhuanrudate }</td>
         <td align="center" class="oldzhuanchudate">${zc.zhuanchudate }</td>
         <td align="center" class="olddate">${zc.date }</td>
         <td align="center" class="olddept">${zc.dept }</td>
         <td align="center" class="oldplace">${zc.place }</td>
         <td align="center" class="olduser">${zc.user }</td>
         <td align="center" class="oldbaoguan">${zc.baoguan }</td>
         <td align="center" class="oldzhuanchudept">${zc.zhuanchudept }</td>
         <td align="center" class="oldzhuanchuplace">${zc.zhuanchuplace }</td>
         <td align="center" class="oldgongyingshang">${zc.gongyingshang }</td>
         <td align="center" class="oldpingzheng">${zc.pingzheng }</td>
         <td align="center" class="oldbaoxiao">${zc.baoxiao }</td>
         <td align="center" class="olddanjuhao" id="danjuhao">${zc.danjuhao }</td>
         <td align="center">${zc.zhuanyidan }</td>
         <td align="center">${zc.chuzhidan }</td>
         <td align="center" class="oldstatus">${zc.status }</td>
         <td align="center" class="oldbeizhu">${zc.beizhu }</td>        
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
    <br/>
    <input type="hidden" value="${loginer }"></input>
    <div style="margin-left: 10%;" id="typeDanTable">
    </div>
    <br/>
    <div style="margin-left: 10%;" id="zhuanyiTable">
    </div>
    <br/>
    <div style="margin-left: 10%;" id="weixiuTable">
    </div>
    <br/>
    <div style="margin-left: 10%;" id="chuzhiTable">
    </div>
    <center> 
    	&nbsp;&nbsp;&nbsp;&nbsp; 
    </center>
    <div id="danju" style="width: 400px;height: 500px;background: white;position: fixed;top: 10%;left: 30%;display:none;">
    	<div style="float:left" >
    		<input type="button" value="����" id="xinzengbtn"></input>
    	</div>
    	<div style="float:left;">
    		<input type="button" value="ת��" id="zhuanyibtn"></input>
    	</div>
    	<div style="float:left;">
    		<input type="button" value="ά��" id="weixiubtn"></input>
    	</div>
    	<div style="">
    		<input type="button" value="����" id="chuzhibtn"></input>
    	</div>
    	<form method="post" id="typeDan">
    	<table style="float:left;position: absolute;margin-top: 10px;" id="xinzengtb">
    		<tr>
    			<td>����</td>
    			<td>
    				<input type="button" value="�ر�" class="close"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>�ʲ���ţ�</td>
    			<td>
    				<input type="text" id="newzichanid"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>���ƣ�</td>
    			<td>
    				<input type="text" id="newname">
    			</td>
    		</tr>
    		<tr>
    			<td>���ݺţ�</td>
    			<td>
    				<input type="text" id="newdanju" name="typedan.danju" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ۣ�</td>
    			<td>
    				<input type="text" id="newprice" name="typedan.price" />
    			</td>
    		</tr>
    		<tr>
    			<td>������</td>
    			<td>
    				<input type="text" id="newnum" name="typedan.num" />
    			</td>
    		</tr>
    		<tr>
    			<td>��</td>
    			<td>
    				<input type="text" id="newjine" name="typedan.jine" />
    			</td>
    		</tr>
    		<tr>
    			<td>����ʱ�䣺</td>
    			<td>
    				<input type="text" id="newgetdate">
    			</td>
    		</tr>
    		<tr>
    			<td>��ŵص㣺</td>
    			<td>
    				<input type="text" id="newplace" name="typedan.place">
    			</td>
    		</tr>
    		<tr>
    			<td>��ע��</td>
    			<td>
    				<input type="text" id="newbeizhu" name="typedan.beizhu">
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="ȷ��" id="xinzeng"></input>
    			</td>
    			<td></td>
    		</tr>
    	</table>
    	<table style="float:left;position: absolute;margin-top: 10px;display: none;" id="zhuanyitb">
    		<tr>
    			<td>ת��</td>
    			<td>
    				<input type="button" value="�ر�" class="close"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>�ʲ���ţ�</td>
    			<td>
    				<input type="text" id="zhuanyizichanid"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>�����ʼ��</td>
    			<td><input type="text" id="zhuanyistartid" /></td>
    		</tr>
    		<tr>
    			<td>��Ž�����</td>
    			<td><input type="text" id="zhuanyiendid" /></td>
    		</tr>
    		<tr>
    			<td>���ƣ�</td>
    			<td>
    				<input type="text" id="zhianyiname" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ݺţ�</td>
    			<td>
    				<input type="text" id="zhianyidanju" />
    			</td>
    		</tr>
    		<tr>
    			<td>ת�����ڣ�</td>
    			<td>
    				<input type="text" id="zhuanyidate" />
    			</td>
    		</tr>
    		<tr>
    			<td>��λ��</td>
    			<td>
    				<input type="text" id="zhuanyidanwei" />
    			</td>
    		</tr>
    		<tr>
    			<td>������</td>
    			<td>
    				<input type="text" id="zhuanyinum" />
    			</td>
    		</tr>
    		<tr>
    			<td>ԭʼ��</td>
    			<td>
    				<input type="text" id="zhuanyiyuanshijine" />
    			</td>
    		</tr>
    		<tr>
    			<td>�۾ɣ�</td>
    			<td>
    				<input type="text" id="zhuanyizhejiu" value="0"/>
    			</td>
    		</tr>
    		<tr>
    			<td>��ֵ��</td>
    			<td>
    				<input type="text" id="zhuanyijinzhi" value="0"/>
    			</td>
    		</tr>
    		<tr>
    			<td>�������ڣ�</td>
    			<td>
    				<input type="text" id="zhuanyiruzhangdate" />
    			</td>
    		</tr>
    		<tr>
    			<td>ת�벿�ţ�</td>
    			<td>
    				<input type="text" id="zhuanyizhuanrudept" />
    			</td>
    		</tr>
    		<tr>
    			<td>ת��ص㣺</td>
    			<td>
    				<input type="text" id="zhuanyizhuanruplace" />
    			</td>
    		</tr>
    		<tr>
    			<td>ת�����ţ�</td>
    			<td>
    				<input type="text" id="zhuanyizhuanchudept" />
    			</td>
    		</tr>
    		<tr>
    			<td>ת���ص㣺</td>
    			<td>
    				<input type="text" id="zhuanyizhuanchuplace" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="button" value="ȷ��" id="zhuanyi"></input>
    			</td>
    			<td></td>
    		</tr>
    	</table>
    	<table style="float:left;position: absolute;margin-top: 10px;display: none;" id="weixiutb">
    		<tr>
    			<td>ά��</td>
    			<td>
    				<input type="button" value="�ر�" class="close"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>�ʲ���ţ�</td>
    			<td>
    				<input type="text" id="weixiuzichanid" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ƣ�</td>
    			<td>
    				<input type="text" id="weixiuname" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ݺţ�</td>
    			<td>
    				<input type="text" id="weixiudanju" />
    			</td>
    		</tr>
    		<tr>
    			<td>ά�޲��ţ�</td>
    			<td>
    				<input type="text" id="weixiudept" />
    			</td>
    		</tr>
    		<tr>
    			<td>���޲��ţ�</td>
    			<td>
    				<input type="text" id="baoxiudept" />
    			</td>
    		</tr>
    		<tr>
    			<td>������</td>
    			<td>
    				<input type="text" id="baoxiunum"  />
    			</td>
    		</tr>
    		<tr>
    			<td>ά�޼۸�</td>
    			<td>
    				<input type="text" id="baoxiuprice" value="0" />
    			</td>
    		</tr>
    		<tr>
    			<td>ά�����ڣ�</td>
    			<td>
    				<input type="text" id="weixiudate" />
    			</td>
    		</tr>
    		<tr>
    			<td>�Ǽ����ڣ�</td>
    			<td>
    				<input type="text" id="dengjidate" />
    			</td>
    		</tr>
    		<tr>
    			<td>ά�����ݣ�</td>
    			<td>
    				<input type="text" id="weixiucontent" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="button" value="ȷ��" id="weixiu"></input>
    			</td>
    			<td></td>
    		</tr>
    	</table>
    	<table style="float:left;position: absolute;margin-top: 10px;display: none;" id="chuzhitb">
    		<tr>
    			<td>����</td>
    			<td>
    				<input type="button" value="�ر�" class="close"></input>
    			</td>
    		</tr>
    		<tr>
    			<td>�ʲ���ţ�</td>
    			<td>
    				<input type="text" id="chuzhizichanid" />
    			</td>
    		</tr>
    		<tr>
    			<td>�����ʼ��</td>
    			<td><input type="text" id="chuzhistartid" /></td>
    		</tr>
    		<tr>
    			<td>��Ž�����</td>
    			<td><input type="text" id="chuzhiendid" /></td>
    		</tr>
    		<tr>
    			<td>���ƣ�</td>
    			<td>
    				<input type="text" id="chuzhiname" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ݺţ�</td>
    			<td>
    				<input type="text" id="chuzhidanju" />
    			</td>
    		</tr>
    		<tr>
    			<td>������ͣ�</td>
    			<td>
    				<input type="text" id="chuzhitype" />
    			</td>
    		</tr>
    		<tr>
    			<td>��λ��</td>
    			<td>
    				<input type="text" id="chuzhidanwei" />
    			</td>
    		</tr>
    		<tr>
    			<td>������</td>
    			<td>
    				<input type="text" id="chuzhinum" />
    			</td>
    		</tr>
    		<tr>
    			<td>��</td>
    			<td>
    				<input type="text" id="chuzhijine" />
    			</td>
    		</tr>
    		<tr>
    			<td>�������ڣ�</td>
    			<td>
    				<input type="text" id="chuzhiruzhangdate" />
    			</td>
    		</tr>
    		<tr>
    			<td>ʹ�ò��ţ�</td>
    			<td>
    				<input type="text" id="chuzhidept" />
    			</td>
    		</tr>
    		<tr>
    			<td>��ʾ���ڣ�</td>
    			<td>
    				<input type="text" id="chuqingshidate" />
    			</td>
    		</tr>
    		<tr>
    			<td>�������ڣ�</td>
    			<td>
    				<input type="text" id="chuzhibaofeidate" />
    			</td>
    		</tr>
    		<tr>
    			<td>����ԭ��</td>
    			<td>
    				<input type="text" id="chuzhibaofei" />
    			</td>
    		</tr>
    		<tr>
    			<td>���ý�</td>
    			<td>
    				<input type="text" id="chuzhibaofeijine" value="0" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="button" value="ȷ��" id="chuzhi"></input>
    			</td>
    			<td></td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		ajaxxinzengparam();
  		ajaxzhuanyiparam();
  		ajaxweixiuparam();
  		ajaxchuzhiparam();
  		//����
  		$("#xinzeng").click(function(){
  			$.ajax({
  				url:"AjaxAddTypedan",
  				type:"post",
  				data:{"newzichanid":$("#newzichanid").val(),"newname":$("#newname").val(),"newtype":$("#newtype").val(),"newprice":$("#newprice").val(),"newnum":$("#newnum").val(),"newjine":$("#newjine").val(),"newplace":$("#newplace").val(),"newbeizhu":$("#newbeizhu").val(),"newgetdate":$("#newgetdate").val(),"newdanju":$("#newdanju").val()},
  				success:function(data){
  					ajaxxinzengparam();
  					$("#danju").css("display","none");
  				},
  				error:function(){
  					ajaxxinzengparam();
  				}
  			});
  		});
  		
  		//ת��
  		$("#zhuanyi").click(function(){
  			if($("#zhuanyistartid").val()==""){
  				alert("��ʼ��Ų���Ϊ��~~");
  				return;
  			}
  	    	if($("#zhuanyiendid").val()==""){
  				$("#zhuanyiendid").val($("#zhuanyistartid").val());
  			}
  			$.ajax({
  				url:"AjaxZhuanyiTypedan",
  				type:"post",
  				data:{"zhuanyizichanid":$("#zhuanyizichanid").val(),"zhianyiname":$("#zhianyiname").val(),"zhianyidanju":$("#zhianyidanju").val(),"zhuanyidate":$("#zhuanyidate").val(),"zhuanyidanwei":$("#zhuanyidanwei").val(),"zhuanyinum":$("#zhuanyinum").val(),"zhuanyiyuanshijine":$("#zhuanyiyuanshijine").val(),"zhuanyizhejiu":$("#zhuanyizhejiu").val(),"zhuanyijinzhi":$("#zhuanyijinzhi").val(),"zhuanyiruzhangdate":$("#zhuanyiruzhangdate").val(),"zhuanyizhuanrudept":$("#zhuanyizhuanrudept").val(),"zhuanyizhuanruplace":$("#zhuanyizhuanruplace").val(),"zhuanyizhuanchudept":$("#zhuanyizhuanchudept").val(),"zhuanyizhuanchuplace":$("#zhuanyizhuanchuplace").val(),"zhuanyistartid":$("#zhuanyistartid").val(),"zhuanyiendid":$("#zhuanyiendid").val()},
  				success:function(data){
  					ajaxzhuanyiparam();
  					$("#danju").css("display","none");
  				},
  				error:function(){
  					ajaxzhuanyiparam();
  				}
  			});
  		});
  		
  	    //ά��
  	    $("#weixiu").click(function(){
  	    	$.ajax({
  	    		url:"AjaxWeixiuTypedan",
  	    		type:"post",
  	    		data:{"zichanid":$("#weixiuzichanid").val(),"name":$("#weixiuname").val(),"danju":$("#weixiudanju").val(),"weixiudept":$("#weixiudept").val(),"baoxiudept":$("#baoxiudept").val(),"num":$("#baoxiunum").val(),"price":$("#baoxiuprice").val(),"weixiudate":$("#weixiudate").val(),"dengjidate":$("#dengjidate").val(),"weixiucontent":$("#weixiucontent").val()},
  	    		success:function(data){
  	    			ajaxweixiuparam();
  					$("#danju").css("display","none");
  	    		},
  	    		error:function(){
  	    		}
  	    	});
  	    });
  	    
  	    //����
  	    $("#chuzhi").click(function(){
  	      	if($("#chuzhistartid").val()==""){
  				alert("��ʼ��Ų���Ϊ��~~");
  				return;
  			}
  	    	if($("#chuzhiendid").val()==""){
  				$("#chuzhiendid").val($("#chuzhistartid").val());
  			}
  			
  	    	$.ajax({
  	    		url:"AjaxChuzhiTypedan",
  	    		type:"post",
  	    		data:{"zichanid":$("#chuzhizichanid").val(),"name":$("#chuzhiname").val(),"danju":$("#chuzhidanju").val(),"type":$("#chuzhitype").val(),"danwei":$("#chuzhidanwei").val(),"num":$("#chuzhinum").val(),"jine":$("#chuzhijine").val(),"ruzhangdate":$("#chuzhiruzhangdate").val(),"dept":$("#chuzhidept").val(),"baofeidate":$("#chuzhibaofeidate").val(),"baofei":$("#chuzhibaofei").val(),"baofeijine":$("#chuzhibaofeijine").val(),"chuzhistartid":$("#chuzhistartid").val(),"chuzhiendid":$("#chuzhiendid").val(),"chuqingshidate":$("#chuqingshidate").val()},
  	    		success:function(data){
  	    			ajaxchuzhiparam();
  					$("#danju").css("display","none");
  	    		},
  	    		error:function(){
  	    		}
  	    	});
  	    });
  	    
  		//if(window.location.pathname=="/gudingzichan/executeAdd.action"){
  		//	location.href="FenyeServlet";
  		//}
  		//�жϵ�ǰҳ���Ƿ����2
  		if($("#ne").val()>2){
			var num = $("#ne").val();
			//alert(num);
			for(var i=2;i<num;i++){
				var content = $("#next").html();
      			content = content + "<a class='fen' style='cursor: pointer;color: blue;' onclick="+"fenye("+i+")"+">"+i+"</a>"+"  ";
                $("#next").html(content);
				//alert(i);
			}
			//$("#next").html();
		}
  	})
  	
  	//ajax��ȡtypedan�������
  	function ajaxxinzengparam(){
  		$.ajax({
  			url:"AjaxQueryTypedan?sqlwhere= where zichanid='"+$(".zichanid").text()+"'",
  			type:"post",
  			success:function(data){
  				$("#typeDanTable").html(data);
  					//��ȡ����������
  					//�ʲ����
  					$("#newzichanid").val($(".oldzichan").text());
  					$("#zhuanyizichanid").val($(".oldzichan").text());
  					$("#weixiuzichanid").val($(".oldzichan").text());
  					$("#chuzhizichanid").val($(".oldzichan").text());
  					//����
  					$("#newname").val($(".oldname").text());
  					$("#zhianyiname").val($(".oldname").text());
  					$("#weixiuname").val($(".oldname").text());
  					$("#chuzhiname").val($(".oldname").text());
  					//���
  					$("#newjine").val($(".oldjine").text());
  					$("#zhuanyiyuanshijine").val($(".oldjine").text());
  					
  					$("#chuzhijine").val($(".oldjine").text());
  					if($("#chuzhijine").val()==""){
  						$("#chuzhijine").val(0);
  					}
  					//��������
  					$("#newgetdate").val($(".olddate").text());
  					$("#zhuanyiruzhangdate").val($(".olddate").text());
  					$("#chuzhiruzhangdate").val($(".olddate").text());
  					//����
  					$("#newnum").val($(".oldnum").text());
  					$("#zhuanyinum").val($(".oldnum").text());
  					$("#baoxiunum").val($(".oldnum").text());
  					$("#chuzhinum").val($(".oldnum").text());
  					$("#newnum").val($(".oldnum").text());
  					//��λ
  					$("#zhuanyidanwei").val($(".olddanwei").text());
  					$("#chuzhidanwei").val($(".olddanwei").text());
  					//
  					$("#newplace").val($(".oldplace").text());
  					$("#newbeizhu").val($(".oldbeizhu").text());
  					$("#zhuanyizhejiu").val($(".oldjitizhejiu").text());
  					if($("#zhuanyizhejiu").val()==""){
  						$("#zhuanyizhejiu").val(0);
  					}
  					$("#zhuanyijinzhi").val($(".oldjingzhi").text());
  					if($("#zhuanyijinzhi").val()==""){
  						$("#zhuanyijinzhi").val(0);
  					}
  					$("#zhuanyizhuanrudept").val($(".oldzhuanrudept").text());
  					$("#zhuanyizhuanruplace").val($(".oldzhuanruplace").text());
  					$("#zhuanyizhuanchudept").val($(".oldzhuanchudept").text());
  					$("#zhuanyizhuanchuplace").val($(".oldzhuanchuplace").text());
  					$("#baoxiudept").val($(".olddept").text());
  					$("#chuzhidept").val($(".olddept").text());
  					$("#chuzhitype").val($(".oldtype").text());
  					
  				$("#ajaxadd td").click(function(){
  					//alert($(this).attr('class'));
  					$.ajax({
  						url:"AjaxDelete?operate=add&delid="+$(this).attr('class'),
  						type:"post",
  						success:function(){
  							ajaxxinzengparam();
  						}
  					});				
  				});
  			},
  			error:function(){
  				alert("queryerror");
  			}
  		});
  	}
  	//ajax��ȡzhuanyi�������
  	function ajaxzhuanyiparam(){
  		$.ajax({
  			url:"AjaxQueryZhuanyi?sqlwhere= where zichanid='"+$(".zichanid").text()+"'",
  			type:"post",
  			success:function(data){
  				$("#zhuanyiTable").html(data);
  				$("#ajaxzhuanyi td").click(function(){
  					//alert($(this).attr('class'));
  					$.ajax({
  						url:"AjaxDelete?operate=zhuanyi&delid="+$(this).attr('class'),
  						type:"post",
  						success:function(){
  							ajaxzhuanyiparam();
  						}
  					});				
  				});
  			},
  			error:function(){
  				alert("queryzhuanyierror");
  			}
  		});
  	}
  	//ajax��ȡweixiu�������
  	function ajaxweixiuparam(){
  		$.ajax({
  			url:"AjaxQueryWeixiu?sqlwhere= where zichanid='"+$(".zichanid").text()+"'",
  			type:"post",
  			success:function(data){
  				$("#weixiuTable").html(data);
  				$("#ajaxweixiu td").click(function(){
  					//alert($(this).attr('class'));
  					$.ajax({
  						url:"AjaxDelete?operate=weixiu&delid="+$(this).attr('class'),
  						type:"post",
  						success:function(){
  							ajaxweixiuparam();
  						}
  					});				
  				});
  			},
  			error:function(){
  				alert("queryzhuanyierror");
  			}
  		});
  	}
  	//ajax��ȡbaofei�������
  	function ajaxchuzhiparam(){
  		$.ajax({
  			url:"AjaxQueryChuzhi?sqlwhere= where zichanid='"+$(".zichanid").text()+"'",
  			type:"post",
  			success:function(data){
  				$("#chuzhiTable").html(data);
  				$("#ajaxchuzhi td").click(function(){
  					//alert($(this).attr('class'));
  					$.ajax({
  						url:"AjaxDelete?operate=chuzhi&delid="+$(this).attr('class'),
  						type:"post",
  						success:function(){
  							ajaxchuzhiparam();
  						}
  					});				
  				});
  			},
  			error:function(){
  				alert("queryzhuanyierror");
  			}
  		});
  	}
  	
  	
  	//����ʲ���Ŵ��������ݺ�
  	$(".zichanid").click(function(){
  		$("#danju").css("display","block");  		
  	});
  	
  	
  	//�رյ�����
  	$(".close").click(function(){
  		$("#danju").css("display","none");
  	});
  	
  	//�����һҳ��һҳǰҳβҳ�ȷ�ҳ����
  	function fenye(i){
  		//alert($("#key").val()+"=="+$("#keyType").val());
  		location.href="QueryName?currentPage="+i+"&name="+$("#key").val()+"&keyType="+$("#keyType").val();
  	}
  	
  	$("#query").click(function(){	
  		location.href="QueryName?name="+$("#key").val();
  	});
  	
  	//tag��ǩ��ʾ������������ת�ơ�ά�޺ͱ���table
  	//��ʾ������
  	$("#xinzengbtn").click(function(){
  		$("#xinzengtb").css("display","block");
  		$("#zhuanyitb").css("display","none");
  		$("#weixiutb").css("display","none");
  		$("#chuzhitb").css("display","none");
  	});
  	//��ʾת�Ʊ�
  	$("#zhuanyibtn").click(function(){
  		$("#zhuanyitb").css("display","block");
  		$("#xinzengtb").css("display","none");
  		$("#weixiutb").css("display","none");
  		$("#chuzhitb").css("display","none");
  	});
  	//��ʾά�ޱ�
  	$("#weixiubtn").click(function(){
  		$("#weixiutb").css("display","block");
  		$("#xinzengtb").css("display","none");
  		$("#zhuanyitb").css("display","none");
  		$("#chuzhitb").css("display","none");
  	});
  	//��ʾ���ñ�
  	$("#chuzhibtn").click(function(){
  		$("#chuzhitb").css("display","block");
  		$("#xinzengtb").css("display","none");
  		$("#zhuanyitb").css("display","none");
  		$("#weixiutb").css("display","none");
  	});
  	
  	
  </script>
  
</html>
