package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.HotelManagerPO;

public interface HotelManagerDao extends Remote{
	
	public HotelManagerPO getHotelManagerInfo(String hotel_ID)  throws RemoteException;
	
	public boolean updateHotelManagerInfo(HotelManagerPO po) throws RemoteException;
	
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
}
