package po;

/**
 * @param orderID 订单ID
 * @param evaluation 评价信息
 * @param numberOfStars 评价星级
 * @author bcy
 *
 */
public class EvaluationPO {
	
	private String orderID;
	private String evaluation;
	private int numberOfStars;

	public EvaluationPO(String orderID , String evaluation, int numberOfStars ) {
		this.orderID=orderID;
		this.evaluation=evaluation;
		this.numberOfStars=numberOfStars;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public int getNumberOfStars() {
		return numberOfStars;
	}

	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}
}
