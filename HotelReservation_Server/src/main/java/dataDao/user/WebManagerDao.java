package dataDao.user;

import java.rmi.Remote;

import po.HotelManagerPO;
import po.HotelPO;
import po.WebBusinessPO;

public interface WebManagerDao extends Remote{
	
	public boolean addHotel(HotelPO hotelPO);
	
	public boolean addHotelManager(HotelManagerPO hotelManagerPO);
	
	public boolean addWebBusiness(WebBusinessPO  webBusinessPO);
	
}
