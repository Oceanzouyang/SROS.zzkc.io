package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;
import com.yatai.model.typeweixiu;

public class AjaxWeixiuTypedan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxWeixiuTypedan() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		TypedanDaoImpl typedanDao = new TypedanDao();
		typeweixiu weixiu = new typeweixiu();
		String zichanid = request.getParameter("zichanid");
		weixiu.setZichanid(zichanid);
		String name = request.getParameter("name"); 
		weixiu.setWeixiuname(name);
		String danju = request.getParameter("danju");
		weixiu.setDanju(danju);
		String weixiudept = request.getParameter("weixiudept");
		weixiu.setWeixiudept(weixiudept);
		String baoxiudept = request.getParameter("baoxiudept");
		weixiu.setBaoxiudept(baoxiudept);
		float num = Float.parseFloat(request.getParameter("num"));
		weixiu.setNum(num);
		float price = Float.parseFloat(request.getParameter("price"));
		weixiu.setPrice(price);
		String weixiudate = request.getParameter("weixiudate");
		weixiu.setWeixiudate(weixiudate);
		String dengjidate = request.getParameter("dengjidate");
		weixiu.setDengjidate(dengjidate);
		String chuli = "维修";
		weixiu.setChulitype(chuli);
		String weixiucontent = request.getParameter("weixiucontent");
		weixiu.setWeixiucontent(weixiucontent);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		weixiu.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		int result = typedanDao.addweixiuTypedan(weixiu);
		if(result==0){
			System.out.println(zichanid+"维修失败~~");
		}	
		//out.println(result);
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
