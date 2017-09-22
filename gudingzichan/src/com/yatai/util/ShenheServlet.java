package com.yatai.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yatai.dao.UserDao;
import com.yatai.dao.ZichanDao;
import com.yatai.model.User;
import com.yatai.model.Zichan;

public class ShenheServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ShenheServlet() {
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
		this.doPost(request,response);
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
		int pageSize = 50, currentPage = 1;	//��ʼ��ֵ��ÿҳ��ʾ�������ݣ���ǰҳΪ��һҳ
		String current = request.getParameter("currentPage");
		String loginer = (String) request.getSession().getAttribute("loginer");
		//System.out.println(loginer);
		//��������ѯ����name��place��������
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String dept = request.getParameter("dept");
		String baoguan = request.getParameter("baoguan");
		String user = request.getParameter("user");
		String status = request.getParameter("status");
		String zichanid = request.getParameter("zichanid");
		String date = request.getParameter("date");
		int shenhe = Integer.parseInt(request.getParameter("shenhe"));
		String danjuhao = request.getParameter("danjuhao");
		int id = Integer.parseInt(request.getParameter("id"));
		Zichan zichan = new Zichan();
		String condition = " where " ;
		//�жϲ�ѯ������Ϊ�գ���ƴ������
		if(!name.isEmpty()){
			condition = condition+"name='"+name+"' and ";
		}
		if(!place.isEmpty()){
			condition = condition+"place='"+place+"' and ";
		}
		if(!dept.isEmpty()){
			condition = condition+"dept='"+dept+"' and ";
		}
		if(!baoguan.isEmpty()){
			condition = condition+"baoguan='"+baoguan+"' and ";
		}
		if(!user.isEmpty()){
			condition = condition+"user='"+user+"' and ";
		}
		if(!status.isEmpty()){
			condition = condition+"status='"+status+"' and ";
		}
		if(!zichanid.isEmpty()){
			condition = condition+"zichanid like'%"+zichanid+"%' and ";
		}
		if(!date.isEmpty()){
			condition = condition+"date='"+date+"' and ";
		}
	  	if(!danjuhao.isEmpty()){
			condition = condition+"danjuhao='"+danjuhao+"' and ";
		}			
	  	
	  	
		//�ַ��������and��ȥ��
		if(condition.substring(condition.length()-4, condition.length()-1).equals("and")){
			condition = condition.substring(0, condition.length()-4);
		}
		
		//���������뵽request��
		request.setAttribute("name", name);
		request.setAttribute("place", place);
		request.setAttribute("dept", dept);
		request.setAttribute("user", user);
		request.setAttribute("baoguan", baoguan);
		request.setAttribute("status", status);
		request.setAttribute("zichanid", zichanid);
		request.setAttribute("danjuhao", danjuhao);
		request.getSession().setAttribute("date", date);
		if(current != null && current != "") {
			currentPage = Integer.valueOf(current);
		}
		ZichanDao zichanDao = new ZichanDao();
		//�޸����״̬
		zichan.setShenhe(shenhe);
		zichan.setId(id);
		zichanDao.shenheUpdate(zichan);
		int allRows = zichanDao.selectByFenye(condition).size();//�õ����ݿ����ж��������ݷ��ϲ�ѯ����
		int countPage = (allRows + pageSize - 1)/pageSize;	//�����ҳ��
		int rowStart = (currentPage - 1) * pageSize;
		condition = condition + " order by id desc limit " + rowStart + ", " + pageSize;
		List<Zichan> list = zichanDao.selectByFenye(condition);
		request.setAttribute("list", list);
		request.setAttribute("countPage", countPage);
		request.setAttribute("currentPage", currentPage);
		String selectId = (String) request.getSession().getAttribute("selectId");
		request.setAttribute("select",selectId);
		//��ת�����ѯ���ҳ��
		request.getRequestDispatcher("/mulresultinfo.jsp").forward(request, response);
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
