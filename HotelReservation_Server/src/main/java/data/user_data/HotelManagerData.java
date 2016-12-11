package data.user_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.database.DBConnection;
import dataDao.user.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerData implements HotelManagerDao{

	public HotelManagerPO getHotelManagerInfo(String hotel_ID) {
		
		HotelManagerPO hotelManagerPO;
		
		String sql="select * from hotelmanager where hotelID='"+hotel_ID+"'";
		Statement statement;
		Connection conn;
		
		try {
			conn = DBConnection.getConnection();
			statement =conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			if (rs.next()) {
				hotelManagerPO = new HotelManagerPO(hotel_ID, null, null, null);
				hotelManagerPO.setIdentityCardID(rs.getString("IdentityCardID"));
				hotelManagerPO.setPhoneNumber(rs.getString("phoneNumber"));
				hotelManagerPO.setTrueName(rs.getString("trueName"));
				
				statement.close();
				conn.close();
				
				return hotelManagerPO;
				
			}else {
				System.out.println("不存在该数据");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean updateHotelManagerInfo(HotelManagerPO po) {
		Connection conn;
		Statement statement;
		String sql="update hotelmanager set phoneNumber ='"+po.getPhoneNumber()+"', IdentityCardID='"+po.getIdentityCardID()
						+"',trueName='"+po.getTrueName()+"' where hotelID='"+po.getHotelID()+"'";
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
