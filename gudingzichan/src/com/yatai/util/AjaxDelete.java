package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;

public class AjaxDelete extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxDelete() {
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
		String operate = request.getParameter("operate");
		String delid = request.getParameter("delid");
		String sqlwhere = "";
		if(operate.equals("add")){
			sqlwhere = " typedan where id="+delid;
		}
		if(operate.equals("zhuanyi")){
			sqlwhere = " typezhuanyi where id="+delid;
		}
		if(operate.equals("weixiu")){
			sqlwhere = " typeweixiu where id="+delid;
		}
		if(operate.equals("chuzhi")){
			sqlwhere = " typebaofei where id="+delid;
		}
		typedanDao.delTypedan(sqlwhere);
		PrintWriter out = response.getWriter();
		out.println("");
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
