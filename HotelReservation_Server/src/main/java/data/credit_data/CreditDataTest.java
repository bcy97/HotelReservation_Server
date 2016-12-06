package data.credit_data;

import java.util.ArrayList;

import po.CreditHistoryPO;

public class CreditDataTest {

	public static void main(String [] args) {
		CreditData creditData = new CreditData();
		ArrayList<CreditHistoryPO> pos = creditData.getCreditHistory("1234");
		for (CreditHistoryPO creditHistoryPO : pos) {
			System.out.println(creditHistoryPO.getUserID()+" "+creditHistoryPO.getTime()+" "+creditHistoryPO.getOrderID());
//								+creditHistoryPO.getAction()+" "+creditHistoryPO.getCreditChange()+" "+creditHistoryPO.getNowCredit());
			System.out.println(creditHistoryPO.getTime());
		}
	}
}
