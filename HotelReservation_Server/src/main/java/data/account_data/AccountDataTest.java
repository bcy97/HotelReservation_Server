package data.account_data;

import po.AccountPO;

public class AccountDataTest {

	public static void main(String[] args) {
		AccountData accountData = new AccountData();
		AccountPO po = new AccountPO("12334", "123456", 1);
		accountData.addAccount(po);
	}

}
