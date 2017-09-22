package com.yatai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yatai.model.User;
import com.yatai.util.JDBCTemplate;

public class UserDao
{
	JDBCTemplate jdbc = new JDBCTemplate();
	
	//��ѯ�����û������ظ��û��б���Ϣ
    public List<User> login()
    {
    	String sql = "select * from admin";
    	
    	ResultSet rs = jdbc.executeQuery(sql);
    	
    	List<User> list = new ArrayList<User>();
    	try
		{
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setType(rs.getString(4));
				user.setChoose(rs.getString(5));
				list.add(user);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}
		return list;
    }
    
    //��ȡ�޸�����
    public User update(int id)
    {
    	User user = null;
    	String sql = "select * from admin where id = ?";
    	ResultSet rs = jdbc.executeQuery(sql, new String[]{id + ""});
    	try
		{
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setType(rs.getString(4));
				user.setChoose(rs.getString(5));
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}finally {
			jdbc.closeResource();
		}	
		return user;

    }
    
    //ִ���޸�
    public int executeUserUpdate(User user)
    {
    	String sql ="update admin set password=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{user.getPassword(),user.getId()+""});
    }
    
    //chooseִ���޸�
    public int executeUpdateChoose(User user)
    {
    	String sql ="update admin set choose=? where id=?";
    	return jdbc.executeUpdate(sql, new String[]{user.getChoose(),user.getId()+""});
    }
    
    //�����û�
    public int register(User user)
    {
    	String sql = "insert into admin(username,password,choose) values(?,?,?)";	
    	return jdbc.executeUpdate(sql, new String[]{user.getUsername(),user.getPassword(),user.getChoose()});
    }
    
    //ɾ��
    public int delete(int id)
    {
        String sql = "delete from admin where id = ?";
        return jdbc.executeUpdate(sql, new String[]{id+""});
    }
}
