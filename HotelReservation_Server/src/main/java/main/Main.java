package main;

import java.rmi.registry.LocateRegistry;

import data.account_data.AcountData;
import data.credit_data.CreditData;
import data.evaluation_data.EvaluationData;
import data.hotel_data.HotelData;
import data.order_data.OrderData;
import data.promotion_data.PromotionData;
import data.room_data.RoomData;
import data.user_data.UserData;
import dataDao.AccountDao;
import dataDao.CreditDao;
import dataDao.EvaluationDao;
import dataDao.HotelDao;
import dataDao.OrderDao;
import dataDao.PromotionDao;
import dataDao.RoomDao;
import dataDao.UserDao;

public class Main {

	public static void main(String[] args) {
		try {
			AccountDao account = new AcountData();
			CreditDao credit = new CreditData();
			EvaluationDao evaluation = new EvaluationData();
			HotelDao hotel = new HotelData();
			OrderDao order = new OrderData();
			PromotionDao promotion = new PromotionData();
			RoomDao room = new RoomData();
			UserDao user = new UserData();
			LocateRegistry.createRegistry(1099);
			java.rmi.Naming.rebind("rmi://localhost:1099/account", account);
			java.rmi.Naming.rebind("rmi://localhost:1099/credit", credit);
			java.rmi.Naming.rebind("rmi://localhost:1099/evaluation", evaluation);
			java.rmi.Naming.rebind("rmi://localhost:1099/hotel", hotel);
			java.rmi.Naming.rebind("rmi://localhost:1099/order", order);
			java.rmi.Naming.rebind("rmi://localhost:1099/promotion", promotion);
			java.rmi.Naming.rebind("rmi://localhost:1099/room", room);
			java.rmi.Naming.rebind("rmi://localhost:1099/user", user);
			System.out.print("Ready");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
