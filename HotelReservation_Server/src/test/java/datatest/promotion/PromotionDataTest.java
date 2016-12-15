package datatest.promotion;

import data.promotion_data.PromotionData;

public class PromotionDataTest {
	
	public static void main(String[] args) {
		testGetPromotionNum();
	}
	
	private static void testGetPromotionNum() {
		PromotionData promotionData= new PromotionData();
		System.out.println(promotionData.getPromotinoNum());
	}
}
