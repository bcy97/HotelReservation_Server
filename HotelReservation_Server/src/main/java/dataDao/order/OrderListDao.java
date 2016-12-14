package dataDao.order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;

public interface OrderListDao extends Remote{
	
	public ArrayList<OrderPO> getOrderListByUserId(String userID) throws RemoteException;
	
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) throws RemoteException;
	
	public ArrayList<OrderPO> getAllDailyOrders(String time) throws RemoteException;
}
