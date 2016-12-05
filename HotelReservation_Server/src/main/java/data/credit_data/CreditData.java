package data.credit_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.database.DBConnection;
import dataDao.CreditDao;
import po.CreditHistoryPO;

public class CreditData implements CreditDao{

	public boolean changeCredit(CreditHistoryPO po) {
		if (po==null) {
			System.out.println("data.credit_data.changeCredit参数错误");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "insert into credithistory values('" 
						+po.getUserID() + "','" + po.getTime() +"','"+po.getOrderID()+"','"+po.getAction()
						+"','"+po.getCreditChange()+"','"+po.getNowCredit()+"')";		
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
				CreditHistoryPO creditHistoryPO = new CreditHistoryPO(null, null, null, 0, 0, 0);
				creditHistoryPO.setUserID(rs.getString("userID"));
				creditHistoryPO.setTime(rs.getString("time"));
				creditHistoryPO.setOrderID(rs.getString("orderID"));
				creditHistoryPO.setAction(rs.getInt("action"));
				creditHistoryPO.setCreditChange(rs.getInt("creditChange"));
				creditHistoryPO.setNowCredit(rs.getInt("nowCredit"));
				
				creditHistory.add(creditHistoryPO);
				
			}
			
			statement.close();
			conn.close();
			
			return creditHistory;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public int getCredit(String userID) {
		ArrayList<CreditHistoryPO> creditHistory = getCreditHistory(userID);
		return creditHistory.get(creditHistory.size()-1).getNowCredit();
	}

}
