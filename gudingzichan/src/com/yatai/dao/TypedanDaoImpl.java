package com.yatai.dao;

import java.util.List;

import com.yatai.model.Typedan;
import com.yatai.model.typebaofei;
import com.yatai.model.typeweixiu;
import com.yatai.model.typezhuanyi;

public interface TypedanDaoImpl {

	//显示所有新增数据
	public abstract List<Typedan> QueryTypedansqlwhere(String sqlwhere);

	//显示所有转移数据
	public abstract List<typezhuanyi> Queryzhuanyisqlwhere(String sqlwhere);

	//显示所有维修数据
	public abstract List<typeweixiu> Queryweixiusqlwhere(String sqlwhere);

	//显示所有处置数据
	public abstract List<typebaofei> Querychuzhisqlwhere(String sqlwhere);

	//新增资产流转表
	public abstract int addTypedan(Typedan typedan);

	//修改新增资产流转表
	public abstract int updateTypedan(Typedan typedan);

	//新增资产流转转移
	public abstract int addZhuanyiTypedan(typezhuanyi zhuanyi);

	//新增资产流转维修
	public abstract int addweixiuTypedan(typeweixiu weixiu);

	//新增资产流转处置
	public abstract int addchuzhiTypedan(typebaofei chuzhi);

	//删除流转数据
	public abstract int delTypedan(String sqlwhere);

}