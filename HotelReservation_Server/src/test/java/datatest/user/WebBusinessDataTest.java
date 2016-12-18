package datatest.user;

import data.user_data.WebBusinessData;
import po.WebBusinessPO;

public class WebBusinessDataTest {

	public static void main(String[] args) {
		WebBusinessData webBusinessData = new WebBusinessData();
		WebBusinessPO webBusinessPO=webBusinessData.getWebBusinessInfo("123456");
		System.out.println(webBusinessPO.getUserID()+" "+webBusinessPO.getTrueName()+" "+webBusinessPO.getPhoneNumber()+" "+webBusinessPO.getNumberOfIdentityCard());
		webBusinessData.updateWebBusinessInfo(new WebBusinessPO("123456", "wyy", "15100000000", "098765432112345678"));
		WebBusinessPO webBusinessPO2=webBusinessData.getWebBusinessInfo("123456");
		System.out.println(webBusinessPO2.getUserID()+" "+webBusinessPO2.getTrueName()+" "+webBusinessPO2.getPhoneNumber()+" "+webBusinessPO2.getNumberOfIdentityCard());
		webBusinessData.addWebBusiness(new WebBusinessPO("654321", "bcy", "76543210981", "098761234512345678"));
	}

}
