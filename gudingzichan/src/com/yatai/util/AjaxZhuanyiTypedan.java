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
import com.yatai.dao.ZichanDao;
import com.yatai.model.Typedan;
import com.yatai.model.typezhuanyi;

public class AjaxZhuanyiTypedan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxZhuanyiTypedan() {
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
		typezhuanyi zhuanyi = new typezhuanyi();
		TypedanDaoImpl typedanDao = new TypedanDao();
		ZichanDao zichanDao = new ZichanDao();
		String zichanid = request.getParameter("zhuanyizichanid");
		String name = request.getParameter("zhianyiname");
		zhuanyi.setName(name);
		String danju = request.getParameter("zhianyidanju");
		zhuanyi.setDanju(danju);
		String zhuanyidate = request.getParameter("zhuanyidate");
		zhuanyi.setKaidandate(zhuanyidate);
		String danwei = request.getParameter("zhuanyidanwei");
		zhuanyi.setDanwei(danwei);
		float num = Float.parseFloat(request.getParameter("zhuanyinum"));
		zhuanyi.setNum(num);
		float yuanshijine = Float.parseFloat(request.getParameter("zhuanyiyuanshijine"));
		zhuanyi.setYuanshijine(yuanshijine);
		float zhejiu = Float.parseFloat(request.getParameter("zhuanyizhejiu"));
		zhuanyi.setZhejiu(zhejiu);
		float jinzhi = Float.parseFloat(request.getParameter("zhuanyijinzhi"));
		zhuanyi.setJinzhi(jinzhi);
		String ruzhangdate = request.getParameter("zhuanyiruzhangdate");
		zhuanyi.setRuzhuangdate(ruzhangdate);
		String zhuanrudept = request.getParameter("zhuanyizhuanrudept");
		zhuanyi.setZhuanrudept(zhuanrudept);
		String zhuanruplace = request.getParameter("zhuanyizhuanruplace");
		zhuanyi.setZhuanruplace(zhuanruplace);
		String zhuanchudept = request.getParameter("zhuanyizhuanchudept");
		zhuanyi.setZhuanchudept(zhuanchudept);
		String zhuanchuplace = request.getParameter("zhuanyizhuanchuplace");
		zhuanyi.setZhuanchuplace(zhuanchuplace);
		String chuli = "转移";
		zhuanyi.setChulitype(chuli);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		zhuanyi.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		int startid = Integer.parseInt(request.getParameter("zhuanyistartid"));
		int endid = Integer.parseInt(request.getParameter("zhuanyiendid"));
		for (int i = startid; i <= endid; i++) {
			if(i<100&&i>=10){
				zhuanyi.setZichanid(zichanid+"-0"+i);
			}else if(i<10){
				zhuanyi.setZichanid(zichanid+"-00"+i);
			}else{
				zhuanyi.setZichanid(zichanid+"-"+i);
			}
			int result = typedanDao.addZhuanyiTypedan(zhuanyi);
			if(result>0){
				String sqlwhere = "update zichan set zhuanchudept='"+zhuanchudept+"',zhuanchuplace='"+zhuanchuplace+"',zhuanrudate='"+zhuanyidate+"',dept='"+zhuanrudept+"',place='"+zhuanruplace+"',zhuanyidan='"+danju+"',jitizhejiu='"+zhejiu+"',jingzhi='"+jinzhi+"' where zichanid='"+zhuanyi.getZichanid()+"'";
				zichanDao.updateTool(sqlwhere);
			}
		}
		
		PrintWriter out = response.getWriter();
		//out.println(result+"");
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
