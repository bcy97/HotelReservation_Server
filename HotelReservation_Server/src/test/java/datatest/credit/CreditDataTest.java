package datatest.credit;

import java.util.ArrayList;

import data.credit_data.CreditData;
import po.CreditHistoryPO;

public class CreditDataTest {

	public static void main(String [] args) {
		CreditData creditData = new CreditData();
		ArrayList<CreditHistoryPO> pos = creditData.getCreditHistory("123");
		for (CreditHistoryPO creditHistoryPO : pos) {
			System.out.println(creditHistoryPO.getUserID()+" "+creditHistoryPO.getTime()+" "+creditHistoryPO.getOrderID()+" "
								+creditHistoryPO.getAction()+" "+creditHistoryPO.getCreditChange()+" "+creditHistoryPO.getNowCredit());
		}
		System.out.println(creditData.getCredit("123"));
		System.out.println(creditData.setVIPCredit(2, 1000));
		System.out.println(creditData.getVIPCredit(2));
	}
}
