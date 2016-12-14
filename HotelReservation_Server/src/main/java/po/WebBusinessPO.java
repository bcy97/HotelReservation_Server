package po;

import java.io.Serializable;

/**
 * @param userID 用户ID
 * @param trueName 真实姓名
 * @param phoneNumber 电话
 * @param numberOfIdentityCard 身份证号码
 * @author bcy
 *
 */
public class WebBusinessPO implements Serializable{
	
	private String userID;
	private String trueName;
	private String phoneNumber;
	private String numberOfIdentityCard;
	
	public WebBusinessPO(String userID,String trueName,String phoneNumber,String numberOfIdentityCard) {
		this.userID=userID;
		this.trueName=trueName;
		this.phoneNumber=phoneNumber;
		this.numberOfIdentityCard=numberOfIdentityCard;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNumberOfIdentityCard() {
		return numberOfIdentityCard;
	}

	public void setNumberOfIdentityCard(String numberOfIdentityCard) {
		this.numberOfIdentityCard = numberOfIdentityCard;
	}
	
	
}
