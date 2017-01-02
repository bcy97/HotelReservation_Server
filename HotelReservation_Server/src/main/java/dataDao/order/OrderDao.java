package dataDao.order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EvaluationPO;
import po.OrderPO;

public interface OrderDao extends Remote{
	
	//生成订单id时调用的,每次调用data层数据需要加1
	public int getOrderNum() throws RemoteException;
	
	/**
	 * 添加order
	 * @param orderPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addOrder(OrderPO orderPO) throws RemoteException;
	
	/**
	 * 更新order
	 * @param orderPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateOrder(OrderPO orderPO) throws RemoteException;
	
	/**
	 * 获取order信息
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public OrderPO getOrderByOrderID(String orderID) throws RemoteException;
	
	/**
	 * 添加评价
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean addEvaluation(EvaluationPO po) throws RemoteException;
	
	/**
	 * 获取order的评价信息
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public EvaluationPO getEvaluationByOrderID(String orderID) throws RemoteException;
	
	/**
	 * 获取酒店评价
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) throws RemoteException;
	
	/**
	 * 获取预定过的酒店
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getBookedHotelList (String userID) throws RemoteException;
}
