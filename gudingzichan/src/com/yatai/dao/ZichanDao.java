package com.yatai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yatai.model.Dept;
import com.yatai.model.Zichan;
import com.yatai.model.ZichanType;
import com.yatai.util.JDBCTemplate;

public class ZichanDao
{
	JDBCTemplate jdbc = new JDBCTemplate();
	
	//显示所有数据
    public List<Zichan> showInfo()
    {
    	String sql = "select * from zichan";
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
	//普通用户显示所有数据
    public List<Zichan> showInfoChoose(String condition)
    {
    	String sql = "select * from zichan" + condition;
    	System.out.println(sql);
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		
		return list;
    }
    
	//显示未审核所有数据
    public List<Zichan> showShenheInfo()
    {
    	String sql = "select * from zichan";
    	
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
    public int add(Zichan zichan)
    {
    	String sql = "insert into zichan(zichanid,name,type,danwei,num,dept,date,place,user,baoguan,gongyingshang,jine,pingzheng,beizhu,status,xuhao,shenhe,danjuhao,jitizhejiu,jingzhi,zhuanchudate,zhuanrudate,zhuanchudept,zhuanchuplace,typecode,typename) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
    	//String sql = "insert into dept(deptname,deptnum,deptdesc) values('"+dept.getDeptname()+"','"+dept.getDeptnum()+"','"+dept.getDeptdesc()+"')";
    	return jdbc.executeUpdate(sql, new String[]{zichan.getZichanid(),zichan.getName(),zichan.getType(),zichan.getDanwei(),zichan.getNum()+"",zichan.getDept(),zichan.getDate(),zichan.getPlace(),zichan.getUser(),zichan.getBaoguan(),zichan.getGongyingshang(),zichan.getJine(),zichan.getPingzheng(),zichan.getBeizhu(),zichan.getStatus(),zichan.getXuhao()+"",1+"",zichan.getDanjuhao(),zichan.getJitizhejiu(),zichan.getJingzhi(),zichan.getZhuanchudate(),zichan.getZhuanrudate(),zichan.getZhuanchudept(),zichan.getZhuanchuplace(),zichan.getTypecode(),zichan.getTypename()});
    	//return jdbc.executeUpdate(sql);
    }
    
    //添加部门
    public int addDept(Dept dept)
    {
    	String sql = "insert into dept(deptname,py) values(?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{dept.getDeptname(),dept.getPy()});
    }
    
    //添加资产类别
    public int addType(ZichanType zichanType)
    {
    	String sql = "insert into zichantype(typecode,type) values(?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{zichanType.getTypecode(),zichanType.getType()});
    }
    
	//显示所有部门数据
    /**
     * @return
     */
    public List<Dept> showDeptInfo()
    {
    	String sql = "select * from dept";
    	
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<Dept> list = new ArrayList<Dept>();
    	try
		{
			while(rs.next())
			{
				Dept dept = new Dept();
				dept.setId(rs.getInt(1));
				dept.setDeptname(rs.getString(2));
				dept.setPy(rs.getString(3));
				list.add(dept);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
  //显示所有资产类型数据
    public List<ZichanType> showTypeInfo()
    {
    	String sql = "select * from zichantype";
    	
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<ZichanType> list = new ArrayList<ZichanType>();
    	try
		{
			while(rs.next())
			{
				ZichanType zichanType = new ZichanType();
				zichanType.setId(rs.getInt(1));
				zichanType.setTypecode(rs.getString(2));
				zichanType.setType(rs.getString(3));
				list.add(zichanType);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
  //显示所有资产类型数据
    public List<ZichanType> showTypeSqlwhere(String sqlwhere)
    {
    	String sql = "select * from zichantype where "+sqlwhere;
    	//System.out.println("sqlzichantype=="+sql);
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<ZichanType> list = new ArrayList<ZichanType>();
    	try
		{
			while(rs.next())
			{
				ZichanType zichanType = new ZichanType();
				zichanType.setId(rs.getInt(1));
				zichanType.setTypecode(rs.getString(2));
				zichanType.setType(rs.getString(3));
				list.add(zichanType);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
    //获取修改数据
    public Zichan update(int id)
    {
    	Zichan zichan = null;
    	String sql = "select * from zichan where id = ?";
    	ResultSet rs = jdbc.executeQuery(sql, new String[]{id + ""});
    	try
		{
			while(rs.next())
			{
				zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}	
		return zichan;

    }
   
    //获取修改部门参数
    public Dept updateDept(int id)
    {
    	Dept dept = null;
    	String sql = "select * from dept where id = ?";
    	ResultSet rs = jdbc.executeQuery(sql, new String[]{id + ""});
    	try
		{
			while(rs.next())
			{
				dept = new Dept();
				dept.setId(rs.getInt(1));
				dept.setDeptname(rs.getString(2));
				dept.setPy(rs.getString(3));
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return dept;
    }
    
  //获取修改资产类别参数
    public ZichanType updateType(int id)
    {
    	ZichanType zichanType = null;
    	String sql = "select * from zichantype where id = ?";
    	ResultSet rs = jdbc.executeQuery(sql, new String[]{id + ""});
    	try
		{
			while(rs.next())
			{
				zichanType = new ZichanType();
				zichanType.setId(rs.getInt(1));
				zichanType.setTypecode(rs.getString(2));
				zichanType.setType(rs.getString(3));
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}	
		return zichanType;
    }
    
    //执行修改部门参数
    public int executeDeptUpdate(Dept dept)
    {
    	String sql ="update dept set deptname=?,py=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{dept.getDeptname(),dept.getPy(),dept.getId()+""});
    }
    
    //执行修改
    public int executeUpdate(Zichan zichan)
    {
    	String sql ="update zichan set zichanid=?,name=?,type=?,danwei=?,num=?,dept=?,date=?,place=?,user=?,baoguan=?,gongyingshang=?,jine=?,pingzheng=?,beizhu=?,status=?,shenhe=?,danjuhao=?,jitizhejiu=?,jingzhi=?,zhuanchudate=?,zhuanrudate=?,zhuanchudept=?,zhuanchuplace=?,typecode=?,typename=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{zichan.getZichanid(),zichan.getName(),zichan.getType(),zichan.getDanwei(),zichan.getNum()+"",zichan.getDept(),zichan.getDate(),zichan.getPlace(),zichan.getUser(),zichan.getBaoguan(),zichan.getGongyingshang(),zichan.getJine(),zichan.getPingzheng(),zichan.getBeizhu(),zichan.getStatus(),1+"",zichan.getDanjuhao(),zichan.getJitizhejiu(),zichan.getJingzhi(),zichan.getZhuanchudate(),zichan.getZhuanrudate(),zichan.getZhuanchudept(),zichan.getZhuanchuplace(),zichan.getTypecode(),zichan.getTypename(),zichan.getId()+""});
    }
    
    //执行修改部门
    public int executeDeptUpdate(String deptname,String dept)
    {
    	String sql ="update zichan set dept='"+deptname+"' where dept='"+dept+"'";
    	return jdbc.executeUpdate(sql);
    }
    
    //执行修改资产类别参数
    public int executeTypeUpdate(ZichanType zichanType)
    {
    	String sql ="update zichantype set typecode=?,type=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{zichanType.getTypecode(),zichanType.getType(),zichanType.getId()+""});
    }
    
    //执行修改类别
    public int executeTypeUpdate(String typecode,String type,String tptypecode,String tptype)
    {
    	String sql ="update zichan set typecode='"+typecode+"',typename='"+type+"' where typecode='"+tptypecode+"' and typename='"+tptype+"'";
    	System.out.println(sql);
    	return jdbc.executeUpdate(sql);
    }
    
    //执行报销
    public int executeBaoxiao(Zichan zichan)
    {  	
    	String sql ="update zichan set baoxiao=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{zichan.getBaoxiao(),zichan.getId()+""});
    }
    
    //执行批量报销
    public int executeBaoxiaoAll(Zichan zichan)
    {  	
    	String sql ="update zichan set baoxiao="+zichan.getBaoxiao()+" where danjuhao="+zichan.getDanjuhao();
    	//System.out.println(sql);
    	return jdbc.executeUpdate(sql);
    }
    
    //审核修改
    public int shenheUpdate(Zichan zichan)
    {
    	String sql ="update zichan set shenhe=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{zichan.getShenhe()+"",zichan.getId()+""});
    }
    
    //批量修改
    public int updateAll(Zichan zichan){
    	System.out.println(zichan.getZichanid()+"--"+zichan.getBaoxiao()+"--"+zichan.getType()+"--"+zichan.getBeizhu());
    	String sql = "update zichan set "+zichan.getType()+"='"+zichan.getBeizhu()+"' where zichanid>='"+zichan.getZichanid()+"' and zichanid<='"+zichan.getBaoxiao()+"'";
    	System.out.println("sql=="+sql);
    	return jdbc.executeUpdate(sql);
    }
    
    //删除
    public int delete(int id)
    {
        String sql = "delete from zichan where id = ?";
        return jdbc.executeUpdate(sql, new String[]{id+""});
    }
    
    //删除部门
    public int deleteDept(int id)
    {
        String sql = "delete from dept where id = ?";
        return jdbc.executeUpdate(sql, new String[]{id+""});
    }
    
  //删除资产类别
    public int deleteType(int id)
    {
        String sql = "delete from zichantype where id = ?";
        return jdbc.executeUpdate(sql, new String[]{id+""});
    }
    
	//显示所有数据
    public List<Zichan> selectByFenye(String condition)
    {
    	String sql = "select * from zichan "+condition;
    	//System.out.println("sql123=="+sql);
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setShenhe(rs.getInt(18));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
    public int maxXuhao(String condition){
    	String sql = "select * from zichan "+condition;
    	List<Zichan> list = new ArrayList<Zichan>();
        ResultSet rs = jdbc.executeQuery(sql);
    	try
		{
			while(rs.next())
			{	
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getFloat(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		int xuhao = 0;
		if(!list.isEmpty()){
			xuhao = list.get(0).getXuhao();
		}
    	return xuhao;
    }
    
    //根据name模糊匹配查找
    public List<Zichan> querylikeNameDao(String name){
    	String sql = "select * from zichan where name like '%"+name+"%'  order by zichanid desc";
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getInt(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setShenhe(rs.getInt(18));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
    	return list;
    }
    
    //获取zichan表中部门
    public List<Zichan> quanxian(){
    	String sql = "select * from zichan where dept!='' group by dept ";
    	//System.out.println("sql=="+sql);
    	ResultSet rs = jdbc.executeQuery(sql);
    	List<Zichan> list = new ArrayList<Zichan>();
    	try
		{
			while(rs.next())
			{
				Zichan zichan = new Zichan();
				zichan.setId(rs.getInt(1));
				zichan.setZichanid(rs.getString(2));
				zichan.setName(rs.getString(3));
				zichan.setType(rs.getString(4));
				zichan.setDanwei(rs.getString(5));
				zichan.setNum(rs.getInt(6));
				zichan.setDept(rs.getString(7));
				zichan.setDate(rs.getString(8));
				zichan.setPlace(rs.getString(9));
				zichan.setUser(rs.getString(10));
				zichan.setBaoguan(rs.getString(11));
				zichan.setGongyingshang(rs.getString(12));
				zichan.setJine(rs.getString(13));
				zichan.setPingzheng(rs.getString(14));
				zichan.setBeizhu(rs.getString(15));
				zichan.setStatus(rs.getString(16));
				zichan.setXuhao(rs.getInt(17));
				zichan.setShenhe(rs.getInt(18));
				zichan.setBaoxiao(rs.getString(19));
				zichan.setDanjuhao(rs.getString(20));
				zichan.setJitizhejiu(rs.getString(21));
				zichan.setJingzhi(rs.getString(22));
				zichan.setZhuanchudate(rs.getString(23));
				zichan.setZhuanchudept(rs.getString(24));
				zichan.setZhuanchuplace(rs.getString(25));
				zichan.setZhuanrudate(rs.getString(26));
				zichan.setTypecode(rs.getString(27));
				zichan.setTypename(rs.getString(28));
				zichan.setZhuanyidan(rs.getString(29));
				zichan.setChuzhidan(rs.getString(30));
				list.add(zichan);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
    	return list;
    }
    
    //审核修改
    public int updateZichanType(String typecode,String type,int id)
    {
    	String sql ="update zichan set typecode='"+typecode+"',typename='"+type+"' where id="+id;
    	return jdbc.executeUpdate(sql);
    }
    
    //工具类操作修改信息
    public int updateTool(String sql){
    	//System.out.println(sql);
    	return jdbc.executeUpdate(sql);
    }
    
}
