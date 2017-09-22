package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;
import com.yatai.model.ZichanType;

public class QueryTypeLike extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryTypeLike() {
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
		ZichanDao dao = new ZichanDao();
		String type = request.getParameter("typename");
		//type=new String(type.getBytes("ISO-8859-1"),"GBK");
		String sqlwhere = " type like '%"+type+"%'";
		List<ZichanType> zichanTypeList = dao.showTypeSqlwhere(sqlwhere);
		StringBuffer sb = new StringBuffer();
		//System.out.println(zichanTypeList.size());
		for (int i = 0; i < zichanTypeList.size(); i++) {
			sb.append("<tr><td>");
			String param1 = "'"+zichanTypeList.get(i).getTypecode()+"'";
			String param2 = "'"+zichanTypeList.get(i).getType()+"'";
			sb.append(zichanTypeList.get(i).getTypecode()+"</td><td><a style='cursor:pointer;' onclick="+"getParam("+param1+","+param2+")"+">"+zichanTypeList.get(i).getType()+"</a>");
			sb.append("</td></tr>");
			//System.out.println(zichanTypeList.get(i).getType());
		}
		String content = "<div style='text-align:center;cursor:pointer;' id='queryResult' onclick='show()'>≤È—ØΩ·π˚</div><table style='background-color: white;' id='typeTable' align='center' border='1'>"+sb+"</table>";
		request.setCharacterEncoding("UTF-8");  
	    response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		
		JSONObject obj=new JSONObject();
		obj.put("name", "≤‚ ‘");
		
		//out.println(obj);
		out.println(content);
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
