package data;

import dataDao.IHello;

public class Hello implements IHello{

	public String sayHello(String name) {
		return "hello"+name;
	}
	
}
