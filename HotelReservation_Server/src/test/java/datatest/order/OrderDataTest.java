package datatest.order;

import java.util.ArrayList;

import data.order_data.OrderData;
import po.EvaluationPO;
import po.OrderPO;

public class OrderDataTest {

	public static void main(String[] args) {
		testGetOrderByOrder();
	}
	
	public static void testGetOrderNum() {
		OrderData orderData = new OrderData();
		System.out.println(orderData.getOrderNum());
	}
	
	public static void testGetBookedHotelList() {
		OrderData orderData = new OrderData();
		ArrayList<String> bookHotels = orderData.getBookedHotelList("123455");
		for (String string : bookHotels) {
			System.out.println(string);
		}
	}
	
	public static void testGetEvaluationByHotelID() {
		OrderData orderData = new OrderData();
		ArrayList<EvaluationPO> evaluationPOs = orderData.getEvaluationByHotelID("12345");
		for (EvaluationPO po : evaluationPOs) {
			System.out.println(po.getOrderID());
			System.out.println(po.getCommentLevel());
			System.out.println(po.getEvaluationContent());
		}
	}
	
	public static void testGetEvaluationiByOrderID() {
		OrderData orderData = new OrderData();
		EvaluationPO po = orderData.getEvaluationByOrderID("201612151241201");
		System.out.println(po.getOrderID());
		System.out.println(po.getCommentLevel());
		System.out.println(po.getEvaluationContent());
	}
	
	public static void testAddEvaluation() {
		OrderData orderData = new OrderData();
		EvaluationPO evaluationPO = new EvaluationPO("201612151241201", 5, "very good!");
		System.out.println(orderData.addEvaluation(evaluationPO));
	}
	public static void testUpdateOrder() {
		OrderData orderData = new OrderData();
		String[] roomIDs={"1101","1102","1103","1104"};
		OrderPO po2 = new OrderPO("bcy123", "201612151241201", "12412", "2016-12-15 12:00:00", "2016-12-16 12:00:00", roomIDs, 1,1, false, 2, 0, 200, 150, "123", "2016-12-16 12:00:00",null,null, null, null);
		System.out.println(orderData.updateOrder(po2));
	}
	
	public static void tsetAddOrder() {
		OrderData orderData = new OrderData();
		String[] roomIDs={"1101","1102","1103","1104"};
		OrderPO po2 = new OrderPO("bcy123", "201612151241201", "12412", "2016-12-15 12:00:00", "2016-12-16 12:00:00", roomIDs, 1,1, false, 2, 0, 200, 150, "123", null,null,null, null, null);
		System.out.println(orderData.addOrder(po2));
	}
	public static void testGetOrderByOrder(){
		OrderData orderData = new OrderData();
		OrderPO po = orderData.getOrderByOrderID("201612151241201");
		System.out.println(po.getUesrID());
		System.out.println(po.getOrderID());
		System.out.println(po.getHotelId());
		System.out.println(po.getStartTime());
		System.out.println(po.getEndTime());
		String[] roomids = po.getRoomIDs();
		for (String string : roomids) {
			System.out.print(string+" ");
		}
		System.out.println();
		System.out.println(po.getRoomNum());
		System.out.println(po.getRoomType());
		System.out.println(po.isHasChild());
		System.out.println(po.getNumberOfPeople());
		System.out.println(po.getState());
		System.out.println(po.getBeforePromotionPrice());
		System.out.println(po.getAfterPromotionPrice());
		System.out.println(po.getPromotionID());
		System.out.println(po.getCheckInTime());
		System.out.println(po.getCheckOutTime());
		System.out.println(po.getUndoAbnormalTime());
		System.out.println(po.getAbnormalTime());
		System.out.println(po.getUndoUnexecutedTime());
		
	}

	public static void testOrderIDExist() {
		OrderData orderData = new OrderData();
		System.out.println(orderData.orderIDExist("201612120000101"));
	}
}
