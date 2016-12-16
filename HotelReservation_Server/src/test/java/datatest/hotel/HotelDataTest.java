package datatest.hotel;

import java.util.ArrayList;
import java.util.HashMap;

import data.hotel_data.HotelData;
import po.HotelPO;

public class HotelDataTest {

	static HotelData hotelData = new HotelData();
	
	public static void main(String[] args) {
		addHotel();
		testUpdateHotel();
		testGetHotelInfoByHotelID();
	}

	public static void testHotelIDExist() {
		System.out.println(hotelData.hotelIDExist("1234"));
		System.out.println(hotelData.hotelIDExist("11111"));
	}
	
	public static void addHotel() {
		HotelPO po = new HotelPO("11111", "bcy豪华酒店", "南京", "马群","马群花园城",5.0, 5, "南京最豪华的五星级酒店", "酒店项目样样俱全", null, "南京大学");
		System.out.println(hotelData.addHotel(po));
	}
	
	public static void testUpdateHotel() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("c:\\\\");
		strings.add("d:\\\\");
		HotelPO po = new HotelPO("11111", "bcy豪华酒店", "南京", "马群","马群花园城",5.0, 5, "南京最豪华的五星级酒店", "最豪华的床最豪华的酒店装饰", strings, null);
		System.out.println(hotelData.updateHotel(po));
	}
	
	public static void testGetHotelInfoByHotelID() {
		HotelPO po = hotelData.getHotelInfoByHotelID("11111");
		System.out.println(po.getHoteID());
		System.out.println(po.getHotelName());
		System.out.println(po.getCity());
		System.out.println(po.getTradingArea());
		System.out.println(po.getLocationOfHotel());
		System.out.println(po.getEvaluationGrades());
		System.out.println(po.getLevelOfHotel());
		System.out.println(po.getIntroduction());
		System.out.println(po.getFacilities());
		System.out.println(po.getPicturesPath());
		System.out.println(po.getBussiness());
	}
}
