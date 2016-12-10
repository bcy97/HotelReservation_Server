package data.hotel_data;

import java.util.ArrayList;

import dataDao.HotelDao;
import po.HotelPO;

public class HotelData implements HotelDao{

	public boolean addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getBookedHotelID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String city,String distract, String tradingArea) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String city,String distract,String tradingArea, String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

}
