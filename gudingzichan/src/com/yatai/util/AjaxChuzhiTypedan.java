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
import com.yatai.model.typebaofei;
import com.yatai.model.typeweixiu;

public class AjaxChuzhiTypedan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxChuzhiTypedan() {
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
		ZichanDao zichanDao = new ZichanDao();
		typebaofei baofei = new typebaofei();
		String zichanid = request.getParameter("zichanid");
		//baofei.setZichanid(zichanid);
		String name = request.getParameter("name"); 
		baofei.setName(name);
		String danju = request.getParameter("danju");
		baofei.setDanju(danju);
		String type = request.getParameter("type");
		baofei.setType(type);
		String danwei = request.getParameter("danwei");
		baofei.setDanwei(danwei);
		float num = Float.parseFloat(request.getParameter("num"));
		baofei.setNum(num);
		float jine = Float.parseFloat(request.getParameter("jine"));
		baofei.setJine(jine);
		String ruzhangdate = request.getParameter("ruzhangdate");
		baofei.setRuzhangdate(ruzhangdate);
		String dept = request.getParameter("dept");
		baofei.setDept(dept);
		String baofeidate = request.getParameter("baofeidate");
		baofei.setBaofeidate(baofeidate);
		String baofeires = request.getParameter("baofei");
		baofei.setBaofei(baofeires);
		float baofeijine = Float.parseFloat(request.getParameter("baofeijine"));
		baofei.setBaofeijine(baofeijine);	
		String chuli = "处置";
		baofei.setChulitype(chuli);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		baofei.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		String qingshidate = request.getParameter("chuqingshidate");
		baofei.setQingshidate(qingshidate);
		int startid = Integer.parseInt(request.getParameter("chuzhistartid"));
		int endid = Integer.parseInt(request.getParameter("chuzhiendid"));
		for (int i = startid; i <= endid; i++) {
			if(i<100&&i>=10){
				baofei.setZichanid(zichanid+"-0"+i);
			}else if(i<10){
				baofei.setZichanid(zichanid+"-00"+i);
			}else{
				baofei.setZichanid(zichanid+"-"+i);
			}
			int result = typedanDao.addchuzhiTypedan(baofei);
			if(result>0){
				//System.out.println(zichanid+"处置失败~~");
				String sqlwhere = "update zichan set status='处置',chuzhidan='"+danju+"' where zichanid='"+baofei.getZichanid()+"'";
				zichanDao.updateTool(sqlwhere);
			}	
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
