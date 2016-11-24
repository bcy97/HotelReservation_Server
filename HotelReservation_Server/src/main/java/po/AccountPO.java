package po;

/**
 * @param identity  帐号身份
 * @param accountID 帐号ID
 * @param password  密码
 * @author bcy
 *
 */
public class AccountPO {
	private int identity;
	private String accountID;
	private String password;
	
	public AccountPO(int identity , String accountID , String password) {
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
