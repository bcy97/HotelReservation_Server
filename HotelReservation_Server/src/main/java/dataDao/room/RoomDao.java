package dataDao.room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao extends Remote{
	
	public RoomPO getRoomInfo(String hotelId, int roomType)  throws RemoteException;
	
	public boolean addRoom(RoomPO roomPO)  throws RemoteException;
	
	public boolean updateRoom(RoomPO po) throws RemoteException;
	
	public ArrayList<RoomPO> getHotelRooms(String hotelId)  throws RemoteException;
}
