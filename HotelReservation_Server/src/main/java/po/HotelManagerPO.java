package po;

import java.io.Serializable;

/**
 * 
 * @param numberOfUser 酒店管理人员号
 * @param hotel     	所属酒店
 * @param phoneNumber   联系方式
 * @param trueName    	真实姓名
 * @param numberOfIdentityCard    身份证号
 */
public class HotelManagerPO implements Serializable{
	private String hotelID;
	private String phoneNumber;
	private String trueName;
	private String IdentityCardID;
	
	public HotelManagerPO(String hotelID, String phoneNumber, String trueName,
			String IdentityCardID) {
		this.hotelID = hotelID;
		this.phoneNumber = phoneNumber;
		this.trueName = trueName;
		this.IdentityCardID = IdentityCardID;
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

	public String getIdentityCardID() {
		return IdentityCardID;
	}

	public void setIdentityCardID(String identityCardID) {
		IdentityCardID = identityCardID;
	}
	

}
