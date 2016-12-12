package dataDao;

import po.AccountPO;

public interface AccountDao {
	public boolean addAccount(AccountPO po);
	
	public boolean modifyPassword(AccountPO po);
	
	public AccountPO getAccountInfo(String accountID);
	
	public boolean userIDExists(String userID);
	
	public boolean hasLogin(String userID);
	
	public boolean setLogout(String userID);
	
	public boolean setLogin(String userID);
}