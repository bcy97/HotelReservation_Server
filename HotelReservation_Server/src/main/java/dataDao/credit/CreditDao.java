package dataDao.credit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditHistoryPO;

public interface CreditDao extends Remote{
	
	public boolean changeCredit(CreditHistoryPO po) throws RemoteException;
	
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) throws RemoteException;
	
	public int getCredit(String userID) throws RemoteException;
	
	public boolean setVIPCredit(int level, int credit_num)  throws RemoteException;

	public int getVIPCredit(int level) throws RemoteException;
	
}
