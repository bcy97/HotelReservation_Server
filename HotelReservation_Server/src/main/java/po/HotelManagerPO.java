package po;

/**
 * 
 * @param numberOfUser 酒店管理人员号
 * @param hotel     所属酒店
 * @param phoneNumber   联系方式
 * @param trueName    真实姓名
 * @param numberOfIdentityCard    身份证号
 */
public class HotelManagerPO {
	private String userID;
	private String hotelID;
	private String phoneNumber;
	private String trueName;
	private String numberOfIdentityCard;
	
	
	public HotelManagerPO(String numberOfUser,String password,String hotel,String phoneNumber,String trueName,String numberOfIdentityCard) {
		super();
		this.userID=numberOfUser;
		this.hotelID=hotel;
		this.phoneNumber=phoneNumber;
		this.trueName=trueName;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getHotelID() {
		return hotelID;
	}


	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getTrueName() {
		return trueName;
	}


	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}


	public String getNumberOfIdentityCard() {
		return numberOfIdentityCard;
	}


	public void setNumberOfIdentityCard(String numberOfIdentityCard) {
		this.numberOfIdentityCard = numberOfIdentityCard;
	}
	
	
}
