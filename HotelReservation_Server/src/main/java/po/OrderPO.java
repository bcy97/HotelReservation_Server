package po;

import java.util.ArrayList;

/**
 * @param uesrID 用户id
 * @param orderID 订单号
 * @param hotelId 酒店id
 * @param startTime 开始时间
 * @param endTime 结束时间
 * @param roomNum 酒店房间数量
 * @param roomID 酒店房间号
 * @param numberOfRooms  房间数量
 * @param hasChild  是否有小孩
 * @param numberOfPeople  入住人数
 * @param state 0:未执行 1:已执行 2:异常 3:撤销
 * @param beforePromotionPrice 促销前价格
 * @param afterPromotionPrice 促销后价格
 * @param promotionNum 使用的促销策略的数量
 * @param promotionIDs 该订单使用的促销策略
 * @param executedTime 订单执行的时间 格式yyyy-MM-dd HH:mm:ss
 * @param undoAbnormalTime 订单撤销的时间 格式yyyy-MM-dd HH:mm:ss
 * @param abnormalTime 订单被置为异常的时间 格式yyyy-MM-dd HH:mm:ss	
 * @author Mark.W
 */
public class OrderPO {
	private String uesrID;
	private String orderID;
	private String hotelId;
	private String startTime;
	private String endTime;
	private int roomNum;
	private ArrayList<String> roomIDs;
	private boolean hasChild;
	private int numberOfPeople;
	private int state; 
	private double beforePromotionPrice;
	private double afterPromotionPrice;
	private int promotionNum;
	private ArrayList<String> promotionIDs;
	private String executedTime; //订单执行的时间
	private String undoAbnormalTime;	//订单撤销的时间
	private String abnormalTime;	//订单被置为异常的时间


	public OrderPO(String userID, String orderID,String hotelId, String startTime, String endTime,
			int roomNum, ArrayList<String> roomIDs,boolean hasChild, int numberOfPeople, int state,
			double beforePromotionPrice, double afterPromotionPrice, int promotionNum, 
			ArrayList<String> promotionIDs,
			String executedTime, String undoAbnormalTime, String abnormalTime) {
		this.uesrID = userID;
		this.orderID=orderID;
		this.startTime=startTime;
		this.hotelId=hotelId;
		this.roomNum = roomNum;
		this.roomIDs = roomIDs;
		this.endTime=endTime;
		this.hasChild=hasChild;
		this.numberOfPeople=numberOfPeople;
		this.state = state;
		this.beforePromotionPrice = beforePromotionPrice;
		this.afterPromotionPrice = afterPromotionPrice;
		this.promotionNum = promotionNum;
		this.promotionIDs = promotionIDs;
		this.executedTime = executedTime;
		this.undoAbnormalTime = undoAbnormalTime;
		this.abnormalTime = abnormalTime;
	}


	public String getUesrID() {
		return uesrID;
	}


	public void setUesrID(String uesrID) {
		this.uesrID = uesrID;
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public ArrayList<String> getRoomIDs() {
		return roomIDs;
	}


	public void setRoomIDs(ArrayList<String> roomIDs) {
		this.roomIDs = roomIDs;
	}


	public boolean isHasChild() {
		return hasChild;
	}


	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}


	public int getNumberOfPeople() {
		return numberOfPeople;
	}


	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public double getBeforePromotionPrice() {
		return beforePromotionPrice;
	}


	public void setBeforePromotionPrice(double beforePromotionPrice) {
		this.beforePromotionPrice = beforePromotionPrice;
	}


	public double getAfterPromotionPrice() {
		return afterPromotionPrice;
	}


	public void setAfterPromotionPrice(double afterPromotionPrice) {
		this.afterPromotionPrice = afterPromotionPrice;
	}


	public int getPromotionNum() {
		return promotionNum;
	}


	public void setPromotionNum(int promotionNum) {
		this.promotionNum = promotionNum;
	}


	public ArrayList<String> getPromotionIDs() {
		return promotionIDs;
	}


	public void setPromotionIDs(ArrayList<String> promotionIDs) {
		this.promotionIDs = promotionIDs;
	}


	public String getExecutedTime() {
		return executedTime;
	}


	public void setExecutedTime(String executedTime) {
		this.executedTime = executedTime;
	}


	public String getUndoAbnormalTime() {
		return undoAbnormalTime;
	}


	public void setUndoAbnormalTime(String undoAbnormalTime) {
		this.undoAbnormalTime = undoAbnormalTime;
	}


	public String getAbnormalTime() {
		return abnormalTime;
	}


	public void setAbnormalTime(String abnormalTime) {
		this.abnormalTime = abnormalTime;
	}
	
}
