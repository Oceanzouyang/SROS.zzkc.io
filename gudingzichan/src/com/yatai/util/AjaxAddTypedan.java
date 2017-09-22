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
import com.yatai.model.Typedan;

public class AjaxAddTypedan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxAddTypedan() {
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
		Typedan typedan = new Typedan();
		String zichanid = request.getParameter("newzichanid");
		typedan.setZichanid(zichanid);
		String name = request.getParameter("newname"); 
		typedan.setName(name);
		float price = Float.parseFloat(request.getParameter("newprice"));
		typedan.setPrice(price);
		float num = Float.parseFloat(request.getParameter("newnum"));
		typedan.setNum(num);
		float jine = Float.parseFloat(request.getParameter("newjine"));
		typedan.setJine(jine);
		String place = request.getParameter("newplace");
		typedan.setPlace(place);
		String beizhu = request.getParameter("newbeizhu");
		typedan.setBeizhu(beizhu);
		String chuli = "新增";
		typedan.setChulitype(chuli);
		String danju = request.getParameter("newdanju");
		typedan.setDanju(danju);
		//System.out.println(zichanid+"--"+name+"--"+type+"--"+price+"--"+num+"--"+jine+"--"+place+"--"+user+"--"+chuli);
		String getdate = request.getParameter("newgetdate");
		typedan.setGetdate(getdate);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		typedan.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		String usedept = request.getParameter("usedept");
		typedan.setUsedept(usedept);
		int result = typedanDao.addTypedan(typedan);
		if(result==0){
			System.out.println(zichanid+"新增失败~~");
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
