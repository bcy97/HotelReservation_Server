package dataDao.user;

import java.rmi.Remote;

import po.WebBusinessPO;

public interface WebBusinessDao extends Remote {

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID);
	
	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo);

}
