package dataDao.room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao extends Remote{
	
	/**
	 * 
	 * 获取酒店信息
	 * @param hotelId
	 * @param roomType
	 * @return
	 * @throws RemoteException
	 */
	public RoomPO getRoomInfo(String hotelId, int roomType)  throws RemoteException;
	
	/**
	 * 添加房间
	 * @param roomPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addRoom(RoomPO roomPO)  throws RemoteException;
	
	/**
	 * 更新房间信息
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateRoom(RoomPO po) throws RemoteException;
	
	/**
	 * 获取酒店所有房间
	 * @param hotelId
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomPO> getHotelRooms(String hotelId)  throws RemoteException;
}
