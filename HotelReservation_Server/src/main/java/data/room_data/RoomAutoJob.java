package data.room_data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import data.database.DBConnection;
import po.RoomPO;

public class RoomAutoJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		ArrayList<RoomPO> hotelRoomsList = new ArrayList<RoomPO>();
		Connection conn;
		Statement statement;
		String sql = "select * from room";
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
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for (RoomPO roomPO : hotelRoomsList) {
			int[] roomNums = roomPO.getSpecificTimeRoomNum();
			for (int i = 0; i < roomNums.length-1; i++) {
				roomNums[i] = roomNums[i+1];
			}
			roomNums[roomNums.length-1] = roomPO.getRoomNum();
			roomPO.setSpecificTimeRoomNum(roomNums);
			RoomData roomData = new RoomData();
			roomData.updateRoom(roomPO);
		}
	}

}
