package com.yatai.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yatai.dao.UserDao;
import com.yatai.model.User;

public class UserLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UserLogin() {
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		request.getSession().setAttribute("name", name);
		UserDao userDao = new UserDao();
		List<User> list = new ArrayList<User>();
		list = userDao.login();
		int token=0;
		for (int i = 0; i < list.size(); i++) {
			if(name.equalsIgnoreCase(list.get(i).getUsername())&&password.equalsIgnoreCase(list.get(i).getPassword())){
				token=1;
				request.getSession().setAttribute("loginid", list.get(i).getId());
			}
		}
		if(token==1){
			request.getSession().setAttribute("loginer", name);
			if(name.equalsIgnoreCase("admin001")&&password.equalsIgnoreCase("admin001")){
				request.setAttribute("list", list);
				request.getRequestDispatcher("/info.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else{
			request.getSession().setAttribute("loginer", "error");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
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
