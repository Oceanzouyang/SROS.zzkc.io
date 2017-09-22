package com.yatai.util;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;

public class Excel {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub
		File file = new File("d:\\1.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		//0代表第一个工作表对象
		Sheet sheet = workbook.getSheet(0);     
		//System.out.println(Integer.parseInt(sheet.getCell(0, 954).getContents().trim()));
		for (int i = 0; i < 144; i++) {
			Zichan zichan = new Zichan();
			//从第0行开始，如果第一行是标题，则改成i=1
			int k = Integer.parseInt(sheet.getCell(0, i).getContents().trim());
			//zichan.setXuhao(i+696);
			//System.out.println(sheet.getCell(0, i).getContents().trim());
			zichan.setXuhao(k);
			zichan.setZichanid(sheet.getCell(1, i).getContents().trim());
			zichan.setName(sheet.getCell(2, i).getContents().trim());
			zichan.setType(sheet.getCell(3, i).getContents().trim());
			zichan.setDanwei(sheet.getCell(4, i).getContents().trim());
			zichan.setNum(Float.parseFloat(sheet.getCell(5, i).getContents().trim()));
			//System.out.println(sheet.getCell(5, i).getContents().trim());
			zichan.setJine(sheet.getCell(6, i).getContents().trim());
			zichan.setJitizhejiu(sheet.getCell(7, i).getContents().trim());
			zichan.setJingzhi(sheet.getCell(8, i).getContents().trim());
			zichan.setZhuanrudate(sheet.getCell(9, i).getContents().trim());
			zichan.setZhuanchudate(sheet.getCell(10, i).getContents().trim());
			zichan.setDate(sheet.getCell(11, i).getContents().trim());
			zichan.setDept(sheet.getCell(12, i).getContents().trim());
			zichan.setPlace(sheet.getCell(13, i).getContents().trim());
			zichan.setUser(sheet.getCell(14, i).getContents().trim());
			zichan.setBaoguan(sheet.getCell(15, i).getContents().trim());
			zichan.setZhuanchudept(sheet.getCell(16, i).getContents().trim());
			zichan.setZhuanchuplace(sheet.getCell(17, i).getContents().trim());
			zichan.setGongyingshang(sheet.getCell(18, i).getContents().trim());	
			zichan.setDanjuhao(sheet.getCell(19, i).getContents().trim());
			zichan.setBeizhu(sheet.getCell(20, i).getContents().trim());
			zichan.setPingzheng(sheet.getCell(21, i).getContents().trim());
			zichan.setBaoxiao("");
			zichan.setStatus("使用");
			ZichanDao zichanDao = new ZichanDao();
			System.out.println(i+"---");
			zichanDao.add(zichan);
		}
	}

}
