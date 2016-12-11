package data.user_data;

import po.HotelManagerPO;

public class HotelManagerDataTest {

	public static void main(String[] args) {
		HotelManagerData hotelManagerData = new HotelManagerData();
		HotelManagerPO hotelManagerPO = hotelManagerData.getHotelManagerInfo("00001");
		System.out.println(hotelManagerPO.getHotelID()+" "+hotelManagerPO.getTrueName()+" "+hotelManagerPO.getIdentityCardID()+" "+hotelManagerPO.getPhoneNumber());
		System.out.println(hotelManagerData.updateHotelManagerInfo(new HotelManagerPO("00001", "12345678901", "卞纯源", "123456789012345678")));
	}

}
