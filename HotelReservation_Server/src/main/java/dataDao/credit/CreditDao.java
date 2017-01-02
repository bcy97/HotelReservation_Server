package dataDao.credit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditHistoryPO;

public interface CreditDao extends Remote{
	
	/**
	 * 改变信用值
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean changeCredit(CreditHistoryPO po) throws RemoteException;
	
	/**
	 * 获取信用记录
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) throws RemoteException;
	
	/**
	 * 获取当前信用
	 * @param userID
	 * @return
	 * @throws RemoteException
	 */
	public int getCredit(String userID) throws RemoteException;
	
	/**
	 * 设置vip信用
	 * @param level
	 * @param credit_num
	 * @return
	 * @throws RemoteException
	 */
	public boolean setVIPCredit(int level, int credit_num)  throws RemoteException;

	/**
	 * 获取等级对应vip信用
	 * @param level
	 * @return
	 * @throws RemoteException
	 */
	public int getVIPCredit(int level) throws RemoteException;
	
}
