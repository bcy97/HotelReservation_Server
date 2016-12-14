package data.promotion_data;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import po.PromotionPO;

public class PromotionDataTest {
	
//	public static void main(String[] args) {
//		PromotionData promotionData = new PromotionData();
//		ArrayList<PromotionPO> pos = promotionData.getWebPromotions(1);
//		for (PromotionPO promotionPO : pos) {
//			HashMap<String, double[]>hashMap = promotionPO.getVipTradeAreaDiscount();
//			Iterator<Entry<String, double[]>> iterator = hashMap.entrySet().iterator();
//			while(iterator.hasNext()){
//				Map.Entry<String,double[]> entry =  (Entry<String, double[]>) iterator.next();
//				String tradingArea = (String) entry.getKey();
//				double[] discounts = (double[]) entry.getValue();
//				System.out.print(tradingArea+" ");
//				for (double d : discounts) {
//					System.out.print(d+" ");
//				}
//			}
//		}
//		System.out.println();
//		PromotionPO promotionPO = promotionData.getPromotion("12345");
//		HashMap<String, double[]>hashMap = promotionPO.getVipTradeAreaDiscount();
//		Iterator iterator = hashMap.entrySet().iterator();
//		while(iterator.hasNext()){
//			Map.Entry entry = (Map.Entry) iterator.next();
//			String tradingArea = (String) entry.getKey();
//			double[] discounts = (double[]) entry.getValue();
//			System.out.print(tradingArea+" ");
//			for (double d : discounts) {
//				System.out.print(d+" ");
//			}
//		}
//		double[] roomsAndDiscount={0.1,0.2,0.3,0.4,0.5};
//		HashMap<String, double[]> vipTradeAreaDiscount =new HashMap<String, double[]>();
//		vipTradeAreaDiscount.put("新街口", roomsAndDiscount);
//		vipTradeAreaDiscount.put("仙林中心", roomsAndDiscount);
//		double[] vipLevelDiscount ={0.5,0.4,0.3};
//		PromotionPO po=new PromotionPO(1, "971008", "00021", "双十二", 0.8, "2016-01-01 00:00:00", "2016-12-31 00:00:00", "南京大学", null, null, vipLevelDiscount);
////		promotionData.addPromotion(po);
//		promotionData.updatePromotion(po);
//		ArrayList<PromotionPO> pos = promotionData.getHotelPromotions("00001", 1);
//		for (PromotionPO promotionPO : pos) {
//			if (promotionPO.getVipTradeAreaDiscount()==null) {
//				continue;
//			}
//			HashMap<String, double[]>hashMap = promotionPO.getVipTradeAreaDiscount();
//			Iterator<Entry<String, double[]>> iterator = hashMap.entrySet().iterator();
//			while(iterator.hasNext()){
//				Map.Entry<String,double[]> entry =  (Entry<String, double[]>) iterator.next();
//				String tradingArea = (String) entry.getKey();
//				double[] discounts = (double[]) entry.getValue();
//				System.out.print(tradingArea+" ");
//				for (double d : discounts) {
//					System.out.print(d+"  ");
//				}
//			}
//			System.out.println(promotionPO.getPromotionName());
//		}
//	}
}
