package po;

import java.awt.Image;
import java.util.ArrayList;

/**
 * @param  kindOfRoom 房间类型
 * @param  price 房间价格
 * @param  isEmpty 是否空房
 * @param  roomID 房间ID
 * @param  pictures 房间照片
 * @author bcy
 *
 */
public class RoomPO {
	private String kindOfRoom;
	private int price;
	private boolean isEmpty;
	private int roomID;
	private ArrayList<Image> pictures;
	
	public RoomPO(String kindOfRoom,int price,boolean isEmpty,int roomID,ArrayList<Image> pictures) {
		this.kindOfRoom=kindOfRoom;
		this.price=price;
		this.isEmpty=isEmpty;
		this.roomID=roomID;
		this.pictures=pictures;
	}

	public String getKindOfRoom() {
		return kindOfRoom;
	}

	public void setKindOfRoom(String kindOfRoom) {
		this.kindOfRoom = kindOfRoom;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public ArrayList<Image> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<Image> pictures) {
		this.pictures = pictures;
	}
	
	
}
