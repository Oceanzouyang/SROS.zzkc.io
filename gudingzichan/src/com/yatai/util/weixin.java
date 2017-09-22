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
import com.yatai.model.ZichanType;

public class weixin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public weixin() {
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
		doPost(request, response);
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
		ZichanDao zichanDao = new ZichanDao();
		ZichanType zichanType = new ZichanType();
		Zichan zichan = new Zichan();
		List<Zichan> list = zichanDao.showInfo();
		int count=0;
//		for (int i = 0; i < list.size(); i++) {
//			//System.out.println(list.get(i).getZichanid());
//			
//			if(list.get(i).getZichanid()==null||list.get(i).getZichanid().equals("")){
//				count++;
//				
//			}else{
//				count++;
//				//System.out.println("资产id不为空:"+list.get(i).getZichanid()+"---"+i);
//				String bianhao = list.get(i).getZichanid().substring(0, 5);
//				System.out.println(bianhao);
//			}
//		}
//		System.out.println(count);
//		System.out.println(list.size());
		
		List<ZichanType> typeList = zichanDao.showTypeInfo();
		for (int i = 0; i < typeList.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getZichanid()==null||list.get(j).getZichanid().equals("")){
					count++;
					
				}else{
					count++;
					String bianhao = list.get(j).getZichanid().substring(0, 5);
					if(typeList.get(i).getTypecode().equals(bianhao)){
						//System.out.println(bianhao+"=="+typeList.get(i).getTypecode()+"=="+typeList.get(i).getType()+"=="+list.get(j).getId());
						zichanDao.updateZichanType(bianhao,typeList.get(i).getType(),list.get(j).getId());
					}
					//System.out.println("资产id不为空:"+list.get(i).getZichanid()+"---"+i);	
				}
				
			}
			//System.out.println("资产类型"+typeList.get(i).getType()+typeList.get(i).getTypecode());
		}
		System.out.println(count);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
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
