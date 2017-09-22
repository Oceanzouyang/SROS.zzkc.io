package com.yatai.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
public class JDBCTemplate
{
	private Connection conn = null;

	private Statement stmt = null;

	private PreparedStatement prestmt = null;

	private ResultSet rs = null;

	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			System.err.println("driver error " + e.getMessage());
		}
	}

	public void getConnection()
	{
		try
		{
//			String URL = "jdbc:mysql://localhost:3306/test";
//	        String userName = "root";
//			String Password = "zouyang";
			String URL = "jdbc:mysql://192.168.1.203:3306/pjbank";
			String userName = "root";
			String Password = "pjbank";
			conn = DriverManager.getConnection(URL, userName, Password);
			conn.setAutoCommit(false);
		} catch (SQLException e)
		{
			System.err.println("connection error " + e.getMessage());
		}
	}

	public void createStatement()
	{
		getConnection();
		try
		{
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			System.err.println("createStatement error" + e.getMessage());
		}
	}

	public void createPrepareStatement(String sql)
	{
		getConnection();
		try
		{
			prestmt = conn.prepareStatement(sql);
		} catch (SQLException e)
		{
			System.err.println("createPrepareStatement " + e.getMessage());
		}
	}

	public ResultSet executeQuery(String sql)
	{
		createStatement();
		try
		{
			rs = stmt.executeQuery(sql);
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return rs;
	}

	public int executeUpdate(String sql)
	{
		int result = 0;
		createStatement();
		try
		{
			result = stmt.executeUpdate(sql);
			commit();
		} catch (SQLException e)
		{
			rollBack();
			System.out.println(e.getMessage());
		} finally
		{
			closeResource();
		}
		return result;
	}

	public ResultSet executeQuery(String sql, String[] args)
	{
		createPrepareStatement(sql);
		try
		{
			if (args != null && args.length != 0)
			{
				for (int i = 0; i < args.length; i++)
				{
					prestmt.setString(i + 1, args[i]);
				}
			}
			rs = prestmt.executeQuery();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		return rs;
	}
	
	public int executeUpdate(String sql, String[] args)
	{
		createPrepareStatement(sql);
		int result = 0;
		try {
		if(args != null && args.length != 0)
		{
			for(int i = 0; i < args.length; i++)
			{
			   prestmt.setString(i + 1, args[i]);	
			}
		}
		result = prestmt.executeUpdate();
		commit();
		}catch(SQLException e)
		{
			rollBack();
			System.err.println(e.getMessage());
		}finally
		{
		    closeResource();	
		}
		return result;
	}
	
	public boolean executeBatch(String[] sqls)
	{ 
		createStatement();
		boolean isCorrect = false;
		try {
			if(sqls != null && sqls.length > 0)
			{
				for(int i = 0; i < sqls.length; i++)
				{
				   stmt.addBatch(sqls[i]);	
				}
			}
			stmt.executeBatch();
			commit();
			isCorrect = true;
		}catch(SQLException e)
		{
			rollBack();
			System.err.println(e.getMessage());
		}finally {
			closeResource();
		}
		return isCorrect;
	}

	private void commit()
	{
		try
		{
			conn.commit();
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	private void rollBack()
	{
		try
		{
			conn.rollback();
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void closeResource()
	{
		try
		{
			if (rs != null)
			{
				rs.close();
				rs = null;
			}
			if (stmt != null)
			{
				stmt.close();
				stmt = null;
			}
			if (prestmt != null)
			{
				prestmt.close();
				prestmt = null;
			}
			if (conn != null)
			{
				conn.close();
				conn = null;
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
