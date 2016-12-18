package datatest.user;

import data.user_data.HotelManagerData;
import po.HotelManagerPO;

public class HotelManagerDataTest {

	public static void main(String[] args) {
		HotelManagerData hotelManagerData = new HotelManagerData();
		HotelManagerPO hotelManagerPO = hotelManagerData.getHotelManagerInfo("00001");
		System.out.println(hotelManagerPO.getHotelID()+" "+hotelManagerPO.getTrueName()+" "+hotelManagerPO.getIdentityCardID()+" "+hotelManagerPO.getPhoneNumber());
		hotelManagerData.updateHotelManagerInfo(new HotelManagerPO("00001", "12345678901", "卞纯源", "123456789012345678"));
		hotelManagerData.addHotelManager(new HotelManagerPO("32145", "09876543211", "wyy", "999995555522222000"));
		HotelManagerPO hotelManagerPO2 = hotelManagerData.getHotelManagerInfo("32145");
		System.out.println(hotelManagerPO2.getHotelID()+" "+hotelManagerPO2.getTrueName()+" "+hotelManagerPO2.getIdentityCardID()+" "+hotelManagerPO2.getPhoneNumber());
		
	}

}
