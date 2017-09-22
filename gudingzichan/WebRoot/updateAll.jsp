<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>批量修改信息</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #9ad2b2;">
  <form action="updateAll.action" method="post">
    <table>
    	<tr>
    		<td>批量修改信息</td>
    	</tr>
    	<tr>
    		<td>
    			编号：
    		</td>
    		<td>
    			<input type="text" name="zichan.zichanid" id="sid"></input>~~<input type="text" id="eid" name="zichan.baoxiao"></input>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			修改类型：
    		</td>
    		<td>
    			<select id="leixing" name="zichan.type">
    				<option value="name">名称</option>
    				<option value="danwei">单位</option>
    				<option value="num">数量</option>
    				<option value="dept">使用部门</option>
    				<option value="date">入账日期</option>
    				<option value="place">存放地点</option>
    				<option value="user">使用人</option>
    				<option value="baoguan">保管人</option>
    				<option value="gongyingshang">供应商</option>
    				<option value="jine">原值</option>
    				<option value="pingzheng">凭证</option>
    				<option value="beizhu">备注</option>
    				<option value="jitizhejiu">计提折旧</option>
    				<option value="jingzhi">净值</option>
    				<option value="zhuanchudate">转出时间</option>
    				<option value="zhuanchudept">转出部门</option>
    				<option value="zhuanchuplace">转出地点</option>
    				<option value="zhuanrudate">转入时间</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			修改内容：
    		</td>
    		<td>
    			<textarea cols="60" rows="3" id="content" name="zichan.beizhu"></textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="提交" id="submit"></input>
    		</td>
    		<td>
    			<a href="FenyeServlet">返回</a>
    		</td>
    	</tr>
    </table>
   </form>
  </body>
</html>
