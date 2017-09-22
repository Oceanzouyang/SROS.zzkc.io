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
import com.yatai.model.typebaofei;
import com.yatai.model.typeweixiu;

public class AjaxQueryChuzhi extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxQueryChuzhi() {
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
		response.setContentType("text/html");
		TypedanDaoImpl typedanDao = new TypedanDao();
		String sqlwhere = request.getParameter("sqlwhere");
		List<typebaofei> list = typedanDao.Querychuzhisqlwhere(sqlwhere);
		StringBuffer sb = new StringBuffer();
		sb.append("<table id='ajaxchuzhi' border='1'><tr><td>资产编号</td><td>名称</td><td>单据号</td><td>规格类型</td><td>单位</td><td>数量</td><td>金额</td><td>入账日期</td><td>使用部门</td><td>请示日期</td><td>处置日期</td><td>处置原因</td><td>处置金额</td><td>操作类型</td><td>操作时间</td><td>功能</td></tr>");
		for (int i = 0; i < list.size(); i++) {
			sb.append("<tr>");
			sb.append("<td>"+list.get(i).getZichanid()+"</td>");
			sb.append("<td>"+list.get(i).getName()+"</td>");
			sb.append("<td>"+list.get(i).getDanju()+"</td>");
			sb.append("<td>"+list.get(i).getType()+"</td>");
			sb.append("<td>"+list.get(i).getDanwei()+"</td>");
			sb.append("<td>"+list.get(i).getNum()+"</td>");
			sb.append("<td>"+list.get(i).getJine()+"</td>");			
			sb.append("<td>"+list.get(i).getRuzhangdate()+"</td>");
			sb.append("<td>"+list.get(i).getDept()+"</td>");
			sb.append("<td>"+list.get(i).getQingshidate()+"</td>");
			sb.append("<td>"+list.get(i).getBaofeidate()+"</td>");
			sb.append("<td>"+list.get(i).getBaofei()+"</td>");
			sb.append("<td>"+list.get(i).getBaofeijine()+"</td>");
			sb.append("<td>"+list.get(i).getChulitype()+"</td>");
			sb.append("<td>"+list.get(i).getOperatedate()+"</td>");
			sb.append("<td style='cursor:pointer;' class='"+list.get(i).getId()+"'>删除</td>");
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
