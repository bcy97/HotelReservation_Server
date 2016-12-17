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

	public RoomPO getRoomInfo(String hotelId, int roomType) {
		RoomPO roomPO;
		Connection conn;
		Statement statement;
		String sql = "select * from room where hotelId='"+hotelId+"' and roomType='"+roomType+"'";
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			
			ResultSet rs=statement.executeQuery(sql);
			
			if (rs.next()) {
				roomPO = new RoomPO(null, 0, 0, 0, null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setRoomNum(rs.getInt("roomNum"));
				roomPO.setPrice(rs.getDouble("price"));
				
				String specificTimeRoomNum = rs.getString("specificTimeRoomNum");
				String[] roomNums = specificTimeRoomNum.split("###");
				int[] nums = new int[roomNums.length];
				for (int i = 0; i < roomNums.length; i++) {
					nums[i] = Integer.valueOf(roomNums[i]);
				}
				roomPO.setSpecificTimeRoomNum(nums);
				
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
		if (roomPO==null||roomPO.getHotelId()==null||roomPO.getHotelId()=="") {
			return false;
		}
		Connection conn;
		Statement statement;
		String sql="insert into room values('"+roomPO.getHotelId()+"','"+roomPO.getRoomType()+"',"+
				roomPO.getPrice()+","+roomPO.getRoomNum()+",";
		if (roomPO.getSpecificTimeRoomNum()!=null) {
			int[] nums = roomPO.getSpecificTimeRoomNum();
			String specificTimeRoomNum = "";
			for (int i : nums) {
				specificTimeRoomNum = specificTimeRoomNum+i+"###";
			}
			sql = sql+"'"+specificTimeRoomNum+"')";
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
		if (roomPO==null||roomPO.getHotelId()==null||roomPO.getHotelId()=="") {
			return false;
		}
		Connection conn;
		Statement statement;
		String sql="delete from room where hotelID='"+roomPO.getHotelId()+"' and roomType="+roomPO.getRoomType();
		try {
			conn  = DBConnection.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			conn.close();
			
			addRoom(roomPO);
			
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
				RoomPO roomPO = new RoomPO(null, 0, 0, 0, null);
				roomPO.setHotelId(rs.getString("hotelId"));
				roomPO.setRoomType(rs.getInt("roomType"));
				roomPO.setRoomNum(rs.getInt("roomNum"));
				roomPO.setPrice(rs.getDouble("price"));
				
				String specificTimeRoomNum = rs.getString("specificTimeRoomNum");
				String[] roomNums = specificTimeRoomNum.split("###");
				int[] nums = new int[roomNums.length];
				for (int i = 0; i < roomNums.length; i++) {
					nums[i] = Integer.valueOf(roomNums[i]);
				}
				roomPO.setSpecificTimeRoomNum(nums);
				
				hotelRoomsList.add(roomPO);
			}
			statement.close();
			conn.close();
			
			return hotelRoomsList;
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
