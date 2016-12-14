package dataDao.room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao extends Remote{

	public RoomPO getRoomInfo(String hotelId, String roomId) throws RemoteException;
	
	public boolean addRoom(RoomPO roomPO) throws RemoteException;
	
	public boolean updateRoom(RoomPO roomPO) throws RemoteException;
	
	public ArrayList<RoomPO> getHotelRooms(String hotelId) throws RemoteException;
}
