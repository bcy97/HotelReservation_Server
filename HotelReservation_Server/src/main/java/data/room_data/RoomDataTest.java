package data.room_data;

import java.util.ArrayList;

import po.RoomPO;

public class RoomDataTest {

	public static void main(String[] args) {
		RoomData roomData = new RoomData();
		ArrayList<String> pictures = new ArrayList<String>();
		pictures.add("abc");
		pictures.add("123");
		roomData.addRoom(new RoomPO("12345", "1234", 1, 200, true, null));
//		RoomPO roomPO = roomData.getRoomInfo("12345", "1234");
//		System.out.println(roomPO.getHotelId()+" "+roomPO.getRoomId()+" "+roomPO.getRoomType()+" "+roomPO.getPrice()+" "+roomPO.isEmpty()+" "+roomPO.getPrice());
	}

}
