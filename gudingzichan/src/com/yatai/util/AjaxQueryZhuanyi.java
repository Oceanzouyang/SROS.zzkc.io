package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;
import com.yatai.model.typezhuanyi;

public class AjaxQueryZhuanyi extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxQueryZhuanyi() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sqlwhere = request.getParameter("sqlwhere");
		TypedanDaoImpl typedanDao = new TypedanDao();
		List<typezhuanyi> list = typedanDao.Queryzhuanyisqlwhere(sqlwhere);
		float num = 0;
		float yuanshijine = 0;
		float zhejiu = 0;
		float jintzhi = 0;
		for (int i = 0; i < list.size(); i++) {
			num = num + list.get(i).getNum();
			yuanshijine = yuanshijine + list.get(i).getYuanshijine();
			zhejiu = zhejiu + list.get(i).getZhejiu();
			jintzhi = jintzhi + list.get(i).getJinzhi();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='zhuanyisum'>������"+num+"     ԭʼ��"+yuanshijine+"     �۾ɣ� "+zhejiu+"     ��ֵ��"+jintzhi+"</div></br>");
		sb.append("<table id='ajaxzhuanyi' border='1'><tr><td>�ʲ����</td><td>����</td><td>���ݺ�</td><td>ת������</td><td>��λ</td><td>����</td><td>ԭʼ���</td><td>�۾�</td><td>��ֵ</td><td>��������</td><td>ת�벿��</td><td>ת��ص�</td><td>ת������</td><td>ת���ص�</td><td>��������</td><td>����ʱ��</td><td>����</td></tr>");
		for (int i = 0; i < list.size(); i++) {
			sb.append("<tr>");
			sb.append("<td>"+list.get(i).getZichanid()+"</td>");
			sb.append("<td>"+list.get(i).getName()+"</td>");
			sb.append("<td>"+list.get(i).getDanju()+"</td>");
			sb.append("<td>"+list.get(i).getKaidandate()+"</td>");
			sb.append("<td>"+list.get(i).getDanwei()+"</td>");
			sb.append("<td>"+list.get(i).getNum()+"</td>");
			sb.append("<td>"+list.get(i).getYuanshijine()+"</td>");
			sb.append("<td>"+list.get(i).getZhejiu()+"</td>");
			sb.append("<td>"+list.get(i).getJinzhi()+"</td>");
			sb.append("<td>"+list.get(i).getRuzhuangdate()+"</td>");
			sb.append("<td>"+list.get(i).getZhuanrudept()+"</td>");
			sb.append("<td>"+list.get(i).getZhuanruplace()+"</td>");
			sb.append("<td>"+list.get(i).getZhuanchudept()+"</td>");
			sb.append("<td>"+list.get(i).getZhuanchuplace()+"</td>");
			sb.append("<td>"+list.get(i).getChulitype()+"</td>");
			sb.append("<td>"+list.get(i).getOperatedate()+"</td>");
			sb.append("<td style='cursor:pointer;' class='"+list.get(i).getId()+"'>ɾ��</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(sb);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
