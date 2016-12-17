package po;

import java.io.Serializable;

/**
 * @param userID 用户ID
 * @param time 信用修改时间
 * @param orderID 订单ID
 * @param action 操作  //0:正常执行订单增加 1:被置为异常订单扣除 2.酒店工作人员补登记异常订单恢复 3.撤销异常订单恢复 4.充值 5.撤销未执行订单扣除订单价值的一半
 * @param cerditChange 信用变化值
 * @param nowCredit 当前信用
 * @author bcy
 *
 */
public class CreditHistoryPO implements Serializable{
	
	private String userID;
	private String time;
	private String orderID;
	private int action;
	private int creditChange;
	private int nowCredit;
	
	public CreditHistoryPO(String userID , String time , String orderID , 
			int action , int creditChange , int nowCredit) {
		this.userID=userID;
		this.time=time;
		this.orderID=orderID;
		this.action=action;
		this.creditChange=creditChange;
		this.nowCredit=nowCredit;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getCreditChange() {
		return creditChange;
	}

	public void setCreditChange(int cerditChange) {
		this.creditChange = cerditChange;
	}

	public int getNowCredit() {
		return nowCredit;
	}

	public void setNowCredit(int nowCredit) {
		this.nowCredit = nowCredit;
	}
	
	
}
