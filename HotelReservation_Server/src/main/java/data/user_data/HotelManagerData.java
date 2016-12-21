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
		if (po==null||po.getHotelID()==null||po.getHotelID()==""||po.getIdentityCardID()==null||po.getIdentityCardID()==""||
				po.getPhoneNumber()==null||po.getPhoneNumber()==""||po.getTrueName()==null||po.getTrueName()=="") {
			System.out.println("data.user_data.HotelManagerData.updateHotelMangerInfo参数错误");
			return false;
		}
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

	public boolean addHotelManager(HotelManagerPO hotelManagerPO) {
		if (hotelManagerPO==null||hotelManagerPO.getHotelID()==""||hotelManagerPO.getHotelID()==null||hotelManagerPO.getTrueName()==null||hotelManagerPO.getTrueName()==""
				||hotelManagerPO.getPhoneNumber()==""||hotelManagerPO.getPhoneNumber()==null||hotelManagerPO.getIdentityCardID()==""||hotelManagerPO.getIdentityCardID()==null) {
			System.out.println("data.user_data.WebBusinessData.addWebBusiness参数错误");
			return false;
		}
		if (getHotelManagerInfo(hotelManagerPO.getHotelID())!=null) {
			System.out.println("已存在该数据");
			return false;
		}
		Connection conn;
		Statement statement;
		String sql = "insert into hotelmanager values('"+hotelManagerPO.getHotelID()+"','"+hotelManagerPO.getPhoneNumber()+"','"
						+hotelManagerPO.getTrueName()+"','"+hotelManagerPO.getIdentityCardID()+"')";
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
