package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientPO;

public interface ClientDao extends Remote{
	
	/**
	 * 添加账户
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean addClient(ClientPO po) throws RemoteException;
	
	/**
	 * 获取账户信息
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ClientPO getClientInfo(String clientID) throws RemoteException;
	
	/**
	 * 更新客户信息
	 * @param clientPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateClientInfo(ClientPO clientPO) throws RemoteException;
	
}