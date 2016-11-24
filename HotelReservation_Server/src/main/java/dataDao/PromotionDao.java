package dataDao;

import java.rmi.Remote;
import java.util.ArrayList;

import po.PromotionPO;

public interface PromotionDao extends Remote{

	public ArrayList<PromotionPO> getHotelPromotions(String hotel);
	
	public PromotionPO getPromotion(String promotionID);
	
	public ArrayList<PromotionPO> getWebPromotions();
	
	public boolean addPromotion(PromotionPO promotionPO);
	
	public boolean updatePromotion(PromotionPO promotionPO);
}
