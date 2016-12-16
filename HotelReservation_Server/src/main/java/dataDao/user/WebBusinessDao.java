package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.WebBusinessPO;

public interface WebBusinessDao extends Remote{

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) throws RemoteException;
	
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) throws RemoteException;
	
	public boolean addWebBusiness(WebBusinessPO  webBusinessPO)  throws RemoteException;
}