package dataDao;

import java.rmi.Remote;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao extends Remote{

	public RoomPO getRoomInfo(String hotelId, String roomId);
	
	public boolean addRoom(RoomPO roomPO);
	
	public boolean updateRoom(RoomPO roomPO);
	
	public ArrayList<RoomPO> getHotelRooms(String hotelId);
}
