package dataDao;

import java.rmi.Remote;
import java.util.ArrayList;

import po.CreditHistoryPO;

public interface CreditDao extends Remote {
	
	public boolean changeCredit(CreditHistoryPO po);
	
	public ArrayList<CreditHistoryPO> getCreditHistory(String userID);
	
	public int getCredit(String userID);
	
	public boolean setVIPCredit(int level, int credit_num);

	public int getVIPCredit(int level);
	
}
