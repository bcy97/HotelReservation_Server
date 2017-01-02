package dataDao.hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao extends Remote{
	
	/**
	 * 获取城市
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getCities() throws RemoteException;
	
	/**
	 * 酒店ID是否存在
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public boolean hotelIDExist(String hotelID) throws RemoteException;
	
	/**
	 * 添加酒店
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean addHotel(HotelPO po) throws RemoteException;
	
	/**
	 * 更新酒店
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateHotel(HotelPO po) throws RemoteException;
	
	/**
	 * 获取酒店信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelPO getHotelInfoByHotelID(String hotelID) throws RemoteException;
	
	/**
	 * 获取商圈
	 * @param city
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<String> getTradingAreas(String city) throws RemoteException;
	
	/**
	 * 查询酒店列表
	 * @param city
	 * @param tradingArea
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelPO> SearchHotelList(String city,String tradingArea) throws RemoteException;
	
}
