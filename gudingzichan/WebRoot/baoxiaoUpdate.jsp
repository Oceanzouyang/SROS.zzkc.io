<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改固定资产报销</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">&nbsp;资产信息</p>
     <form action="executeBaoxiao.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>
                                                 资产编号<input type="hidden" name="zichan.id" value=${zichan.id }></input>
                   <input type="hidden" name="zichan.shenhe" value=${zichan.shenhe }></input>
              </td>
              <td><input type="text" name="zichan.zichanid" value="${zichan.zichanid }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>名称</td>
                <td><input type="text" name="zichan.name" value="${zichan.name }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>规格型号</td>
                <td><input type="text" name="zichan.type" value="${zichan.type }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>单位</td>
                <td><input type="text" name="zichan.danwei" value="${zichan.danwei }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>数量</td>
                <td><input type="text" name="zichan.num" value="${zichan.num }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>原值</td>
                <td><input type="text" name="zichan.jine" value="${zichan.jine }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>计提折旧</td>
                <td><input type="text" name="zichan.jitizhejiu" value="${zichan.jitizhejiu }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>净值</td>
                <td><input type="text" name="zichan.jingzhi" value="${zichan.jingzhi }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>转入时间</td>
                <td><input type="text" name="zichan.zhuanrudate" value="${zichan.zhuanrudate }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>转入时间</td>
                <td><input type="text" name="zichan.zhuanchudate" value="${zichan.zhuanchudate }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>使用部门</td>
                <td><input type="text" name="zichan.dept" value="${zichan.dept }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>入账日期</td>
                <td><input type="text" name="zichan.date" value="${zichan.date }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>存放地点</td>
                <td><input type="text" name="zichan.place" value="${zichan.place }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>使用人</td>
                <td><input type="text" name="zichan.user" value="${zichan.user }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>保管人</td>
                <td><input type="text" name="zichan.baoguan" value="${zichan.baoguan }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>转出部门</td>
                <td><input type="text" name="zichan.zhuanchudept" value="${zichan.zhuanchudept }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>转出地点</td>
                <td><input type="text" name="zichan.zhuanchuplace" value="${zichan.zhuanchuplace }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>供应商</td>
                <td><input type="text" name="zichan.gongyingshang" value="${zichan.gongyingshang }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>凭证</td>
                <td><input type="text" name="zichan.pingzheng" value="${zichan.pingzheng }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>报销</td>
                <td><input type="text" name="zichan.baoxiao" value="${zichan.baoxiao }"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                	<input type="text" name="zichan.status" id="status" value="${zichan.status }" readonly="readonly">
                </td>
            </tr>
            <tr>
               <td>备注</td>
               <td>
                 <textarea cols="60" rows="3" name="zichan.beizhu" readonly="readonly">${zichan.beizhu }</textarea>
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
  </body>
  <script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  <script type="text/javascript">
  	 $("#change").change(function(){
  	 	$("#status").val($("#change").val());
  	 })
  	 
  	 $(document).ready(function(){
  	 	if($("#status").val()==null||$("#status").val()==""){
  	 		$("#status").val($("#change").val());
  	 	}
  	 })
  </script>
</html>
