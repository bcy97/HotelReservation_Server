package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @param uesrID 用户id
 * @param orderID 订单号
 * @param hotelId 酒店id
 * @param startTime 开始时间
 * @param endTime 结束时间
 * @param roomNum 酒店房间数量
 * @param roomType 房间类型
 * @param numberOfRooms  房间数量
 * @param hasChild  是否有小孩
 * @param numberOfPeople  入住人数
 * @param state 0:未执行 1:已执行 2:异常 3:撤销
 * @param beforePromotionPrice 促销前价格
 * @param afterPromotionPrice 促销后价格
 * @param promotionNum 使用的促销策略的数量
 * @param promotionID 该订单使用的促销策略
 * @param executedTime 订单执行的时间 格式yyyy/MM/dd HH:mm:ss
 * @param undoAbnormalTime 异常订单撤销的时间 格式yyyy/MM/dd HH:mm:ss
 * @param abnormalTime 订单被置为异常的时间 格式yyyy/MM/dd HH:mm:ss	
 * @param undoUnexecutedTime 未执行订单被置为异常的时间 格式yyyy/MM/dd HH:mm:ss	
 * @author Mark.W
 */
public class OrderPO implements Serializable{
	private String uesrID;
	private String orderID;
	private String hotelId;
	private String startTime;
	private String endTime;
	private int roomNum;
	private int roomType;
	private boolean hasChild;
	private int numberOfPeople;
	private int state; 
	private double beforePromotionPrice;
	private double afterPromotionPrice;
	private String promotionID;
	private String executedTime; //订单执行的时间
	private String undoAbnormalTime;	//异常订单撤销的时间
	private String abnormalTime;	//订单被置为异常的时间
	private String undoUnexecutedTime;	//未执行订单被用户置为异常的时间


	/**
	 * @param uesrID
	 * @param orderID
	 * @param hotelId
	 * @param startTime
	 * @param endTime
	 * @param roomNum
	 * @param roomType
	 * @param hasChild
	 * @param numberOfPeople
	 * @param state
	 * @param beforePromotionPrice
	 * @param afterPromotionPrice
	 * @param promotionNum
	 * @param promotionID
	 * @param executedTime
	 * @param undoAbnormalTime
	 * @param abnormalTime
	 * @param undoUnexecutedTime
	 */
	public OrderPO(String uesrID, String orderID, String hotelId, String startTime, String endTime, int roomNum,
			int roomType, boolean hasChild, int numberOfPeople, int state, double beforePromotionPrice,
			double afterPromotionPrice, String promotionID, String executedTime,
			String undoAbnormalTime, String abnormalTime, String undoUnexecutedTime) {
		super();
		this.uesrID = uesrID;
		this.orderID = orderID;
		this.hotelId = hotelId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.hasChild = hasChild;
		this.numberOfPeople = numberOfPeople;
		this.state = state;
		this.beforePromotionPrice = beforePromotionPrice;
		this.afterPromotionPrice = afterPromotionPrice;
		this.promotionID = promotionID;
		this.executedTime = executedTime;
		this.undoAbnormalTime = undoAbnormalTime;
		this.abnormalTime = abnormalTime;
		this.undoUnexecutedTime = undoUnexecutedTime;
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

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
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
	
	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
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

	public String getUndoUnexecutedTime() {
		return undoUnexecutedTime;
	}

	public void setUndoUnexecutedTime(String undoUnexecutedTime) {
		this.undoUnexecutedTime = undoUnexecutedTime;
	}
	

}
