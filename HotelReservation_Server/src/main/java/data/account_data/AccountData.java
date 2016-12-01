package data.account_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.database.DBConnection;
import dataDao.AccountDao;
import po.AccountPO;

public class AccountData implements AccountDao{

	public boolean addAccount(AccountPO po) {
		Connection conn;
		Statement statement;
		String sql = "insert into account (AccountID, password,identity) values('" +
				po.getAccountID() + "','" + po.getPassword() +"','"+po.getIdentity()+"')";		
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

}