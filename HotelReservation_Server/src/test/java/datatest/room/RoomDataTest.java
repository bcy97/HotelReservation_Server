package datatest.room;

import java.util.ArrayList;

import data.room_data.RoomData;
import po.RoomPO;

public class RoomDataTest {

	static RoomData roomData = new RoomData();
	
	public static void main(String[] args) {
		testAddRoom();
}

	public static void  testGetRoomInfo() {
		RoomPO po = roomData.getRoomInfo("11111", 2);
		System.out.println(po.getHotelId());
		System.out.println(po.getRoomType());
		System.out.println(po.getPrice());
		System.out.println(po.getRoomNum());
		int[] roomNum = po.getSpecificTimeRoomNum();
		for (int i : roomNum) {
			System.out.println(i);
		}
	}
	
	public static void testAddRoom() {
		int[] specificTimeRoomNum = {5,5,4,3,2,
									 1,2,3,4,5,
									 4,4,4,4,4,
									 4,4,4,4,4,
									 4,4,4,4,4,
									 4,4,4,4,4};
		RoomPO roomPO = new RoomPO("11111", 1, 10, 200, specificTimeRoomNum);
		System.out.println(roomData.addRoom(roomPO));
	}
	
	public static void testUpdateRoom() {
		int[] specificTimeRoomNum = {5,5,4,3,2,1,2};
		RoomPO roomPO = new RoomPO("11111", 2, 1, 200, specificTimeRoomNum);
		System.out.println(roomData.updateRoom(roomPO));
		
	}
}
