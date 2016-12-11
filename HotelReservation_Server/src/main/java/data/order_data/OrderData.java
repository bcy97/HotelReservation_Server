package data.order_data;

import java.util.ArrayList;

import dataDao.order.OrderDao;
import po.EvaluationPO;
import po.OrderPO;

public class OrderData implements OrderDao{

	public boolean addOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderPO getOrderByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addEvalution(EvaluationPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public EvaluationPO getEvaluationByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getBookedHotelList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}


}
