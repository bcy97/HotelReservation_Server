package data.room_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.database.DBConnection;
import dataDao.room.RoomDao;
import po.RoomPO;

public class RoomData implements RoomDao{

	public RoomPO getRoomInfo(String hotelId, String roomId) {
		RoomPO roomPO;
		Connection conn;
		Statement statement;
		String sql = "select * from room where hotelId='"+hotelId+"' and roomId='"+roomId+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			
			if (rs.next()) {
				roomPO = new RoomPO(null, null, 0, 0, false, null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomId(rs.getString("roomId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setPrice(rs.getDouble("price"));
				roomPO.setEmpty(rs.getInt("isEmpty")==1);
				if (rs.getString("pictures")!=null) {
					String[] pictures = rs.getString("pictures").split("###");
					ArrayList<String> picture = new ArrayList<String>();
					for (String string : pictures) {
						picture.add(string);
					}
					roomPO.setPictures(picture);
				}else {
					roomPO.setPictures(null);
				}
				
				statement.close();
				conn.close();
				
				return roomPO;
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean addRoom(RoomPO roomPO) {
		Connection conn;
		Statement statement;
		String pictures;
		String sql;
		int empty=0;
		if (roomPO.isEmpty()) {
			empty=1;
		}else {
			empty=0;
		}
		pictures = "";
		if (roomPO.getPictures()!=null) {
			for (String  picture : roomPO.getPictures()) {
				pictures+=picture+"###";
			}
			sql = "insert into room values('"+roomPO.getHotelId()+"','"+roomPO.getRoomId()+"',"+
					roomPO.getRoomType()+","+roomPO.getPrice()+","+empty+",'"+pictures+"')";
		}else {
			sql = "insert into room(hotelId,roomId,roomType,price,isEmpty) values('"+roomPO.getHotelId()+"','"+roomPO.getRoomId()+"',"+
					roomPO.getRoomType()+","+roomPO.getPrice()+","+empty+")";
		}
		
		try {
			conn = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.execute(sql);
			
			statement.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean updateRoom(RoomPO roomPO) {
		Connection conn;
		Statement statement;
		String pictures = "";
		String sql="";
		if (roomPO.getPictures()!=null) {
			for (String  picture : roomPO.getPictures()) {
				pictures+=picture+"###";
			}
			sql="update room set roomType="+roomPO.getRoomType()
						+",price="+roomPO.getPrice()
						+",isEmpty="+roomPO.isEmpty()
						+",pictures='"+pictures
						+"' where hotelId='"+roomPO.getHotelId()+"'and roomId='"+roomPO.getRoomId()+"'";
		}else {
			sql="update room set roomType="+roomPO.getRoomType()
						+",price="+roomPO.getPrice()
						+",isEmpty="+roomPO.isEmpty()
						+"' where hotelId='"+roomPO.getHotelId()+"'and roomId='"+roomPO.getRoomId()+"'";
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

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		ArrayList<RoomPO> hotelRoomsList = new ArrayList<RoomPO>();
		Connection conn;
		Statement statement;
		String sql = "select * from room where hotelId='"+hotelId+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			
			while (rs.next()) {
				RoomPO roomPO = new RoomPO(null, null, 0, 0, false, null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomId(rs.getString("roomId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setPrice(rs.getDouble("price"));
				if (rs.getInt("isEmpty")==1) {
					roomPO.setEmpty(true);
				}else {
					roomPO.setEmpty(false);
				}
				String[] pictures = rs.getString("pictures").split("###");
				ArrayList<String> picture = new ArrayList<String>();
				for (String string : pictures) {
					picture.add(string);
				}
				roomPO.setPictures(picture);
				
				hotelRoomsList.add(roomPO);
				
				statement.close();
				conn.close();
				
				return hotelRoomsList;
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
