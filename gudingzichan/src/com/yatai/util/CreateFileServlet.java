package com.yatai.util;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;

public class CreateFileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CreateFileServlet() {
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
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println("count=="+count);
		String dept = request.getParameter("dept");
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String baoguan = request.getParameter("baoguan");
		String user = request.getParameter("user");
		String status = request.getParameter("status");
		String zichanid = request.getParameter("zichanid");
		if(count==1){
			request.getSession().setAttribute("namese", name);
			request.getSession().setAttribute("deptse", dept);
			request.getSession().setAttribute("placese", place);
			request.getSession().setAttribute("baoguanse", baoguan);
			request.getSession().setAttribute("userse", user);
			request.getSession().setAttribute("statusse", status);
		}
		name = (String) request.getSession().getAttribute("namese");
		dept = (String) request.getSession().getAttribute("deptse");
		place = (String) request.getSession().getAttribute("placese");
		baoguan = (String) request.getSession().getAttribute("baoguanse");
		user = (String) request.getSession().getAttribute("userse");
		status = (String) request.getSession().getAttribute("statusse");
		System.out.println(name+"--"+place+"--"+dept+"--"+baoguan+"--"+user+"--"+status+"--"+zichanid);
		String condition = " where ";
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
		
		if(condition.substring(condition.length()-4, condition.length()-1).equals("and")){
			condition = condition.substring(0, condition.length()-4);
		}
		ZichanDao zichanDao = new ZichanDao();
		System.out.println("����=="+condition);
		List<Zichan> list = zichanDao.selectByFenye(condition);
		if(list.size()>0){
			request.getSession().setAttribute("Dlist", list);
		}
		System.out.println("׼����ӡ"+list.size()+"��");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//��ȡ��ǰʱ����Ϊ�ļ�����
	    //String fileName= df.format(new Date()).substring(0,10);
	    String fileName= "�̶��ʲ�"+df.format(new Date());
		String xlsFile = fileName+".xls"; //������Excel�ļ�������
		HSSFWorkbook workbook = new HSSFWorkbook(); //��������������
		HSSFSheet sheet = workbook.createSheet(); //�������������,���õ�һ�������������ΪfirstSheet//Ϊ�˹�������֧�����ģ������ַ�����ΪUTF_16
		  workbook.setSheetName(0,"firstSheet");//����һ��
		  HSSFRow row = sheet.createRow(0);
		  HSSFCell cell = row.createCell(0);
		  //cell.setCellValue("�̶��ʲ�");
		  //row = sheet.createRow(1);
		  cell = row.createCell(0);
		  cell.setCellValue("���");
		  cell = row.createCell(1);
		  cell.setCellValue("���");
		  cell = row.createCell(2);
		  cell.setCellValue("����");
		  cell = row.createCell(3);
		  cell.setCellValue("����ͺ�");
		  cell = row.createCell(4);
		  cell.setCellValue("��λ");
		  cell = row.createCell(5);
		  cell.setCellValue("����");
		  cell = row.createCell(6);
		  cell.setCellValue("ԭֵ");
		  cell = row.createCell(7);
		  cell.setCellValue("�����۾�");
		  cell = row.createCell(8);
		  cell.setCellValue("��ֵ");
		  cell = row.createCell(9);
		  cell.setCellValue("ת��ʱ��");
		  cell = row.createCell(10);
		  cell.setCellValue("ת��ʱ��");
		  cell = row.createCell(11);
		  cell.setCellValue("��������");
		  cell = row.createCell(12);
		  cell.setCellValue("ʹ�ò���");
		  cell = row.createCell(13);
		  cell.setCellValue("��ŵص�");
		  cell = row.createCell(14);
		  cell.setCellValue("ʹ����");
		  cell = row.createCell(15);
		  cell.setCellValue("������");
		  cell = row.createCell(16);
		  cell.setCellValue("ת������");
		  cell = row.createCell(17);
		  cell.setCellValue("ת���ص�");
		  cell = row.createCell(18);
		  cell.setCellValue("��Ӧ��");
		  cell = row.createCell(19);
		  cell.setCellValue("��ע");
		  cell = row.createCell(20);
		  cell.setCellValue("ƾ֤");
		  cell = row.createCell(21);
		  cell.setCellValue("״̬");
		  
//			String a = "35";
//			String b = "";
//			//String chuku = "XS2014 0411 042113";
//			//String chu = "XS201407";
//			Random random = new Random();
//			for (int j = 0; j < 65000; j++) {
//				int c = random.nextInt(2)+1;
//			//	chu = "XS201407";
//				a="35";
//				b="";
//				for (int i = 0; i < 13; i++) {
//					b= b + random.nextInt(10);
//				//	b = b+c+""+random.nextInt(10)+""+random.nextInt(2)+""+random.nextInt(10)+""+random.nextInt(5)+""+random.nextInt(10)+""+random.nextInt(5)+""+random.nextInt(10);		
//				}
//				a = a+b;
//			//	chu = chu + b;
//				System.out.println(a);
//				//System.out.println(chu);
//				  HSSFRow circle = sheet.createRow(j);
//		  			cell = circle.createCell(0);
//		  			//����ѭ���к���
//		  			cell.setCellValue(a);
//		  			cell = circle.createCell(1);
//			}
		  
		  
		  //list = (List<Zichan>) request.getSession().getAttribute("Dlist");
			  for (int i = 0; i < list.size(); i++) {
				  HSSFRow circle = sheet.createRow(i+1);
		  			cell = circle.createCell(0);
		  			//����ѭ���к���
		  			cell.setCellValue(list.get(i).getXuhao());
		  			cell = circle.createCell(1);
		  			cell.setCellValue(list.get(i).getZichanid());
		  			cell = circle.createCell(2);
		  			cell.setCellValue(list.get(i).getName());
		  			cell = circle.createCell(3);
		  			cell.setCellValue(list.get(i).getType());
		  			cell = circle.createCell(4);
		  			cell.setCellValue(list.get(i).getDanwei());
		  			cell = circle.createCell(5);
		  			cell.setCellValue(list.get(i).getNum());
		  			cell = circle.createCell(6);
		  			cell.setCellValue(list.get(i).getJine());
		  			cell = circle.createCell(7);
		  			cell.setCellValue(list.get(i).getJitizhejiu());
		  			cell = circle.createCell(8);
		  			cell.setCellValue(list.get(i).getJingzhi());
		  			cell = circle.createCell(9);
		  			cell.setCellValue(list.get(i).getZhuanrudate());
		  			cell = circle.createCell(10);
		  			cell.setCellValue(list.get(i).getZhuanchudate());
		  			cell = circle.createCell(11);
		  			cell.setCellValue(list.get(i).getDate());
		  			cell = circle.createCell(12);
		  			cell.setCellValue(list.get(i).getDept());
		  			cell = circle.createCell(13);
		  			cell.setCellValue(list.get(i).getPlace());
		  			cell = circle.createCell(14);
		  			cell.setCellValue(list.get(i).getUser());
		  			cell = circle.createCell(15);
		  			cell.setCellValue(list.get(i).getBaoguan());
		  			cell = circle.createCell(16);
		  			cell.setCellValue(list.get(i).getZhuanchudept());
		  			cell = circle.createCell(17);
		  			cell.setCellValue(list.get(i).getZhuanchuplace());
		  			cell = circle.createCell(18);
		  			cell.setCellValue(list.get(i).getGongyingshang());
		  			cell = circle.createCell(19);
		  			cell.setCellValue(list.get(i).getBeizhu());
		  			cell = circle.createCell(20);
		  			cell.setCellValue(list.get(i).getPingzheng());
		  			cell = circle.createCell(21);
		  			cell.setCellValue(list.get(i).getStatus());
		  			cell = circle.createCell(22);
				}
		  	  request.setAttribute("count", 2);
			  //�ŵ������ļ��ĸ�Ŀ¼��
			  FileOutputStream fOut = new FileOutputStream("e:/downloadGudingzichan/"+xlsFile);
				     workbook.write(fOut);
				     fOut.flush();
				     fOut.close();
				     // System.out.println("�ļ�����...");
				     //��������ȡ���ɵ�Excel�ļ�����
					 response.setHeader("Content-Disposition","attachment;filename="+xlsFile);//ָ�����ص��ļ���
					 response.setContentType("application/vnd.ms-excel");
					 response.setHeader("Pragma", "no-cache");
					 response.setHeader("Cache-Control", "no-cache");
					 response.setDateHeader("Expires", 0);
					 OutputStream output = response.getOutputStream();
					 BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
					 try {
						 bufferedOutPut.flush();
						 workbook.write(bufferedOutPut);
						 bufferedOutPut.close();
					 }catch(IOException e){
						 e.printStackTrace();
						 System.out.println( "Output   is   closed ");
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
