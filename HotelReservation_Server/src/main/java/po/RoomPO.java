package po;

import java.util.ArrayList;


/**
 * @param hotelId
 * @param roomId
 * @param roomType
 * @param price 小数点保留两位
 * @param isEmpty
 * @param pictures
 */
public class RoomPO {

	private String hotelId;
	private String roomId;
	private int roomType; 
	private double price;
	private boolean isEmpty;
	private ArrayList<String> pictures;
	
	public RoomPO(String hotelId, String roomId, int roomType, double price, boolean isEmpty,
			ArrayList<String> pictures) {
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.isEmpty = isEmpty;
		this.pictures = pictures;
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

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public ArrayList<String> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}
	
}
