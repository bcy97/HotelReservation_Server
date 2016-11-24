package data.order_data;

import java.util.ArrayList;

import dataDao.OrderDao;
import po.OrderPO;

public class OrderData implements OrderDao{

	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderPO getOrderByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
