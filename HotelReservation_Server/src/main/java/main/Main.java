package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {

	public static void main(String[] args) {
		try {
			DataRemoteObject dataRemoteObject = new DataRemoteObject();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/DataRemoteObject", dataRemoteObject);
			System.out.print("Ready");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
