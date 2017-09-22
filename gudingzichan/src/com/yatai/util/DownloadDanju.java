package com.yatai.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;
import com.yatai.model.*;

public class DownloadDanju extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadDanju() {
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
		TypedanDaoImpl typedanDao = new TypedanDao();
		String choose = request.getParameter("choose");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String sqlwheretypdan = " where getdate>='"+start+"' and getdate<='"+end+"' ORDER BY getdate";
		String sqlwherezhuanyi = " where kaidandate>='"+start+"' and kaidandate<='"+end+"' ORDER BY kaidandate";
		String sqlwhereweixiu = " where dengjidate>='"+start+"' and dengjidate<='"+end+"' ORDER BY dengjidate";
		String sqlwherechuzhi = " where baofeidate>='"+start+"' and baofeidate<='"+end+"' ORDER BY baofeidate";
		List<Typedan> listdan = new ArrayList<Typedan>();
		List<typezhuanyi> listzhuanyi = new ArrayList<typezhuanyi>();
		List<typeweixiu> listweixiu = new ArrayList<typeweixiu>();
		List<typebaofei> listchuzhi = new ArrayList<typebaofei>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String fileName= "�̶��ʲ�"+df.format(new Date());
		String xlsFile = fileName+".xls"; //������Excel�ļ�������		
		if(choose.equals("����")){
			listdan = typedanDao.QueryTypedansqlwhere(sqlwheretypdan);
			HSSFWorkbook workbook = new HSSFWorkbook(); //��������������
			HSSFSheet sheet = workbook.createSheet(); //�������������,���õ�һ�������������ΪfirstSheet//Ϊ�˹�������֧�����ģ������ַ�����ΪUTF_16
			workbook.setSheetName(0,"firstSheet");//����һ��
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell = row.createCell(0);
				//cell.setCellValue("�̶��ʲ�");
				//row = sheet.createRow(1);
				cell = row.createCell(0);
				cell.setCellValue("�ʲ����");
				cell = row.createCell(1);
				cell.setCellValue("����");
				cell = row.createCell(2);
				cell.setCellValue("���ݺ�");
				cell = row.createCell(3);
				cell.setCellValue("����");
				cell = row.createCell(4);
				cell.setCellValue("����");
				cell = row.createCell(5);
				cell.setCellValue("���");
				cell = row.createCell(6);
				cell.setCellValue("����ʱ��");
				cell = row.createCell(7);
				cell.setCellValue("��ŵص�");
				cell = row.createCell(8);
				cell.setCellValue("ʹ�ò���");
				cell = row.createCell(9);
				cell.setCellValue("��ע");
				cell = row.createCell(10);
				cell.setCellValue("��������");
				cell = row.createCell(10);
				cell.setCellValue("����ʱ��");
				float xinzengsum = 0;
				float xinzengnum = 0;
				for (int i = 0; i < listdan.size(); i++) {
					HSSFRow circle = sheet.createRow(i+1);
			  		cell = circle.createCell(0);
			  		//����ѭ���к���
			  		cell.setCellValue(listdan.get(i).getZichanid());
			  		cell = circle.createCell(1);
			  		cell.setCellValue(listdan.get(i).getName());
			  		cell = circle.createCell(2);
			  		cell.setCellValue(listdan.get(i).getDanju());
			  		cell = circle.createCell(3);
			  		cell.setCellValue(listdan.get(i).getPrice());
			  		cell = circle.createCell(4);
			  		cell.setCellValue(listdan.get(i).getNum());
			  		cell = circle.createCell(5);
			  		cell.setCellValue(listdan.get(i).getJine());
			  		cell = circle.createCell(6);
			  		cell.setCellValue(listdan.get(i).getGetdate());
			  		cell = circle.createCell(7);
			  		cell.setCellValue(listdan.get(i).getPlace());
			  		cell = circle.createCell(8);
			  		cell.setCellValue(listdan.get(i).getUsedept());
			  		cell = circle.createCell(9);
			  		cell.setCellValue(listdan.get(i).getBeizhu());
			  		cell = circle.createCell(10);
			  		cell.setCellValue(listdan.get(i).getChulitype());
			  		cell = circle.createCell(11);
			  		cell.setCellValue(listdan.get(i).getOperatedate());
			  		xinzengsum = xinzengsum + listdan.get(i).getJine();
			  		xinzengnum = xinzengnum + listdan.get(i).getNum();
				}
				row = sheet.createRow(listdan.size()+2);	
				cell = row.createCell(0);
				cell.setCellValue("�ϼƣ�");
				cell = row.createCell(4);
				cell.setCellValue(xinzengnum);
				cell = row.createCell(5);
				cell.setCellValue(xinzengsum);
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
		if(choose.equals("ת��")){
			listzhuanyi = typedanDao.Queryzhuanyisqlwhere(sqlwherezhuanyi);
			HSSFWorkbook workbook = new HSSFWorkbook(); //��������������
			HSSFSheet sheet = workbook.createSheet(); //�������������,���õ�һ�������������ΪfirstSheet//Ϊ�˹�������֧�����ģ������ַ�����ΪUTF_16
			workbook.setSheetName(0,"firstSheet");//����һ��
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell = row.createCell(0);
				//cell.setCellValue("�̶��ʲ�");
				//row = sheet.createRow(1);
				cell = row.createCell(0);
				cell.setCellValue("�ʲ����");
				cell = row.createCell(1);
				cell.setCellValue("����");
				cell = row.createCell(2);
				cell.setCellValue("���ݺ�");
				cell = row.createCell(3);
				cell.setCellValue("ת������");
				cell = row.createCell(4);
				cell.setCellValue("��λ");
				cell = row.createCell(5);
				cell.setCellValue("����");
				cell = row.createCell(6);
				cell.setCellValue("ԭʼ���");
				cell = row.createCell(7);
				cell.setCellValue("�۾�");
				cell = row.createCell(8);
				cell.setCellValue("��ֵ");
				cell = row.createCell(9);
				cell.setCellValue("��������");
				cell = row.createCell(10);
				cell.setCellValue("ת�벿��");
				cell = row.createCell(11);
				cell.setCellValue("ת��ص�");
				cell = row.createCell(12);
				cell.setCellValue("ת������");
				cell = row.createCell(13);
				cell.setCellValue("ת���ص�");
				cell = row.createCell(14);
				cell.setCellValue("��������");
				cell = row.createCell(15);
				cell.setCellValue("����ʱ��");
				float zhuanyinum = 0;
				float jinesum = 0;
				float zhejiusum = 0;
				float jingzhisum = 0;
				for (int i = 0; i < listzhuanyi.size(); i++) {
					HSSFRow circle = sheet.createRow(i+1);
			  		cell = circle.createCell(0);
			  		//����ѭ���к���
			  		cell.setCellValue(listzhuanyi.get(i).getZichanid());
			  		cell = circle.createCell(1);
			  		cell.setCellValue(listzhuanyi.get(i).getName());
			  		cell = circle.createCell(2);
			  		cell.setCellValue(listzhuanyi.get(i).getDanju());
			  		cell = circle.createCell(3);
			  		cell.setCellValue(listzhuanyi.get(i).getKaidandate());
			  		cell = circle.createCell(4);
			  		cell.setCellValue(listzhuanyi.get(i).getDanwei());
			  		cell = circle.createCell(5);
			  		cell.setCellValue(listzhuanyi.get(i).getNum());
			  		cell = circle.createCell(6);
			  		cell.setCellValue(listzhuanyi.get(i).getYuanshijine());
			  		cell = circle.createCell(7);
			  		cell.setCellValue(listzhuanyi.get(i).getZhejiu());
			  		cell = circle.createCell(8);
			  		cell.setCellValue(listzhuanyi.get(i).getJinzhi());
			  		cell = circle.createCell(9);
			  		cell.setCellValue(listzhuanyi.get(i).getRuzhuangdate());
			  		cell = circle.createCell(10);
			  		cell.setCellValue(listzhuanyi.get(i).getZhuanrudept());
			  		cell = circle.createCell(11);
			  		cell.setCellValue(listzhuanyi.get(i).getZhuanruplace());
			  		cell = circle.createCell(12);
			  		cell.setCellValue(listzhuanyi.get(i).getZhuanchudept());
			  		cell = circle.createCell(13);
			  		cell.setCellValue(listzhuanyi.get(i).getZhuanchuplace());
			  		cell = circle.createCell(14);
			  		cell.setCellValue(listzhuanyi.get(i).getChulitype());
			  		cell = circle.createCell(15);
			  		cell.setCellValue(listzhuanyi.get(i).getOperatedate());
			  		jinesum = jinesum + listzhuanyi.get(i).getYuanshijine();
			  		zhejiusum = zhejiusum + listzhuanyi.get(i).getZhejiu();
			  		jingzhisum = jingzhisum + listzhuanyi.get(i).getJinzhi();
			  		zhuanyinum = zhuanyinum + listzhuanyi.get(i).getNum();
				}
				row = sheet.createRow(listzhuanyi.size()+2);	
				cell = row.createCell(0);
				cell.setCellValue("�ϼƣ�");
				cell = row.createCell(5);
				cell.setCellValue(zhuanyinum);
				cell = row.createCell(6);
				cell.setCellValue(jinesum);
				cell = row.createCell(7);
				cell.setCellValue(zhejiusum);
				cell = row.createCell(8);
				cell.setCellValue(jingzhisum);
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
		if(choose.equals("ά��")){
			listweixiu = typedanDao.Queryweixiusqlwhere(sqlwhereweixiu);
			HSSFWorkbook workbook = new HSSFWorkbook(); //��������������
			HSSFSheet sheet = workbook.createSheet(); //�������������,���õ�һ�������������ΪfirstSheet//Ϊ�˹�������֧�����ģ������ַ�����ΪUTF_16
			workbook.setSheetName(0,"firstSheet");//����һ��
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell = row.createCell(0);
				//cell.setCellValue("�̶��ʲ�");
				//row = sheet.createRow(1);
				cell = row.createCell(0);
				cell.setCellValue("�ʲ����");
				cell = row.createCell(1);
				cell.setCellValue("����");
				cell = row.createCell(2);
				cell.setCellValue("���ݺ�");
				cell = row.createCell(3);
				cell.setCellValue("ά�޲���");
				cell = row.createCell(4);
				cell.setCellValue("���޲���");
				cell = row.createCell(5);
				cell.setCellValue("����");
				cell = row.createCell(6);
				cell.setCellValue("ά�޼۸�");
				cell = row.createCell(7);
				cell.setCellValue("ά������");
				cell = row.createCell(8);
				cell.setCellValue("�Ǽ�����");
				cell = row.createCell(9);
				cell.setCellValue("��������");
				cell = row.createCell(10);
				cell.setCellValue("����ʱ��");
				float weixiusum = 0;
				for (int i = 0; i < listweixiu.size(); i++) {
					HSSFRow circle = sheet.createRow(i+1);
			  		cell = circle.createCell(0);
			  		//����ѭ���к���
			  		cell.setCellValue(listweixiu.get(i).getZichanid());
			  		cell = circle.createCell(1);
			  		cell.setCellValue(listweixiu.get(i).getWeixiuname());
			  		cell = circle.createCell(2);
			  		cell.setCellValue(listweixiu.get(i).getDanju());
			  		cell = circle.createCell(3);
			  		cell.setCellValue(listweixiu.get(i).getWeixiudept());
			  		cell = circle.createCell(4);
			  		cell.setCellValue(listweixiu.get(i).getBaoxiudept());
			  		cell = circle.createCell(5);
			  		cell.setCellValue(listweixiu.get(i).getNum());
			  		cell = circle.createCell(6);
			  		cell.setCellValue(listweixiu.get(i).getPrice());
			  		cell = circle.createCell(7);
			  		cell.setCellValue(listweixiu.get(i).getWeixiudate());
			  		cell = circle.createCell(8);
			  		cell.setCellValue(listweixiu.get(i).getWeixiudate());
			  		cell = circle.createCell(9);
			  		cell.setCellValue(listweixiu.get(i).getChulitype());
			  		cell = circle.createCell(10);
			  		cell.setCellValue(listweixiu.get(i).getOperatedate());
			  		weixiusum = weixiusum + listweixiu.get(i).getPrice();
				}
				row = sheet.createRow(listweixiu.size()+2);	
				cell = row.createCell(0);
				cell.setCellValue("�ϼƣ�");
				cell = row.createCell(6);
				cell.setCellValue(weixiusum);
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
		if(choose.equals("����")){
			listchuzhi = typedanDao.Querychuzhisqlwhere(sqlwherechuzhi);
			HSSFWorkbook workbook = new HSSFWorkbook(); //��������������
			HSSFSheet sheet = workbook.createSheet(); //�������������,���õ�һ�������������ΪfirstSheet//Ϊ�˹�������֧�����ģ������ַ�����ΪUTF_16
			workbook.setSheetName(0,"firstSheet");//����һ��
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell = row.createCell(0);
				//cell.setCellValue("�̶��ʲ�");
				//row = sheet.createRow(1);
				cell = row.createCell(0);
				cell.setCellValue("�ʲ����");
				cell = row.createCell(1);
				cell.setCellValue("����");
				cell = row.createCell(2);
				cell.setCellValue("���ݺ�");
				cell = row.createCell(3);
				cell.setCellValue("�������");
				cell = row.createCell(4);
				cell.setCellValue("��λ");
				cell = row.createCell(5);
				cell.setCellValue("����");
				cell = row.createCell(6);
				cell.setCellValue("���");
				cell = row.createCell(7);
				cell.setCellValue("��������");
				cell = row.createCell(8);
				cell.setCellValue("ʹ�ò���");
				cell = row.createCell(9);
				cell.setCellValue("��ʾ����");
				cell = row.createCell(10);
				cell.setCellValue("��������");
				cell = row.createCell(11);
				cell.setCellValue("���ý��");
				cell = row.createCell(12);
				cell.setCellValue("��������");
				cell = row.createCell(13);
				cell.setCellValue("����ʱ��");
				float chuzhisum = 0;
				float jinesum = 0;
				for (int i = 0; i < listchuzhi.size(); i++) {
					HSSFRow circle = sheet.createRow(i+1);
			  		cell = circle.createCell(0);
			  		//����ѭ���к���
			  		cell.setCellValue(listchuzhi.get(i).getZichanid());
			  		cell = circle.createCell(1);
			  		cell.setCellValue(listchuzhi.get(i).getName());
			  		cell = circle.createCell(2);
			  		cell.setCellValue(listchuzhi.get(i).getDanju());
			  		cell = circle.createCell(3);
			  		cell.setCellValue(listchuzhi.get(i).getType());
			  		cell = circle.createCell(4);
			  		cell.setCellValue(listchuzhi.get(i).getDanwei());
			  		cell = circle.createCell(5);
			  		cell.setCellValue(listchuzhi.get(i).getNum());
			  		cell = circle.createCell(6);
			  		cell.setCellValue(listchuzhi.get(i).getJine());
			  		cell = circle.createCell(7);
			  		cell.setCellValue(listchuzhi.get(i).getRuzhangdate());
			  		cell = circle.createCell(8);
			  		cell.setCellValue(listchuzhi.get(i).getDept());
			  		cell = circle.createCell(9);
			  		cell.setCellValue(listchuzhi.get(i).getQingshidate());
			  		cell = circle.createCell(10);
			  		cell.setCellValue(listchuzhi.get(i).getBaofeidate());
			  		cell = circle.createCell(11);
			  		cell.setCellValue(listchuzhi.get(i).getBaofeijine());
			  		cell = circle.createCell(12);
			  		cell.setCellValue(listchuzhi.get(i).getChulitype());
			  		cell = circle.createCell(13);
			  		cell.setCellValue(listchuzhi.get(i).getOperatedate());
			  		jinesum = jinesum + listchuzhi.get(i).getJine();
			  		chuzhisum = chuzhisum + listchuzhi.get(i).getBaofeijine();
				}
				row = sheet.createRow(listchuzhi.size()+2);	
				cell = row.createCell(0);
				cell.setCellValue("�ϼƣ�");
				cell = row.createCell(6);
				cell.setCellValue(jinesum);
				cell = row.createCell(10);
				cell.setCellValue(chuzhisum);
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
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		//out.println("");
		//out.flush();
		//out.close();
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
