package po;

import java.io.Serializable;
import java.util.HashMap;


/**
 * @param hotelId
 * @param roomId
 * @param roomType
 * @param price 小数点保留两位
 * @param notEmptyTime 保存房间不空闲的时间 key-value分别对应开始时间和结束时间，形式如“YYYY-MM-DD 12:00:00”
 */
public class RoomPO implements Serializable{

	private String hotelId;
	private String roomId;
	private int roomType; 
	private double price;
	private HashMap<String, String> notEmptyTime;
	

	/**
	 * @param hotelId
	 * @param roomId
	 * @param roomType
	 * @param price 小数点保留两位
	 * @param notEmptyTime 保存房间不空闲的时间 key-value分别对应开始时间和结束时间，形式如“YYYY-MM-DD 12:00:00”
s	 */
	public RoomPO(String hotelId, String roomId, int roomType, double price, 
			HashMap<String, String> notEmptyTime) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.notEmptyTime = notEmptyTime;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public HashMap<String, String> getNotEmptyTime() {
		return notEmptyTime;
	}

	public void setNotEmptyTime(HashMap<String, String> notEmptyTime) {
		this.notEmptyTime = notEmptyTime;
	}
	
}
