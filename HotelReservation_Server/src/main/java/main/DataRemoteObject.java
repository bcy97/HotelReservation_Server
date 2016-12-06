package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.account_data.AccountData;
import data.client_data.ClientData;
import data.credit_data.CreditData;
import data.evaluation_data.EvaluationData;
import data.hotel_data.HotelData;
import data.order_data.OrderData;
import data.promotion_data.PromotionData;
import data.room_data.RoomData;
import dataDao.AccountDao;
import dataDao.ClientDao;
import dataDao.CreditDao;
import dataDao.EvaluationDao;
import dataDao.HotelDao;
import dataDao.OrderDao;
import dataDao.PromotionDao;
import dataDao.RoomDao;
import po.AccountPO;
import po.ClientPO;
import po.CreditHistoryPO;
import po.EvaluationPO;
import po.HotelPO;
import po.OrderPO;
import po.PromotionPO;
import po.RoomPO;

public class DataRemoteObject extends UnicastRemoteObject
		implements AccountDao, ClientDao, CreditDao, EvaluationDao, HotelDao, OrderDao, PromotionDao, RoomDao {

	private static final long serialVersionUID = 4029039744279087114L;
	private AccountDao accountDao;
	private ClientDao clientDao;
	private CreditDao creditDao;
	private EvaluationDao evaluationDao;
	private HotelDao hotelDao;
	private OrderDao orderDao;
	private PromotionDao promotionDao;
	private RoomDao roomDao;
	
	protected DataRemoteObject() throws RemoteException {
		super();
		accountDao = new AccountData();
		clientDao = new ClientData();
		creditDao = new CreditData();
		evaluationDao = new EvaluationData();
		hotelDao = new HotelData();
		orderDao = new OrderData();
		promotionDao = new PromotionData();
		roomDao = new RoomData();
	}

	public RoomPO getRoomInfo(String hotelId, String roomId) {
		return roomDao.getRoomInfo(hotelId, roomId);
	}

	public boolean addRoom(RoomPO roomPO) {
		return roomDao.addRoom(roomPO);
	}

	public boolean updateRoom(RoomPO roomPO) {
		return roomDao.updateRoom(roomPO);
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		return roomDao.getHotelRooms(hotelId);
	}

	public ArrayList<PromotionPO> getHotelPromotions(String hotel) {
		return promotionDao.getHotelPromotions(hotel);
	}

	public PromotionPO getPromotion(String promotionID) {
		return promotionDao.getPromotion(promotionID);
	}

	public ArrayList<PromotionPO> getWebPromotions() {
		return promotionDao.getWebPromotions();
	}

	public boolean addPromotion(PromotionPO promotionPO) {
		return promotionDao.addPromotion(promotionPO);
	}

	public boolean updatePromotion(PromotionPO promotionPO) {
		return promotionDao.updatePromotion(promotionPO);
	}

	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		return orderDao.getOrderListByUserId(userID);
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		return orderDao.getOrderListByHotelID(hotelID);
	}

	public ArrayList<OrderPO> getHotelDailyOrders(String hotelID) {
		return orderDao.getHotelDailyOrders(hotelID);
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		return orderDao.getAllDailyOrders(time);
	}

	public boolean updateOrder(OrderPO orderPO) {
		return orderDao.updateOrder(orderPO);
	}

	public boolean addOrder(OrderPO orderPO) {
		return orderDao.addOrder(orderPO);
	}

	public OrderPO getOrderByOrderID(String orderID) {
		return orderDao.getOrderByOrderID(orderID);
	}

	public boolean addHotel(HotelPO po) {
		return hotelDao.addHotel(po);
	}

	public boolean modifyHotelInfo(HotelPO po) {
		return hotelDao.modifyHotelInfo(po);
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		return hotelDao.getHotelInfoByHotelID(hotelID);
	}
	
	public ArrayList<String> getBookedHotelID(String userID) {
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		return hotelDao.getTradingAreas(loaction);
	}

	public ArrayList<HotelPO> SearchHotelList(String tradingArea, int level, int priceFloor, int priceCeiling) {
		return hotelDao.SearchHotelList(tradingArea, level, priceFloor, priceCeiling);
	}

	public boolean addEvalution(EvaluationPO po) {
		return evaluationDao.addEvalution(po);
	}

	public boolean deleteEvaluation(EvaluationPO po) {
		return evaluationDao.deleteEvaluation(po);
	}

	public EvaluationPO getEvaluationByOrderID(String order_id) {
		return evaluationDao.getEvaluationByOrderID(order_id);
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		return evaluationDao.getEvaluationByHotelID(hotelID);
	}

	public boolean changeCredit(CreditHistoryPO po) {
		return creditDao.changeCredit(po);
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		return creditDao.getCreditHistory(userID);
	}

	public int getCredit(String userID) {
		return creditDao.getCredit(userID);
	}

	public boolean addClient(ClientPO po) {
		return clientDao.addClient(po);
	}

	public ClientPO getClientInfo(String clientID) {
		return clientDao.getClientInfo(clientID);
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		return clientDao.updateClientInfo(clientPO);
	}

	public boolean addAccount(AccountPO po) {
		return accountDao.addAccount(po);
	}

	public boolean modifyPassword(AccountPO po) {
		return accountDao.modifyPassword(po);
	}

	public AccountPO getAccountInfo(String accountID) {
		return accountDao.getAccountInfo(accountID);
	}

}
