<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<html>
  <head>
    <title>�޸Ĺ̶��ʲ���Ϣ</title>
    <style type="text/css">
				ul{
					list-style:none;	
					width:300px;
    				height:300px;
    				overflow:auto;
    				display: none;
    				position: absolute;
    				background-color: white;
				}
		</style>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">�ʲ���Ϣ</p>
     <form action="executeUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>�ʲ����
              	<input type="hidden" name="zichan.id" value=${zichan.id }></input>
              	<input type="hidden" name="zichan.shenhe" value=${zichan.shenhe }></input>
              </td>
              <td><input type="text" name="zichan.zichanid" value=${zichan.zichanid } id="zichanId"></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="text" name="zichan.name" value=${zichan.name }></td>
            </tr>
            <tr>
                <td>�ʲ������</td>
                <td><input type="text" name="zichan.typecode" value=${zichan.typecode } id="typecode"></td>
            </tr>
            <tr>
                <td>�ʲ��������</td>
                <td><input type="text" name="zichan.typename" value=${zichan.typename } id="typename">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" id="queryType"></input></td>
            </tr>
            <tr>
                <td>����ͺ�</td>
                <td><input type="text" name="zichan.type" value=${zichan.type }></td>
            </tr>
            <tr>
                <td>��λ</td>
                <td><input type="text" name="zichan.danwei" value=${zichan.danwei }></td>
            </tr>
            <tr>
                <td>����</td>
                <td>
                	<input type="text" name="zichan.num" value=${zichan.num }>
                </td>
            </tr>
            <tr>
                <td>ԭֵ</td>
                <td><input type="text" name="zichan.jine" value=${zichan.jine }></td>
            </tr>
            <tr>
                <td>�����۾�</td>
                <td><input type="text" name="zichan.jitizhejiu" value="${zichan.jitizhejiu }"></td>
            </tr>
            <tr>
                <td>��ֵ</td>
                <td><input type="text" name="zichan.jingzhi" value="${zichan.jingzhi }"></td>
            </tr>
            <tr>
                <td>ת��ʱ��</td>
                <td><input type="text" name="zichan.zhuanrudate" value="${zichan.zhuanrudate }"></td>
            </tr>
            <tr>
                <td>ת��ʱ��</td>
                <td><input type="text" name="zichan.zhuanchudate" value="${zichan.zhuanchudate }"></td>
            </tr>
            <tr>
                <td>��������</td>
                <td><input type="text" name="zichan.date" value=${zichan.date }></td>
            </tr>
            <tr>
                <td>ʹ�ò���</td>
                <td>
                	<input id="xiala" type="text" name="zichan.dept" value=${zichan.dept }></input>
	    			<br/>
	    			<ul id="ul">
	    				<s:iterator value="listzichan">
	    					<li pinyin="<s:property value="py"/>" deptname="<s:property value="deptname"/>" class="deptpy"><s:property value="deptname"/></li>
	    				</s:iterator>
	    			</ul>
                </td>
            </tr>
            <tr>
                <td>��ŵص�</td>
                <td><input type="text" name="zichan.place" value=${zichan.place }></td>
            </tr>
            <tr>
                <td>ʹ����</td>
                <td><input type="text" name="zichan.user" value=${zichan.user }></td>
            </tr>
            <tr>
                <td>������</td>
                <td><input type="text" name="zichan.baoguan" value=${zichan.baoguan }></td>
            </tr>

            <tr>
                <td>ת������</td>
                <td><input type="text" name="zichan.zhuanchudept" value="${zichan.zhuanchudept}"></td>
            </tr>
            <tr>
                <td>ת���ص�</td>
                <td><input type="text" name="zichan.zhuanchuplace" value="${zichan.zhuanchuplace }"></td>
            </tr>
            <tr>
                <td>��Ӧ��</td>
                <td><input type="text" name="zichan.gongyingshang" value=${zichan.gongyingshang }></td>
            </tr>
            <tr>
                <td>ƾ֤</td>
                <td><input type="text" name="zichan.pingzheng" value=${zichan.pingzheng }></td>
            </tr>
            <tr>
                <td>�������ݺ�</td>
                <td><input type="text" name="zichan.danjuhao" value=${zichan.danjuhao }></td>
            </tr>
            <tr>
                <td>״̬</td>
                <td>
                	<select id="change">
                		<option value="ʹ��">ʹ��</option>
                		<option value="ͣ��">ͣ��</option>
                		<option value="����">����</option>
 						<option value="����">����</option>
                	</select>
                	<input type="hidden" name="zichan.status" id="status" value=${zichan.status }></td>
            </tr>
            <tr>
               <td>��ע</td>
               <td>
                 <textarea cols="60" rows="3" name="zichan.beizhu">${zichan.beizhu }</textarea>
               </td>
            </tr>
            
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="�ύ"/>
                 <a href="FenyeServlet">����</a>
              </td>
            </tr>
       </table>
     </form>
     <div id="likecontent" style="float:left;width: 200px;position: absolute;top: 10px;">
     </div>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  		//�󶨲���
  		$("#xiala").bind('input propertychange', function() {
    		searchDept();
    	});
  		
  		function searchDept() {
    		var searchDeptName = $("#xiala").val();    
      		$("ul").show();
      		$("ul li").each(          
      			function() {
            		var pinyin = $(this).attr("pinyin");            
            		var deptName = $(this).attr("deptname");   
            		//alert(pinyin+"=="+cityName);         
            		if (pinyin.indexOf(searchDeptName) != -1|| deptName.indexOf(searchDeptName) != -1) {
              			$(this).show();
              			//alert($(this).text());
            		} else {
              			$(this).hide();
            		}
          		});
  		}
  
  		//�����ȡ��������
  		$(".deptpy").click(function(){
  			//alert($(this).text());
  			$("#xiala").val($(this).text());
  			$("#ul").hide();
  		});
  		
  		
  	  $("#queryType").click(function(){
  			$.ajax({
            	url: "QueryTypeLike?typename="+$("#typename").val(),
            	type: "get",
            	success: function (msg) {
            		//alert(msg);
            		//var a = JSON.parse(msg);
            		//var d = eval("("+msg+")");
            		//alert(d["name"] +"--"+a["name"]);
                	//$("#zichanId").val(msg);
                	$("#likecontent").html(msg);
             	},
             	error: function (data, textStatus, errorThrown) {
             		alert("����");
             	}
  			});
  		});
  
  	 function getParam(a,b){
  			$("#typecode").val(a);
  			$("#typename").val(b);
  			//��ȡ����zichanid���
  			$.ajax({
  				url: "QueryMaxZichanid?typecode="+$("#typecode").val(),
  				type: "get",
  				success: function(data){
  					$("#zichanId").val(data);
  				},
  				error:function (data, textStatus, errorThrown) {
             		alert("����");
             	}
  			});
     }
  
  	 function show(){
  	 	$("#typeTable").slideToggle("slow");
  	 }
  
  	 $("#change").change(function(){
  	 	$("#status").val($("#change").val());
  	 })
  	 
  	 //$("#xiala").change(function(){
  	 //	$("#u").val($(this).val())
  	 //})
  	 
  	 $(document).ready(function(){
  	 	if($("#status").val()==null||$("#status").val()==""){
  	 		$("#status").val($("#change").val());
  	 	}
  	 })
  </script>
</html>
