package po;

import java.io.Serializable;

/**
 * @param userID 用户id
 * @param phoneNumber 电话
 * @param trueName 真实姓名
 * @param identityID 身份证号
 * @param vipType 会员类型 0:不是会员 1:普通会员 2:企业会员 
 * @param vipLevel 会员等级 0:不是会员 
 * @param vipInfo 若memberType为0则为空，否则为相应的生日或者企业信息
 * @author bcy
 *
 */
public class ClientPO implements Serializable{
	
	private String userID;
	private String phoneNumber;
	private String trueName;
	private String identityID;
	private int vipType; 
	private int vipLevel;
	private String vipInfo;

	public ClientPO(String userID, String phoneNumber, String trueName, String identityID,
			int vipType, int vipLevel, String vipInfo) {
		this.userID = userID;
		this.phoneNumber = phoneNumber;
		this.trueName = trueName;
		this.identityID = identityID;
		this.vipType = vipType;
		this.vipLevel = vipLevel;
		this.vipInfo = vipInfo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getIdentityID() {
		return identityID;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	
	public int getVipType() {
		return vipType;
	}

	public void setVipType(int vipType) {
		this.vipType = vipType;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(String vipInfo) {
		this.vipInfo = vipInfo;
	}
}