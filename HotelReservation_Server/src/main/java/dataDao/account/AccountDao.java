package dataDao.account;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AccountPO;

public interface AccountDao extends Remote{
	
	public boolean addAccount(AccountPO po) throws RemoteException;
	
	public boolean modifyPassword(AccountPO po) throws RemoteException;
	
	public AccountPO getAccountInfo(String accountID) throws RemoteException;
	
	public boolean userIDExists(String userID) throws RemoteException;
	
	public boolean hasLogin(String userID) throws RemoteException;
	
	public boolean setLogout(String userID) throws RemoteException;
	
	public boolean setLogin(String userID) throws RemoteException;
}