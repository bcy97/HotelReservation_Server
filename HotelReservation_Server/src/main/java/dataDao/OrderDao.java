package dataDao;

import java.rmi.Remote;
import java.util.ArrayList;

import po.OrderPO;

public interface OrderDao extends Remote{
	public ArrayList<OrderPO> getOrderListByUserId(String userID);
	
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID);
	
	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID);
	
	public ArrayList<OrderPO> getAllDailyOrders(String time);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean addOrder(OrderPO orderPO);
	
	public OrderPO getOrderByOrderID(String orderID);
}
