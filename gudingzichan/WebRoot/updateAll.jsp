<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�����޸���Ϣ</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #9ad2b2;">
  <form action="updateAll.action" method="post">
    <table>
    	<tr>
    		<td>�����޸���Ϣ</td>
    	</tr>
    	<tr>
    		<td>
    			��ţ�
    		</td>
    		<td>
    			<input type="text" name="zichan.zichanid" id="sid"></input>~~<input type="text" id="eid" name="zichan.baoxiao"></input>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			�޸����ͣ�
    		</td>
    		<td>
    			<select id="leixing" name="zichan.type">
    				<option value="name">����</option>
    				<option value="danwei">��λ</option>
    				<option value="num">����</option>
    				<option value="dept">ʹ�ò���</option>
    				<option value="date">��������</option>
    				<option value="place">��ŵص�</option>
    				<option value="user">ʹ����</option>
    				<option value="baoguan">������</option>
    				<option value="gongyingshang">��Ӧ��</option>
    				<option value="jine">ԭֵ</option>
    				<option value="pingzheng">ƾ֤</option>
    				<option value="beizhu">��ע</option>
    				<option value="jitizhejiu">�����۾�</option>
    				<option value="jingzhi">��ֵ</option>
    				<option value="zhuanchudate">ת��ʱ��</option>
    				<option value="zhuanchudept">ת������</option>
    				<option value="zhuanchuplace">ת���ص�</option>
    				<option value="zhuanrudate">ת��ʱ��</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			�޸����ݣ�
    		</td>
    		<td>
    			<textarea cols="60" rows="3" id="content" name="zichan.beizhu"></textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="�ύ" id="submit"></input>
    		</td>
    		<td>
    			<a href="FenyeServlet">����</a>
    		</td>
    	</tr>
    </table>
   </form>
  </body>
</html>
