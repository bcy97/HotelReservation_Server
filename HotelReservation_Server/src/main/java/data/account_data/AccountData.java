package data.account_data;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.database.DBConnection;
import dataDao.account.AccountDao;
import po.AccountPO;

public class AccountData implements AccountDao{

	public boolean addAccount(AccountPO po) {
		if (po.getAccountID().length()<5||po.getPassword()==null||po.getPassword()=="") {
			System.out.println("data.account_data.AccountData.addAccount参数错误");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "insert into account  values('" +
				po.getAccountID() + "','" + po.getPassword() +"','"+po.getIdentity()+"',0)";		
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean modifyPassword(AccountPO po) {
		Connection conn;
		Statement statement;
		String sql="update account set password='"+po.getPassword()+"' where AccountID='"+po.getAccountID()+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public AccountPO getAccountInfo(String accountID) {
		AccountPO accountPO;
		
		String sql="select * from account where AccountID='"+accountID+"'";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				accountPO = new AccountPO(null, null, 0);
				accountPO.setAccountID(rs.getString("AccountID"));
				accountPO.setPassword(rs.getString("password"));
				accountPO.setIdentity(rs.getInt("identity"));
				
				statement.close();
				conn.close();
				
				return accountPO;
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean userIDExists(String userID) {
		String sql="select * from account where AccountID='"+userID+"'";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				statement.close();
				conn.close();
				
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean hasLogin(String userID) {
		String sql="select * from account where AccountID='"+userID+"'";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				int isLogin=rs.getInt("isLogin");
				statement.close();
				conn.close();
				if (isLogin==1) {
					return true;
				}else {
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean setLogout(String userID) {
		Connection conn;
		Statement statement;
		String sql="update account set isLogin='"+0+"' where AccountID='"+userID+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean setLogin(String userID) {
		Connection conn;
		Statement statement;
		String sql="update account set isLogin='"+1+"' where AccountID='"+userID+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
