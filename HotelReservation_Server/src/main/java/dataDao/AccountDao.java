package dataDao;

import java.rmi.Remote;

import po.AccountPO;

public interface AccountDao extends Remote{
	
	public boolean addAccount(AccountPO po);
	
	public boolean modifyPassword(AccountPO po);
	
	public AccountPO getAccountInfo(AccountPO po);
}
