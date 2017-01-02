package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.HotelManagerPO;

public interface HotelManagerDao extends Remote{
	
	/**
	 * 获取酒店管理人员信息
	 * @param hotel_ID
	 * @return
	 * @throws RemoteException
	 */
	public HotelManagerPO getHotelManagerInfo(String hotel_ID)  throws RemoteException;
	
	/**
	 * 更新信息
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateHotelManagerInfo(HotelManagerPO po) throws RemoteException;
	
	/**
	 * 添加酒店管理人员
	 * @param hotelManagerPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
}
