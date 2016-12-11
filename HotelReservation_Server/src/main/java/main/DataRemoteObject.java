package main;

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
import dataDao.AccountDao;
import dataDao.CreditDao;
import dataDao.HotelDao;
import dataDao.PromotionDao;
import dataDao.RoomDao;
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
		super();
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

	public RoomPO getRoomInfo(String hotelId, String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addRoom(RoomPO roomPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateRoom(RoomPO roomPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<RoomPO> getHotelRooms(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionPO> getHotelPromotions(String hotel, int promotionType) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PromotionPO> getWebPromotions(int promotionType) {
		// TODO Auto-generated method stub
		return null;
	}

	public PromotionPO getPromotion(String promotionID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addPromotion(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePromotion(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<OrderPO> getOrderListByUserId(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getOrderListByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> getAllDailyOrders(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderPO getOrderByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addEvalution(EvaluationPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public EvaluationPO getEvaluationByOrderID(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EvaluationPO> getEvaluationByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getBookedHotelList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hotelIDExist(String hotelID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public HotelPO getHotelInfoByHotelID(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getTradingAreas(String loaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelPO> SearchHotelList(String city, String tradingArea) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changeCredit(CreditHistoryPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CreditHistoryPO> getCreditHistory(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCredit(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean setVIPCredit(int level, int credit_num) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getVIPCredit(int level) {
		// TODO Auto-generated method stub
		return 0;
	}

	public WebBusinessPO getWebBusinessInfo(String webBusiness_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateWebBusinessInfo(WebBusinessPO webBusinessInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public HotelManagerPO getHotelManagerInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateHotelManagerInfo(HotelManagerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addClient(ClientPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public ClientPO getClientInfo(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateClientInfo(ClientPO clientPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAccount(AccountPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyPassword(AccountPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public AccountPO getAccountInfo(String accountID) {
		// TODO Auto-generated method stub
		return null;
	}


}
