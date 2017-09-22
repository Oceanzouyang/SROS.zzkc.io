package com.yatai.util;

import java.util.List;

import com.yatai.dao.ZichanDao;
import com.yatai.model.Zichan;

public abstract class tool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZichanDao zichanDao = new ZichanDao();
		List<Zichan> list =  zichanDao.showInfoChoose(" where zichanid like '%x%'");
		for (int i = 0; i < list.size(); i++) {
			String newStr = list.get(i).getZichanid().replaceAll("X","~X");
			String sqlwhere = "update zichan set zichanid='"+newStr+"' where zichanid='"+list.get(i).getZichanid()+"'";
			zichanDao.updateTool(sqlwhere);
			System.out.println(newStr);
		}
	}

}
