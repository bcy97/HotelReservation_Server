package po;

/**
 * @param orderID 订单ID
 * @param commentLevel 评价星级
 * @param evaluationContent 评价信息
 * @author bcy
 *
 */
public class EvaluationPO {
	
	private String orderID;
	private double commentLevel;
	private String evaluationContent;
	
	
	/**
	 * @param orderID
	 * @param commentLevel
	 * @param evaluationContent
	 */
	public EvaluationPO(String orderID, double commentLevel, String evaluationContent) {
		this.orderID = orderID;
		this.commentLevel = commentLevel;
		this.evaluationContent = evaluationContent;
	}

	public String getOrderID() {
		return orderID;
	}
	
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public double getCommentLevel() {
		return commentLevel;
	}
	
	public void setCommentLevel(double commentLevel) {
		this.commentLevel = commentLevel;
	}
	
	public String getEvaluationContent() {
		return evaluationContent;
	}
	
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	

	
}
