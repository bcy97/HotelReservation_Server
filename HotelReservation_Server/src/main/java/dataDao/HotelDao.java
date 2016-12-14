package dataDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao extends Remote{
	
	public boolean hotelIDExist(String hotelID) throws RemoteException;

	public boolean addHotel(HotelPO po) throws RemoteException;
	
	public boolean updateHotel(HotelPO po) throws RemoteException;
	
	public HotelPO getHotelInfoByHotelID(String hotelID) throws RemoteException;
	
	public ArrayList<String> getTradingAreas(String loaction) throws RemoteException;
	
	public ArrayList<HotelPO> SearchHotelList(String city,String tradingArea) throws RemoteException;
	
}
