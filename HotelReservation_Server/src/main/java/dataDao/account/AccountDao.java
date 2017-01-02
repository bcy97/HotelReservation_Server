package dataDao.account;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AccountPO;

public interface AccountDao extends Remote{
	
	/**
	 * 添加account
	 * @param po
	 * @return boolean是否添加成功
	 * @throws RemoteException
	 */
	public boolean addAccount(AccountPO po) throws RemoteException;
	
	/**
	 * 修改密码
	 * @param po
	 * @return boolean是否修改成功
	 * @throws RemoteException
	 */
	public boolean modifyPassword(AccountPO po) throws RemoteException;
	
	
	/**
	 * 获取account信息
	 * @param accountID
	 * @return AccountPO返回信息
	 * @throws RemoteException
	 */
	public AccountPO getAccountInfo(String accountID) throws RemoteException;
	
	/**
	 * 帐号是否存在
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public boolean userIDExists(String userID) throws RemoteException;
	
	/**
	 * 帐号是否登录
	 * @param userID
	 * @return boolean是否登录
	 * @throws RemoteException
	 */
	public boolean hasLogin(String userID) throws RemoteException;
	
	/**
	 * 置为登出
	 * @param userID
	 * @return boolean是否登出成功
	 * @throws RemoteException
	 */
	public boolean setLogout(String userID) throws RemoteException;
	
	/**
	 * 置为登录
	 * @param userID
	 * @return boolean是否登录成功
	 * @throws RemoteException
	 */
	public boolean setLogin(String userID) throws RemoteException;
}