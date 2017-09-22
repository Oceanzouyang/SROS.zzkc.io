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
 * �������ɾ�Ĳ�
 * ������struts2.0��ʹ��
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
	
	
	
	
    //��ҳ
    public List<Zichan> queryFenye(int currentPage, int pageSize){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = " order by zichanid desc limit " + rowStart + ", " + pageSize;	//ÿ��ֻ���һҳ������
		list = dao.selectByFenye(condition);
    	return list;
    }
	
    //��ͨ�û���ҳ
    public List<Zichan> queryFenyeChoose(int currentPage, int pageSize,String choose){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = choose + " order by zichanid desc limit " + rowStart + ", " + pageSize;	//ÿ��ֻ���һҳ������
		list = dao.selectByFenye(condition);
    	return list;
    }
    
    
    //δ��˷�ҳ	
    public List<Zichan> queryShenheFenye(int currentPage, int pageSize){
    	List<Zichan> list = new ArrayList<Zichan>();
		int rowStart = (currentPage - 1) * pageSize;
		String condition = " limit " + rowStart + ", " + pageSize;	//ÿ��ֻ���һҳ������
		list = dao.selectByFenye(condition);
    	return list;
    }
    
    //��ѯ���ű�dept
    public String deptAction(){
    	listzichan = dao.showDeptInfo();
    	return "success";
    }
    
    //��Ӳ���
    public String addDeptAction(){
    	dao.addDept(dept);
    	return this.showDeptAction();
    }
    
    //����ʲ����
    public String addTypeAction(){
    	//System.out.println("��ʼ���"+zichanType.getId()+"--"+zichanType.getType()+"--"+zichanType.getTypecode());
    	if(!"".equals(zichanType.getType())&&!"".equals(zichanType.getClass())){
    		dao.addType(zichanType);
    	}else{
    		System.out.println("δ��������~~");
    	}
    	return this.showTypeAction();
    }
    
    //��ȡ�޸Ĳ��Ų���
	public String updateDeptAction()
	{
		dept = dao.updateDept(dept.getId());
		dpName = dept.getDeptname();
		return "success";
	}
    
	 //��ȡ�޸��ʲ�������
	public String updateTypeAction()
	{
		zichanType = dao.updateType(zichanType.getId());
		tptype = zichanType.getType();
		tptypecode = zichanType.getTypecode();
		return "success";
	}
	
	
	//��������ģ��ƥ�����
	public String querylikeNameAction(){
		String name = zichan.getName();
		list = dao.querylikeNameDao(name);
		return "";
	}
	
	//�޸Ĳ��Ų���
	public String executeDeptUpdateAction()
	{
		dao.executeDeptUpdate(dept.getDeptname(), dpName);
		dao.executeDeptUpdate(dept);
		return this.showDeptAction();
	}
	
	//�޸��ʲ����Ͳ���
	public String executeTypeUpdateAction()
	{
		dao.executeTypeUpdate(zichanType.getTypecode(),zichanType.getType(),tptypecode,tptype);
		dao.executeTypeUpdate(zichanType);
		return this.showTypeAction();
	}
	
    //��ʾ����
    public String showDeptAction()
	{
    	deptList = dao.showDeptInfo();
		return "success";
	}
    
    //��ʾ�ʲ����
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
                 sb.append("<td><a href='updateType.action?ZichanType.id="+zichanTypeList.get(i).getId()+" '/>"+zichanTypeList.get(i).getTypecode()+"</a>  "+zichanTypeList.get(i).getType()+"</td><td><a class='deleteType' id='"+zichanTypeList.get(i).getId()+"'>"+"ɾ��"+"</a></td>");
    		}else{
    			 sb.append("<td><a href='updateType.action?ZichanType.id="+zichanTypeList.get(i).getId()+" '/>"+zichanTypeList.get(i).getTypecode()+"</a>  "+zichanTypeList.get(i).getType()+"</td><td><a class='deleteType' id='"+zichanTypeList.get(i).getId()+"'>"+"ɾ��"+"</a></td>");
    		}
    		
		}
    	sb.append("</tr>");
    	ActionContext ctx = ActionContext.getContext();
    	content = "<table align='center' border='1'>"+sb+"</table>";
    	ctx.put("req", content);
    	//ctx.getSession().put("ses", "123");
//    	
//    	
//    	String sqlwhere = " type like '%��%'";
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
    
  //sqlwhere��ѯzichantype��
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
		obj.put("name", "����");
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
    
    //��ʾ������Ϣ
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

	//�������
	public String addAction()
	{
		listzichan = dao.showDeptInfo();
		return "success";
	}
	
	//�������
	public String addPiliangAction()
	{
		listzichan = dao.showDeptInfo();
		return "success";
	}
	
	//���
	public String shenheAction(){
		zichan.setShenhe(0);
		dao.shenheUpdate(zichan);
		return this.showAction();
	}
	
	//���
	public String cancelShenheAction(){
		zichan.setShenhe(1);
		dao.shenheUpdate(zichan);
		return this.showAction();
	}
	
	//���һ����¼
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		typedan.setOperatedate(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		typedan.setChulitype("����");
		typedanDao.addTypedan(typedan);
	    return this.showAction();
	}
	
	//���N����¼
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
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			typedan.setOperatedate(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
			typedan.setChulitype("����");
			typedanDao.addTypedan(typedan);
		}
	    return this.showAction();
	}
	
	//��ȡ��Ҫ�޸ĵĲ���
	public String updateAction()
	{
		//�޸�zichan��
		zichan = dao.update(zichan.getId());
		//�޸�typedan��
		TypedanDaoImpl typedanDao = new TypedanDao();
		//listzichan = dao.quanxian();
		listzichan = dao.showDeptInfo();
		return this.showAction();
	}
	
	
	//��ȡ��Ҫ�����Ĳ���
	public String baoxiaoAction()
	{
		zichan = dao.update(zichan.getId());
		return this.showAction();
	}
	
	//ִ���޸���Ϣ
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
		typedan.setChulitype("����");
		float price=0;
		if(!zichan.getJine().isEmpty()){
			typedan.setPrice(Float.parseFloat(zichan.getJine()));
		}else{	
			typedan.setPrice(price);
		}
		float jine = typedan.getPrice()*typedan.getNum();
		typedan.setJine(jine);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		typedan.setOperatedate(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		typedanDao.updateTypedan(typedan);
		return "success";
	}
	
	//�����޸���Ϣ
	public String executeUpdateAllAction(){
		dao.updateAll(zichan);
		return "success";
	}
	
	//ִ�б����޸�
	public String executeBaoxiaoAction()
	{
		//����setvlet���õ�ǰҳ��Ϊ1/1
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("countPage", 1);
		request.setAttribute("currentPage", 1);
		dao.executeBaoxiao(zichan);
		list = dao.selectByFenye(" where id="+zichan.getId());
		return "success";
	}
	
	//ִ�����������޸�
	public String executeBaoxiaoAllAction()
	{
		//����setvlet���õ�ǰҳ��Ϊ1/1
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
	
	
	//ɾ��һ����¼
	public String deleteAction()
	{
		dao.delete(zichan.getId());
		return this.showAction();
	}

	//ɾ��һ�����ż�¼
	public String deleteDeptAction()
	{
		dao.deleteDept(dept.getId());
		return this.showDeptAction();
	}
	
	//ɾ��һ���ʲ�����¼
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
