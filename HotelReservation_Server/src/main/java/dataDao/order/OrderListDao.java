package dataDao.order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;

public interface OrderListDao extends Remote{
	
	/**
	 * 获取用户订单
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> getOrderListByUserId(String userID) throws RemoteException;
	
	/**
	 * 获取酒店订单
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) throws RemoteException;
	
	/**
	 * 获取当日所有订单
	 * @param time
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> getAllDailyOrders(String time) throws RemoteException;
}
