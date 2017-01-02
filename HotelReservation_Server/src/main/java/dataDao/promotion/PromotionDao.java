package dataDao.promotion;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao extends Remote{
	
	/**
	 * 删除评价
	 * @param promotionID
	 * @return
	 * @throws RemoteException
	 */
	public boolean deletePromotion(String promotionID) throws RemoteException;

	/**
	 * promotionType 参数若为0，则表示要拿hotel的所有promotion
	 * @param hotel
	 * @param promotionType
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) throws RemoteException;
	
	/**
	 * 获取网站促销策略
	 * @param promotionType
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PromotionPO> getWebPromotions(int promotionType) throws RemoteException;
	
	/**
	 * 获取促销策略
	 * @param promotionID
	 * @return
	 * @throws RemoteException
	 */
	public PromotionPO getPromotion(String promotionID) throws RemoteException;
	
	/**
	 * 
	 * @param promotionPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean addPromotion(PromotionPO promotionPO) throws RemoteException;
	
	/**
	 * 
	 * @param promotionPO
	 * @return
	 * @throws RemoteException
	 */
	public boolean updatePromotion(PromotionPO promotionPO) throws RemoteException;
	
	/**
	 * 获取是第几个订单，用于生成订单promotionid 每次调用完data层数字加一
	 * @return
	 * @throws RemoteException
	 */
	public int getPromotinoNum() throws RemoteException;
}
