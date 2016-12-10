package dataDao;

import java.rmi.Remote;

import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao extends Remote{
	
	public boolean addHotel(HotelPO po);
	
	public boolean updateHotel(HotelPO po);
	
	public HotelPO getHotelInfoByHotelID(String hotelID);
	
	public ArrayList<String> getBookedHotelID(String userID);

	public ArrayList<String> getTradingAreas(String loaction);
	
	public ArrayList<HotelPO> SearchHotelList(String city,String distract,String tradingArea,String hotelName);
	
	public ArrayList<HotelPO> SearchHotelList(String city,String distract,String tradingArea);
	
}
