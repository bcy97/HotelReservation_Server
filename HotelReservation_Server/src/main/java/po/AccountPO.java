package po;

import java.io.Serializable;

/**
 * @param accountID 帐号ID
 * @param password  密码
 * @param identity  帐号身份 0:客户 1:酒店管理人员 2:网站管理人员 3:网站营销人员
 * @author bcy
 *
 */
public class AccountPO implements Serializable{
	
	private String accountID;
	private String password;
	private int identity;
	
	public AccountPO(String accountID , String password, int identity) {
		this.identity=identity;
		this.accountID=accountID;
		this.password=password;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
