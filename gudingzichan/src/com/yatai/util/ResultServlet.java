package com.yatai.util;

import java.io.IOException;
import java.text.NumberFormat;
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

public class ResultServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ResultServlet() {
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
		int pageSize = 50, currentPage = 1;	//初始化值，每页显示几行数据，当前页为第一页
		String current = request.getParameter("currentPage");
		String loginer = (String) request.getSession().getAttribute("loginer");
		//System.out.println(loginer);
		//多条件查询包括name、place。。。等
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String dept = request.getParameter("dept");
		String baoguan = request.getParameter("baoguan");
		String user = request.getParameter("user");
		String status = request.getParameter("status");
		String zichanid = request.getParameter("zichanid");
		String date = request.getParameter("date");
		String danjuhao = request.getParameter("danjuhao");
		UserDao userDao = new UserDao();
		List<User> userList = new ArrayList<User>();
		String type="";
		String choose = "";
		String chooseCondition = " ";
		String condition = " where " ;
		//判断查询条件不为空，则拼接条件
		if(!name.isEmpty()){
			condition = condition+"name like'%"+name+"%' and ";
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
		//字符串最后是and则去掉
		if(condition.substring(condition.length()-4, condition.length()-1).equals("and")){
			condition = condition.substring(0, condition.length()-4);
		}
		
		//将参数放入到request中
		request.setAttribute("name", name);
		request.setAttribute("place", place);
		request.setAttribute("dept", dept);
		request.setAttribute("user", user);
		request.setAttribute("baoguan", baoguan);
		request.setAttribute("status", status);
		request.setAttribute("zichanid", zichanid);
		request.getSession().setAttribute("date", date);
		request.setAttribute("danjuhao", danjuhao);
		if(current != null && current != "") {
			currentPage = Integer.valueOf(current);
		}
		userList = userDao.login();
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(loginer)){
				choose = userList.get(i).getChoose();
				type = userList.get(i).getType();
			}
		}
		if(type.equals("普通")){
			String[] sourceStrArray=choose.split(",");
			for (int i = 0; i < sourceStrArray.length; i++) {
				chooseCondition = chooseCondition + "'"+sourceStrArray[i]+"',";
			}
			chooseCondition = chooseCondition.substring(0, chooseCondition.length()-2);
			condition = condition +" and dept in ("+ chooseCondition+"')" + " order by id desc ";
			System.out.println(condition);
		}else{
			condition = condition + " order by id desc ";
		}
		ZichanDao zichanDao = new ZichanDao();
		//不分页获取查询list
		List<Zichan> listall = zichanDao.selectByFenye(condition);
		//累加金额和数量
		double sum = 0;
		float num = 0;
		for (int i = 0; i < listall.size(); i++) {
			if(!listall.get(i).getJine().isEmpty()){
				double money = Double.parseDouble(listall.get(i).getJine());
				if(listall.get(i).getStatus().equals("使用")||listall.get(i).getStatus().equals("停用")){
					sum = sum + money;
				}
				//System.out.println("money="+sum);
			}
			if(listall.get(i).getNum()!=0){
				num = num + listall.get(i).getNum();
				//System.out.println(num+"==num");
			}
		}
		int allRows = zichanDao.selectByFenye(condition).size();//得到数据库里有多少条数据符合查询条件
		int countPage = (allRows + pageSize - 1)/pageSize;	//获得总页数
		int rowStart = (currentPage - 1) * pageSize;
		condition = condition + " limit " + rowStart + ", " + pageSize;
		List<Zichan> list = zichanDao.selectByFenye(condition);
		String money = NumberFormat.getInstance().format(sum);
		request.setAttribute("list", list);
		request.setAttribute("countPage", countPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("shuliang", num);
		request.setAttribute("qiuhe", money);
		String selectId = (String) request.getSession().getAttribute("selectId");
		request.setAttribute("select",selectId);
		//跳转进入查询结果页面
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
