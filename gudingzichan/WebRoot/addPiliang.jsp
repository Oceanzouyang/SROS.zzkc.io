<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>������ӹ̶��ʲ�</title>
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
    <p align="center" style="font-size: 30px;margin-top: 30px;">&nbsp;�ʲ���Ϣ</p>
     <form action="executePiliangAdd.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>�ʲ����ǰ׺</td>
              <td><input type="text" name="zichan.zichanid" id="zichanId"></td>
            </tr>
            <tr>
              <td>��ſ�ʼ</td>
              <td><input type="text" name="zichan.xuhao"></td>
            </tr>
            <tr>
              <td>��Ž���</td>
              <td><input type="text" name="zichan.shenhe"></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="text" name="zichan.name" id="nameType"></td>
            </tr>
            <tr>
                <td>�ʲ������</td>
                <td><input type="text" name="zichan.typecode" id="typecode"></td>
            </tr>
            <tr>
                <td>�ʲ��������</td>
                <td><input type="text" name="zichan.typename" id="typename">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" id="queryType"></input></td>
            </tr>
            <tr>
                <td>����ͺ�</td>
                <td><input type="text" name="zichan.type"></td>
            </tr>
            <tr>
                <td>��λ</td>
                <td><input type="text" name="zichan.danwei"></td>
            </tr>
            <tr>
                <td>����</td>
                <td>
                	<input type="text" name="zichan.num">
                	<input type="hidden" name="zichan.dept" style="display: block;" id="u" value="������">
                </td>
            </tr>
            <tr>
                <td>ԭֵ</td>
                <td><input type="text" name="zichan.jine"></td>
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
                <td><input type="text" name="zichan.date"></td>
            </tr>
            <tr>
                <td>ʹ�ò���</td>
                <td>
                	<input id="xiala" type="text" name="zichan.dept"></input>
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
                <td><input type="text" name="zichan.place"></td>
            </tr>
            <tr>
                <td>ʹ����</td>
                <td><input type="text" name="zichan.user"></td>
            </tr>
            <tr>
                <td>������</td>
                <td><input type="text" name="zichan.baoguan"></td>
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
                <td><input type="text" name="zichan.gongyingshang"></td>
            </tr>
            <tr>
                <td>ƾ֤</td>
                <td><input type="text" name="zichan.pingzheng"></td>
            </tr>
            <tr>
                <td>�������ݺ�</td>
                <td><input type="text" name="zichan.danjuhao"></td>
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
                	<input type="hidden" name="zichan.status" id="status" value="ʹ��"></input>
                </td>
            </tr>
            <tr>
               <td>��ע</td>
               <td>
                 <textarea cols="60" rows="3" name="zichan.beizhu"></textarea>
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
    		if (searchDeptName == "") {
      			$("ul li").show();
    		} else {
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
  		}
  
  		$("#xiala").click(function(){
  			$("#ul").show();
  		});
  		
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
  	 
  	 $("#xiala").change(function(){
  	 	$("#u").val($(this).val());
  	 })
  	 
  	 $("#nameType").blur(function(){
  	 	if($("#nameType").val()==""||$("#nameType").val()==null){
  	 		alert("���Ʋ���Ϊ��");
  	 		$("#nameType").focus();
  	 	}
  	 })
  </script>
</html>
