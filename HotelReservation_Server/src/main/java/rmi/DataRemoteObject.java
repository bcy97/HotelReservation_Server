package rmi;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.account_data.AccountData;
import data.credit_data.CreditData;
import data.hotel_data.HotelData;
import data.order_data.OrderData;
import data.order_data.OrderListData;
import data.promotion_data.PromotionData;
import data.room_data.RoomData;
import data.user_data.ClientData;
import data.user_data.HotelManagerData;
import data.user_data.WebBusinessData;
import dataDao.account.AccountDao;
import dataDao.credit.CreditDao;
import dataDao.hotel.HotelDao;
import dataDao.promotion.PromotionDao;
import dataDao.room.RoomDao;
import dataDao.order.OrderDao;
import dataDao.order.OrderListDao;
import dataDao.user.ClientDao;
import dataDao.user.HotelManagerDao;
import dataDao.user.WebBusinessDao;
import po.AccountPO;
import po.ClientPO;
import po.CreditHistoryPO;
import po.EvaluationPO;
import po.HotelManagerPO;
import po.HotelPO;
import po.OrderPO;
import po.PromotionPO;
import po.RoomPO;
import po.WebBusinessPO;

public class DataRemoteObject extends UnicastRemoteObject 
		implements AccountDao, ClientDao, HotelManagerDao,WebBusinessDao,CreditDao,
		HotelDao, OrderDao, OrderListDao,PromotionDao, RoomDao {

	private static final long serialVersionUID = 4029039744279087114L;
	private AccountDao accountDao;
	private ClientDao clientDao;
	private HotelManagerDao hotelManagerDao;
	private WebBusinessDao webBusinessDao;
	private CreditDao creditDao;
	private HotelDao hotelDao;
	private OrderDao orderDao;
	private OrderListDao orderListDao;
	private PromotionDao promotionDao;
	private RoomDao roomDao;
	
	protected DataRemoteObject() throws RemoteException {
		accountDao = new AccountData();
		clientDao = new ClientData();
		hotelManagerDao = new HotelManagerData();
		webBusinessDao = new WebBusinessData();
		creditDao = new CreditData();
		hotelDao = new HotelData();
		orderDao = new OrderData();
		orderListDao = new OrderListData();
		promotionDao = new PromotionData();
		roomDao = new RoomData();
	}

	public RoomPO getRoomInfo(String hotelId, int roomType) throws RemoteException{
		return roomDao.getRoomInfo(hotelId, roomType);
	}

	public boolean addRoom(RoomPO roomPO) throws RemoteException{
		return roomDao.addRoom(roomPO);
	}

	public boolean updateRoom(RoomPO roomPO) throws RemoteException{
		return roomDao.updateRoom(roomPO);
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) throws RemoteException{
		return roomDao.getHotelRooms(hotelId);
	}

	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) throws RemoteException{
		return promotionDao.getHotelPromotions(hotel, promotionType);
	}

	public ArrayList<PromotionPO> getWebPromotions(int promotionType) throws RemoteException{
		return promotionDao.getWebPromotions(promotionType);
	}

	public PromotionPO getPromotion(String promotionID) throws RemoteException{
		return promotionDao.getPromotion(promotionID);
	}

	public boolean addPromotion(PromotionPO promotionPO) throws RemoteException{
		return promotionDao.addPromotion(promotionPO);
	}

	public boolean updatePromotion(PromotionPO promotionPO) throws RemoteException{
		return promotionDao.updatePromotion(promotionPO);
	}

	public ArrayList<OrderPO> getOrderListByUserId(String userID) throws RemoteException{
		return orderListDao.getOrderListByUserId(userID);
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) throws RemoteException{
		return orderListDao.getOrderListByHotelID(hotelID);
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) throws RemoteException{
		return orderListDao.getAllDailyOrders(time);
	}

	public boolean addOrder(OrderPO orderPO) throws RemoteException{
		return orderDao.addOrder(orderPO);
	}

	public boolean updateOrder(OrderPO orderPO) throws RemoteException{
		return orderDao.updateOrder(orderPO);
	}

	public OrderPO getOrderByOrderID(String orderID) throws RemoteException{
		return orderDao.getOrderByOrderID(orderID);
	}

	public boolean addEvaluation(EvaluationPO po) throws RemoteException{
		return orderDao.addEvaluation(po);
	}

	public EvaluationPO getEvaluationByOrderID(String orderID) throws RemoteException{
		return orderDao.getEvaluationByOrderID(orderID);
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) throws RemoteException{
		return orderDao.getEvaluationByHotelID(hotelID);
	}

	public ArrayList<String> getBookedHotelList(String userID) throws RemoteException{
		return orderDao.getBookedHotelList(userID);
	}

	public boolean hotelIDExist(String hotelID) throws RemoteException{
		return hotelDao.hotelIDExist(hotelID);
	}

	public boolean addHotel(HotelPO po) throws RemoteException{
		return hotelDao.addHotel(po);
	}

	public boolean updateHotel(HotelPO po) throws RemoteException{
		return hotelDao.updateHotel(po);
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) throws RemoteException{
		return hotelDao.getHotelInfoByHotelID(hotelID);
	}

	public ArrayList<String> getTradingAreas(String loaction) throws RemoteException{
		return hotelDao.getTradingAreas(loaction);
	}

	public ArrayList<HotelPO> SearchHotelList(String city, String tradingArea) throws RemoteException{
		return hotelDao.SearchHotelList(city, tradingArea);
	}

	public boolean changeCredit(CreditHistoryPO po) throws RemoteException{
		return creditDao.changeCredit(po);
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) throws RemoteException{
		return creditDao.getCreditHistory(userID);
	}

	public int getCredit(String userID) throws RemoteException{
		return creditDao.getCredit(userID);
	}

	public boolean setVIPCredit(int level, int credit_num) throws RemoteException{
		return creditDao.setVIPCredit(level, credit_num);
	}

	public int getVIPCredit(int level) throws RemoteException{
		return creditDao.getVIPCredit(level);
	}

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) throws RemoteException{
		return webBusinessDao.getWebBusinessInfo(webBusiness_ID);
	}

	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) throws RemoteException{
		return webBusinessDao.updateWebBusinessInfo(webBusinessInfo);
	}

	public HotelManagerPO getHotelManagerInfo(String hotel_ID) throws RemoteException{
		return hotelManagerDao.getHotelManagerInfo(hotel_ID);
	}

	public boolean updateHotelManagerInfo(HotelManagerPO po) throws RemoteException{
		return hotelManagerDao.updateHotelManagerInfo(po);
	}

	public boolean addClient(ClientPO po) throws RemoteException{
		return clientDao.addClient(po);
	}

	public ClientPO getClientInfo(String clientID) throws RemoteException{
		return clientDao.getClientInfo(clientID);
	}

	public boolean updateClientInfo(ClientPO clientPO) throws RemoteException{
		return clientDao.updateClientInfo(clientPO);
	}

	public boolean addAccount(AccountPO po) throws RemoteException{
		return accountDao.addAccount(po);
	}

	public boolean modifyPassword(AccountPO po) throws RemoteException{
		return accountDao.modifyPassword(po);
	}

	public AccountPO getAccountInfo(String accountID) throws RemoteException{
		return accountDao.getAccountInfo(accountID);
	}

	public boolean userIDExists(String userID) throws RemoteException{
		return accountDao.userIDExists(userID);
	}

	public boolean hasLogin(String userID) throws RemoteException{
		return accountDao.hasLogin(userID);
	}

	public boolean setLogout(String userID) throws RemoteException{
		return accountDao.setLogout(userID);
	}

	public boolean setLogin(String userID) throws RemoteException{
		return accountDao.setLogin(userID);
	}

	public int getPromotinoNum() throws RemoteException {
		return promotionDao.getPromotinoNum();
	}

	public int getOrderNum() throws RemoteException{
		return orderDao.getOrderNum();
	}


}
