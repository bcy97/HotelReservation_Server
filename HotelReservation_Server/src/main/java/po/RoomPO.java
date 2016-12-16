package po;


/**
 * @param hotelId
 * @param roomType
 * @param roomNum
 * @param price
 * @param specificTimeRoomNum  接下来30天对应的房间数量, 0表示今天，1表示明天，依次类推，每天过0点后更新数组数据
 */
public class RoomPO {

	private String hotelId;
	private int roomType;
	private int roomNum;
	private double price;
	private int[] specificTimeRoomNum;

	/**
	 * @param hotelId
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @param specificTimeRoomNum
	 */
	public RoomPO(String hotelId, int roomType, int roomNum, double price, int[] specificTimeRoomNum) {
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.price = price;
		this.specificTimeRoomNum = specificTimeRoomNum;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int[] getSpecificTimeRoomNum() {
		return specificTimeRoomNum;
	}

	public void setSpecificTimeRoomNum(int[] specificTimeRoomNum) {
		this.specificTimeRoomNum = specificTimeRoomNum;
	}

}
