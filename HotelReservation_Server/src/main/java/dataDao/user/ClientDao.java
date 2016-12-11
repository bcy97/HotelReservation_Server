package dataDao.user;

import java.rmi.Remote;

import po.ClientPO;

public interface ClientDao extends Remote{

	public boolean addClient(ClientPO po);
	
	public ClientPO getClientInfo(String clientID);
	
	public boolean updateClientInfo(ClientPO clientPO);
}
