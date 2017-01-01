package datatest.user;

import data.user_data.ClientData;
import po.ClientPO;

public class ClientDataTest {

	public static void main(String[] args) {
		testAddClient();
		testGetClientInfo();
	}

	public static void testAddClient() {
		ClientData clientData = new ClientData();
		clientData.addClient(new ClientPO("abcdefgf", "12345678901", "卞纯源", "320923199710080017", 0, 0, null));
	}
	
	public static void testGetClientInfo(){
		ClientData clientData = new ClientData();
		ClientPO po = clientData.getClientInfo("abcdefgf");
		System.out.println(po.getUserID()+" "+po.getPhoneNumber()+" "+po.getTrueName()+" "+po.getIdentityID()+" "+po.getVipLevel()+" "+po.getVipType()+" "+po.getVipInfo());
	}
}
