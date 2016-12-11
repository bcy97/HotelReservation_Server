package po;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @param hoteID 酒店ID
 * @param hotelName 酒店名称
 * @param city 城市
 * @param distract 所在行政区
 * @param tradingArea 所属商圈
 * @param locationOfHotel 酒店地址
 * 
 * @param evaluationGrades 评价等级
 * @param levelOfHotel 酒店星级
 * @param introduction 酒店介绍
 * @param facilities 酒店设施
 * @param picturesPath 照片
 * @param emptyRoomNum 不同类型房间空余数量，类型 0单人间 1标准间 2三人间 3大床房 4套间
 * @param bussiness 合作企业
 * @author Mark.W
 *
 */
public class HotelPO {

	private String hoteID;
	private String hotelName;
	private String city;
	private String distract;
	private String tradingArea;
	private String locationOfHotel;
	public double evaluationGrades;
	private int levelOfHotel;
	private String introduction;
	private String facilities;
	private ArrayList<String> picturesPath;
	private HashMap<Integer, Integer> emptyRoomNum;
	private String bussiness;

	public HotelPO(String hoteID,String hotelName,String city,String distract,String tradingArea,
			String locationOfHotel,Double evaluationGrades,int levelOfHotel,String introduction, String facilities, 
			ArrayList<String> pictures,	HashMap<Integer, Integer> emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.hotelName=hotelName;
		this.city=city;
		this.distract = distract;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.evaluationGrades=evaluationGrades;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.facilities = facilities;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
	}
	
	/**
	 * 提供给WebManager的构造方法
	 * @param hoteID
	 * @param hotelName
	 * @param city
	 * @param distract
	 * @param tradingArea
	 * @param locationOfHotel
	 * @param levelOfHotel
	 * @param introduction
	 * @param facilities
	 * @param pictures
	 * @param emptyRoomNum
	 * @param bussiness
	 */
	public HotelPO(String hoteID,String hotelName,String city,String distract,String tradingArea,
			String locationOfHotel,int levelOfHotel,String introduction, String facilities, 
			ArrayList<String> pictures,	HashMap<Integer, Integer> emptyRoomNum, String bussiness) {
		this.hoteID=hoteID;
		this.hotelName=hotelName;
		this.city=city;
		this.distract = distract;
		this.tradingArea=tradingArea;
		this.locationOfHotel=locationOfHotel;
		this.levelOfHotel=levelOfHotel;
		this.introduction=introduction;
		this.facilities = facilities;
		this.picturesPath=pictures;
		this.emptyRoomNum=emptyRoomNum;
		this.bussiness = bussiness;
	}

	public String getHoteID() {
		return hoteID;
	}

	public void setHoteID(String hoteID) {
		this.hoteID = hoteID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistract() {
		return distract;
	}

	public void setDistract(String distract) {
		this.distract = distract;
	}

	public String getTradingArea() {
		return tradingArea;
	}

	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}

	public String getLocationOfHotel() {
		return locationOfHotel;
	}

	public void setLocationOfHotel(String locationOfHotel) {
		this.locationOfHotel = locationOfHotel;
	}

	public double getEvaluationGrades() {
		return evaluationGrades;
	}

	public void setEvaluationGrades(double evaluationGrades) {
		this.evaluationGrades = evaluationGrades;
	}

	public int getLevelOfHotel() {
		return levelOfHotel;
	}

	public void setLevelOfHotel(int levelOfHotel) {
		this.levelOfHotel = levelOfHotel;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public ArrayList<String> getPicturesPath() {
		return picturesPath;
	}

	public void setPicturesPath(ArrayList<String> picturesPath) {
		this.picturesPath = picturesPath;
	}

	public HashMap<Integer, Integer> getEmptyRoomNum() {
		return emptyRoomNum;
	}

	public void setEmptyRoomNum(HashMap<Integer, Integer> emptyRoomNum) {
		this.emptyRoomNum = emptyRoomNum;
	}

	public String getBussiness() {
		return bussiness;
	}

	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}
	
}
