package dataDao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.WebBusinessPO;

public interface WebBusinessDao extends Remote{

	/**
	 * 获取网站营销人员信息
	 * @param webBusiness_ID
	 * @return
	 * @throws RemoteException
	 */
	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) throws RemoteException;
	
	/**
	 * 更新信息
	 * @param webBusinessInfo
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) throws RemoteException;
	
	/**
	 * 添加网站营销人员
	 * @param webBusinessPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addWebBusiness(WebBusinessPO  webBusinessPO)  throws RemoteException;
}