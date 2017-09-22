package com.yatai.action;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;
import com.yatai.dao.ZichanDao;
import com.yatai.model.Dept;
import com.yatai.model.Typedan;
import com.yatai.model.Zichan;
import com.yatai.model.ZichanType;

/**
 * 单表的增删改查
 * 基本的struts2.0的使用
 *
 */
public class ZichanAction
{
	List<Zichan> list = new ArrayList<Zichan>();
	List<Dept> listzichan = new ArrayList<Dept>();
	List<Dept> deptList = new ArrayList<Dept>();
	TypedanDaoImpl typedanDao = new TypedanDao();
	List<Typedan> listdan = new ArrayList<Typedan>();
	List<ZichanType> zichanTypeList = new ArrayList<ZichanType>();
	Typedan typedan = new Typedan();
	public List<Typedan> getListdan() {
		return listdan;
	}

	public void setListdan(List<Typedan> listdan) {
		this.listdan = listdan;
	}

	public Typedan getTypedan() {
		return typedan;
	}

	public void setTypedan(Typedan typedan) {
		this.typedan = typedan;
	}

	Zichan zichan = new Zichan();

	ZichanDao dao = new ZichanDao();
	public List<ZichanType> getZichanTypeList() {
		return zichanTypeList;
	}

	public void setZichanTypeList(List<ZichanType> zichanTypeList) {
		this.zichanTypeList = zichanTypeList;
	}

	ZichanType zichanType = new ZichanType();
	Dept dept = new Dept();
	static String  dpName = "";
	static String tptype = "";
	static String tptypecode = "";
	
	
	
	
    //分页
    public List<Zichan> queryFenye(int currentPage, int pageSize){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = " order by zichanid desc limit " + rowStart + ", " + pageSize;	//每次只获得一页的数据
		list = dao.selectByFenye(condition);
    	return list;
    }
	
    //普通用户分页
    public List<Zichan> queryFenyeChoose(int currentPage, int pageSize,String choose){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = choose + " order by zichanid desc limit " + rowStart + ", " + pageSize;	//每次只获得一页的数据
		list = dao.selectByFenye(condition);
    	return list;
    }
    
    
    //未审核分页	
    public List<Zichan> queryShenheFenye(int currentPage, int pageSize){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = " limit " + rowStart + ", " + pageSize;	//每次只获得一页的数据
		list = dao.selectByFenye(condition);
    	return list;
    }
    
    //查询部门表dept
    public String deptAction(){
    	listzichan = dao.showDeptInfo();
    	return "success";
    }
    
    //添加部门
    public String addDeptAction(){
    	dao.addDept(dept);
    	return this.showDeptAction();
    }
    
    //添加资产类别
    public String addTypeAction(){
    	//System.out.println("开始添加"+zichanType.getId()+"--"+zichanType.getType()+"--"+zichanType.getTypecode());
    	if(!"".equals(zichanType.getType())&&!"".equals(zichanType.getClass())){
    		dao.addType(zichanType);
    	}else{
    		System.out.println("未输入数据~~");
    	}
    	return this.showTypeAction();
    }
    
    //获取修改部门参数
	public String updateDeptAction()
	{
		dept = dao.updateDept(dept.getId());
		dpName = dept.getDeptname();
		return "success";
	}
    
	 //获取修改资产类别参数
	public String updateTypeAction()
	{
		zichanType = dao.updateType(zichanType.getId());
		tptype = zichanType.getType();
		tptypecode = zichanType.getTypecode();
		return "success";
	}
	
	
	//根据名称模糊匹配查找
	public String querylikeNameAction(){
		String name = zichan.getName();
		list = dao.querylikeNameDao(name);
		return "";
	}
	
	//修改部门参数
	public String executeDeptUpdateAction()
	{
		dao.executeDeptUpdate(dept.getDeptname(), dpName);
		dao.executeDeptUpdate(dept);
		return this.showDeptAction();
	}
	
	//修改资产类型参数
	public String executeTypeUpdateAction()
	{
		dao.executeTypeUpdate(zichanType.getTypecode(),zichanType.getType(),tptypecode,tptype);
		dao.executeTypeUpdate(zichanType);
		return this.showTypeAction();
	}
	
    //显示部门
    public String showDeptAction()
	{
    	deptList = dao.showDeptInfo();
		return "success";
	}
    
    //显示资产类别
    public String showTypeAction()
	{
    	zichanTypeList = dao.showTypeInfo();
    	String content= "";
    	StringBuilder sb = new StringBuilder();
    	sb.append("<tr>");
    	for (int i = 0; i < zichanTypeList.size(); i++) {
    		//System.out.println(zichanTypeList.get(i).getType()+"--"+zichanTypeList.get(i).getTypecode());
    		if(i%8==0&&i>0){
    			 sb.append("</tr>");
                 sb.append("<tr>");
                 sb.append("<td><a href='updateType.action?ZichanType.id="+zichanTypeList.get(i).getId()+" '/>"+zichanTypeList.get(i).getTypecode()+"</a>  "+zichanTypeList.get(i).getType()+"</td><td><a class='deleteType' id='"+zichanTypeList.get(i).getId()+"'>"+"删除"+"</a></td>");
    		}else{
    			 sb.append("<td><a href='updateType.action?ZichanType.id="+zichanTypeList.get(i).getId()+" '/>"+zichanTypeList.get(i).getTypecode()+"</a>  "+zichanTypeList.get(i).getType()+"</td><td><a class='deleteType' id='"+zichanTypeList.get(i).getId()+"'>"+"删除"+"</a></td>");
    		}
    		
		}
    	sb.append("</tr>");
    	ActionContext ctx = ActionContext.getContext();
    	content = "<table align='center' border='1'>"+sb+"</table>";
    	ctx.put("req", content);
    	//ctx.getSession().put("ses", "123");
//    	
//    	
//    	String sqlwhere = " type like '%桌%'";
//		zichanTypeList = dao.showTypeSqlwhere(sqlwhere);
//		StringBuffer sb1 = new StringBuffer();
//		for (int i = 0; i < zichanTypeList.size(); i++) {
//			sb1.append("<tr><td>");
//			sb1.append(zichanTypeList.get(i).getTypecode()+"</td><td>"+zichanTypeList.get(i).getType());
//			sb1.append("</td></tr>");
//			System.out.println(zichanTypeList.get(i).getType());
//		}
//		String content1 = "<table align='center' border='1'>"+sb1+"</table>";
//		ctx.put("req1", content1);
		return "success";
	}
    
  //sqlwhere查询zichantype表
	public String QueryZichanTypeSqlwhere() throws IOException{
		ActionContext ctx = ActionContext.getContext();
		String type = zichan.getTypename();
		String sqlwhere = " type like '%"+type+"%'";
		zichanTypeList = dao.showTypeSqlwhere(sqlwhere);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < zichanTypeList.size(); i++) {
			sb.append("<tr><td>");
			sb.append(zichanTypeList.get(i).getTypecode()+"</td><td>"+zichanTypeList.get(i).getType());
			sb.append("</td></tr>");
			System.out.println(zichanTypeList.get(i).getType());
		}
		String content = "<table align='center' border='1'>"+sb+"</table>";
		String abc = "{'name':'123'}";
		JSONObject obj=new JSONObject();
		obj.put("name", "测试");
		//JSONArray array=JSONArray.fromObject(abc);
		HttpServletRequest request = ServletActionContext.getRequest();  
        HttpServletResponse response = ServletActionContext.getResponse();  
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        //PrintWriter out = response.getWriter();
		//out.println(obj);
        response.getWriter().print(obj); 
//		ctx.put("req", content);
        
		return "success";
	}
    
    //显示所有信息
	public String showAction()
	{
        list = dao.showInfo();
		return "success";
	}
	
	public Zichan getZichan() {
		return zichan;
	}

	public void setZichan(Zichan zichan) {
		this.zichan = zichan;
	}

	public ZichanDao getDao() {
		return dao;
	}

	public void setDao(ZichanDao dao) {
		this.dao = dao;
	}

	//单个添加
	public String addAction()
	{
		listzichan = dao.showDeptInfo();
		return "success";
	}
	
	//批量添加
	public String addPiliangAction()
	{
		listzichan = dao.showDeptInfo();
		return "success";
	}
	
	//审核
	public String shenheAction(){
		zichan.setShenhe(0);
		dao.shenheUpdate(zichan);
		return this.showAction();
	}
	
	//审核
	public String cancelShenheAction(){
		zichan.setShenhe(1);
		dao.shenheUpdate(zichan);
		return this.showAction();
	}
	
	//添加一条记录
	public String executeAddAction()
	{
		String name = "'"+zichan.getName()+"'";
		String sql = " where name="+name+" order by xuhao desc";
		int xuhao = dao.maxXuhao(sql);
		zichan.setXuhao(xuhao+1);
		System.out.println(zichan.getDept());
		dao.add(zichan);
		TypedanDaoImpl typedanDao = new TypedanDao();
		typedan.setZichanid(zichan.getZichanid());
		typedan.setName(zichan.getName());
		typedan.setBeizhu(zichan.getBeizhu());
		typedan.setDanju(zichan.getDanjuhao());
		typedan.setNum(zichan.getNum());
		typedan.setPlace(zichan.getPlace());
		typedan.setGetdate(zichan.getDate());
		typedan.setUsedept(zichan.getDept());
		float price=0;
		if(!zichan.getJine().isEmpty()){
			typedan.setPrice(Float.parseFloat(zichan.getJine()));
		}else{	
			typedan.setPrice(price);
		}
		float jine = typedan.getPrice()*typedan.getNum();
		typedan.setJine(jine);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		typedan.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		typedan.setChulitype("新增");
		typedanDao.addTypedan(typedan);
	    return this.showAction();
	}
	
	//添加N条记录
	public String executePiliangAddAction()
	{
		//System.out.println(zichan.getXuhao()+"=="+zichan.getShenhe()+"=="+zichan.getDept());
		String name = "'"+zichan.getName()+"'";
		String sql = " where name="+name+" order by xuhao desc";
		int xuhao = dao.maxXuhao(sql);
		int start = zichan.getXuhao();
		int end = zichan.getShenhe();
		String zichanid = zichan.getZichanid();
		for(int i=start;i<=end;i++){
			zichan.setXuhao(xuhao+i);
			if(i<10){
				zichan.setZichanid(zichanid+"-00"+i);
			}else if(i<100){
				zichan.setZichanid(zichanid+"-0"+i);
			}else{
				zichan.setZichanid(zichanid+"-"+i);
			}
			dao.add(zichan);
			TypedanDaoImpl typedanDao = new TypedanDao();
			typedan.setZichanid(zichan.getZichanid());
			typedan.setName(zichan.getName());
			typedan.setBeizhu(zichan.getBeizhu());
			typedan.setDanju(zichan.getDanjuhao());
			typedan.setNum(zichan.getNum());
			typedan.setPlace(zichan.getPlace());
			typedan.setGetdate(zichan.getDate());
			typedan.setUsedept(zichan.getDept());
			float price=0;
			if(!zichan.getJine().isEmpty()){
				typedan.setPrice(Float.parseFloat(zichan.getJine()));
			}else{	
				typedan.setPrice(price);
			}
			float jine = typedan.getPrice()*typedan.getNum();
			typedan.setJine(jine);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			typedan.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
			typedan.setChulitype("新增");
			typedanDao.addTypedan(typedan);
		}
	    return this.showAction();
	}
	
	//获取需要修改的参数
	public String updateAction()
	{
		//修改zichan表
		zichan = dao.update(zichan.getId());
		//修改typedan表
		TypedanDaoImpl typedanDao = new TypedanDao();
		//listzichan = dao.quanxian();
		listzichan = dao.showDeptInfo();
		return this.showAction();
	}
	
	
	//获取需要报销的参数
	public String baoxiaoAction()
	{
		zichan = dao.update(zichan.getId());
		return this.showAction();
	}
	
	//执行修改信息
	public String executeUpdateAction()
	{
		dao.executeUpdate(zichan);
		typedan.setZichanid(zichan.getZichanid());
		typedan.setName(zichan.getName());
		typedan.setBeizhu(zichan.getBeizhu());
		typedan.setDanju(zichan.getDanjuhao());
		typedan.setNum(zichan.getNum());
		typedan.setPlace(zichan.getPlace());
		typedan.setGetdate(zichan.getDate());
		typedan.setUsedept(zichan.getDept());
		typedan.setChulitype("新增");
		float price=0;
		if(!zichan.getJine().isEmpty()){
			typedan.setPrice(Float.parseFloat(zichan.getJine()));
		}else{	
			typedan.setPrice(price);
		}
		float jine = typedan.getPrice()*typedan.getNum();
		typedan.setJine(jine);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		typedan.setOperatedate(df.format(new Date()));// new Date()为获取当前系统时间
		typedanDao.updateTypedan(typedan);
		return "success";
	}
	
	//批量修改信息
	public String executeUpdateAllAction(){
		dao.updateAll(zichan);
		return "success";
	}
	
	//执行报销修改
	public String executeBaoxiaoAction()
	{
		//创建setvlet设置当前页面为1/1
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("countPage", 1);
		request.setAttribute("currentPage", 1);
		dao.executeBaoxiao(zichan);
		list = dao.selectByFenye(" where id="+zichan.getId());
		return "success";
	}
	
	//执行批量报销修改
	public String executeBaoxiaoAllAction()
	{
		//创建setvlet设置当前页面为1/1
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("countPage", 1);
		request.setAttribute("currentPage", 1);
		//System.out.println(zichan.getDanjuhao()+"--"+zichan.getBaoxiao());
		int result = dao.executeBaoxiaoAll(zichan);
		if(result>0){
			list = dao.selectByFenye(" where danjuhao="+zichan.getDanjuhao());
		}
		return "success";
	}
	
	
	//删除一条记录
	public String deleteAction()
	{
		dao.delete(zichan.getId());
		return this.showAction();
	}

	//删除一条部门记录
	public String deleteDeptAction()
	{
		dao.deleteDept(dept.getId());
		return this.showDeptAction();
	}
	
	//删除一条资产类别记录
	public String deleteTypeAction()
	{
		//System.out.println(zichanType.getId());
		dao.deleteType(zichanType.getId());
		return this.showTypeAction();
	}
	
	
	
	public static String getTptype() {
		return tptype;
	}

	public static void setTptype(String tptype) {
		ZichanAction.tptype = tptype;
	}

	public static String getTptypecode() {
		return tptypecode;
	}

	public static void setTptypecode(String tptypecode) {
		ZichanAction.tptypecode = tptypecode;
	}

	public List<Zichan> getList()
	{
		return list;
	}

	public void setList(List<Zichan> list)
	{
		this.list = list;
	}

	public List<Dept> getListzichan() {
		return listzichan;
	}



	public ZichanType getZichanType() {
		return zichanType;
	}

	public void setZichanType(ZichanType zichanType) {
		this.zichanType = zichanType;
	}

	public void setListzichan(List<Dept> listzichan) {
		this.listzichan = listzichan;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}
	
	
}
