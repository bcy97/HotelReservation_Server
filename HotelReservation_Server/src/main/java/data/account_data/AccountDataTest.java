package data.account_data;

import po.AccountPO;

public class AccountDataTest {

	public static void main(String[] args) {
		AccountData accountData = new AccountData();
		System.out.println(accountData.addAccount(new AccountPO("00001", "", 3)));
	}

}
