<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.yatai.model.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸Ĺ̶��ʲ�����</title>
  </head>
  <body style="background-color: #9ad2b2;">
  	<p align="center" style="font-size: 30px;margin-top: 30px;">&nbsp;�ʲ���Ϣ</p>
     <form action="executeBaoxiao.action" method="post">
       <table border="1" align="center", width="80%">
            <tr>
              <td>
                                                 �ʲ����<input type="hidden" name="zichan.id" value=${zichan.id }></input>
                   <input type="hidden" name="zichan.shenhe" value=${zichan.shenhe }></input>
              </td>
              <td><input type="text" name="zichan.zichanid" value="${zichan.zichanid }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="text" name="zichan.name" value="${zichan.name }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>����ͺ�</td>
                <td><input type="text" name="zichan.type" value="${zichan.type }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>��λ</td>
                <td><input type="text" name="zichan.danwei" value="${zichan.danwei }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="text" name="zichan.num" value="${zichan.num }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ԭֵ</td>
                <td><input type="text" name="zichan.jine" value="${zichan.jine }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>�����۾�</td>
                <td><input type="text" name="zichan.jitizhejiu" value="${zichan.jitizhejiu }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>��ֵ</td>
                <td><input type="text" name="zichan.jingzhi" value="${zichan.jingzhi }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ת��ʱ��</td>
                <td><input type="text" name="zichan.zhuanrudate" value="${zichan.zhuanrudate }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ת��ʱ��</td>
                <td><input type="text" name="zichan.zhuanchudate" value="${zichan.zhuanchudate }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ʹ�ò���</td>
                <td><input type="text" name="zichan.dept" value="${zichan.dept }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>��������</td>
                <td><input type="text" name="zichan.date" value="${zichan.date }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>��ŵص�</td>
                <td><input type="text" name="zichan.place" value="${zichan.place }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ʹ����</td>
                <td><input type="text" name="zichan.user" value="${zichan.user }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>������</td>
                <td><input type="text" name="zichan.baoguan" value="${zichan.baoguan }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ת������</td>
                <td><input type="text" name="zichan.zhuanchudept" value="${zichan.zhuanchudept }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ת���ص�</td>
                <td><input type="text" name="zichan.zhuanchuplace" value="${zichan.zhuanchuplace }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>��Ӧ��</td>
                <td><input type="text" name="zichan.gongyingshang" value="${zichan.gongyingshang }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>ƾ֤</td>
                <td><input type="text" name="zichan.pingzheng" value="${zichan.pingzheng }" readonly="readonly"></td>
            </tr>
            <tr>
                <td>����</td>
                <td><input type="text" name="zichan.baoxiao" value="${zichan.baoxiao }"></td>
            </tr>
            <tr>
                <td>״̬</td>
                <td>
                	<input type="text" name="zichan.status" id="status" value="${zichan.status }" readonly="readonly">
                </td>
            </tr>
            <tr>
               <td>��ע</td>
               <td>
                 <textarea cols="60" rows="3" name="zichan.beizhu" readonly="readonly">${zichan.beizhu }</textarea>
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
