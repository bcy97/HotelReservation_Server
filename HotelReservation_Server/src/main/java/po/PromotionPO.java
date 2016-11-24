package po;

import java.util.HashMap;

/**
 * @param promotionID 促销ID
 * @param name 促销名称
 * @param hotelID 酒店ID
 * @param isWeb 是否为网站促销策略
 * @param discount 折扣
 * @param enough 满多少
 * @param enoughMinus 减多少
 * @param startTime 促销开始时间
 * @param endTime 促销结束时间
 * @param vipLevelDiscount 会员等级对应折扣
 * @param vipLocationDiscount 会员特定商圈专属折扣
 * @author bcy
 *
 */
public class PromotionPO {
	private String promotionID;
	private String name;
	private String hotelID;
	private boolean isWeb;
	private double discount;
	private int enough;
	private int enoughMinus;
	private String startTime;
	private String endTime;
	private HashMap<Integer, Double> vipLevelDiscount;
	private HashMap<Integer, Double> vipLocationDiscount;
	
	public PromotionPO(String promotionID,String name,String hotelID,boolean isWeb, 
			HashMap<Integer, Double> vipLevelDiscount,HashMap<Integer, Double> vipLocationDiscount,
			double discount, int enough, int enoughMinus, String startTime, String endTime) {
		this.promotionID=promotionID;
		this.name=name;
		this.hotelID=hotelID;
		this.isWeb=isWeb;
		this.vipLevelDiscount = vipLevelDiscount;
		this.vipLocationDiscount = vipLocationDiscount;
	}

	public String getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(String promotionID) {
		this.promotionID = promotionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public boolean isWeb() {
		return isWeb;
	}

	public void setWeb(boolean isWeb) {
		this.isWeb = isWeb;
	}
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getEnough() {
		return enough;
	}

	public void setEnough(int enough) {
		this.enough = enough;
	}

	public int getEnoughMinus() {
		return enoughMinus;
	}

	public void setEnoughMinus(int enoughMinus) {
		this.enoughMinus = enoughMinus;
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

	public HashMap<Integer, Double> getVipLevelDiscount() {
		return vipLevelDiscount;
	}

	public void setVipLevelDiscount(HashMap<Integer, Double> vipLevelDiscount) {
		this.vipLevelDiscount = vipLevelDiscount;
	}

	public HashMap<Integer, Double> getVipLocationDiscount() {
		return vipLocationDiscount;
	}

	public void setVipLocationDiscount(HashMap<Integer, Double> vipLocationDiscount) {
		this.vipLocationDiscount = vipLocationDiscount;
	}

	
}
