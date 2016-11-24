package po;

/**
 * @param userID 用户ID
 * @param time 信用修改时间
 * @param orderID 订单ID
 * @param action 操作  0:正常执行订单增加 1:异常订单扣除 2.撤销订单扣除 3.充值
 * @param cerditChange 信用变化值
 * @param nowCredit 当前信用
 * @author bcy
 *
 */
public class CreditHistoryPO {
	
	private String userID;
	private String time;
	private String orderID;
	private int action;
	private int cerditChange;
	private int nowCredit;
	
	public CreditHistoryPO(String userID , String time , String orderID , 
			int action , int cerditChange , int nowCredit) {
		this.userID=userID;
		this.time=time;
		this.orderID=orderID;
		this.action=action;
		this.cerditChange=cerditChange;
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

	public int getCerditChange() {
		return cerditChange;
	}

	public void setCerditChange(int cerditChange) {
		this.cerditChange = cerditChange;
	}

	public int getNowCredit() {
		return nowCredit;
	}

	public void setNowCredit(int nowCredit) {
		this.nowCredit = nowCredit;
	}
	
	
}
