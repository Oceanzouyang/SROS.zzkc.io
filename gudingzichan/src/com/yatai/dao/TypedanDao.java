package com.yatai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yatai.model.*;
import com.yatai.util.JDBCTemplate;

public class TypedanDao implements TypedanDaoImpl {
	JDBCTemplate jdbc = new JDBCTemplate();
	
	//显示所有新增数据
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#QueryTypedansqlwhere(java.lang.String)
	 */
    @Override
	public List<Typedan> QueryTypedansqlwhere(String sqlwhere)
    {
    	String sql = "select * from typedan "+sqlwhere;
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<Typedan> list = new ArrayList<Typedan>();
    	try
		{
			while(rs.next())
			{
				Typedan typedan = new Typedan();
				typedan.setId(rs.getInt(1));
				typedan.setZichanid(rs.getString(2));
				typedan.setName(rs.getString(3));
				typedan.setNum(rs.getFloat(4));
				typedan.setJine(rs.getFloat(5));
				typedan.setPlace(rs.getString(6));
				typedan.setPrice(rs.getFloat(7));
				typedan.setBeizhu(rs.getString(8));
				typedan.setChulitype(rs.getString(9));
				typedan.setDanju(rs.getString(10));
				typedan.setGetdate(rs.getString(11));
				typedan.setOperatedate(rs.getString(12));
				typedan.setUsedept(rs.getString(13));
				list.add(typedan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
  //显示所有转移数据
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#Queryzhuanyisqlwhere(java.lang.String)
	 */
    @Override
	public List<typezhuanyi> Queryzhuanyisqlwhere(String sqlwhere)
    {
    	String sql = "select * from typezhuanyi "+sqlwhere;
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<typezhuanyi> list = new ArrayList<typezhuanyi>();
    	try
		{
			while(rs.next())
			{
				typezhuanyi zhuanyi = new typezhuanyi();
				zhuanyi.setId(rs.getInt(1));
				zhuanyi.setZichanid(rs.getString(2));
				zhuanyi.setName(rs.getString(3));
				zhuanyi.setKaidandate(rs.getString(4));
				zhuanyi.setDanwei(rs.getString(5));			
				zhuanyi.setNum(rs.getFloat(6));
				zhuanyi.setYuanshijine(rs.getFloat(7));
				zhuanyi.setZhejiu(rs.getFloat(8));
				zhuanyi.setJinzhi(rs.getFloat(9));
				zhuanyi.setRuzhuangdate(rs.getString(10));
				zhuanyi.setZhuanrudept(rs.getString(11));
				zhuanyi.setZhuanruplace(rs.getString(12));
				zhuanyi.setZhuanchudept(rs.getString(13));
				zhuanyi.setZhuanchuplace(rs.getString(14));
				zhuanyi.setChulitype(rs.getString(15));
				zhuanyi.setDanju(rs.getString(16));
				zhuanyi.setOperatedate(rs.getString(17));
				list.add(zhuanyi);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
  //显示所有维修数据
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#Queryweixiusqlwhere(java.lang.String)
	 */
    @Override
	public List<typeweixiu> Queryweixiusqlwhere(String sqlwhere)
    {
    	String sql = "select * from typeweixiu "+sqlwhere;
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<typeweixiu> list = new ArrayList<typeweixiu>();
    	try
		{
			while(rs.next())
			{
				typeweixiu weixiu = new typeweixiu();
				weixiu.setId(rs.getInt(1));
				weixiu.setWeixiudept(rs.getString(2));
				weixiu.setBaoxiudept(rs.getString(3));
				weixiu.setZichanid(rs.getString(4));
				weixiu.setWeixiuname(rs.getString(5));	
				weixiu.setNum(rs.getFloat(6));
				weixiu.setPrice(rs.getFloat(7));
				weixiu.setWeixiudate(rs.getString(8));
				weixiu.setDengjidate(rs.getString(9));
				weixiu.setDanju(rs.getString(10));
				weixiu.setChulitype(rs.getString(11));
				weixiu.setOperatedate(rs.getString(12));
				weixiu.setWeixiucontent(rs.getString(13));
				list.add(weixiu);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
  //显示所有处置数据
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#Querychuzhisqlwhere(java.lang.String)
	 */
    @Override
	public List<typebaofei> Querychuzhisqlwhere(String sqlwhere)
    {
    	String sql = "select * from typebaofei "+sqlwhere;
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<typebaofei> list = new ArrayList<typebaofei>();
    	try
		{
			while(rs.next())
			{
				typebaofei baofei = new typebaofei();
				baofei.setId(rs.getInt(1));
				baofei.setZichanid(rs.getString(2));
				baofei.setName(rs.getString(3));	
				baofei.setDanwei(rs.getString(4));
				baofei.setNum(rs.getFloat(5));
				baofei.setJine(rs.getFloat(6));
				baofei.setRuzhangdate(rs.getString(7));
				baofei.setDept(rs.getString(8));
				baofei.setBaofeidate(rs.getString(9));
				baofei.setBaofei(rs.getString(10));
				baofei.setBaofeijine(rs.getFloat(11));
				baofei.setChulitype(rs.getString(12));
				baofei.setDanju(rs.getString(13));
				baofei.setOperatedate(rs.getString(14));
				baofei.setType(rs.getString(15));
				baofei.setQingshidate(rs.getString(16));
				list.add(baofei);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
    //新增资产流转表
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#addTypedan(com.yatai.model.Typedan)
	 */
    @Override
	public int addTypedan(Typedan typedan)
    {
    	String sql = "insert into typedan(zichanid,name,num,jine,place,price,beizhu,chulitype,danju,getdate,operatedate,usedept) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    	return jdbc.executeUpdate(sql, new String[]{typedan.getZichanid(),typedan.getName(),typedan.getNum()+"",typedan.getJine()+"",typedan.getPlace(),typedan.getPrice()+"",typedan.getBeizhu(),typedan.getChulitype(),typedan.getDanju(),typedan.getGetdate(),typedan.getOperatedate(),typedan.getUsedept()});
    }
    
    //修改新增资产流转表
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#updateTypedan(com.yatai.model.Typedan)
	 */
    @Override
	public int updateTypedan(Typedan typedan){
    	String sql ="update typedan set name=?,num=?,jine=?,place=?,price=?,beizhu=?,chulitype=?,danju=?,getdate=?,operatedate=?,usedept=? where zichanid=?";
    	return jdbc.executeUpdate(sql, new String[]{typedan.getName(),typedan.getNum()+"",typedan.getJine()+"",typedan.getPlace(),typedan.getPrice()+"",typedan.getBeizhu(),typedan.getChulitype(),typedan.getDanju(),typedan.getGetdate(),typedan.getOperatedate(),typedan.getUsedept(),typedan.getZichanid()});
    	
    }
    
    //新增资产流转转移
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#addZhuanyiTypedan(com.yatai.model.typezhuanyi)
	 */
    @Override
	public int addZhuanyiTypedan(typezhuanyi zhuanyi)
    {
    	String sql = "insert into typezhuanyi(zichanid,name,kaidandate,danwei,num,yuanshijine,zhejiu,jinzhi,ruzhangdate,zhuanrudept,zhuanruplace,zhuanchudept,zhuanchuplace,chulitype,danju,operatedate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{zhuanyi.getZichanid(),zhuanyi.getName(),zhuanyi.getKaidandate(),zhuanyi.getDanwei(),zhuanyi.getNum()+"",zhuanyi.getYuanshijine()+"",zhuanyi.getZhejiu()+"",zhuanyi.getJinzhi()+"",zhuanyi.getRuzhuangdate(),zhuanyi.getZhuanrudept(),zhuanyi.getZhuanruplace(),zhuanyi.getZhuanchudept(),zhuanyi.getZhuanchuplace(),zhuanyi.getChulitype(),zhuanyi.getDanju(),zhuanyi.getOperatedate()});
    }
    
    
    //新增资产流转维修
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#addweixiuTypedan(com.yatai.model.typeweixiu)
	 */
    @Override
	public int addweixiuTypedan(typeweixiu weixiu)
    {
    	String sql = "insert into typeweixiu(zichanid,weixiuname,weixiudept,baoxiudept,num,price,weixiudate,dengjidate,danju,chulitype,operatedate,weixiucontent) values(?,?,?,?,?,?,?,?,?,?,?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{weixiu.getZichanid(),weixiu.getWeixiuname(),weixiu.getWeixiudept(),weixiu.getBaoxiudept(),weixiu.getNum()+"",weixiu.getPrice()+"",weixiu.getWeixiudate(),weixiu.getDengjidate(),weixiu.getDanju(),weixiu.getChulitype(),weixiu.getOperatedate(),weixiu.getWeixiucontent()});
    }
    
    
    //新增资产流转处置
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#addchuzhiTypedan(com.yatai.model.typebaofei)
	 */
    @Override
	public int addchuzhiTypedan(typebaofei chuzhi)
    {
    	System.out.println(chuzhi.getQingshidate());
    	String sql = "insert into typebaofei(zichanid,name,type,danwei,num,jine,ruzhangdate,dept,baofeidate,baofei,baofeijine,chulitype,danju,operatedate,qingshidate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{chuzhi.getZichanid(),chuzhi.getName(),chuzhi.getType(),chuzhi.getDanwei(),chuzhi.getNum()+"",chuzhi.getJine()+"",chuzhi.getRuzhangdate(),chuzhi.getDept(),chuzhi.getBaofeidate(),chuzhi.getBaofei(),chuzhi.getBaofeijine()+"",chuzhi.getChulitype(),chuzhi.getDanju(),chuzhi.getOperatedate(),chuzhi.getQingshidate()});
    }
    
    //删除流转数据
    /* (non-Javadoc)
	 * @see com.yatai.dao.TypedanDaoImpl#delTypedan(java.lang.String)
	 */
    @Override
	public int delTypedan(String sqlwhere){
    	String sql = "delete from "+sqlwhere;
    	return jdbc.executeUpdate(sql);
    }
}
