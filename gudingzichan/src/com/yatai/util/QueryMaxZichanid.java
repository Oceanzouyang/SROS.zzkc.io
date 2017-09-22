package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yatai.action.ZichanAction;
import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;

public class QueryMaxZichanid extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryMaxZichanid() {
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
		String typecode = request.getParameter("typecode");
		ZichanDao zichanDao = new ZichanDao();
		List<Zichan> list = zichanDao.showInfoChoose(" where typecode='"+typecode+"' order by id desc");
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			String[] houzhui = list.get(i).getZichanid().split("-");
			if(houzhui[1].indexOf("~")!=-1){
				System.out.println(houzhui[1]);
			}else{
				if(!houzhui[1].isEmpty()){
					if(Integer.valueOf(houzhui[1])>max){
						max = Integer.valueOf(houzhui[1]);
					}
				}
			}
			
		}
		PrintWriter out = response.getWriter();
		out.println(typecode+"-"+max);
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
