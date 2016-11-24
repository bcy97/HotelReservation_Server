package po;

import java.awt.Image;
import java.util.ArrayList;
/**
 * @param orderID 订单ID
 * @param hotelId 酒店ID
 * @param evaluation 评价信息
 * @param numberOfStars 评价星级
 * @param pictures 照片
 * @author bcy
 *
 */
public class EvaluationPO {
	
	private String orderID;
	private String hotelId;
	private String evaluation;
	private int numberOfStars;
	private ArrayList<Image> pictures;

	public EvaluationPO(String orderID , String hotelId , String evaluation , 
			int numberOfStars , ArrayList<Image> pictures) {
		this.orderID=orderID;
		this.hotelId=hotelId;
		this.evaluation=evaluation;
		this.numberOfStars=numberOfStars;
		this.pictures=pictures;
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

	public ArrayList<Image> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<Image> pictures) {
		this.pictures = pictures;
	}
	
	
}
