package data.room_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
				roomPO = new RoomPO(null, null, 0, 0,null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomId(rs.getString("roomId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setPrice(rs.getDouble("price"));
				
				HashMap<String, String> notEmptyTime = new HashMap<String, String>();
				String[] emptyTime = rs.getString("emptyTime").split("###");
				for (String string : emptyTime) {
					String[] temp = string.split("##");
					notEmptyTime.put(temp[0], temp[1]);
				}
				roomPO.setNotEmptyTime(notEmptyTime);
				
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
		String sql="insert into room values('"+roomPO.getHotelId()+"','"+roomPO.getRoomId()+"',"+
				roomPO.getRoomType()+","+roomPO.getPrice();

		if (roomPO.getNotEmptyTime()==null) {
			sql = sql +",null)";
		}else {
			String notEmptyTime = "";
			Iterator<Entry<String, String>> iterator = roomPO.getNotEmptyTime().entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
				notEmptyTime=notEmptyTime+entry.getKey()+"##"+entry.getValue()+"###";
			}
			sql = sql+",'"+notEmptyTime;
		}
		//获得完整的sql指令
		
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
		String sql="";
		if (roomPO.getNotEmptyTime()!=null) {
			String notEmptyTime = "";
			Iterator<Entry<String, String>> iterator = roomPO.getNotEmptyTime().entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
				notEmptyTime=notEmptyTime+entry.getKey()+"##"+entry.getValue()+"###";
			}
			sql="update room set roomType="+roomPO.getRoomType()
						+",price="+roomPO.getPrice()
						+",notEmptyTime='"+notEmptyTime
						+"' where hotelId='"+roomPO.getHotelId()+"'and roomId='"+roomPO.getRoomId()+"'";
		}else {
			sql="update room set roomType="+roomPO.getRoomType()
						+",price="+roomPO.getPrice()
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
				RoomPO roomPO = new RoomPO(null, null, 0, 0,null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomId(rs.getString("roomId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setPrice(rs.getDouble("price"));
				
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
