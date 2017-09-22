<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<html>
  <head>
    <title>修改固定资产信息</title>
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
  	<p align="center" style="font-size: 30px;margin-top: 30px;">资产信息</p>
     <form action="executeUpdate.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>资产编号
              	<input type="hidden" name="zichan.id" value=${zichan.id }></input>
              	<input type="hidden" name="zichan.shenhe" value=${zichan.shenhe }></input>
              </td>
              <td><input type="text" name="zichan.zichanid" value=${zichan.zichanid } id="zichanId"></td>
            </tr>
            <tr>
                <td>名称</td>
                <td><input type="text" name="zichan.name" value=${zichan.name }></td>
            </tr>
            <tr>
                <td>资产类别编号</td>
                <td><input type="text" name="zichan.typecode" value=${zichan.typecode } id="typecode"></td>
            </tr>
            <tr>
                <td>资产类别名称</td>
                <td><input type="text" name="zichan.typename" value=${zichan.typename } id="typename">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="搜索" id="queryType"></input></td>
            </tr>
            <tr>
                <td>规格型号</td>
                <td><input type="text" name="zichan.type" value=${zichan.type }></td>
            </tr>
            <tr>
                <td>单位</td>
                <td><input type="text" name="zichan.danwei" value=${zichan.danwei }></td>
            </tr>
            <tr>
                <td>数量</td>
                <td>
                	<input type="text" name="zichan.num" value=${zichan.num }>
                </td>
            </tr>
            <tr>
                <td>原值</td>
                <td><input type="text" name="zichan.jine" value=${zichan.jine }></td>
            </tr>
            <tr>
                <td>计提折旧</td>
                <td><input type="text" name="zichan.jitizhejiu" value="${zichan.jitizhejiu }"></td>
            </tr>
            <tr>
                <td>净值</td>
                <td><input type="text" name="zichan.jingzhi" value="${zichan.jingzhi }"></td>
            </tr>
            <tr>
                <td>转入时间</td>
                <td><input type="text" name="zichan.zhuanrudate" value="${zichan.zhuanrudate }"></td>
            </tr>
            <tr>
                <td>转出时间</td>
                <td><input type="text" name="zichan.zhuanchudate" value="${zichan.zhuanchudate }"></td>
            </tr>
            <tr>
                <td>入账日期</td>
                <td><input type="text" name="zichan.date" value=${zichan.date }></td>
            </tr>
            <tr>
                <td>使用部门</td>
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
                <td>存放地点</td>
                <td><input type="text" name="zichan.place" value=${zichan.place }></td>
            </tr>
            <tr>
                <td>使用人</td>
                <td><input type="text" name="zichan.user" value=${zichan.user }></td>
            </tr>
            <tr>
                <td>保管人</td>
                <td><input type="text" name="zichan.baoguan" value=${zichan.baoguan }></td>
            </tr>

            <tr>
                <td>转出部门</td>
                <td><input type="text" name="zichan.zhuanchudept" value="${zichan.zhuanchudept}"></td>
            </tr>
            <tr>
                <td>转出地点</td>
                <td><input type="text" name="zichan.zhuanchuplace" value="${zichan.zhuanchuplace }"></td>
            </tr>
            <tr>
                <td>供应商</td>
                <td><input type="text" name="zichan.gongyingshang" value=${zichan.gongyingshang }></td>
            </tr>
            <tr>
                <td>凭证</td>
                <td><input type="text" name="zichan.pingzheng" value=${zichan.pingzheng }></td>
            </tr>
            <tr>
                <td>新增单据号</td>
                <td><input type="text" name="zichan.danjuhao" value=${zichan.danjuhao }></td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                	<select id="change">
                		<option value="使用">使用</option>
                		<option value="停用">停用</option>
                		<option value="报废">报废</option>
 						<option value="处置">处置</option>
                	</select>
                	<input type="hidden" name="zichan.status" id="status" value=${zichan.status }></td>
            </tr>
            <tr>
               <td>备注</td>
               <td>
                 <textarea cols="60" rows="3" name="zichan.beizhu">${zichan.beizhu }</textarea>
               </td>
            </tr>
            
            <tr>
              <td colspan="2" align="center" >
                 <input type="submit" value="提交"/>
                 <a href="FenyeServlet">返回</a>
              </td>
            </tr>
       </table>
     </form>
     <div id="likecontent" style="float:left;width: 200px;position: absolute;top: 10px;">
     </div>
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  		//绑定部门
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
  
  		//点击获取部门名称
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
             		alert("错误");
             	}
  			});
  		});
  
  	 function getParam(a,b){
  			$("#typecode").val(a);
  			$("#typename").val(b);
  			//获取最大的zichanid编号
  			$.ajax({
  				url: "QueryMaxZichanid?typecode="+$("#typecode").val(),
  				type: "get",
  				success: function(data){
  					$("#zichanId").val(data);
  				},
  				error:function (data, textStatus, errorThrown) {
             		alert("错误");
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
