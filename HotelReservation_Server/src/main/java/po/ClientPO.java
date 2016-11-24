package po;

/**
 * @param nameOfUser 用户名
 * @param phoneNumber 电话
 * @param isMember 是否是会员
 * @param birthdayOfMember 会员生日
 * @param trueName 真实姓名
 * @param credit 信用
 * @param bussiness 所属企业
 * @author bcy
 *
 */
public class ClientPO {
	
	private String nameOfUser;
	private String phoneNumber;
	private boolean isMember;
	private String birthdayOfMember;
	private String trueName;
	private int credit;
	private String bussiness;
	
	public ClientPO(String nameOfUser,String phoneNumber,boolean isMember,
			String birthdayOfMember,String trueName,int credit, String bussiness) {
		this.nameOfUser=nameOfUser;
		this.phoneNumber=phoneNumber;
		this.isMember=isMember;
		this.birthdayOfMember=birthdayOfMember;
		this.trueName=trueName;
		this.credit=credit;
		this.bussiness = bussiness;
	}
	
	public String getBussiness() {
		return bussiness;
	}

	public void setBussiness(String bussiness) {
		this.bussiness = bussiness;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public String getBirthdayOfMember() {
		return birthdayOfMember;
	}

	public void setBirthdayOfMember(String birthdayOfMember) {
		this.birthdayOfMember = birthdayOfMember;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
