package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientPO;

public interface ClientDao extends Remote{
	
	public boolean addClient(ClientPO po) throws RemoteException;
	
	public ClientPO getClientInfo(String clientID) throws RemoteException;
	
	public boolean updateClientInfo(ClientPO clientPO) throws RemoteException;
	
}