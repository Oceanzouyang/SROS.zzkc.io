package com.yatai.util;

import java.io.File;
import java.io.IOException;
import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excelread {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		File file = new File("e:\\2.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		//0代表第一个工作表对象
		Sheet sheet = workbook.getSheet(0);     
		//System.out.println(Integer.parseInt(sheet.getCell(0, 954).getContents().trim()));
		for (int i = 0; i < 27; i++) {
			Zichan zichan = new Zichan();
			//从第0行开始，如果第一行是标题，则改成i=1
			int k = Integer.parseInt(sheet.getCell(0, i).getContents().trim());
			//zichan.setXuhao(i+696);
			zichan.setXuhao(k);
			zichan.setZichanid(sheet.getCell(1, i).getContents().trim());
			//System.out.println(sheet.getCell(1, i).getContents().trim()+"==");
			zichan.setName(sheet.getCell(2, i).getContents().trim());
			zichan.setType(sheet.getCell(3, i).getContents().trim());
			zichan.setDanwei(sheet.getCell(4, i).getContents().trim());
			//zichan.setNum(Integer.parseInt(sheet.getCell(5, i).getContents().trim()));
			zichan.setNum(Float.parseFloat(sheet.getCell(5, i).getContents().trim()));
			zichan.setJine(sheet.getCell(6, i).getContents().trim());
			zichan.setDate(sheet.getCell(7, i).getContents().trim());
			zichan.setDept(sheet.getCell(8, i).getContents().trim());
			zichan.setPlace(sheet.getCell(9, i).getContents().trim());
			zichan.setUser(sheet.getCell(10, i).getContents().trim());
			zichan.setBaoguan(sheet.getCell(11, i).getContents().trim());
			zichan.setGongyingshang(sheet.getCell(12, i).getContents().trim());	
			zichan.setDanjuhao(sheet.getCell(13, i).getContents().trim());
			zichan.setBeizhu(sheet.getCell(14, i).getContents().trim());
			zichan.setPingzheng(sheet.getCell(15, i).getContents().trim());
			//zichan.setPingzheng("");
			zichan.setBaoxiao("");
			zichan.setStatus("使用");
			//System.out.println(sheet.getCell(1, i).getContents().trim());
			ZichanDao zichanDao = new ZichanDao();
			zichanDao.add(zichan);
		}
	}

}
