package dataDao.order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EvaluationPO;
import po.OrderPO;

public interface OrderDao extends Remote{
	
	//生成订单id时调用的,每次调用data层数据需要加1
	public int getOrderNum() throws RemoteException;
	
	public boolean addOrder(OrderPO orderPO) throws RemoteException;
	
	public boolean updateOrder(OrderPO orderPO) throws RemoteException;
	
	public OrderPO getOrderByOrderID(String orderID) throws RemoteException;
	
	public boolean addEvaluation(EvaluationPO po) throws RemoteException;
	
	public EvaluationPO getEvaluationByOrderID(String orderID) throws RemoteException;
	
	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) throws RemoteException;
	
	public ArrayList<String> getBookedHotelList (String userID) throws RemoteException;
}
