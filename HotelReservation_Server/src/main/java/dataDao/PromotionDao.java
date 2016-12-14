package dataDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao extends Remote {

	// promotionType 参数若为0，则表示要拿hotel的所有promotion
	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) throws RemoteException;
	
	public ArrayList<PromotionPO> getWebPromotions(int promotionType) throws RemoteException;
	
	public PromotionPO getPromotion(String promotionID) throws RemoteException;
	
	public boolean addPromotion(PromotionPO promotionPO) throws RemoteException;
	
	public boolean updatePromotion(PromotionPO promotionPO) throws RemoteException;
}
