package data.user_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.database.DBConnection;
import dataDao.user.WebBusinessDao;
import po.HotelManagerPO;
import po.WebBusinessPO;

public class WebBusinessData implements WebBusinessDao{

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) {
		
		WebBusinessPO webBusinessPO;
		
		String sql="select * from webbusiness where userID='"+webBusiness_ID+"'";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				webBusinessPO = new WebBusinessPO(webBusiness_ID, null, null, null);
				webBusinessPO.setNumberOfIdentityCard(rs.getString("numberOfIdentityCard"));
				webBusinessPO.setPhoneNumber(rs.getString("phoneNumber"));
				webBusinessPO.setTrueName(rs.getString("trueName"));
				
				statement.close();
				conn.close();
				
				return webBusinessPO;
				
			}else {
				System.out.println("不存在该数据");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean updateWebBusinessInfo(WebBusinessPO po) {
		if (po==null||po.getUserID()==null||po.getUserID()==""||po.getTrueName()==null||po.getTrueName()==""||
				po.getPhoneNumber()==null||po.getPhoneNumber()==""||po.getNumberOfIdentityCard()==null||po.getNumberOfIdentityCard()=="") {
			System.out.println("data.user_data.HotelManagerData.updateHotelMangerInfo参数错误");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql="update webbusiness set phoneNumber ='"+po.getPhoneNumber()+"', numberOfIdentityCard='"+po.getNumberOfIdentityCard()
						+"',trueName='"+po.getTrueName()+"' where userID='"+po.getUserID()+"'";
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

	public boolean addWebBusiness(WebBusinessPO webBusinessPO) {
		if (webBusinessPO==null||webBusinessPO.getUserID()==""||webBusinessPO.getUserID()==null||webBusinessPO.getTrueName()==null||webBusinessPO.getTrueName()==""
				||webBusinessPO.getPhoneNumber()==""||webBusinessPO.getPhoneNumber()==null||webBusinessPO.getNumberOfIdentityCard()==""||webBusinessPO.getNumberOfIdentityCard()==null) {
			System.out.println("data.user_data.WebBusinessData.addWebBusiness参数错误");
			return false;
		}
		if (getWebBusinessInfo(webBusinessPO.getUserID())!=null) {
			System.out.println("已存在该数据");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "insert into webbusiness values('"+webBusinessPO.getUserID()+"','"+webBusinessPO.getTrueName()+"','"
						+webBusinessPO.getPhoneNumber()+"','"+webBusinessPO.getNumberOfIdentityCard()+"')";
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
