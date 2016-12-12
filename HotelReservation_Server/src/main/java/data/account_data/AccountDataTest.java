package data.account_data;

import po.AccountPO;

public class AccountDataTest {

	public static void main(String[] args) {
		AccountData accountData = new AccountData();
		System.out.println(accountData.addAccount(new AccountPO("00001", "1234567", 3)));
		System.out.println(accountData.getAccountInfo("00001").getPassword()+" "+accountData.getAccountInfo("00001").getIdentity());
		accountData.modifyPassword(new AccountPO("00001", "123456", 1));
		System.out.println(accountData.getAccountInfo("00001").getPassword()+" "+accountData.getAccountInfo("00001").getIdentity());
	}

}
