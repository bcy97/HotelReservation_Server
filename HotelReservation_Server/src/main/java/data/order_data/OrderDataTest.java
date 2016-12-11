package data.order_data;

import java.util.ArrayList;

import po.OrderPO;

public class OrderDataTest {

	public static void main(String[] args) {
		OrderData orderData = new OrderData();
		ArrayList<String> roomID1 = new ArrayList<String>();
		roomID1.add("0001");
		ArrayList<String> roomID2 = new ArrayList<String>();
		roomID2.add("1108");
		roomID2.add("1109");
//		orderData.addOrder(new OrderPO("123455", "201612120000101", "00001", "2016-12-12 00:00:00", "2016-12-13 00:00:00", 1, roomID1, false, 2, 0, 200, 200, 0, null, "2016-12-12  00:00:00", null, null));
//		orderData.addOrder(new OrderPO("123455", "201612121234501", "12345", "2016-12-12 00:00:00", "2016-12-13 00:00:00", 2, roomID2, false, 2, 0, 200, 200, 0, null, null, "2016-12-12 00:00:00", null));
		orderData.updateOrder(new OrderPO("123455", "201612120000101", "00001", "2016-12-31 12:00:00", "2017-01-01 12:00:00", 1, roomID2, false, 2, 0, 200, 200, 0, null, "2016-12-31  18:00:00", null, null));
	}

}
