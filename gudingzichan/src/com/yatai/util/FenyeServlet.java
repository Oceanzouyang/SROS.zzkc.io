package com.yatai.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yatai.action.ZichanAction;
import com.yatai.dao.UserDao;
import com.yatai.dao.ZichanDao;
import com.yatai.model.User;
import com.yatai.model.Zichan;

public class FenyeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public FenyeServlet() {
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
		//System.out.println("��ʼ��ҳ");
		int pageSize = 50, currentPage = 1;	//��ʼ��ֵ��ÿҳ��ʾ�������ݣ���ǰҳΪ��һҳ
		String current = request.getParameter("currentPage");
		ZichanAction zichanAction = new ZichanAction();
		ZichanDao zichanDao = new ZichanDao();
		UserDao userDao = new UserDao();
		List<User> userList = new ArrayList<User>();
		if(current != null && current != "") {
			currentPage = Integer.valueOf(current);
		}
		String loginer = (String) request.getSession().getAttribute("loginer");
		//System.out.println(loginer);
		//��ѯ���жϵ�ǰ�û�����ͨ�û�������ȡ�û��Ĳ���
		String type="";
		String choose = "";
		String chooseCondition = " where ";
		userList = userDao.login();
		int allRows = 0;
		int countPage =0;
		List<Zichan> list = new ArrayList<Zichan>();
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(loginer)){
				choose = userList.get(i).getChoose();
				type = userList.get(i).getType();
			}
		}
		if(type.equals("��ͨ")){
			String[] sourceStrArray=choose.split(",");
			for (int i = 0; i < sourceStrArray.length; i++) {
				chooseCondition = chooseCondition + "dept='"+sourceStrArray[i]+"' or ";
			}
			chooseCondition = chooseCondition.substring(0, chooseCondition.length()-3);
			//System.out.println(chooseCondition);
			allRows = zichanDao.showInfoChoose(chooseCondition).size();	//�õ����ݿ����ж��������ݷ��ϲ�ѯ����
			countPage = (allRows + pageSize - 1)/pageSize;	//�����ҳ��
			list = zichanAction.queryFenyeChoose(currentPage, pageSize,chooseCondition);	
		}else{
			allRows = zichanDao.showInfo().size();	//�õ����ݿ����ж��������ݷ��ϲ�ѯ����
			countPage = (allRows + pageSize - 1)/pageSize;	//�����ҳ��
			list = zichanAction.queryFenye(currentPage, pageSize);	
		}
		request.setAttribute("list", list);
		request.setAttribute("countPage", countPage);
		request.setAttribute("currentPage", currentPage);
		String selectId = (String) request.getSession().getAttribute("selectId");
		request.setAttribute("select",selectId);
		request.getRequestDispatcher("/zichaninfo.jsp").forward(request, response);
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
