package com.yatai.action;
import java.util.ArrayList;
import java.util.List;

import com.yatai.dao.TypedanDao;
import com.yatai.dao.TypedanDaoImpl;
import com.yatai.model.*;

public class TypedanAction {
	Typedan typedan = new Typedan();
	TypedanDaoImpl typedanDao = new TypedanDao();
	List<Typedan> list = new ArrayList<Typedan>();
	String sqlwhere = "";
	public Typedan getTypedan() {
		return typedan;
	}
	public void setTypedan(Typedan typedan) {
		this.typedan = typedan;
	}
	public List<Typedan> getList() {
		return list;
	}
	public void setList(List<Typedan> list) {
		this.list = list;
	}
	
	
	public String getSqlwhere() {
		return sqlwhere;
	}
	public void setSqlwhere(String sqlwhere) {
		this.sqlwhere = sqlwhere;
	}
	//查询Typedan表
	public String QueryTypedansqlwhere(){
		list = typedanDao.QueryTypedansqlwhere(sqlwhere);
		return "success";
	}
	
	
	//新增资产流转
	public String addTypedanAction(){
		typedanDao.addTypedan(typedan);
		return "success";
	}
	
}
