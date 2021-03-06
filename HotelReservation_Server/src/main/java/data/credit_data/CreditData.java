package data.credit_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import data.database.DBConnection;
import dataDao.credit.CreditDao;
import po.CreditHistoryPO;

public class CreditData implements CreditDao{

	public boolean changeCredit(CreditHistoryPO po) {
		if (po==null) {
			System.out.println("data.credit_data.changeCredit参数错误");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "";
		if (po.getOrderID()!=null) {
			sql = "insert into credithistory values('" 
					+po.getUserID() + "','" + po.getTime() +"','"+po.getOrderID()+"','"+po.getAction()
					+"','"+po.getCreditChange()+"','"+po.getNowCredit()+"')";		
		}else {
			sql = "insert into credithistory(userID,time,action,creditChange,nowCredit) values('"
					+po.getUserID()+"','"+po.getTime()+"','"+po.getAction()
					+"','"+po.getCreditChange()+"','"+po.getNowCredit()+"')";		
		}
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

	/**
	 * 获取信用修改历史记录，按时间顺序排列
	 */
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		ArrayList<CreditHistoryPO> creditHistory = new ArrayList<CreditHistoryPO>();
		String sql="select * from credithistory where userID='"+userID+"' order by time";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				if (rs.getInt("action")==6) {
					continue;
				}
				CreditHistoryPO creditHistoryPO = new CreditHistoryPO(null, null, null, 0, 0, 0);
				creditHistoryPO.setUserID(rs.getString("userID"));
				creditHistoryPO.setTime(rs.getString("time").substring(0,19));
				creditHistoryPO.setOrderID(rs.getString("orderID"));
				creditHistoryPO.setAction(rs.getInt("action"));
				creditHistoryPO.setCreditChange(rs.getInt("creditChange"));
				creditHistoryPO.setNowCredit(rs.getInt("nowCredit"));
				
				creditHistory.add(creditHistoryPO);
				
			}
			
			statement.close();
			conn.close();
			
			Collections.reverse(creditHistory);
			
			return creditHistory;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getCredit(String userID) {
		ArrayList<CreditHistoryPO> creditHistory = getCreditHistory(userID);
		if (creditHistory==null||creditHistory.size()==0) {
			return 1000;
		}else {
			return creditHistory.get(0).getNowCredit();
		}
	}

	public boolean setVIPCredit(int level, int vipLevelCredit) {
		String sql="update vipcredit set vipLevelCredit = "+vipLevelCredit +" where vipLevel ="+level;
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			statement.executeUpdate(sql);
			
			statement.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public int getVIPCredit(int level) {
		String sql="select * from vipcredit where vipLevel="+level;
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				int vipLevelCredit = rs.getInt("vipLevelCredit");
				statement.close();
				conn.close();
				return vipLevelCredit;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;	
	
	}

}
