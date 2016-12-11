package dataDao.user;

import java.rmi.Remote;

import po.HotelManagerPO;

public interface HotelManagerDao extends Remote{
	
	public HotelManagerPO getHotelManagerInfo(String hotel_ID);
	
	public boolean updateHotelManagerInfo(HotelManagerPO po);
	
}
