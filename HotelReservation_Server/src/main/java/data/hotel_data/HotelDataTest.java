package data.hotel_data;

import java.util.ArrayList;
import java.util.HashMap;

import po.HotelPO;

public class HotelDataTest {

	public static void main(String[] args) {
		HotelData hotelData = new HotelData();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 10);
		map.put(1, 10);
		HotelPO hotelPO = new HotelPO("1234", "汉庭", "南京", "玄武区", "新街口", "南京新街口汉庭酒店",4.7,0, "南京的新街口汉庭酒店", "大床房40间", null, map, "南京大学");
//		hotelData.addHotel(hotelPO);
//		System.out.println(hotelData.addHotel(new HotelPO("12335", "汉庭", "南京", "玄武区", "仙林中心", "南京新街口汉庭酒店",4.7,0, "南京的新街口汉庭酒店", "大床房40间", null, map, null)));
//		System.out.println(hotelData.hotelIDExist("00001"));hoteID
		System.out.println(hotelData.updateHotel(new HotelPO("1234", "汉庭", "南京", "玄武区", "仙林中心", "南京新街口汉庭酒店",4.7,0, "南京的新街口汉庭酒店", "大床房40间", null, map, "南京大学")));
		ArrayList<HotelPO> hotelList = hotelData.SearchHotelList("南京", "仙林中心");
		for (HotelPO hotelPO2 : hotelList) {
			System.out.println(hotelPO2.getHoteID()+" "+hotelPO2.getHotelName()+" "+hotelPO2.getBussiness()+" "+hotelPO2.getEmptyRoomNum());
		}
	}

}
