package com.yatai.dao;

import java.util.List;

import com.yatai.model.Typedan;
import com.yatai.model.typebaofei;
import com.yatai.model.typeweixiu;
import com.yatai.model.typezhuanyi;

public interface TypedanDaoImpl {

	//��ʾ������������
	public abstract List<Typedan> QueryTypedansqlwhere(String sqlwhere);

	//��ʾ����ת������
	public abstract List<typezhuanyi> Queryzhuanyisqlwhere(String sqlwhere);

	//��ʾ����ά������
	public abstract List<typeweixiu> Queryweixiusqlwhere(String sqlwhere);

	//��ʾ���д�������
	public abstract List<typebaofei> Querychuzhisqlwhere(String sqlwhere);

	//�����ʲ���ת��
	public abstract int addTypedan(Typedan typedan);

	//�޸������ʲ���ת��
	public abstract int updateTypedan(Typedan typedan);

	//�����ʲ���תת��
	public abstract int addZhuanyiTypedan(typezhuanyi zhuanyi);

	//�����ʲ���תά��
	public abstract int addweixiuTypedan(typeweixiu weixiu);

	//�����ʲ���ת����
	public abstract int addchuzhiTypedan(typebaofei chuzhi);

	//ɾ����ת����
	public abstract int delTypedan(String sqlwhere);

}